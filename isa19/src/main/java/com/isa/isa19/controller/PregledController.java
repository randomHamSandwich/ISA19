package com.isa.isa19.controller;

import java.time.LocalDateTime;
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

import com.isa.isa19.dto.BrziPregledDTO;
import com.isa.isa19.dto.PregledDTO;
import com.isa.isa19.dto.PregledZakaziDTO;
import com.isa.isa19.message.response.ResponseMessage;
import com.isa.isa19.service.EmailService;
import com.isa.isa19.service.PregledService;
import com.isa.isa19.util.DateChecker;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/pregled")
public class PregledController {

	@Autowired
	private PregledService pregledService;

	@GetMapping(value = "/brzi")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<PregledDTO>> getAllBrziPregledi(@RequestParam Long idKlinika) {

		List<PregledDTO> preglediDTO = pregledService.getAllBrziPregledi(idKlinika);

		return new ResponseEntity<>(preglediDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/bolesti")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<PregledDTO>> getPreglediBolestiPacijent(@RequestParam Long idKorisnik) {

		List<PregledDTO> preglediDTO = pregledService.getBolestiPacijent(idKorisnik);

		return new ResponseEntity<>(preglediDTO, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json", value = "/brzi")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<PregledDTO> zakaziBrziPregled(	@RequestBody BrziPregledDTO brziPregldDTO) {

		Optional<PregledDTO> resultPregledDTO = pregledService.zakaziBrziPregledIPosaljiMail(brziPregldDTO);

		if (resultPregledDTO.isPresent()) {
			
			return new ResponseEntity<>(resultPregledDTO.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	


	@GetMapping(value = "/izvrseni")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<PregledDTO>> getAllIzvrseniPregled(@RequestParam Long idKorisnik) {

		List<PregledDTO> preglediDTO = pregledService.getIzvrseniPreglediByIdKorisnik(idKorisnik);

		return new ResponseEntity<>(preglediDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/zakazani")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<PregledDTO>> getAllZakazaniPregled(@RequestParam Long idKorisnik) {

		List<PregledDTO> preglediDTO = pregledService.getZakazaniPreglediByIdKorisnik(idKorisnik);

		return new ResponseEntity<>(preglediDTO, HttpStatus.OK);
	}

	//Rezervis pregled jer jos mora da na mail-u potvri da bi zavrsio proces zakazivaja
	//stavi u stanje REZERVISAN NE U STANJE ZAKAZAN
	@PostMapping(consumes = "application/json")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<PregledDTO> rezervisiPregled(@RequestBody PregledZakaziDTO pregledZakaziDTO) {
		LocalDateTime start;

		if (pregledZakaziDTO.getDate().length() == 10) {
			start = DateChecker.parseChoppedDateToLocalDateAndTime(pregledZakaziDTO.getDate(),
					pregledZakaziDTO.getTime());
		} else {
			start = DateChecker.parseToLocalDateAndTime(pregledZakaziDTO.getDate(), pregledZakaziDTO.getTime());
		}
//		TODO umesto zakaziPregled stavi da kroisnik rezervise pregled a da je zakazan kada
//		prihvati preko maila a ako odbije stavi otkazan pregled		
		Optional<PregledDTO> resultDto = pregledService.rezervisiPregled(pregledZakaziDTO, start);

		if (resultDto.isPresent()) {
			return new ResponseEntity<>(resultDto.get(), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping(value="/zakazimailom")
//	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<?> zavrsiZakazivanjePrekoMail(@RequestParam Long idPregleda, @RequestParam String mail) {

		Optional<PregledDTO> resultDto = pregledService.zakaziPregled(idPregleda, mail);

		if (resultDto.isPresent()) {
			return new ResponseEntity<>(new ResponseMessage("Uspesno ste potvrdili pregled"),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ResponseMessage("error mail dont match or pregled dosen't exist"), HttpStatus.BAD_REQUEST);
		}

	}
	
	
	@GetMapping(value="/otkazimailom")
//	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<?> otkaziMailomPregled(@RequestParam Long idPregleda, @RequestParam String mail) {

		Optional<PregledDTO> resultDto = pregledService.otkaziRezevisaniPregled(idPregleda, mail);

		if (resultDto.isPresent()) {
			return new ResponseEntity<>(new ResponseMessage("Uspesno ste otkazali pregled"),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ResponseMessage("error mail dont match or pregled dosen't exist"), HttpStatus.BAD_REQUEST);
		}

	}
	
	
	
	

	@PutMapping(consumes = "application/json", value = "/otkazi")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<PregledDTO> otkaziPregled(@RequestBody PregledDTO pregledDTO) {

		Optional<PregledDTO> pregledResult = pregledService.otkaziPregled(pregledDTO);
		if (pregledResult.isPresent()) {
			return new ResponseEntity<>(pregledResult.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping(consumes = "application/json", value = "/oceniLekara")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<PregledDTO> oceniLekaraPregled(@RequestBody PregledDTO pregledDTO) {
		
		Optional<PregledDTO> pregledResult = pregledService.oceniLekaraPregled(pregledDTO);
		
		if(pregledResult.isPresent()) {
			return new ResponseEntity<>(pregledResult.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping(consumes = "application/json", value = "/oceniKliniku")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<PregledDTO> oceniKlinikuPregled(@RequestBody PregledDTO pregledDTO) {
		
		Optional<PregledDTO> pregledResult = pregledService.oceniKlinikuPregled(pregledDTO);


		if(pregledResult.isPresent()) {
			return new ResponseEntity<>(pregledResult.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
