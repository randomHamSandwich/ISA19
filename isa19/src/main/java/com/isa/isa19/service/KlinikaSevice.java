package com.isa.isa19.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.isa.isa19.dto.KlinikaDTO;
import com.isa.isa19.model.Klinika;
import com.isa.isa19.model.Specijalizacija;

public interface KlinikaSevice {

	Optional<Klinika> findOne(Long id);

	List<Klinika> findAll();

	Klinika save(Klinika Klinika);

	void remove(Long id);

	Page<Klinika> findAll(Pageable page);

	List<Klinika> findClincSpec(String spec);

	List<KlinikaDTO> findBySpecAndDate(Specijalizacija specijalizacija, LocalDate date);
}
