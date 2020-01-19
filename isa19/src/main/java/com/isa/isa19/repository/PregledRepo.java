package com.isa.isa19.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.isa.isa19.model.Pregled;

public interface PregledRepo extends JpaRepository<Pregled, Long>{

//	@Query(value="SELECT * FROM Pregled pr where pr.id_pacijent = :idPacijent")
//	List<Pregled> findByIdPacijent(@Param("idPacijent") String idPacijent);
	
//	@Query(value="select p from Pregled p where p.id_pacijent = ?1" )
//	List<Pregled> findByIdPacijent(String idPacijent);
	
	@Query(value="SELECT * FROM Pregled pr where pr.id_pacijent = ?1" , nativeQuery=true)
	List<Pregled> findByIdPacijent( String idPacijent);

	

}
