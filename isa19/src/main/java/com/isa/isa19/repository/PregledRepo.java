package com.isa.isa19.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Pregled;
import com.isa.isa19.model.Specijalizacija;
import com.isa.isa19.model.StatusPregledaOperacije;

public interface PregledRepo extends JpaRepository<Pregled, Long>{

	@Query(value="SELECT * FROM Pregled pr where pr.id_pacijent = ?1 and pr.status =?2" , nativeQuery=true)
	List<Pregled> findByIdPacijentAndStatus( Long idPacijent, String status);

	@Query(value="SELECT * FROM test_test.pregled where id_lekar=?1 and cast(vreme_pocetka AS DATE) = ?2", nativeQuery=true)
	List<Pregled> findByLekarAndDate(Long idLekar, LocalDate date);
	
	@Query(value="SELECT * FROM test_test.pregled where id_lekar=?1 and ocena_lekara is not null", nativeQuery=true)
	List<Pregled> findByLekarWhereOcenaLNotNull(Long idLekar);

	@Query(value = "SELECT * FROM test_test.pregled where id_klinika = ?1 and ocena_kilinike is not null", nativeQuery= true)
	List<Pregled>findByIdKlinikaAndOcenaKlinikaNotNull(Long idKlinika);
	
	List<Pregled> findByStatus(StatusPregledaOperacije status);

}
