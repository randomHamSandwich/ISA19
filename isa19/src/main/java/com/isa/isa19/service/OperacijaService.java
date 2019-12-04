package com.isa.isa19.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isa.isa19.model.Operacija;
import com.isa.isa19.repository.OperacijaRepo;

@Service
public class OperacijaService {
	
	@Autowired
	private OperacijaRepo operacijaRepo;
	
	public Optional<Operacija> findOne(Long id) {
		return operacijaRepo.findById(id);
	}

	public List<Operacija> findAll() {
		return operacijaRepo.findAll();
	}

	public Operacija save(Operacija operacija) {
		return operacijaRepo.save(operacija);
	}

	public void remove(Long id) {
		operacijaRepo.deleteById(id);
	}

	public Page<Operacija> findAll(Pageable page) {
		return operacijaRepo.findAll(page);
	}

}
