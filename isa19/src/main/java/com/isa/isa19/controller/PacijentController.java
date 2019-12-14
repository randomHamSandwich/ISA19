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

import com.isa.isa19.dto.PacijentDTO;
import com.isa.isa19.model.Pacijent;
import com.isa.isa19.service.PacijentService;

//@RestController
//@RequestMapping(value = "api/pacijent")
public class PacijentController {

//	@Autowired
//	private PacijentService pacijentService;
//
//	@GetMapping(value = "/all")
//	public ResponseEntity<List<PacijentDTO>> getAllStudents() {
//
//		List<Pacijent> pacijenti = pacijentService.findAll();
//
//		List<PacijentDTO> pacijentiDTO = new ArrayList<>();
//		for (Pacijent p : pacijenti) {
//			pacijentiDTO.add(new PacijentDTO(p));
//		}
//
//		return new ResponseEntity<>(pacijentiDTO, HttpStatus.OK);
//	}
//
//	@GetMapping
//	public ResponseEntity<List<PacijentDTO>> getStudentsPage(Pageable page) {
//
//		// page object holds data about pagination and sorting
//		// the object is created based on the url parameters "page", "size" and "sort"
//		Page<Pacijent> pacijenti = pacijentService.findAll(page);
//
//		List<PacijentDTO> pacijentiDTO = new ArrayList<>();
//		for (Pacijent p : pacijenti) {
//			pacijentiDTO.add(new PacijentDTO(p));
//		}
//
//		return new ResponseEntity<>(pacijentiDTO, HttpStatus.OK);
//	}
//
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<PacijentDTO> getStudent(@PathVariable Long id) {
//		Optional<Pacijent> pacijenti = pacijentService.findOne(id);
//
//		if (!pacijenti.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//		return new ResponseEntity<>(new PacijentDTO(pacijenti.get()), HttpStatus.OK);
//	}
//
//	@PostMapping(consumes = "application/json")
//	public ResponseEntity<PacijentDTO> saveStudent(@RequestBody PacijentDTO pacijentDTO) {
//
//		Pacijent pacijent = new Pacijent();
//		pacijent.setEmail(pacijentDTO.getEmail());
//		pacijent.setLozinka(pacijentDTO.getLozinka());
//		pacijent.setIme(pacijentDTO.getIme());
//		pacijent.setPrezime(pacijentDTO.getPrezime());
//		pacijent.setUlica(pacijentDTO.getUlica());
//		pacijent.setBrojUlice(pacijentDTO.getBrojUlice());
//		pacijent.setGrad(pacijentDTO.getGrad());
//		pacijent.setDrzava(pacijentDTO.getDrzava());
//		pacijent.setBrojTelefona(pacijentDTO.getBrojTelefona());
//		pacijent.setJmbg(pacijentDTO.getJmbg());
//
//		pacijent = pacijentService.save(pacijent);
//		return new ResponseEntity<>(new PacijentDTO(pacijent), HttpStatus.CREATED);
//	}
//
//	@PutMapping(consumes = "application/json")
//	public ResponseEntity<PacijentDTO> updateStudent(@RequestBody PacijentDTO pacijentDTO) {
//
//		Optional<Pacijent> pacijent = pacijentService.findOne(pacijentDTO.getIdOsoba());
//
//		if (!pacijent.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//
//		pacijent.get().setEmail(pacijentDTO.getEmail());
//		pacijent.get().setLozinka(pacijentDTO.getLozinka());
//		pacijent.get().setIme(pacijentDTO.getIme());
//		pacijent.get().setPrezime(pacijentDTO.getPrezime());
//		pacijent.get().setUlica(pacijentDTO.getUlica());
//		pacijent.get().setBrojUlice(pacijentDTO.getBrojUlice());
//		pacijent.get().setGrad(pacijentDTO.getGrad());
//		pacijent.get().setDrzava(pacijentDTO.getDrzava());
//		pacijent.get().setBrojTelefona(pacijentDTO.getBrojTelefona());
//		pacijent.get().setJmbg(pacijentDTO.getJmbg());
//		Pacijent p = pacijent.get();
//		p = pacijentService.save(p);
//		return new ResponseEntity<>(new PacijentDTO(p), HttpStatus.OK);
//	}
//
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
//
//
//		Optional<Pacijent> pacijent= pacijentService.findOne(id);
//
//		if (!pacijent.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//		pacijentService.remove(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}

}
