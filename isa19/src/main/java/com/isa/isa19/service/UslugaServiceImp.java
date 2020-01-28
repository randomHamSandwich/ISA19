package com.isa.isa19.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.isa19.model.Usluga;
import com.isa.isa19.repository.UslugaRepo;
@Service
@Transactional(readOnly= true)
public class UslugaServiceImp  implements UslugaService{
	
	@Autowired
	private UslugaRepo uslugaRepo;

	@Override
	public Optional<Usluga> findUsluga(String usluga, Long idKlinika) {
		return uslugaRepo.findUsluga(usluga, idKlinika);
	}

}
