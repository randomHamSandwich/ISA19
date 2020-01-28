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

import com.isa.isa19.dto.OperacijaDTO;
import com.isa.isa19.model.Operacija;
import com.isa.isa19.model.StatusPregledaOperacije;
import com.isa.isa19.service.OperacijaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/operacija")
public class OperacijaController {

	@Autowired
	private OperacijaService operacijaService;

	@GetMapping(value = "/izvrseni")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<OperacijaDTO>> getAllIzvrseneOperacije(@RequestParam Long idKorisnik) {

		List<OperacijaDTO> resultOperacijeDTO = operacijaService.getAllIzvrseneOperacije(idKorisnik);

		return new ResponseEntity<>(resultOperacijeDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/zakazani")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<OperacijaDTO>> getAllZakazaneOperacije(@RequestParam Long idKorisnik) {

		List<OperacijaDTO> resultOperacijeDTO = operacijaService.getAllZakazaneOperacije(idKorisnik);

		return new ResponseEntity<>(resultOperacijeDTO, HttpStatus.OK);
	}

}
