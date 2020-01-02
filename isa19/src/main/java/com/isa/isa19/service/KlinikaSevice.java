package com.isa.isa19.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isa.isa19.model.Klinika;
import com.isa.isa19.repository.KlinikaRepo;

@Service
public class KlinikaSevice {
	@Autowired
	private KlinikaRepo klinikaRepo;

	public Optional<Klinika> findOne(Long id) {
		return klinikaRepo.findById(id);
	}

	public List<Klinika> findAll() {
		return klinikaRepo.findAll();
	}

	public Klinika save(Klinika Klinika) {
		return klinikaRepo.save(Klinika);
	}

	public void remove(Long id) {
		klinikaRepo.deleteById(id);
	}

	public Page<Klinika> findAll(Pageable page) {
		return klinikaRepo.findAll(page);
	}

}
