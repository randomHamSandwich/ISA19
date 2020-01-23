package com.isa.isa19.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.isa.isa19.model.Korisnik;
import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Specijalizacija;

public interface KorisnikService {

	public Optional<Korisnik> findOne(Long id);

	public Optional<Korisnik> findByEmail(String email);

	public List<Korisnik> findAll();

	public Korisnik save(Korisnik pacijent);

	public void remove(Long id);

	public Page<Korisnik> findAll(Pageable page);

	public List<Lekar> findLekarKlSpec(String idKlinika, String spec);

	public List<Lekar> findByIdKlinika(String idKlinika);

	public List<Lekar> findBySpecijalizacija(Specijalizacija specijalizacija);
}
