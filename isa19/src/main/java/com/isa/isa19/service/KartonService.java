package com.isa.isa19.service;

import java.util.Optional;

import com.isa.isa19.dto.KartonDTO;
import com.isa.isa19.model.Karton;

public interface KartonService {

	public Optional<Karton> findOne(Long id);

	public Karton save(Karton karton);

	public Optional<KartonDTO> getDTO(Long idKorisnik);
	
	public Optional<Karton> findKartonByPacijentID(Long idPacijent);

}
