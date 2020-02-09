package com.isa.isa19.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.isa19.dto.KorisnikDTO;
import com.isa.isa19.dto.LekarDTO;
import com.isa.isa19.dto.LozinkeDTO;
import com.isa.isa19.message.response.ResponseMessage;
import com.isa.isa19.model.Korisnik;
import com.isa.isa19.model.Specijalizacija;
import com.isa.isa19.service.KorisnikService;
import com.isa.isa19.service.UslugaService;
import com.isa.isa19.util.DateChecker;

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
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lekariDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/lekari/oceimeprez")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<LekarDTO>> getLekariOcenaImePrezime(@RequestParam Long idKlinike,
			@RequestParam String spec, @RequestParam String date, @RequestParam Float omin, @RequestParam Float omax,
			@RequestParam String ime, @RequestParam String prezime) {
		if (spec.isEmpty() || date.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		LocalDate specifiedDate;
		if (date.length() == 10) {
			specifiedDate = DateChecker.parseChoppedDateToLocalDate(date);
		} else {
			specifiedDate = DateChecker.parseToLocalDate(date);
		}

		List<LekarDTO> lekariDTO = korisnikService.findLekarBySpecAndDateOcenaImePrezime(idKlinike,
				Specijalizacija.valueOf(spec), specifiedDate, omin, omax, ime, prezime);

		if (lekariDTO.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lekariDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/lekari/oceime")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<LekarDTO>> getLekariOcenaIme(@RequestParam Long idKlinike, @RequestParam String spec,
			@RequestParam String date, @RequestParam Float omin, @RequestParam Float omax, @RequestParam String ime) {
		if (spec.isEmpty() || date.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		LocalDate specifiedDate;
		if (date.length() == 10) {
			specifiedDate = DateChecker.parseChoppedDateToLocalDate(date);
		} else {
			specifiedDate = DateChecker.parseToLocalDate(date);
		}

		List<LekarDTO> lekariDTO = korisnikService.findLekarBySpecAndDateOcenaIme(idKlinike,
				Specijalizacija.valueOf(spec), specifiedDate, omin, omax, ime);

		if (lekariDTO.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lekariDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/lekari/oceprez")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<LekarDTO>> getLekariOcenaPrezime(@RequestParam Long idKlinike, @RequestParam String spec,
			@RequestParam String date, @RequestParam Float omin, @RequestParam Float omax,
			@RequestParam String prezime) {
		if (spec.isEmpty() || date.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		LocalDate specifiedDate;
		if (date.length() == 10) {
			specifiedDate = DateChecker.parseChoppedDateToLocalDate(date);
		} else {
			specifiedDate = DateChecker.parseToLocalDate(date);
		}

		List<LekarDTO> lekariDTO = korisnikService.findLekarBySpecAndDateOcenaPrezime(idKlinike,
				Specijalizacija.valueOf(spec), specifiedDate, omin, omax, prezime);

		if (lekariDTO.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lekariDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/lekari/oce")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<LekarDTO>> getLekariOcena(@RequestParam Long idKlinike, @RequestParam String spec,
			@RequestParam String date, @RequestParam Float omin, @RequestParam Float omax) {
		if (spec.isEmpty() || date.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		LocalDate specifiedDate;
		if (date.length() == 10) {
			specifiedDate = DateChecker.parseChoppedDateToLocalDate(date);
		} else {
			specifiedDate = DateChecker.parseToLocalDate(date);
		}

		List<LekarDTO> lekariDTO = korisnikService.findLekarBySpecAndDateOcena(idKlinike, Specijalizacija.valueOf(spec),
				specifiedDate, omin, omax);

		if (lekariDTO.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lekariDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/lekari/imeprez")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<LekarDTO>> getLekariImePrezime(@RequestParam Long idKlinike, @RequestParam String spec,
			@RequestParam String date, @RequestParam String ime, @RequestParam String prezime) {
		if (spec.isEmpty() || date.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		LocalDate specifiedDate;
		if (date.length() == 10) {
			specifiedDate = DateChecker.parseChoppedDateToLocalDate(date);
		} else {
			specifiedDate = DateChecker.parseToLocalDate(date);
		}

		List<LekarDTO> lekariDTO = korisnikService.findLekarBySpecAndDateImePrezime(idKlinike,
				Specijalizacija.valueOf(spec), specifiedDate, ime, prezime);
		System.out.println("888888888888888888888 imerez vracen size " + lekariDTO.size());

		if (lekariDTO.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lekariDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/lekari/ime")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<LekarDTO>> getLekariIme(@RequestParam Long idKlinike, @RequestParam String spec,
			@RequestParam String date, @RequestParam String ime) {
		if (spec.isEmpty() || date.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		LocalDate specifiedDate;
		if (date.length() == 10) {
			specifiedDate = DateChecker.parseChoppedDateToLocalDate(date);
		} else {
			specifiedDate = DateChecker.parseToLocalDate(date);
		}

		List<LekarDTO> lekariDTO = korisnikService.findLekarBySpecAndDateIme(idKlinike, Specijalizacija.valueOf(spec),
				specifiedDate, ime);

		if (lekariDTO.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lekariDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/lekari/prez")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<LekarDTO>> getLekariPrezime(@RequestParam Long idKlinike, @RequestParam String spec,
			@RequestParam String date, @RequestParam String prezime) {
		if (spec.isEmpty() || date.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		LocalDate specifiedDate;
		if (date.length() == 10) {
			specifiedDate = DateChecker.parseChoppedDateToLocalDate(date);
		} else {
			specifiedDate = DateChecker.parseToLocalDate(date);
		}

		List<LekarDTO> lekariDTO = korisnikService.findLekarBySpecAndDatePrezime(idKlinike,
				Specijalizacija.valueOf(spec), specifiedDate, prezime);

		if (lekariDTO.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lekariDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/lekari/all")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<LekarDTO>> getLekariKlinikeAll(@RequestParam Long idKlinike) {

		Pageable page = PageRequest.of(0, 1);
		Pageable sortedByName = PageRequest.of(0, 3, Sort.by("ocena_lekar").descending());
//		sortedByName

//		page.getSort().

		List<LekarDTO> lekariDTO = korisnikService.findByKlinika(idKlinike);
//		List<LekarDTO> lekariDTO = korisnikService.findByKlinika(idKlinike,sortedByName);
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
		// save je sam po sebi transactional
		korisnik.get().setLozinka(encoder.encode(lozinkeDTO.getLozinkaNova()));
		Korisnik k = korisnik.get();
		k = korisnikService.save(k);
		return new ResponseEntity<>(new KorisnikDTO(k), HttpStatus.OK);

	}

}
