package com.isa.isa19.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.isa19.model.Usluga;
import com.isa.isa19.repository.UslugaRepo;

@Service
public class UslugaService {

	@Autowired
	private UslugaRepo uslugaRepo;

//	public Optional<Usluga> findByNazivUsluge(String usluga) {
//		return uslugaRepo.findByNazivUsluge(usluga);
//	}

//	public Optional<Usluga> findByNazivUslugeAndKlinika(String usluga, String idKlinika) {
//		return uslugaRepo.findByNazivUslugeAndKlinika(usluga, idKlinika);
//	}
	
	public Optional<Usluga> findUsluga(String usluga, String idKlinika) {
	return uslugaRepo.findUsluga(usluga, idKlinika);
}
}
