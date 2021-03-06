package com.isa.isa19.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.isa.isa19.dto.KorisnikDTO;
import com.isa.isa19.dto.LekarDTO;
import com.isa.isa19.dto.LozinkeDTO;
import com.isa.isa19.model.Korisnik;
import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Pacijent;
import com.isa.isa19.model.Specijalizacija;

public interface KorisnikService {

	Lekar findLekarById(Long id);
	
	Pacijent findPacijentById(Long id);

	Optional<Korisnik> findByEmail(String email);

	List<Korisnik> findAll();

	Korisnik save(Korisnik korisnik);
	
	Pacijent save(Pacijent pacijent);
	
	Lekar save(Lekar lekar);
	
	Lekar updateLekarOcena(Lekar lekar);

	List<Lekar> findLekarKlSpec(Long idKlinika, String spec);

	List<LekarDTO> findByKlinika(Long idKlinika);

	List<Lekar> findBySpecijalizacija(Specijalizacija specijalizacija);

	List<LekarDTO> findLekarBySpecAndDate(Long idKlinika, Specijalizacija specijalizacija, LocalDate date);
	
	List<LekarDTO> getSlobodniLekariDTO(Collection<Lekar> slobodniLekari, Long idKlinika, LocalDate specifiedDate);

	KorisnikDTO saveKorisnik(KorisnikDTO korisnikDTO);

	Optional<KorisnikDTO> updateKorisnik(String email, KorisnikDTO korisnikDTO);

	Optional<KorisnikDTO> changePassword(String email, LozinkeDTO lozinkeDTO);


	List<LekarDTO> findLekarBySpecAndDateOcenaImePrezime(Long idKlinike, Specijalizacija spec,
			LocalDate specifiedDate, Float omin, Float omax, String ime, String prezime);

	List<LekarDTO> findLekarBySpecAndDateOcenaIme(Long idKlinike, Specijalizacija spec, LocalDate specifiedDate,
			Float omin, Float omax, String ime);

	List<LekarDTO> findLekarBySpecAndDateOcenaPrezime(Long idKlinike, Specijalizacija spec, LocalDate specifiedDate,
			Float omin, Float omax, String prezime);

	List<LekarDTO> findLekarBySpecAndDateOcena(Long idKlinike, Specijalizacija spec, LocalDate specifiedDate,
			Float omin, Float omax);

	List<LekarDTO> findLekarBySpecAndDateImePrezime(Long idKlinike, Specijalizacija spec, LocalDate specifiedDate,
			String ime, String prezime);

	List<LekarDTO> findLekarBySpecAndDateIme(Long idKlinike, Specijalizacija spec, LocalDate specifiedDate,
			String ime);

	List<LekarDTO> findLekarBySpecAndDatePrezime(Long idKlinike, Specijalizacija spec, LocalDate specifiedDate,
			String prezime);

	List<LekarDTO> findByKlinika(Long idKlinike, Pageable page);

}
