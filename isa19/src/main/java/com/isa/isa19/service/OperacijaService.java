package com.isa.isa19.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isa.isa19.dto.OperacijaDTO;
import com.isa.isa19.model.Operacija;
import com.isa.isa19.repository.OperacijaRepo;

public interface OperacijaService {

	public Optional<Operacija> findOne(Long id);

	public List<Operacija> findAll();

	public Operacija save(Operacija operacija);

	public List<Operacija> findByIdKlinikaAndOcenaKlinikaNotNull(Long idKlinika);

	public List<Operacija> findByIdLekarAndOcenaLekaraNotNull(Long idLekar);

	public List<Operacija> findByIdPacijentAndStatus(Long idKorisnik, String status);

	public List<OperacijaDTO> getAllIzvrseneOperacije(Long idKorisnik);

	public List<OperacijaDTO> getAllZakazaneOperacije(Long idKorisnik);

}
