package com.isa.isa19.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.isa19.dto.LekarDTO;
import com.isa.isa19.model.Korisnik;
import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Pacijent;
import com.isa.isa19.model.Specijalizacija;
import com.isa.isa19.model.Usluga;
import com.isa.isa19.repository.KorisnikRepo;
import com.isa.isa19.util.DateChecker;

@Service
@Transactional(readOnly = true)
public class KorisnikServiceImpl implements KorisnikService {

	@Autowired
	private KorisnikRepo korisnikRepo;

	@Autowired
	private KorisnikService korisnikService;

	@Autowired
	private UslugaService uslugaService;

	@Autowired
	private PregledService pregledService;

	public Optional<Korisnik> findByEmail(String email) {
		return korisnikRepo.findByEmail(email);
	}

	public List<Korisnik> findAll() {
		return korisnikRepo.findAll();
	}

	@Transactional
	public Korisnik save(Korisnik pacijent) {
		return korisnikRepo.save(pacijent);
	}

	@Transactional
	public void remove(Long id) {
		korisnikRepo.deleteById(id);
	}

	public Page<Korisnik> findAll(Pageable page) {
		return korisnikRepo.findAll(page);
	}

	public List<Lekar> findLekarKlSpec(String idKlinika, String spec) {
		return korisnikRepo.findLekarKlSpec(idKlinika, spec);
	}

	public List<Lekar> findByIdKlinika(String idKlinika) {
		return korisnikRepo.findByIdKlinika(idKlinika);
	}

	public List<Lekar> findBySpecijalizacija(Specijalizacija specijalizacija) {
		return korisnikRepo.findBySpecijalizacija(specijalizacija);
	}

	@Override
	public List<LekarDTO> findLekarBySpecAndDate(String idKlinika, Specijalizacija specijalizacija,
			LocalDate specifiedDate) {
		List<Lekar> lekari = korisnikService.findLekarKlSpec(idKlinika, specijalizacija.toString());
		List<Lekar> slobodniLekari = new ArrayList<>();

		for (Lekar lekar : lekari) {
			boolean imaOdsustvo = DateChecker.daLiLekarImaOdsustvo(lekar, specifiedDate);
			boolean imaTermin = DateChecker.daLiLekarImaPreglede(lekar, specifiedDate);
			boolean imaOperaciju = DateChecker.daLiLekarImaOperaciju(lekar, specifiedDate);
			System.out.println("\n\n+++++++++++++++++++++++++++++++  imaOdsustvo:" + imaOdsustvo + " imaTermin: "
					+ imaTermin + " imaOperaciju: " + imaOperaciju);
			if (!imaOdsustvo && !imaTermin && !imaOperaciju) {
//				ArrayList<String> sviTermini = new  ArrayList<String>(Arrays.asList
//						("08:00:00 08:30:00" ,"08:30:00 09:00:00", "09:00:00 09:30:00", "09:30:00 10:00:00"
//						,"10:00:00 10:30:00", "10:30:00 11:00:00", "11:00:00 11:30:00"
//						,"11:30:00 12:00:00", "12:00:00 12:30:00", "12:30:00 13:00:00"
//						,"13:00:00 13:30:00", "13:30:00 14:00:00", "14:00:00 14:30:00"
//						,"14:30:00 15:00:00", "15:00:00 15:30:00", "15:30:00 16:00:00"));
//				
//				List<String> zauzetiTermini = pregledService.getZauzetiPreglediVreme(lekar.getIdOsoba().toString(), specifiedDate);
//				for (String vreme : zauzetiTermini) {
//					sviTermini.remove(vreme);
//				}
				slobodniLekari.add(lekar);
			}
		}

		return convertDataToDTO(slobodniLekari, idKlinika, specifiedDate);
	}

	@Override
	public List<LekarDTO> convertDataToDTO(Collection<Lekar> slobodniLekari, String idKlinika,
			LocalDate specifiedDate) {
		List<LekarDTO> lekariDTO = new ArrayList<>();
		for (Lekar l : slobodniLekari) {
			Optional<Usluga> usluga = uslugaService.findUsluga(l.getSpecijalizacija().name(), idKlinika);

			ArrayList<String> sviTermini = new ArrayList<String>(
					Arrays.asList("08:00:00 08:30:00", "08:30:00 09:00:00", "09:00:00 09:30:00", "09:30:00 10:00:00",
							"10:00:00 10:30:00", "10:30:00 11:00:00", "11:00:00 11:30:00", "11:30:00 12:00:00",
							"12:00:00 12:30:00", "12:30:00 13:00:00", "13:00:00 13:30:00", "13:30:00 14:00:00",
							"14:00:00 14:30:00", "14:30:00 15:00:00", "15:00:00 15:30:00", "15:30:00 16:00:00"));

			List<String> zauzetiTermini = pregledService.getZauzetiPreglediVreme(l.getIdOsoba().toString(),
					specifiedDate);
			for (String vreme : zauzetiTermini) {
				sviTermini.remove(vreme);
			}

			if (!usluga.isPresent()) {
				lekariDTO.add(new LekarDTO(l, sviTermini));
			} else {
				lekariDTO.add(new LekarDTO(l, usluga.get().getCena(), sviTermini));
			}

		}
		return lekariDTO;

	}

//	public List<LekarDTO> convertDataAndTimeToDTO(Collection<Lekar> slobodniLekari, String idKlinika) {
//		List<LekarDTO> lekariDTO = new ArrayList<>();
//		for (Lekar l : slobodniLekari) {
//			Optional<Usluga> usluga = uslugaService.findUsluga(l.getSpecijalizacija().name(), idKlinika);
//
//			if (!usluga.isPresent()) {
//				lekariDTO.add(new LekarDTO(l));
//			} else {
//				lekariDTO.add(new LekarDTO(l, usluga.get().getCena()));
//			}
//
//		}
//		return lekariDTO;
//	}

	@Override
	public Lekar findLekarById(Long id) {
		return (Lekar) korisnikRepo.findById(id).get();
	}

	@Override
	public Pacijent findPacijentById(Long id) {
		return (Pacijent) korisnikRepo.findById(id).get();

	}

}
