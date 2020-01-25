package com.isa.isa19.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.isa19.dto.PregledDTO;
import com.isa.isa19.dto.PregledZakaziDTO;
import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Pacijent;
import com.isa.isa19.model.Pregled;
import com.isa.isa19.model.StatusPregledaOperacije;
import com.isa.isa19.service.KorisnikService;
import com.isa.isa19.service.PregledService;
import com.isa.isa19.util.DateChecker;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/pregled")
public class PregledController {

	@Autowired
	private PregledService pregledService;

	@Autowired
	private KorisnikService korisnikService;
//	private SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");

	@GetMapping(value = "/izvrseni")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<PregledDTO>> getAllIzvrseniPregled(@RequestParam String idKorisnik) {

//		List<Pregled> pregledi = pregledService.findByIdPacijent(idKorisnik);
		
		List<Pregled> pregledi  = pregledService.findByIdPacijentAndStatus(idKorisnik, StatusPregledaOperacije.IZVRSEN_PREGLED.toString());
		List<PregledDTO> preglediDTO = new ArrayList<>();
		for (Pregled p : pregledi) {
			preglediDTO.add(new PregledDTO(p, p.getVremePocetka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
					p.getVremeZavrsetka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
		}

		return new ResponseEntity<>(preglediDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/zakazani")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<PregledDTO>> getAllZakazaniPregled(@RequestParam String idKorisnik) {

//		List<Pregled> pregledi = pregledService.findByIdPacijent(idKorisnik);
		
		List<Pregled> pregledi  = pregledService.findByIdPacijentAndStatus(idKorisnik, StatusPregledaOperacije.ZAKAZAN_PREGLED.toString());
		List<PregledDTO> preglediDTO = new ArrayList<>();
		for (Pregled p : pregledi) {
			preglediDTO.add(new PregledDTO(p, p.getVremePocetka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
					p.getVremeZavrsetka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
		}

		return new ResponseEntity<>(preglediDTO, HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<PregledDTO> zakaziPregled(@RequestBody PregledZakaziDTO pregledZakaziDTO) {
		Lekar lekar = korisnikService.findLekarById(Long.valueOf(pregledZakaziDTO.getIdLekar()));
		Pacijent pacijent = korisnikService.findPacijentById(Long.valueOf(pregledZakaziDTO.getIdPacijent()));

//		LocalDateTime start = DateChecker.parseToLocalDateAndTime(pregledZakaziDTO.getDate(), pregledZakaziDTO.getTime());
		LocalDateTime start;
		if (pregledZakaziDTO.getDate().length() == 10) {
			start = DateChecker.parseChoppedDateToLocalDateAndTime(pregledZakaziDTO.getDate(),
					pregledZakaziDTO.getTime());
		} else {
			start = DateChecker.parseToLocalDateAndTime(pregledZakaziDTO.getDate(), pregledZakaziDTO.getTime());
		}

		boolean imaOdsustvo = DateChecker.daLiLekarImaOdsustvo(lekar, start.toLocalDate());
		boolean imaOvajTerminZakazan = DateChecker.daLiLekarImaZakazanPregled(lekar, start);
		boolean imaOperaciju = DateChecker.daLiLekarImaOperaciju(lekar, start.toLocalDate());

		if (!imaOdsustvo && !imaOvajTerminZakazan && !imaOperaciju) {

			Pregled pregled = new Pregled();
			pregled.setVremePocetka(start);
			pregled.setVremeZavrsetka(start.plusMinutes(30));
			pregled.setLekar(lekar);
			pregled.setPacijent(pacijent);
			pregled.setStatus(StatusPregledaOperacije.ZAKAZAN_PREGLED);

			pregled = pregledService.save(pregled);
			return new ResponseEntity<>(new PregledDTO(pregled, pregled.getVremePocetka().toString(),
					pregled.getVremeZavrsetka().toString()), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping(consumes = "application/json", value= "/otkazi")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<PregledDTO> otkaziPregled(@RequestBody PregledDTO pregledDTO) {

		// a student must exist
		Optional<Pregled> pregled = pregledService.findOne(pregledDTO.getIdPregleda());

		if (!pregled.isPresent() || pregled.get().getStatus() != StatusPregledaOperacije.ZAKAZAN_PREGLED) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		pregled.get().setStatus(StatusPregledaOperacije.OTKAZAN_PREGLED);

		Pregled p = pregled.get();
		p = pregledService.save(p);
		return new ResponseEntity<>(new PregledDTO(p, null, null), HttpStatus.OK);
	}
	
	@PutMapping(consumes = "application/json", value= "/oceniLekara")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<PregledDTO> oceniLekaraPregled(@RequestBody PregledDTO pregledDTO) {

		System.out.println("pregled Lekar dto: " + pregledDTO.getIdPregleda()+ " " + pregledDTO.getOcenaLekara() );
		Optional<Pregled> pregled = pregledService.findOne(pregledDTO.getIdPregleda());
		System.out.println("pregled Lekar dto: " + pregledDTO.getIdPregleda()+ " " + pregledDTO.getOcenaLekara() );
		if (!pregled.isPresent() || pregled.get().getStatus() != StatusPregledaOperacije.IZVRSEN_PREGLED) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
//		TODO u ovom momentu update golobalnu ocenu LEKARA- nalazi se u svakom lekaru
		pregled.get().setOcenaLekara(pregledDTO.getOcenaLekara());
		System.out.println("pregled Lekar dto: " + pregledDTO.getIdPregleda()+ " " + pregledDTO.getOcenaLekara() );
		Pregled p = pregled.get();
		p = pregledService.save(p);
		return new ResponseEntity<>(new PregledDTO(p, null, null), HttpStatus.OK);
	}
	
	@PutMapping(consumes = "application/json", value= "/oceniKliniku")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<PregledDTO> updatePregled(@RequestBody PregledDTO pregledDTO) {

		// a student must exist
		Optional<Pregled> pregled = pregledService.findOne(pregledDTO.getIdPregleda());

		if (!pregled.isPresent() || pregled.get().getStatus() != StatusPregledaOperacije.IZVRSEN_PREGLED) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
//		TODO u ovom momentu update golobalnu ocenu KLINIKE- nalazi se u svakoj klinici
		pregled.get().setOcenaKilinike(pregledDTO.getOcenaKilinike());

		Pregled p = pregled.get();
		p = pregledService.save(p);
		return new ResponseEntity<>(new PregledDTO(p, null, null), HttpStatus.OK);
	}

}
