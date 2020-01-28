package com.isa.isa19.service;

import java.util.Optional;

import com.isa.isa19.model.Karton;

public interface KartonService {

	public Optional<Karton> findOne(Long id);

}
