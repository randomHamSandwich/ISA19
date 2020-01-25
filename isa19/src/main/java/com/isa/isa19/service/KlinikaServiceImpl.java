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

	public Optional<Klinika> findOne(Long id) {
		return klinikaRepo.findById(id);
	}

	public List<KlinikaDTO> findAll() {
		return convertDataToDTO(klinikaRepo.findAll());
	}

	@Transactional
	public Klinika save(Klinika Klinika) {
		return klinikaRepo.save(Klinika);
	}

	@Transactional
	public void remove(Long id) {
		klinikaRepo.deleteById(id);
	}

	public Page<Klinika> findAll(Pageable page) {
		return klinikaRepo.findAll(page);
	}

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

}
