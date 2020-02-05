package com.isa.isa19.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.isa.isa19.model.Lek;

public interface LekRepo extends JpaRepository<Lek, Long>{
	
@Query( value ="SELECT l.* from lek l inner join alergije a on l.id_lek = a.id_lek where a.id_karton= ?1", nativeQuery = true)
List<Lek> findAlergijeKorisnika(Long idKarton);
	

}
