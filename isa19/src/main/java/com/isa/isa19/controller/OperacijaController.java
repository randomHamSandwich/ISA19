package com.isa.isa19.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.isa19.dto.OperacijaDTO;
import com.isa.isa19.model.Operacija;
import com.isa.isa19.service.OperacijaService;

@RestController
@RequestMapping(value = "api/operacija")
public class OperacijaController {

	
	@Autowired
	private OperacijaService operacijaService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<OperacijaDTO>> getAllStudents() {

		List<Operacija> operacije = operacijaService.findAll();

		// convert students to DTOs
		List<OperacijaDTO> operacijeDTO = new ArrayList<>();
		for (Operacija o : operacije) {
			operacijeDTO.add(new OperacijaDTO(o));
		}

		return new ResponseEntity<>(operacijeDTO, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<OperacijaDTO>> getStudentsPage(Pageable page) {

		// page object holds data about pagination and sorting
		// the object is created based on the url parameters "page", "size" and "sort"
		Page<Operacija> operacije = operacijaService.findAll(page);

		// convert operacija's to DTOs
		List<OperacijaDTO> operacijeDTO = new ArrayList<>();
		for (Operacija o : operacije) {
			operacijeDTO.add(new OperacijaDTO(o));
		}

		return new ResponseEntity<>(operacijeDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<OperacijaDTO> getStudent(@PathVariable Long id) {
		Optional<Operacija> operacija = operacijaService.findOne(id);

		if (!operacija.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new OperacijaDTO(operacija.get()), HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<OperacijaDTO> saveStudent(@RequestBody OperacijaDTO operacijaDTO) {

		Operacija operacija = new Operacija();
		
		operacija.setVremePocetka(operacijaDTO.getVremePocetka());
		operacija.setVremeZavrsetka(operacijaDTO.getVremeZavrsetka());
		operacija.setOcenaKlinke(operacijaDTO.getOcenaKlinke());
		operacija.setOcenaLekara(operacijaDTO.getOcenaLekara());

		operacija = operacijaService.save(operacija);
		return new ResponseEntity<>(new OperacijaDTO(operacija), HttpStatus.CREATED);
	}

	@PutMapping(consumes = "application/json")
	public ResponseEntity<OperacijaDTO> updateStudent(@RequestBody OperacijaDTO operacijaDTO) {

		// a student must exist
		Optional<Operacija> operacija = operacijaService.findOne(operacijaDTO.getIdOperacija());

		if (!operacija.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

//		operacija.get().setNaziv(OperacijaDTO.getNaziv());

		operacija.get().setVremePocetka(operacijaDTO.getVremePocetka());
		operacija.get().setVremeZavrsetka(operacijaDTO.getVremeZavrsetka());
		operacija.get().setOcenaKlinke(operacijaDTO.getOcenaKlinke());
		operacija.get().setOcenaLekara(operacijaDTO.getOcenaLekara());

		Operacija o = operacija.get();
		o = operacijaService.save(o);
		return new ResponseEntity<>(new OperacijaDTO(o), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
		Optional<Operacija> operacija = operacijaService.findOne(id);
		if (!operacija.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		operacijaService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
