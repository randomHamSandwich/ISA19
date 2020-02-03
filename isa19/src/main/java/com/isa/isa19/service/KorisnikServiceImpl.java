package com.isa.isa19.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.isa19.dto.KorisnikDTO;
import com.isa.isa19.dto.LekarDTO;
import com.isa.isa19.dto.LozinkeDTO;
import com.isa.isa19.message.response.ResponseMessage;
import com.isa.isa19.model.Korisnik;
import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Operacija;
import com.isa.isa19.model.Pacijent;
import com.isa.isa19.model.Pregled;
import com.isa.isa19.model.Specijalizacija;
import com.isa.isa19.model.StatusKorisnika;
import com.isa.isa19.model.Usluga;
import com.isa.isa19.repository.KorisnikRepo;
import com.isa.isa19.util.DateChecker;

@Service
@Transactional(readOnly = true)
public class KorisnikServiceImpl implements KorisnikService {

	@Autowired
	private KorisnikRepo korisnikRepo;

	@Autowired
	private UslugaService uslugaService;

	@Autowired
	private PregledService pregledService;

	@Autowired
	private OperacijaService operacijaService;

	@Override
	public Optional<Korisnik> findByEmail(String email) {
		return korisnikRepo.findByEmail(email);
	}

	@Override
	public List<Korisnik> findAll() {
		return korisnikRepo.findAll();
	}

	@Override
	@Transactional
	public Korisnik save(Korisnik pacijent) {
		return korisnikRepo.save(pacijent);
	}

	@Override
	@Transactional
	public Lekar save(Lekar lekar) {
		return korisnikRepo.save(lekar);
	}

	@Override
	@Transactional
	public Pacijent save(Pacijent pacijent) {
		return korisnikRepo.save(pacijent);
	}

	@Override
	@Transactional
	public Lekar updateLekarOcena(Lekar lekar) {
		List<Pregled> pregledi = pregledService.findPregledByIdLekarAndOcenALekraNotNull(lekar.getIdOsoba());
		float konacnaOcenaLekara = 0;
		for (Pregled pregled : pregledi) {
			konacnaOcenaLekara += pregled.getOcenaLekara();
		}
		List<Operacija> operacije = operacijaService.findByIdLekarAndOcenaLekaraNotNull(lekar.getIdOsoba());
		for (Operacija operacija : operacije) {
			konacnaOcenaLekara += operacija.getOcenaLekara();
		}

		lekar.setOcenaLekar(konacnaOcenaLekara / (pregledi.size() + operacije.size()));
		return korisnikRepo.save(lekar);

	}

	@Override
	public List<Lekar> findBySpecijalizacija(Specijalizacija specijalizacija) {
		return korisnikRepo.findBySpecijalizacija(specijalizacija);
	}

//	TODO skrati kod da koristi osnovnaPretraga
	@Override
	public List<LekarDTO> findLekarBySpecAndDate(Long idKlinika, Specijalizacija specijalizacija,
			LocalDate specifiedDate) {
		List<Lekar> lekari = korisnikRepo.findLekarKlSpec(idKlinika, specijalizacija.toString());
		List<Lekar> slobodniLekari = new ArrayList<>();

		for (Lekar lekar : lekari) {
			boolean imaOdsustvo = DateChecker.daLiLekarImaOdsustvo(lekar, specifiedDate);
			boolean imaTermin = DateChecker.daLiLekarImaZakazaneIliBrzePreglede(lekar, specifiedDate);
			boolean imaOperaciju = DateChecker.daLiLekarImaOperaciju(lekar, specifiedDate);
			System.out.println("\n\n+++++++++++++++++++++++++++++++  imaOdsustvo:" + imaOdsustvo + " imaTermin: "
					+ imaTermin + " imaOperaciju: " + imaOperaciju);
			if (!imaOdsustvo && !imaTermin && !imaOperaciju) {

				slobodniLekari.add(lekar);
			}
		}

		return getSlobodniLekariDTO(slobodniLekari, idKlinika, specifiedDate);
	}

	public Set<Lekar> osnovnaPretraga(Long idKlinika, Specijalizacija specijalizacija, LocalDate specifiedDate) {
		List<Lekar> lekari = korisnikRepo.findLekarKlSpec(idKlinika, specijalizacija.toString());
		Set<Lekar> slobodniLekari = new HashSet<>();

		for (Lekar lekar : lekari) {
			boolean imaOdsustvo = DateChecker.daLiLekarImaOdsustvo(lekar, specifiedDate);
			boolean imaTermin = DateChecker.daLiLekarImaZakazaneIliBrzePreglede(lekar, specifiedDate);
			boolean imaOperaciju = DateChecker.daLiLekarImaOperaciju(lekar, specifiedDate);
			System.out.println("\n\n+++++++++++++++++++++++++++++++  imaOdsustvo:" + imaOdsustvo + " imaTermin: "
					+ imaTermin + " imaOperaciju: " + imaOperaciju);
			if (!imaOdsustvo && !imaTermin && !imaOperaciju) {

				slobodniLekari.add(lekar);
			}
		}
		return slobodniLekari;
	}

	@Override
	public List<LekarDTO> findLekarBySpecAndDateOcenaImePrezime(Long idKlinike, Specijalizacija spec,
			LocalDate specifiedDate, Float omin, Float omax, String ime, String prezime) {
		Float min = omin;
		Float max = omax;
		if (omin > omax) {
			min = omax;
			max = omin;
		}
		List<Lekar> lekariResult = new ArrayList<>();
		Set<Lekar> lekarSpecDate = osnovnaPretraga(idKlinike, spec, specifiedDate);
		for (Lekar lekar : lekarSpecDate) {

			if (lekar.getOcenaLekar() != null) {
				System.out.println("///////////////" + lekar.toString() + "\n" + ime + "   " + prezime + " _" + min
						+ "_ _" + max + "_");
				System.out.println(lekar.getOcenaLekar() >= min);
				System.out.println(lekar.getOcenaLekar() <= max);
				System.out.println(lekar.getIme().startsWith(ime));
				System.out.println(lekar.getPrezime().startsWith(prezime));
				if (lekar.getOcenaLekar() >= min && lekar.getOcenaLekar() <= max
						&& lekar.getIme().toLowerCase().startsWith(ime.toLowerCase())
						&& lekar.getPrezime().toLowerCase().startsWith(prezime.toLowerCase())) {

					lekariResult.add(lekar);
				}
			}
		}
		return getSlobodniLekariDTO(lekariResult, idKlinike, specifiedDate);
	}

	@Override
	public List<LekarDTO> findLekarBySpecAndDateOcenaIme(Long idKlinike, Specijalizacija spec, LocalDate specifiedDate,
			Float omin, Float omax, String ime) {
		Float min = omin;
		Float max = omax;
		if (omin > omax) {
			min = omax;
			max = omin;
		}
		List<Lekar> lekariResult = new ArrayList<>();
		Set<Lekar> lekarSpecDate = osnovnaPretraga(idKlinike, spec, specifiedDate);
		for (Lekar lekar : lekarSpecDate) {

			if (lekar.getOcenaLekar() != null) {
				System.out.println(
						"///////////////" + lekar.toString() + "\n" + ime + "   " + " _" + min + "_ _" + max + "_");
				System.out.println(lekar.getOcenaLekar() >= min);
				System.out.println(lekar.getOcenaLekar() <= max);
				System.out.println(lekar.getIme().startsWith(ime));
				if (lekar.getOcenaLekar() >= min && lekar.getOcenaLekar() <= max
						&& lekar.getIme().toLowerCase().startsWith(ime.toLowerCase())) {

					lekariResult.add(lekar);
				}
			}
		}
		return getSlobodniLekariDTO(lekariResult, idKlinike, specifiedDate);
	}

	@Override
	public List<LekarDTO> findLekarBySpecAndDateOcenaPrezime(Long idKlinike, Specijalizacija spec,
			LocalDate specifiedDate, Float omin, Float omax, String prezime) {

		Float min = omin;
		Float max = omax;
		if (omin > omax) {
			min = omax;
			max = omin;
		}
		List<Lekar> lekariResult = new ArrayList<>();
		Set<Lekar> lekarSpecDate = osnovnaPretraga(idKlinike, spec, specifiedDate);
		for (Lekar lekar : lekarSpecDate) {

			if (lekar.getOcenaLekar() != null) {
				System.out.println(
						"///////////////" + lekar.toString() + "\n" + "   " + prezime + " _" + min + "_ _" + max + "_");
				System.out.println(lekar.getOcenaLekar() >= min);
				System.out.println(lekar.getOcenaLekar() <= max);
				System.out.println(lekar.getPrezime().startsWith(prezime));
				if (lekar.getOcenaLekar() >= min && lekar.getOcenaLekar() <= max
						&& lekar.getPrezime().toLowerCase().startsWith(prezime.toLowerCase())) {

					lekariResult.add(lekar);
				}
			}
		}
		return getSlobodniLekariDTO(lekariResult, idKlinike, specifiedDate);
	}

	@Override
	public List<LekarDTO> findLekarBySpecAndDateOcena(Long idKlinike, Specijalizacija spec, LocalDate specifiedDate,
			Float omin, Float omax) {
		Float min = omin;
		Float max = omax;
		if (omin > omax) {
			min = omax;
			max = omin;
		}
		List<Lekar> lekariResult = new ArrayList<>();
		Set<Lekar> lekarSpecDate = osnovnaPretraga(idKlinike, spec, specifiedDate);
		for (Lekar lekar : lekarSpecDate) {

			if (lekar.getOcenaLekar() != null) {
				System.out.println("///////////////" + lekar.toString() + "\n" + " _" + min + "_ _" + max + "_");
				System.out.println(lekar.getOcenaLekar() >= min);
				System.out.println(lekar.getOcenaLekar() <= max);
				if (lekar.getOcenaLekar() >= min && lekar.getOcenaLekar() <= max) {

					lekariResult.add(lekar);
				}
			}
		}
		return getSlobodniLekariDTO(lekariResult, idKlinike, specifiedDate);
	}

	@Override
	public List<LekarDTO> findLekarBySpecAndDateImePrezime(Long idKlinike, Specijalizacija spec,
			LocalDate specifiedDate, String ime, String prezime) {

		List<Lekar> lekariResult = new ArrayList<>();
		Set<Lekar> lekarSpecDate = osnovnaPretraga(idKlinike, spec, specifiedDate);
		for (Lekar lekar : lekarSpecDate) {

			System.out.println("///////////////" + lekar.toString() + "\n" + ime + "   " + prezime + " _");
			System.out.println(lekar.getIme().startsWith(ime));
			System.out.println(lekar.getPrezime().startsWith(prezime));
			if (lekar.getIme().toLowerCase().startsWith(ime.toLowerCase())
					&& lekar.getPrezime().toLowerCase().startsWith(prezime.toLowerCase())) {

				lekariResult.add(lekar);
			}

		}
		return getSlobodniLekariDTO(lekariResult, idKlinike, specifiedDate);
	}

	@Override
	public List<LekarDTO> findLekarBySpecAndDateIme(Long idKlinike, Specijalizacija spec, LocalDate specifiedDate,
			String ime) {

		List<Lekar> lekariResult = new ArrayList<>();
		Set<Lekar> lekarSpecDate = osnovnaPretraga(idKlinike, spec, specifiedDate);
		for (Lekar lekar : lekarSpecDate) {

			System.out.println("///////////////" + lekar.toString() + "\n" + ime + "   " + " _");
			System.out.println(lekar.getIme().startsWith(ime));
			if (lekar.getIme().toLowerCase().startsWith(ime.toLowerCase())) {

				lekariResult.add(lekar);
			}

		}
		return getSlobodniLekariDTO(lekariResult, idKlinike, specifiedDate);
	}

	@Override
	public List<LekarDTO> findLekarBySpecAndDatePrezime(Long idKlinike, Specijalizacija spec, LocalDate specifiedDate,
			String prezime) {

		List<Lekar> lekariResult = new ArrayList<>();
		Set<Lekar> lekarSpecDate = osnovnaPretraga(idKlinike, spec, specifiedDate);
		for (Lekar lekar : lekarSpecDate) {

			System.out.println("///////////////" + lekar.toString() + "\n" + "   " + prezime + " _");
			System.out.println(lekar.getPrezime().startsWith(prezime));
			if (lekar.getPrezime().toLowerCase().startsWith(prezime.toLowerCase())) {

				lekariResult.add(lekar);
			}

		}
		return getSlobodniLekariDTO(lekariResult, idKlinike, specifiedDate);
	}

	@Override
	public List<LekarDTO> getSlobodniLekariDTO(Collection<Lekar> slobodniLekari, Long idKlinika,
			LocalDate specifiedDate) {
		List<LekarDTO> lekariDTO = new ArrayList<>();
		for (Lekar l : slobodniLekari) {
			Optional<Usluga> usluga = uslugaService.findUsluga(l.getSpecijalizacija().name(), idKlinika);

			ArrayList<String> sviTermini = new ArrayList<String>(
					Arrays.asList("08:00:00 08:30:00", "08:30:00 09:00:00", "09:00:00 09:30:00", "09:30:00 10:00:00",
							"10:00:00 10:30:00", "10:30:00 11:00:00", "11:00:00 11:30:00", "11:30:00 12:00:00",
							"12:00:00 12:30:00", "12:30:00 13:00:00", "13:00:00 13:30:00", "13:30:00 14:00:00",
							"14:00:00 14:30:00", "14:30:00 15:00:00", "15:00:00 15:30:00", "15:30:00 16:00:00"));

			List<String> zauzetiTermini = pregledService.getZauzetiPreglediVreme(l.getIdOsoba(), specifiedDate);
			for (String vreme : zauzetiTermini) {
				sviTermini.remove(vreme);
			}

			if (!usluga.isPresent()) {
				lekariDTO.add(new LekarDTO(l, sviTermini));
			} else {
				lekariDTO.add(new LekarDTO(l, usluga.get().getCena(), sviTermini, l.getKlinika().getGrad()));
			}

		}
		return lekariDTO;

	}

	@Override
	public Lekar findLekarById(Long id) {
		return (Lekar) korisnikRepo.findById(id).get();
	}

	@Override
	public Pacijent findPacijentById(Long id) {
		return (Pacijent) korisnikRepo.findById(id).get();

	}

	@Override
	public List<LekarDTO> findByKlinika(Long idKlinika) {
		List<Lekar> lekari = korisnikRepo.findByIdKlinika(idKlinika);
		List<LekarDTO> lekariDTO = new ArrayList<>();
		for (Lekar lekar : lekari) {
			Optional<Usluga> usluga = uslugaService.findUsluga(lekar.getSpecijalizacija().name(), idKlinika);

			if (!usluga.isPresent()) {
				lekariDTO.add(new LekarDTO(lekar));
			} else {
				lekariDTO.add(new LekarDTO(lekar, usluga.get().getCena()));
			}
		}

		return lekariDTO;
	}
	
	

	@Override
	public List<LekarDTO> findByKlinika(Long idKlinika, Pageable page) {
			List<Lekar> lekari = korisnikRepo.findByIdKlinikaPageable(idKlinika, page);
			List<LekarDTO> lekariDTO = new ArrayList<>();
			for (Lekar lekar : lekari) {
				Optional<Usluga> usluga = uslugaService.findUsluga(lekar.getSpecijalizacija().name(), idKlinika);

				if (!usluga.isPresent()) {
					lekariDTO.add(new LekarDTO(lekar));
				} else {
					lekariDTO.add(new LekarDTO(lekar, usluga.get().getCena()));
				}
			}

			return lekariDTO;
		}
	@Override
	public List<Lekar> findLekarKlSpec(Long idKlinika, String spec) {
		return korisnikRepo.findLekarKlSpec(idKlinika, spec);
	}

	@Override
	@Transactional
	public KorisnikDTO saveKorisnik(KorisnikDTO korisnikDTO) {
		Korisnik korisnik = new Korisnik();
		korisnik.setEmail(korisnikDTO.getEmail());
		korisnik.setLozinka(korisnikDTO.getLozinka());
		korisnik.setIme(korisnikDTO.getIme());
		korisnik.setPrezime(korisnikDTO.getPrezime());
		korisnik.setUlica(korisnikDTO.getUlica());
		korisnik.setBrojUlice(korisnikDTO.getBrojUlice());
		korisnik.setGrad(korisnikDTO.getGrad());
		korisnik.setDrzava(korisnikDTO.getDrzava());
		korisnik.setBrojTelefona(korisnikDTO.getBrojTelefona());
		korisnik.setJmbg(korisnikDTO.getJmbg());
		korisnik.setStatusKorisnika(StatusKorisnika.NOT_ACTIVATED);
		korisnik = korisnikRepo.save(korisnik);
		return new KorisnikDTO(korisnik);
	}

	@Override
	@Transactional
	public Optional<KorisnikDTO> updateKorisnik(String email, KorisnikDTO korisnikDTO) {

		Optional<Korisnik> korisnik = korisnikRepo.findByEmail(email);

		if (!korisnik.isPresent()) {
			return Optional.empty();
		}

		korisnik.get().setIme(korisnikDTO.getIme());
		korisnik.get().setPrezime(korisnikDTO.getPrezime());
		korisnik.get().setUlica(korisnikDTO.getUlica());
		korisnik.get().setBrojUlice(korisnikDTO.getBrojUlice());
		korisnik.get().setGrad(korisnikDTO.getGrad());
		korisnik.get().setDrzava(korisnikDTO.getDrzava());
		korisnik.get().setBrojTelefona(korisnikDTO.getBrojTelefona());
		Korisnik k = korisnik.get();
		k = korisnikRepo.save(k);
		return Optional.of(new KorisnikDTO(k));

	}

	@Override
	@Transactional
	public Optional<KorisnikDTO> changePassword(String email, LozinkeDTO lozinkeDTO) {

//		Optional<Korisnik> korisnik = korisnikRepo.findByEmail(email);
//
//		if (!korisnik.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//
//		if (!encoder.matches(lozinkeDTO.getLozinkaStara(), korisnik.get().getLozinka())) {
//			return new ResponseEntity<>(new ResponseMessage("Fail -> old password is wrong!"), HttpStatus.BAD_REQUEST);
//
//		}
//		korisnik.get().setLozinka(encoder.encode(lozinkeDTO.getLozinkaNova()));
//		Korisnik k = korisnik.get();
//		k = korisnikRepo.save(k);
//		return new ResponseEntity<>(new KorisnikDTO(k), HttpStatus.OK);
//		
//		
		return null;
	}

}
