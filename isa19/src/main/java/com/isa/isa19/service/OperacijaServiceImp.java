package com.isa.isa19.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.isa19.dto.OperacijaDTO;
import com.isa.isa19.model.Operacija;
import com.isa.isa19.model.StatusPregledaOperacije;
import com.isa.isa19.repository.OperacijaRepo;

@Service
@Transactional(readOnly = true)
public class OperacijaServiceImp implements OperacijaService {

	@Autowired
	private OperacijaRepo operacijaRepo;

	@Override
	public Optional<Operacija> findOne(Long id) {
		return operacijaRepo.findById(id);
	}

	@Override
	public List<Operacija> findAll() {
		return operacijaRepo.findAll();
	}

	@Override
	@Transactional
	public Operacija save(Operacija operacija) {
		return operacijaRepo.save(operacija);
	}

	@Override
	public List<Operacija> findByIdKlinikaAndOcenaKlinikaNotNull(Long idKlinika) {
		return operacijaRepo.findByIdKlinikaAndOcenaKlinikaNotNull(idKlinika);

	}

	@Override
	public List<Operacija> findByIdLekarAndOcenaLekaraNotNull(Long idLekar) {
		return operacijaRepo.findByIdLekarAndOcenaLekaraNotNull(idLekar);
	}

	@Override
	public List<Operacija> findByIdPacijentAndStatus(Long idKorisnik, String status) {
		return operacijaRepo.findByIdPacijentAndStatus(idKorisnik, status);
	}

	@Override
	public List<OperacijaDTO> getAllIzvrseneOperacije(Long idKorisnik) {

		List<Operacija> operacije = operacijaRepo.findByIdPacijentAndStatus(idKorisnik,
				StatusPregledaOperacije.IZVRSENA_OPERACIJA.toString());

		List<OperacijaDTO> operacijeDTO = new ArrayList<>();
		for (Operacija o : operacije) {
			operacijeDTO.add(new OperacijaDTO(o));
		}

		return operacijeDTO;
	}

	@Override
	public List<OperacijaDTO> getAllZakazaneOperacije(Long idKorisnik) {

		List<Operacija> operacije = operacijaRepo.findByIdPacijentAndStatus(idKorisnik,
				StatusPregledaOperacije.ZAKAZANA_OPERACIJA.toString());

		List<OperacijaDTO> operacijeDTO = new ArrayList<>();
		for (Operacija o : operacije) {
			operacijeDTO.add(new OperacijaDTO(o));
		}

		return operacijeDTO;
		
	}

}
