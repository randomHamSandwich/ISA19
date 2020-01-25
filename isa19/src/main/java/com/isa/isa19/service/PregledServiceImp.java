package com.isa.isa19.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.isa19.model.Pregled;
import com.isa.isa19.repository.PregledRepo;
@Service
public class PregledServiceImp implements PregledService {
	
	
	@Autowired
	private PregledRepo pregledRepo;
	
	public List<Pregled> findByIdPacijentAndStatus(String id, String status){
		return pregledRepo.findByIdPacijentAndStatus(id, status);
	}
	
	public Optional<Pregled> findOne(Long id) {
		return pregledRepo.findById(id);
	}

	public List<Pregled> findAll() {
		return pregledRepo.findAll();
	}

	public Pregled save(Pregled pregled) {
		return pregledRepo.save(pregled);
	}

	@Override
	public List<String> getZauzetiPreglediVreme(String idLekar, LocalDate date) {
		List<String> result = new ArrayList<String>();
		for (Pregled pregled :  pregledRepo.findByLekarAndDate(idLekar, date)) {
			//		09:30:00 10:00:00
			String startTime = pregled.getVremePocetka().format( DateTimeFormatter.ofPattern("HH:mm:ss"));
			String endTime = pregled.getVremeZavrsetka().format( DateTimeFormatter.ofPattern("HH:mm:ss"));
			result.add(startTime+" "+endTime);
		}
		return result;
	}


}
