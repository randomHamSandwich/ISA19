package com.isa.isa19.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.isa19.dto.KartonDTO;
import com.isa.isa19.service.KartonService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/karton")
public class KartonController {
	
	@Autowired
	private KartonService kartonService;
	
	@GetMapping()
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<KartonDTO> getKarton(@RequestParam Long idKorisnik) {

		Optional<KartonDTO> kartonDTO = kartonService.getDTO(idKorisnik);
		if(!kartonDTO.isPresent()) {
			System.out.println("");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	

		return new ResponseEntity<>(kartonDTO.get(), HttpStatus.OK);
	}

}
