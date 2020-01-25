package com.isa.isa19.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.isa.isa19.model.Pregled;

public interface PregledRepo extends JpaRepository<Pregled, Long>{

//	@Query(value="SELECT * FROM Pregled pr where pr.id_pacijent = :idPacijent")
//	List<Pregled> findByIdPacijent(@Param("idPacijent") String idPacijent);
	
//	@Query(value="select p from Pregled p where p.id_pacijent = ?1" )
//	List<Pregled> findByIdPacijent(String idPacijent);
	
	@Query(value="SELECT * FROM Pregled pr where pr.id_pacijent = ?1 and pr.status =?2" , nativeQuery=true)
	List<Pregled> findByIdPacijentAndStatus( String idPacijent, String status);

	@Query(value="SELECT * FROM test_test.pregled where id_lekar=?1 and cast(vreme_pocetka AS DATE) = ?2", nativeQuery=true)
	List<Pregled> findByLekarAndDate(String idLekar, LocalDate date);
	

}
