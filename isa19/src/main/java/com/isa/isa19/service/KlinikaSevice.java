package com.isa.isa19.service;

import java.time.LocalDate;
import java.util.ArrayList;
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

	List<KlinikaDTO> findAll();

	Klinika save(Klinika Klinika);

	List<Klinika> findClincSpec(String spec);

	List<KlinikaDTO> findBySpecAndDate(Specijalizacija specijalizacija, LocalDate date);
	
	List<KlinikaDTO> getSlobodneKlinike(Collection<Klinika> klinike, Specijalizacija specijalizacija);
	
	Klinika updateKlinikaOcena(Klinika k);

	List<KlinikaDTO> convertDataToDTO(Collection<Klinika> klinike);

	List<KlinikaDTO> findBySpecAndDateAndLoc(Specijalizacija spec, LocalDate specifiedDate, String loc);

	List<KlinikaDTO> findBySpecAndDateAndOcenaAndLoc(Specijalizacija spec, LocalDate specifiedDate, String loc,
			Float omin, Float omax);

	List<KlinikaDTO> findBySpecAndDateAndOcena(Specijalizacija spec, LocalDate specifiedDate, Float omin,
			Float omax);

	
}
