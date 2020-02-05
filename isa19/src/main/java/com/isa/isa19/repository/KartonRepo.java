package com.isa.isa19.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.isa.isa19.model.Karton;

public interface KartonRepo extends JpaRepository<Karton, Long>{
	
	@Query(value="SELECT * FROM karton k where k.id_pacijent= ?1", nativeQuery = true)
	Optional<Karton> findKartonByPacijentID(Long idPacijent);

}
