package com.isa.isa19.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping(value = "/{id}")
	public ResponseEntity<LekDTO> getStudent(@PathVariable Long id) {
		Optional<Lek> lek = lekService.findOne(id);

		if (!lek.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new LekDTO(lek.get()), HttpStatus.OK);
	}

}
