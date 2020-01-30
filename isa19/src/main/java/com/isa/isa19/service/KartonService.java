package com.isa.isa19.service;

import java.util.Optional;

import com.isa.isa19.model.Karton;
import com.isa.isa19.model.Pacijent;

public interface KartonService {

	public Optional<Karton> findOne(Long id);

	Karton save(Karton karton);

}
