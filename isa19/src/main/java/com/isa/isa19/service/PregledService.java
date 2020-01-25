package com.isa.isa19.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isa.isa19.model.Pregled;
import com.isa.isa19.repository.PregledRepo;

public interface PregledService {

	public List<Pregled> findByIdPacijentAndStatus(String id, String status);

	public Optional<Pregled> findOne(Long id);

	public List<Pregled> findAll();

	public Pregled save(Pregled pregled);
	
	public List<String> getZauzetiPreglediVreme(String idLekar, LocalDate date);
	
	

}
