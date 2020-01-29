package com.isa.isa19.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.isa19.dto.OperacijaDTO;
import com.isa.isa19.dto.PregledDTO;
import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Operacija;
import com.isa.isa19.model.Pregled;
import com.isa.isa19.model.StatusPregledaOperacije;
import com.isa.isa19.repository.OperacijaRepo;

@Service
@Transactional(readOnly = true)
public class OperacijaServiceImp implements OperacijaService {

	@Autowired
	private OperacijaRepo operacijaRepo;
	
	@Autowired
	private KorisnikService korisnickiServis;
	
	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private KlinikaSevice klinikaService;


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
			operacijeDTO.add(new OperacijaDTO(o, o.getVremePocetka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
					o.getLekar()));
		}

		return operacijeDTO;
	}

	@Override
	public List<OperacijaDTO> getAllZakazaneOperacije(Long idKorisnik) {

		List<Operacija> operacije = operacijaRepo.findByIdPacijentAndStatus(idKorisnik,
				StatusPregledaOperacije.ZAKAZANA_OPERACIJA.toString());

		List<OperacijaDTO> operacijeDTO = new ArrayList<>();
		for (Operacija o : operacije) {
			operacijeDTO
					.add(new OperacijaDTO(o, o.getVremePocetka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), o.getLekar()));

		}

		return operacijeDTO;

	}

	@Override
	@Transactional
	public Optional<OperacijaDTO> oceniLekaraPregled(OperacijaDTO operacijaDTO) {
		
		Optional<Operacija> operacija = operacijaRepo.findById(operacijaDTO.getIdOperacija());
		if (!operacija.isPresent() || operacija.get().getStatus() != StatusPregledaOperacije.IZVRSENA_OPERACIJA
				|| operacijaDTO.getOcenaLekara() == null
				|| (operacijaDTO.getOcenaLekara() != 5 && operacijaDTO.getOcenaLekara() != 4
						&& operacijaDTO.getOcenaLekara() != 3 && operacijaDTO.getOcenaLekara() != 2
						&& operacijaDTO.getOcenaLekara() != 1)) {
			return Optional.empty();
		}
		
		operacija.get().setOcenaLekara(operacijaDTO.getOcenaLekara());
		Operacija o = operacija.get();
		o= operacijaRepo.save(o);
//		u ovom momentu update golobalnu ocenu LEKARA- nalazi se u svakom lekaru
		for (Lekar lekar : o.getLekar()) {
			korisnickiServis.updateLekarOcena(lekar);
		}
		return Optional.of(new OperacijaDTO(o));
		
		
	}

	@Override
	@Transactional
	public Optional<OperacijaDTO> oceniKlinikuPregled(OperacijaDTO operacijaDTO) {
		
		Optional<Operacija> operacija = operacijaRepo.findById(operacijaDTO.getIdOperacija());
		
		if (!operacija.isPresent() || operacija.get().getStatus() != StatusPregledaOperacije.IZVRSENA_OPERACIJA
				|| operacijaDTO.getOcenaKlinke() == null
				|| (operacijaDTO.getOcenaKlinke() != 5 && operacijaDTO.getOcenaKlinke() != 4
						&& operacijaDTO.getOcenaKlinke() != 3 && operacijaDTO.getOcenaKlinke() != 2
						&& operacijaDTO.getOcenaKlinke() != 1)) {
			return Optional.empty();
		}

		operacija.get().setOcenaKlinke(operacijaDTO.getOcenaKlinke());
		Operacija o = operacija.get();
		o = operacijaRepo.save(o);

//		 u ovom momentu update golobalnu ocenu KLINIKE- nalazi se u svakoj klinici
//		Lekar lekar = korisnikService.findLekarById(operacijaDTO.get);
//		klinikaService.updateKlinikaOcena(lekar.getKlinika());
		
		klinikaService.updateKlinikaOcena(o.getKlinika());

		return Optional.of(new OperacijaDTO(o));
	}

}
