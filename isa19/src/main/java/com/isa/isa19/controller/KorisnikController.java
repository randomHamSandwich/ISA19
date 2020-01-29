package com.isa.isa19.controller;

import java.security.cert.PKIXRevocationChecker.Option;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.isa19.dto.KlinikaDTO;
import com.isa.isa19.dto.KorisnikDTO;
import com.isa.isa19.dto.LekarDTO;
import com.isa.isa19.dto.LozinkeDTO;
import com.isa.isa19.message.response.ResponseMessage;
import com.isa.isa19.model.Korisnik;
import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Specijalizacija;
import com.isa.isa19.model.StatusKorisnika;
import com.isa.isa19.model.Usluga;
import com.isa.isa19.service.KlinikaSevice;
import com.isa.isa19.service.KorisnikService;
import com.isa.isa19.service.UslugaService;
import com.isa.isa19.util.DateChecker;

import ch.qos.logback.classic.pattern.DateConverter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/kroisnik")
public class KorisnikController {

	@Autowired
	private KorisnikService korisnikService;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private UslugaService uslugaService;

	@GetMapping(value = "/lekari")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<LekarDTO>> getLekariKlinike(@RequestParam Long idKlinike, @RequestParam String spec,
			@RequestParam String date) {
		if (spec.isEmpty() || date.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		LocalDate specifiedDate;
		if (date.length() == 10) {
			specifiedDate = DateChecker.parseChoppedDateToLocalDate(date);
		} else {
			specifiedDate = DateChecker.parseToLocalDate(date);
		}

		List<LekarDTO> lekariDTO = korisnikService.findLekarBySpecAndDate(idKlinike, Specijalizacija.valueOf(spec),
				specifiedDate);

		if (lekariDTO.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lekariDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/lekari/all")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<LekarDTO>> getLekariKlinikeAll(@RequestParam Long idKlinike) {

		List<LekarDTO> lekariDTO = korisnikService.findByKlinika(idKlinike);
		return new ResponseEntity<>(lekariDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/{email}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<KorisnikDTO> getKorisnikEMail(@PathVariable String email) {
		Optional<Korisnik> korisnik = korisnikService.findByEmail(email);

		if (!korisnik.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new KorisnikDTO(korisnik.get()), HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<KorisnikDTO> saveKorisnik(@RequestBody KorisnikDTO korisnikDTO) {
		
		KorisnikDTO resultKorisnikDTO = korisnikService.saveKorisnik(korisnikDTO);

		return new ResponseEntity<>(resultKorisnikDTO, HttpStatus.CREATED);
	}

	@PutMapping(consumes = "application/json", value = "/{email}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<?> updateKorisnik(@PathVariable String email, @RequestBody KorisnikDTO korisnikDTO) {
		
		
		Optional<KorisnikDTO> resultKorisnikDTO = korisnikService.updateKorisnik(email, korisnikDTO);
		
		if (!resultKorisnikDTO.isPresent()) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> This user does not exit!"), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(resultKorisnikDTO.get(), HttpStatus.OK);
	}

	@PutMapping(consumes = "application/json", value = "/pass/{email}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<?> changePassword(@PathVariable String email, @RequestBody LozinkeDTO lozinkeDTO) {
		
//		TODO proveri ovde ili u servsImp jer ja saljem <?> koji moze biti message response
//		Optional<KorisnikDto> resultKorisnikDTO = korisnikService.changePassword(email, lozinkeDTO);

		Optional<Korisnik> korisnik = korisnikService.findByEmail(email);

		if (!korisnik.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (!encoder.matches(lozinkeDTO.getLozinkaStara(), korisnik.get().getLozinka())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> old password is wrong!"), HttpStatus.BAD_REQUEST);

		}
		korisnik.get().setLozinka(encoder.encode(lozinkeDTO.getLozinkaNova()));
		Korisnik k = korisnik.get();
		k = korisnikService.save(k);
		return new ResponseEntity<>(new KorisnikDTO(k), HttpStatus.OK);
		
	}

}
