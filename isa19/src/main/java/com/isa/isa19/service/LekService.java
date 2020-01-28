package com.isa.isa19.service;

import java.util.Optional;

import com.isa.isa19.model.Lek;

public interface LekService {

	public Optional<Lek> findOne(Long id);

}
