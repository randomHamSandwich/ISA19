package com.isa.isa19.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.isa.isa19.model.Korisnik;
import com.isa.isa19.model.Pacijent;
import com.isa.isa19.model.Pregled;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	/*
	 * Koriscenje klase za ocitavanje vrednosti iz application.properties fajla
	 */
	@Autowired
	private Environment env;

//	annotating a method of a bean with @Async will make it execute in a separate thread i.e. the caller will not wait for the completion of the called method.
	@Async
	public void sendMailAsync(Korisnik korisnik) throws MailException, InterruptedException {
		System.out.println("Slanje emaila...");

		LocalDateTime dateTimeNow = LocalDateTime.now();
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

		try {
			helper.setTo(korisnik.getEmail());

			helper.setFrom(env.getProperty("spring.mail.username"));
			helper.setSubject("Link za registraciju ISA");
			String htmlPoruka = dateTimeNow.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + "<p>Pozdrav  "
					+ korisnik.getIme() + " " + korisnik.getPrezime() + "</p>"
					+ "<p>Kliknite na lik da bi zavrsili proces registracije vaseg naloga</p>"
					+ "<p><a href=\"http://127.0.0.1:8080/api/auth/activate/" + korisnik.getEmail()
					+ " \">link</a></p>";
			helper.setText(htmlPoruka, true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		javaMailSender.send(mimeMessage);

		System.out.println("Email poslat!");
	}

	@Async
	public void sendBrziPregledMail(Pregled pregled) {

		System.out.println("Slanje emaila...");

		LocalDateTime dateTimeNow = LocalDateTime.now();
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

		try {
			helper.setTo(pregled.getPacijent().getEmail());

			helper.setFrom(env.getProperty("spring.mail.username"));
			helper.setSubject("Uspesno zakazivanje pregleda");
			String htmlPoruka = dateTimeNow.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + "<p>Pozdrav  "
					+ pregled.getPacijent().getIme() + " " + pregled.getPacijent().getPrezime() + "</p>"
					+ "<p>Uspesno ste zakazali pregled</p>" + "<p>"
					+ pregled.getVremePocetka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + " u klinici:"
					+ pregled.getKlinika().getNaziv() + " na lokaciji:" + pregled.getKlinika().getGrad() + " "
					+ pregled.getKlinika().getUlica() + " " + pregled.getKlinika().getBrojUlice() + "</p>" + "<p>"
					+ " specijalizacije: " + pregled.getLekar().getSpecijalizacija().toString() + " lekar: "
					+ pregled.getLekar().getIme() + " " + pregled.getLekar().getPrezime() + "</p>";
			helper.setText(htmlPoruka, true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		javaMailSender.send(mimeMessage);

		System.out.println("Email poslat!");
	}

}