package com.isa.isa19.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.isa.isa19.model.Lek;
import com.isa.isa19.repository.LekRepo;

import org.springframework.stereotype.Service;

@Service
public class LekService {

	@Autowired
	private LekRepo lekRepo;

	public Optional<Lek> findOne(Long id) {
		return lekRepo.findById(id);
	}

	public List<Lek> findAll() {
		return lekRepo.findAll();
	}

	public Lek save(Lek lek) {
		return lekRepo.save(lek);
	}

	public void remove(Long id) {
		lekRepo.deleteById(id);
	}

	public Page<Lek> findAll(Pageable page) {
		return lekRepo.findAll(page);
	}

}
