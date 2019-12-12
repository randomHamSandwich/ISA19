package com.isa.isa19.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isa.isa19.model.Pacijent;
import com.isa.isa19.repository.PacijentRepo;
@Service
public class PacijentService {
	@Autowired
	private PacijentRepo pacijentRepo;

	public Optional<Pacijent> findOne(Long id) {
		return pacijentRepo.findById(id);
	}
	
	public Optional<Pacijent> findByEmail(String email){
		return pacijentRepo.findByEmail(email);
	}

	public List<Pacijent> findAll() {
		return pacijentRepo.findAll();
	}

	public Pacijent save(Pacijent pacijent) {
		return pacijentRepo.save(pacijent);
	}

	public void remove(Long id) {
		pacijentRepo.deleteById(id);
	}

	public Page<Pacijent> findAll(Pageable page) {
		return pacijentRepo.findAll(page);
	}

}
