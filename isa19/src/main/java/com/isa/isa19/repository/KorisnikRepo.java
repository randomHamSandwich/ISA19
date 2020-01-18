package com.isa.isa19.repository;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.tools.Trace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.isa.isa19.model.Klinika;
import com.isa.isa19.model.Korisnik;

public interface KorisnikRepo extends JpaRepository<Korisnik, Long>{
	Optional<Korisnik> findByEmail(String email);
	Boolean existsByEmail(String email);
	
	@Query(value="SELECT * FROM korisnik le where le.id_klinika= ?1 and le.tipp ='LEKAR'",nativeQuery=true)
	List<Korisnik> findByIdKlinika(String idKlinika);
	
	@Query(value ="SELECT le.* FROM korisnik le WHERE le.id_klinika = ?1 AND le.specijalizacija = ?2 and le.tipp ='LEKAR'", nativeQuery= true)
	List<Korisnik> findLekarKlSpec(String idKlinika,String spec);
}
