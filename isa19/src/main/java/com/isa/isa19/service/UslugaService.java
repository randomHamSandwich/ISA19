package com.isa.isa19.service;

import java.util.Optional;

import com.isa.isa19.model.Usluga;

public interface UslugaService {

	public Optional<Usluga> findUsluga(String usluga, Long idKlinika);
}
