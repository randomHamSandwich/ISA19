package com.isa.isa19.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.isa.isa19.model.Operacija;

public interface OperacijaRepo extends JpaRepository<Operacija, Long> {

//	@Query(value="SELECT * FROM test_test.operacija where id_lekar=?1 ", nativeQuery=true)
//	List<Operacija> findByLekar(String idLekar);

	@Query(value = "SELECT * FROM test_test.operacija where id_klinika =2 and ocena_klinke is not null", nativeQuery = true)
	List<Operacija> findByIdKlinikaAndOcenaKlinikaNotNull(Long idKlinika);

	@Query(value = "SELECT op.* from operacija op inner join lekar_operacija on op.id_operacija= lekar_operacija.id_operacija where lekar_operacija.id_lekar= ?1 and op.ocena_lekara is not null", nativeQuery = true)
	List<Operacija> findByIdLekarAndOcenaLekaraNotNull(Long idLekar);
	
	@Query(value= "Select * from operacija op where op.id_pacijent = ?1 and op.status = ?2", nativeQuery= true)
	List<Operacija> findByIdPacijentAndStatus(Long idKorisnik, String status);
}


//Select * from operacija op where op.id_pacijent = 11 and op.status is null;