package com.isa.isa19.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

import com.isa.isa19.message.request.LoginForm;
import com.isa.isa19.message.request.SignUpForm;
import com.isa.isa19.message.response.JwtResponse;
import com.isa.isa19.message.response.ResponseMessage;
import com.isa.isa19.model.Pacijent;
import com.isa.isa19.model.RoleNaziv;
import com.isa.isa19.model.Roles;
import com.isa.isa19.model.StatusKorisnika;
import com.isa.isa19.repository.PacijentRepo;
import com.isa.isa19.security.jwt.JwtProvider;
import com.isa.isa19.security.repository.RoleRepo;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PacijentRepo userRepository;

	@Autowired
	RoleRepo roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;
	@Autowired
	private Environment env;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		Pacijent user = new Pacijent();
		user.setEmail(signUpRequest.getEmail());
		user.setBrojTelefona(signUpRequest.getBrojTelefona());
		user.setBrojUlice(signUpRequest.getBrojUlice());
		user.setDrzava(signUpRequest.getDrzava());
		user.setGrad(signUpRequest.getGrad());
		user.setIme(signUpRequest.getIme());
		user.setPrezime(signUpRequest.getPrezime());
		user.setJmbg(signUpRequest.getJmbg());
		user.setUlica(signUpRequest.getUlica());
		user.setStatusKorisnika(StatusKorisnika.NOT_ACTIVATED);

		user.setLozinka(encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Roles> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "ak":
				Roles adminRole = roleRepository.findByNazivRole(RoleNaziv.ADMINISTRAOR_KLINIKE)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);
				break;
			case "lekar":
				Roles lekarRole = roleRepository.findByNazivRole(RoleNaziv.LEKAR)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(lekarRole);

			case "ms":
				Roles medicinskaSestraROle = roleRepository.findByNazivRole(RoleNaziv.MEDICINSKA_SESTRA)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(medicinskaSestraROle);
			case "akc":
				Roles administratorKlinickogCentraRole = roleRepository
						.findByNazivRole(RoleNaziv.ADMINISTRATOR_KLINICKOG_CENTRA)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(administratorKlinickogCentraRole);

			default:
				Roles userRole = roleRepository.findByNazivRole(RoleNaziv.PACIJENT)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);
		sendMail(user.getEmail());

		return new ResponseEntity<>(new ResponseMessage("Activate account on your mail!"), HttpStatus.OK);
	}

	@Async
	public void sendMail(String recipentMail) {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		System.out.println(formatter.format(calendar.getTime()));
		// slanje emaila
		final String username = env.getProperty("spring.mail.username");
		final String password = env.getProperty("spring.mail.password");
		String recipient = recipentMail;

		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("no-reply@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			message.setSubject("Hi user");

//			message.setText("welcome " + formatter.format(calendar.getTime())  + "click on the link to active\n" + 
//			"<a href=\"http://127.0.0.1:8080/api/auth/activate/ "+ recipentMail+" \">link</a>" );

			MimeBodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message
			messageBodyPart.setText(
					"welcome " + formatter.format(calendar.getTime()) + "<p>click on the link to activate</p>"
							+ "<a href=\"http://127.0.0.1:8080/api/auth/activate/" + recipentMail + " \">link</a>",
					"UTF-8", "html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Put parts in message
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}