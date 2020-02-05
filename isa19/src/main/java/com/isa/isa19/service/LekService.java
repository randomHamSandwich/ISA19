package com.isa.isa19.service;

import java.util.List;
import java.util.Optional;

import com.isa.isa19.dto.LekDTO;
import com.isa.isa19.model.Lek;

public interface LekService {

	public Optional<Lek> findOne(Long id);

	public List<LekDTO> findAlergijeKorisnika(Long idKarton);

}
