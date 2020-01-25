package com.isa.isa19.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.isa.isa19.dto.LekarDTO;
import com.isa.isa19.model.Korisnik;
import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Pacijent;
import com.isa.isa19.model.Specijalizacija;

public interface KorisnikService {

	Lekar findLekarById(Long id);
	
	Pacijent findPacijentById(Long id);

	Optional<Korisnik> findByEmail(String email);

	List<Korisnik> findAll();

	Korisnik save(Korisnik pacijent);

	void remove(Long id);

	Page<Korisnik> findAll(Pageable page);

	List<Lekar> findLekarKlSpec(String idKlinika, String spec);

	List<Lekar> findByIdKlinika(String idKlinika);

	List<Lekar> findBySpecijalizacija(Specijalizacija specijalizacija);

	List<LekarDTO> findLekarBySpecAndDate(String idKlinika, Specijalizacija specijalizacija, LocalDate date);
	
	
	List<LekarDTO> convertDataToDTO(Collection<Lekar> slobodniLekari, String idKlinika, LocalDate specifiedDate);
}
