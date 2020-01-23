package com.isa.isa19.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.isa19.dto.KlinikaDTO;
import com.isa.isa19.model.Klinika;
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
	public ResponseEntity<List<KlinikaDTO>> getAllKlinike(@RequestParam String spec, @RequestParam String date) {
		LocalDate specifiedDate = DateChecker.parseToLocalDate(date);

		System.out.println("________________________________________________________________" + specifiedDate);

		if (!spec.isEmpty() && !date.isEmpty()) {
			List<KlinikaDTO> klinikaiDTO = klinikaSevice.findBySpecAndDate(Specijalizacija.valueOf(spec),
					specifiedDate);
			if (klinikaiDTO.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(klinikaiDTO, HttpStatus.OK);

		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/all")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<KlinikaDTO>> getKlinikeSpec() {

		List<Klinika> klinikai = klinikaSevice.findAll();

		List<KlinikaDTO> klinikaiDTO = new ArrayList<>();
		for (Klinika k : klinikai) {
			klinikaiDTO.add(new KlinikaDTO(k));
		}
		if (klinikaiDTO.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(klinikaiDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<KlinikaDTO> getKlinika(@PathVariable Long id) {
		Optional<Klinika> klinika = klinikaSevice.findOne(id);

		if (!klinika.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new KlinikaDTO(klinika.get()), HttpStatus.OK);
	}

}
