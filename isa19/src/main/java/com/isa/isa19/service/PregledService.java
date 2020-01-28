package com.isa.isa19.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.isa.isa19.dto.PregledDTO;
import com.isa.isa19.dto.PregledZakaziDTO;
import com.isa.isa19.model.Pregled;

public interface PregledService {

	public List<Pregled> findByIdPacijentAndStatus(Long id, String status);

	public Optional<Pregled> findOne(Long id);

	public List<Pregled> findAll();

	public Pregled save(Pregled pregled);
	
	public List<String> getZauzetiPreglediVreme(Long idLekar, LocalDate date);

	public List<Pregled> findPregledByIdLekarAndOcenALekraNotNull(Long idOsoba);
	
	public List<Pregled> findByIdKlinikaAndOcenaKlinikaNotNull (Long idKlinika);

	public List<PregledDTO> getIzvrseniPreglediByIdKorisnik(Long idKorisnik);

	public List<PregledDTO> getZakazaniPreglediByIdKorisnik(Long idKorisnik);

	public Optional<PregledDTO> zakaziPregled(PregledZakaziDTO pregledZakaziDTO, LocalDateTime start);

	public Optional<PregledDTO> otkaziPregled(PregledDTO pregledDTO);

	public Optional<PregledDTO> oceniLekaraPregled(PregledDTO pregledDTO);

	public Optional<PregledDTO> oceniKlinikuPregled(PregledDTO pregledDTO);
	
}
