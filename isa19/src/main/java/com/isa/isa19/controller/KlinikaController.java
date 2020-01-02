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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.isa.isa19.dto.KlinikaDTO;
import com.isa.isa19.model.Klinika;



import com.isa.isa19.service.KlinikaSevice;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/klinika")
public class KlinikaController {
	
	@Autowired
	private KlinikaSevice klinikaSevice;
	
//	In spring security, hasRole() is the same as hasAuthority(), but hasRole() function map with Authority without ROLE_ prefix.
	@GetMapping(value = "/all")
//	@PreAuthorize("hasRole('PACIJENT') or hasRole('pacijent')")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<KlinikaDTO>> getAllStudents() {

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
	
	
	
	
	
	
	
	
	
	

}
