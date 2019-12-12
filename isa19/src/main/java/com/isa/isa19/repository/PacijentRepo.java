package com.isa.isa19.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.isa19.model.Pacijent;

public interface PacijentRepo extends JpaRepository<Pacijent, Long>{
	Optional<Pacijent> findByEmail(String email);
	Boolean existsByEmail(String email);
}
