package com.isa.isa19.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.isa19.dto.KorisnikDTO;
import com.isa.isa19.dto.LozinkeDTO;
import com.isa.isa19.message.response.ResponseMessage;
import com.isa.isa19.model.Korisnik;
import com.isa.isa19.model.StatusKorisnika;
import com.isa.isa19.service.KorisnikService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/kroisnik")
public class KorisnikController {

	@Autowired
	private KorisnikService korisnikService;

	@Autowired
	PasswordEncoder encoder;

	@GetMapping(value = "/all")
	public ResponseEntity<List<KorisnikDTO>> getAllStudents() {

		List<Korisnik> korisnici = korisnikService.findAll();

		List<KorisnikDTO> korisniciDTO = new ArrayList<>();
		for (Korisnik k : korisnici) {
			korisniciDTO.add(new KorisnikDTO(k));
		}

		return new ResponseEntity<>(korisniciDTO, HttpStatus.OK);
	}

	@GetMapping
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<KorisnikDTO>> getStudentsPage(Pageable page) {

		// page object holds data about pagination and sorting
		// the object is created based on the url parameters "page", "size" and "sort"
		Page<Korisnik> kroisnici = korisnikService.findAll(page);

		List<KorisnikDTO> korisniciDTO = new ArrayList<>();
		for (Korisnik k : kroisnici) {
			korisniciDTO.add(new KorisnikDTO(k));
		}

		return new ResponseEntity<>(korisniciDTO, HttpStatus.OK);
	}

//	@GetMapping(value = "/{id}")
//	public ResponseEntity<KorisnikDTO> getStudent(@PathVariable Long id) {
//		Optional<Korisnik> korisnik = korisnikService.findOne(id);
//
//		if (!korisnik.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//		return new ResponseEntity<>(new KorisnikDTO(korisnik.get()), HttpStatus.OK);
//	}

	@GetMapping(value = "/{email}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<KorisnikDTO> getStudentEMail(@PathVariable String email) {
		Optional<Korisnik> korisnik = korisnikService.findByEmail(email);

		if (!korisnik.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new KorisnikDTO(korisnik.get()), HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<KorisnikDTO> saveStudent(@RequestBody KorisnikDTO korisnikDTO) {

		Korisnik korisnik = new Korisnik();
		korisnik.setEmail(korisnikDTO.getEmail());
		korisnik.setLozinka(korisnikDTO.getLozinka());
		korisnik.setIme(korisnikDTO.getIme());
		korisnik.setPrezime(korisnikDTO.getPrezime());
		korisnik.setUlica(korisnikDTO.getUlica());
		korisnik.setBrojUlice(korisnikDTO.getBrojUlice());
		korisnik.setGrad(korisnikDTO.getGrad());
		korisnik.setDrzava(korisnikDTO.getDrzava());
		korisnik.setBrojTelefona(korisnikDTO.getBrojTelefona());
		korisnik.setJmbg(korisnikDTO.getJmbg());
		korisnik.setStatusKorisnika(StatusKorisnika.NOT_ACTIVATED);
		korisnik = korisnikService.save(korisnik);
		return new ResponseEntity<>(new KorisnikDTO(korisnik), HttpStatus.CREATED);
	}

//	@PutMapping(consumes = "application/json")
//	public ResponseEntity<KorisnikDTO> updateStudent(@RequestBody KorisnikDTO korisnikDTO) {
//
//		Optional<Korisnik> korisnik = korisnikService.findOne(korisnikDTO.getIdOsoba());
//
//		if (!korisnik.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//
//		korisnik.get().setEmail(korisnikDTO.getEmail());
//		korisnik.get().setLozinka(korisnikDTO.getLozinka());
//		korisnik.get().setIme(korisnikDTO.getIme());
//		korisnik.get().setPrezime(korisnikDTO.getPrezime());
//		korisnik.get().setUlica(korisnikDTO.getUlica());
//		korisnik.get().setBrojUlice(korisnikDTO.getBrojUlice());
//		korisnik.get().setGrad(korisnikDTO.getGrad());
//		korisnik.get().setDrzava(korisnikDTO.getDrzava());
//		korisnik.get().setBrojTelefona(korisnikDTO.getBrojTelefona());
//		korisnik.get().setJmbg(korisnikDTO.getJmbg());
//		Korisnik k = korisnik.get();
//		k = korisnikService.save(k);
//		return new ResponseEntity<>(new KorisnikDTO(k), HttpStatus.OK);
//	}

	@PutMapping(consumes = "application/json", value = "/{email}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<?> updateStudent(@PathVariable String email, @RequestBody KorisnikDTO korisnikDTO) {

		Optional<Korisnik> korisnik = korisnikService.findByEmail(email);

		if (!korisnik.isPresent()) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> This user does not exit!"),
					HttpStatus.NOT_FOUND);
		}

		korisnik.get().setIme(korisnikDTO.getIme());
		korisnik.get().setPrezime(korisnikDTO.getPrezime());
		korisnik.get().setUlica(korisnikDTO.getUlica());
		korisnik.get().setBrojUlice(korisnikDTO.getBrojUlice());
		korisnik.get().setGrad(korisnikDTO.getGrad());
		korisnik.get().setDrzava(korisnikDTO.getDrzava());
		korisnik.get().setBrojTelefona(korisnikDTO.getBrojTelefona());
		Korisnik k = korisnik.get();
		k = korisnikService.save(k);
		return new ResponseEntity<>(new KorisnikDTO(k), HttpStatus.OK);
	}

	@PutMapping(consumes = "application/json", value = "/pass/{email}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<?> changePassword(@PathVariable String email, @RequestBody LozinkeDTO lozinkeDTO) {

		Optional<Korisnik> korisnik = korisnikService.findByEmail(email);

		if (!korisnik.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}


		if (!encoder.matches(lozinkeDTO.getLozinkaStara(), korisnik.get().getLozinka())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> old password is wrong!"),
					HttpStatus.BAD_REQUEST);

		}
		korisnik.get().setLozinka(encoder.encode(lozinkeDTO.getLozinkaNova()));

		Korisnik k = korisnik.get();
		k = korisnikService.save(k);
		return new ResponseEntity<>(new KorisnikDTO(k), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {

		Optional<Korisnik> korisnik = korisnikService.findOne(id);

		if (!korisnik.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		korisnikService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
