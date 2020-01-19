package com.isa.isa19.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isa.isa19.model.Pregled;
import com.isa.isa19.repository.PregledRepo;

@Service
public class PregledService {
	
	@Autowired
	private PregledRepo pregledRepo;
	
	public List<Pregled> findByIdPacijent(String id){
		return pregledRepo.findByIdPacijent(id);
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

	public void remove(Long id) {
		pregledRepo.deleteById(id);
	}

	public Page<Pregled> findAll(Pageable page) {
		return pregledRepo.findAll(page);
	}


}
