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

import com.isa.isa19.dto.LekDTO;
import com.isa.isa19.model.Lek;
import com.isa.isa19.service.LekService;

@RestController
@RequestMapping(value = "api/lek")
public class LekController {

	@Autowired
	private LekService lekService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<LekDTO>> getAllStudents() {

		List<Lek> lekovi = lekService.findAll();

		// convert students to DTOs
		List<LekDTO> lekoviDTO = new ArrayList<>();
		for (Lek l : lekovi) {
			lekoviDTO.add(new LekDTO(l));
		}

		return new ResponseEntity<>(lekoviDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LekDTO> getStudent(@PathVariable Long id) {
		Optional<Lek> lek = lekService.findOne(id);

		if (!lek.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new LekDTO(lek.get()), HttpStatus.OK);
	}

//	@GetMapping
//	public ResponseEntity<List<LekDTO>> getStudentsPage(Pageable page) {
//
//		// page object holds data about pagination and sorting
//		// the object is created based on the url parameters "page", "size" and "sort"
//		Page<Lek> lekovi = lekService.findAll(page);
//
//		// convert lek's to DTOs
//		List<LekDTO> lekoviDTO = new ArrayList<>();
//		for (Lek l : lekovi) {
//			lekoviDTO.add(new LekDTO(l));
//		}
//
//		return new ResponseEntity<>(lekoviDTO, HttpStatus.OK);
//	}



//	@PostMapping(consumes = "application/json")
//	public ResponseEntity<LekDTO> saveStudent(@RequestBody LekDTO lekDTO) {
//
//		Lek lek = new Lek();
//		lek.setNaziv(lekDTO.getNaziv());
//
//		lek = lekService.save(lek);
//		return new ResponseEntity<>(new LekDTO(lek), HttpStatus.CREATED);
//	}
//
//	@PutMapping(consumes = "application/json")
//	public ResponseEntity<LekDTO> updateStudent(@RequestBody LekDTO lekDTO) {
//
//		// a student must exist
//		Optional<Lek> lek = lekService.findOne(lekDTO.getIdLek());
//
//		if (!lek.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//
//		lek.get().setNaziv(lekDTO.getNaziv());
//		Lek l = lek.get();
//		l = lekService.save(l);
//		return new ResponseEntity<>(new LekDTO(l), HttpStatus.OK);
//	}
//
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
//		Optional<Lek> lek = lekService.findOne(id);
//		if (!lek.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//		lekService.remove(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}

}
