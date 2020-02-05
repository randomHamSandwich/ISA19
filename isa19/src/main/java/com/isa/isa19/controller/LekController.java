package com.isa.isa19.controller;

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

import com.isa.isa19.dto.LekDTO;
import com.isa.isa19.model.Karton;
import com.isa.isa19.model.Lek;
import com.isa.isa19.service.KartonService;
import com.isa.isa19.service.LekService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/lek")
public class LekController {

	@Autowired
	private LekService lekService;
	
	@Autowired
	private KartonService kartonService;


	@GetMapping(value = "/alergije")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<LekDTO>> getAlergije(@RequestParam Long idKorisnik) {
		Optional<Karton> karton = kartonService.findKartonByPacijentID(idKorisnik);
		List<LekDTO> lek = lekService.findAlergijeKorisnika(karton.get().getIdKarton());
		return new ResponseEntity<>(lek, HttpStatus.OK);
	}

}
