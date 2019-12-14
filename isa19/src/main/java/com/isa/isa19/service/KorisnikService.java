package com.isa.isa19.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isa.isa19.model.Korisnik;
import com.isa.isa19.repository.KorisnikRepo;
@Service
public class KorisnikService {

	@Autowired
	private KorisnikRepo krisnikRepo;

	public Optional<Korisnik> findOne(Long id) {
		return krisnikRepo.findById(id);
	}
	
	public Optional<Korisnik> findByEmail(String email){
		return krisnikRepo.findByEmail(email);
	}

	public List<Korisnik> findAll() {
		return krisnikRepo.findAll();
	}

	public Korisnik save(Korisnik pacijent) {
		return krisnikRepo.save(pacijent);
	}

	public void remove(Long id) {
		krisnikRepo.deleteById(id);
	}

	public Page<Korisnik> findAll(Pageable page) {
		return krisnikRepo.findAll(page);
	}
}
