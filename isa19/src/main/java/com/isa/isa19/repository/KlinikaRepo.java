package com.isa.isa19.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.isa.isa19.model.Klinika;
import com.isa.isa19.model.Specijalizacija;

public interface KlinikaRepo extends JpaRepository<Klinika, Long>{
	
	@Query(value ="SELECT distinct kl.*  FROM klinika kl inner join korisnik le on kl.id_klinika= le.id_klinika where le.specijalizacija = ?1", nativeQuery= true)
	List<Klinika> findClincSpec(String spec);

//	@Query(value ="SELECT * FROM klinika kl inner join korisnik le on kl.id_klinika= le.id_klinika where le.specijalizacija = ?1", nativeQuery=true)
//	@Query(value ="SELECT distinct kl.*  FROM klinika kl inner join korisnik le on kl.id_klinika= le.id_klinika where le.specijalizacija = ?1", nativeQuery= true)
//	@Query(value= "SELECT kl  FROM Lekar le  INNER JOIN le.klinika as kl  where le.specijalizacija.name() = :spec")
//	List<Klinika> findClincSpec(@Param("spec")String spec);

//	@Query(value= "SELECT kl  FROM Lekar le  INNER JOIN le.klinika as kl  where le.specijalizacija=?1")
//	List<Klinika> findClincSpec(String spec);


}
