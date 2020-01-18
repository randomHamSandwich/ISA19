package com.isa.isa19.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.isa.isa19.model.Korisnik;
import com.isa.isa19.model.Usluga;

public interface UslugaRepo extends JpaRepository<Usluga, Long>{
	
//	Optional<Usluga> findByNazivUsluge(String usluga);
	

//	Optional<Usluga> findByNazivUslugeAndKlinika(String usluga, String idKlinika);

	@Query(value="SELECT * FROM usluga u where u.naziv_usluge= ?1 and u.id_klinika= ?2", nativeQuery = true)
	Optional<Usluga> findUsluga(String usluga, String idKlinika);
}
