package com.isa.isa19.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.isa19.model.Karton;
import com.isa.isa19.repository.KartonRepo;

@Service
@Transactional(readOnly = true)
public class KartonServiceImp implements KartonService{
	
	@Autowired
	private KartonRepo kartonRepo;

	@Override
	public Optional<Karton> findOne(Long id) {
		return kartonRepo.findById(id);
	}

	@Override
	@Transactional
	public Karton save(Karton karton) {
		return kartonRepo.save(karton);
	}


}
