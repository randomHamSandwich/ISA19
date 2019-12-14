package com.isa.isa19.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.isa19.model.Korisnik;

public interface KorisnikRepo extends JpaRepository<Korisnik, Long>{
	Optional<Korisnik> findByEmail(String email);
	Boolean existsByEmail(String email);
}
