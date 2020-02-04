package com.isa.isa19.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.isa19.dto.KlinikaDTO;
import com.isa.isa19.model.Specijalizacija;
import com.isa.isa19.service.KlinikaSevice;
import com.isa.isa19.util.DateChecker;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/klinika")
public class KlinikaController {

	@Autowired
	private KlinikaSevice klinikaSevice;

//	In spring security, hasRole() is the same as hasAuthority(), but hasRole() function map with Authority without ROLE_ prefix.
//	@PreAuthorize("hasRole('PACIJENT') or hasRole('pacijent')")
	@GetMapping(value = "/specdate")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<KlinikaDTO>> getSpecDate(@RequestParam String spec, @RequestParam String date) {
		LocalDate specifiedDate = DateChecker.parseToLocalDate(date);
		if (!spec.isEmpty() && !date.isEmpty()) {
			List<KlinikaDTO> klinikaiDTO = klinikaSevice.findBySpecAndDate(Specijalizacija.valueOf(spec),
					specifiedDate);
			if (klinikaiDTO.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(klinikaiDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/specdateloc")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<KlinikaDTO>> getSpecDateLoc(@RequestParam String spec, @RequestParam String date,
			@RequestParam String loc) {
		LocalDate specifiedDate = DateChecker.parseToLocalDate(date);
		if (!spec.isEmpty() && !date.isEmpty()) {
			List<KlinikaDTO> klinikaiDTO = klinikaSevice.findBySpecAndDateAndLoc(Specijalizacija.valueOf(spec),
					specifiedDate, loc);
			if (klinikaiDTO.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(klinikaiDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/specdateocenaloc")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<KlinikaDTO>> getSpecDateOcenaLoc(@RequestParam String spec, @RequestParam String date,
			@RequestParam String loc, @RequestParam Float omin, @RequestParam Float omax) {
		LocalDate specifiedDate = DateChecker.parseToLocalDate(date);
		if (!spec.isEmpty() && !date.isEmpty()) {
			List<KlinikaDTO> klinikaiDTO = klinikaSevice.findBySpecAndDateAndOcenaAndLoc(Specijalizacija.valueOf(spec),
					specifiedDate, loc, omin, omax);
			if (klinikaiDTO.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(klinikaiDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping(value = "/specdateocena")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<KlinikaDTO>> getSpecDateOcena(@RequestParam String spec, @RequestParam String date,
			 @RequestParam Float omin, @RequestParam Float omax) {
		LocalDate specifiedDate = DateChecker.parseToLocalDate(date);
		if (!spec.isEmpty() && !date.isEmpty()) {
			List<KlinikaDTO> klinikaiDTO = klinikaSevice.findBySpecAndDateAndOcena(Specijalizacija.valueOf(spec),
					specifiedDate, omin, omax);
			if (klinikaiDTO.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(klinikaiDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	

	@GetMapping(value = "/all")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<KlinikaDTO>> getAllKlinike() {

		List<KlinikaDTO> klinikeDTO = klinikaSevice.findAll();
		if (klinikeDTO.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(klinikeDTO, HttpStatus.OK);
	}

}
