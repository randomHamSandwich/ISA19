package com.isa.isa19.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isa.isa19.model.Korisnik;
import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Specijalizacija;
import com.isa.isa19.repository.KorisnikRepo;

@Service
public class KorisnikServiceImpl implements KorisnikService{
	
	@Autowired
	private KorisnikRepo korisnikRepo;

	public Optional<Korisnik> findOne(Long id) {
		return korisnikRepo.findById(id);
	}

	public Optional<Korisnik> findByEmail(String email) {
		return korisnikRepo.findByEmail(email);
	}

	public List<Korisnik> findAll() {
		return korisnikRepo.findAll();
	}

	public Korisnik save(Korisnik pacijent) {
		return korisnikRepo.save(pacijent);
	}

	public void remove(Long id) {
		korisnikRepo.deleteById(id);
	}

	public Page<Korisnik> findAll(Pageable page) {
		return korisnikRepo.findAll(page);
	}

	public List<Lekar> findLekarKlSpec(String idKlinika, String spec) {
		return korisnikRepo.findLekarKlSpec(idKlinika, spec);
	}

	public List<Lekar> findByIdKlinika(String idKlinika) {
		return korisnikRepo.findByIdKlinika(idKlinika);
	}
	
	public List<Lekar> findBySpecijalizacija(Specijalizacija specijalizacija){
		return korisnikRepo.findBySpecijalizacija(specijalizacija);
	}

}
