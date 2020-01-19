package com.isa.isa19.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.isa.isa19.dto.PregledDTO;
import com.isa.isa19.model.Pregled;
import com.isa.isa19.service.PregledService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/pregled")
public class PregledController {

	@Autowired
	private PregledService pregledService;

	@GetMapping(value = "/all")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<PregledDTO>> getAllPregled(@RequestParam String idKorisnik) {

		List<Pregled> pregledi = pregledService.findByIdPacijent(idKorisnik);
		

		List<PregledDTO> preglediDTO = new ArrayList<>();

		for (Pregled p : pregledi) {
			preglediDTO.add(new PregledDTO(p));
		}

		return new ResponseEntity<>(preglediDTO, HttpStatus.OK);
	}

//	@GetMapping
//	public ResponseEntity<List<PregledDTO>> getPregledPage(Pageable page) {
//
//		// page object holds data about pagination and sorting
//		// the object is created based on the url parameters "page", "size" and "sort"
//		Page<Pregled> pregledi = pregledService.findAll(page);
//
//		// convert pregled's to DTOs
//		List<PregledDTO> lekoviDTO = new ArrayList<>();
//		for (Pregled p : pregledi) {
//			lekoviDTO.add(new PregledDTO(p));
//		}
//
//		return new ResponseEntity<>(lekoviDTO, HttpStatus.OK);
//	}
//
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<PregledDTO> getPregled(@PathVariable Long id) {
//		Optional<Pregled> pregled = pregledService.findOne(id);
//
//		if (!pregled.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//		return new ResponseEntity<>(new PregledDTO(pregled.get()), HttpStatus.OK);
//	}

//	@PostMapping(consumes = "application/json")
//	public ResponseEntity<PregledDTO> saveStudent(@RequestBody PregledDTO pregledDTO) {
//
//		Pregled pregled = new Pregled();
//		pregled.setVremePocetka(pregledDTO.getVremePocetka());
//		pregled.setVremeZavrsetka(pregledDTO.getVremeZavrsetka());
//		pregled.setPopust(pregledDTO.getPopust());
//		pregled.setCenaSaPopustom(pregledDTO.getCenaSaPopustom());
//		pregled.setOcenaLekara(pregledDTO.getOcenaLekara());
//		pregled.setOcenaKilinike(pregledDTO.getOcenaKilinike());
//
//		pregled = pregledService.save(pregled);
//		return new ResponseEntity<>(new PregledDTO(pregled), HttpStatus.CREATED);
//	}
//
//	@PutMapping(consumes = "application/json")
//	public ResponseEntity<PregledDTO> updatePregled(@RequestBody PregledDTO pregledDTO) {
//
//		// a student must exist
//		Optional<Pregled> pregled = pregledService.findOne(pregledDTO.getIdPregleda());
//
//		if (!pregled.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		pregled.get().setVremePocetka(pregledDTO.getVremePocetka());
//		pregled.get().setVremeZavrsetka(pregledDTO.getVremeZavrsetka());
//		pregled.get().setPopust(pregledDTO.getPopust());
//		pregled.get().setCenaSaPopustom(pregledDTO.getCenaSaPopustom());
//		pregled.get().setOcenaLekara(pregledDTO.getOcenaLekara());
//		pregled.get().setOcenaKilinike(pregledDTO.getOcenaKilinike());
//
//		Pregled p = pregled.get();
//		p = pregledService.save(p);
//		return new ResponseEntity<>(new PregledDTO(p), HttpStatus.OK);
//	}
//
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
//		Optional<Pregled> pregled = pregledService.findOne(id);
//		if (!pregled.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//		pregledService.remove(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
}
