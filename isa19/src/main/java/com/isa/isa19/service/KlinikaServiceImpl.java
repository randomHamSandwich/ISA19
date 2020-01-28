package com.isa.isa19.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.isa19.dto.KlinikaDTO;
import com.isa.isa19.model.Klinika;
import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Operacija;
import com.isa.isa19.model.Pregled;
import com.isa.isa19.model.Specijalizacija;
import com.isa.isa19.repository.KlinikaRepo;
import com.isa.isa19.util.DateChecker;

@Service
@Transactional(readOnly = true)
public class KlinikaServiceImpl implements KlinikaSevice {

	@Autowired
	private KlinikaRepo klinikaRepo;

	@Autowired
	private KorisnikService korisnikService;

	@Autowired
	private OperacijaService operacijaService;

	@Autowired
	private PregledService pregledService;

	@Override
	public Optional<Klinika> findOne(Long id) {
		return klinikaRepo.findById(id);
	}

	@Override
	public List<KlinikaDTO> findAll() {
		return convertDataToDTO(klinikaRepo.findAll());
	}

	@Override
	@Transactional
	public Klinika save(Klinika Klinika) {
		return klinikaRepo.save(Klinika);
	}

	@Override
	public List<Klinika> findClincSpec(String spec) {
		return klinikaRepo.findClincSpec(spec);
	}

	@Override
	public List<KlinikaDTO> findBySpecAndDate(Specijalizacija specijalizacija, LocalDate specifiedDate) {
		List<Lekar> slobodniLekari = new ArrayList<>();
		Set<Klinika> slobodneKlinike = new HashSet<>();
		List<Lekar> lekari = korisnikService.findBySpecijalizacija(specijalizacija);

		for (Lekar lekar : lekari) {
			boolean imaOdsustvo = DateChecker.daLiLekarImaOdsustvo(lekar, specifiedDate);
			boolean imaTermin = DateChecker.daLiLekarImaPreglede(lekar, specifiedDate);
			boolean imaOperaciju = DateChecker.daLiLekarImaOperaciju(lekar, specifiedDate);

			System.out.println("oooooooooooooOOOooooo idLekar: " + lekar.getIdOsoba() + " imaOdsustvo: " + imaOdsustvo
					+ " imaTermin: " + imaTermin + " imaOperaciju: " + imaOperaciju);
			if (!imaOdsustvo && !imaTermin && !imaOperaciju) {
				slobodniLekari.add(lekar);
				slobodneKlinike.add(lekar.getKlinika());
				System.out.println("****************** lekar: " + lekar.getIdOsoba() + "  sobodniLekaro: "
						+ slobodniLekari + " slobodneKlinike: " + slobodneKlinike);
			}
		}

		return convertDataToDTO(slobodneKlinike);

	}

	@Override
	public List<KlinikaDTO> convertDataToDTO(Collection<Klinika> klinike) {

		List<KlinikaDTO> klinikeDTO = new ArrayList<>();
		for (Klinika k : klinike) {
			klinikeDTO.add(new KlinikaDTO(k));
		}
		return klinikeDTO;
	}

	@Override
	@Transactional
	public Klinika updateKlinikaOcena(Klinika k) {
		List<Pregled> pregledi = pregledService.findByIdKlinikaAndOcenaKlinikaNotNull(k.getIdKlinika());
		float konacnaOcenaKlinika = 0;
		for (Pregled pregled : pregledi) {
			konacnaOcenaKlinika += pregled.getOcenaKilinike();
		}
		List<Operacija> operacije = operacijaService.findByIdKlinikaAndOcenaKlinikaNotNull(k.getIdKlinika());

		for (Operacija operacija : operacije) {
			konacnaOcenaKlinika += operacija.getOcenaKlinke();
		}
		k.setOcenaKlinike(konacnaOcenaKlinika / (operacije.size() + pregledi.size()));
		return klinikaRepo.save(k);
	}

}
