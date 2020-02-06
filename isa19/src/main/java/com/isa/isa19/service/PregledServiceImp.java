package com.isa.isa19.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.isa19.dto.BrziPregledDTO;
import com.isa.isa19.dto.PregledDTO;
import com.isa.isa19.dto.PregledZakaziDTO;
import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Pacijent;
import com.isa.isa19.model.Pregled;
import com.isa.isa19.model.StatusPregledaOperacije;
import com.isa.isa19.repository.PregledRepo;
import com.isa.isa19.util.DateChecker;

@Service
@Transactional(readOnly = true)
public class PregledServiceImp implements PregledService {

	@Autowired
	private PregledRepo pregledRepo;

	@Autowired
	private KorisnikService korisnikService;

	@Autowired
	private KlinikaSevice klinikaService;

	@Autowired
	private EmailService emailService;

	@Override
	public List<Pregled> findByIdPacijentAndStatus(Long id, String status) {
		return pregledRepo.findByIdPacijentAndStatus(id, status);
	}

	@Override
	public Optional<Pregled> findOne(Long id) {
		return pregledRepo.findById(id);
	}

	@Override
	public List<Pregled> findAll() {
		return pregledRepo.findAll();
	}

	@Override
	@Transactional
	public Pregled save(Pregled pregled) {
		return pregledRepo.save(pregled);
	}

	@Override
	public List<String> getZauzetiPreglediVreme(Long idLekar, LocalDate date) {
		List<String> result = new ArrayList<String>();
		for (Pregled pregled : pregledRepo.findByLekarAndDate(idLekar, date)) {
			// 09:30:00 10:00:00
			String startTime = pregled.getVremePocetka().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			String endTime = pregled.getVremeZavrsetka().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			result.add(startTime + " " + endTime);
		}
		return result;
	}

	@Override
	public List<Pregled> findPregledByIdLekarAndOcenALekraNotNull(Long idOsoba) {
		return pregledRepo.findByLekarWhereOcenaLNotNull(idOsoba);
	}

	@Override
	public List<Pregled> findByIdKlinikaAndOcenaKlinikaNotNull(Long idKlinika) {
		return pregledRepo.findByIdKlinikaAndOcenaKlinikaNotNull(idKlinika);
	}

	@Override
	public List<PregledDTO> getIzvrseniPreglediByIdKorisnik(Long idKorisnik) {
		List<Pregled> pregledi = pregledRepo.findByIdPacijentAndStatus(idKorisnik,
				StatusPregledaOperacije.IZVRSEN_PREGLED.toString());
		List<PregledDTO> preglediDTO = new ArrayList<>();
		for (Pregled p : pregledi) {
			preglediDTO.add(new PregledDTO(p, p.getVremePocetka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm")),
					p.getVremeZavrsetka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), p.getLekar().getIme(),
					p.getLekar().getPrezime(), p.getDijagnoza().getNazivDijagnoza(),
					p.getLekar().getSpecijalizacija().toString(), p.getKlinika().getNaziv()));
		}
		return preglediDTO;
	}

	@Override
	public List<PregledDTO> getZakazaniPreglediByIdKorisnik(Long idKorisnik) {
		List<Pregled> pregledi = pregledRepo.findByIdPacijentAndStatus(idKorisnik,
				StatusPregledaOperacije.ZAKAZAN_PREGLED.toString());
		List<PregledDTO> preglediDTO = new ArrayList<>();
		for (Pregled p : pregledi) {
			preglediDTO.add(new PregledDTO(p, p.getVremePocetka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
					p.getVremeZavrsetka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), p.getLekar().getIme(),
					p.getLekar().getPrezime(), p.getLekar().getSpecijalizacija().toString(), p.getKlinika().getNaziv(),
					p.getKlinika().getGrad(), p.getKlinika().getUlica(), p.getKlinika().getBrojUlice()));
		}
		return preglediDTO;
	}

	@Override
	@Transactional
	public Optional<PregledDTO> rezervisiPregled(PregledZakaziDTO pregledZakaziDTO, LocalDateTime start) {

		Lekar lekar = korisnikService.findLekarById(Long.valueOf(pregledZakaziDTO.getIdLekar()));
		Pacijent pacijent = korisnikService.findPacijentById(Long.valueOf(pregledZakaziDTO.getIdPacijent()));

		boolean imaOdsustvo = DateChecker.daLiLekarImaOdsustvo(lekar, start.toLocalDate());
		boolean imaOvajTerminZakazan = DateChecker.daLiLekarImaZakazanIliBrziPregledTerminIliRezervisan(lekar, start);
		boolean imaOperaciju = DateChecker.daLiLekarImaOperaciju(lekar, start.toLocalDate());

		if (!imaOdsustvo && !imaOvajTerminZakazan && !imaOperaciju) {

			Pregled pregled = new Pregled();
			pregled.setVremePocetka(start);
			pregled.setVremeZavrsetka(start.plusMinutes(30));
			pregled.setLekar(lekar);
			pregled.setPacijent(pacijent);
			pregled.setStatus(StatusPregledaOperacije.REZERVISAN_PREGLED);
			pregled.setKlinika(lekar.getKlinika());

			pregled = pregledRepo.save(pregled);
			emailService.sendZavrsiZakazivanjeMailom(pregled);

			return Optional.of(new PregledDTO(pregled, pregled.getVremePocetka().toString(),
					pregled.getVremeZavrsetka().toString()));
		} else {
			return Optional.empty();
		}

	}

	@Override
	@Transactional
	public Optional<PregledDTO> zakaziPregled(Long idPregleda, String mail) {

		Pregled rezervisaniPregled = pregledRepo.getOne(idPregleda);
		if (!rezervisaniPregled.getPacijent().getEmail().equals(mail)) {
			System.out.println(
					"    mail's are not the same" + mail + " !=" + rezervisaniPregled.getPacijent().getEmail());
			return Optional.empty();
		}
		Lekar lekar = rezervisaniPregled.getLekar();

		boolean imaOdsustvo = DateChecker.daLiLekarImaOdsustvo(lekar,
				rezervisaniPregled.getVremePocetka().toLocalDate());
		boolean imaOvajTerminZakazan = DateChecker.daLiLekarImaZakazanIliBrziPregledTerminIliRezervisan(lekar,
				rezervisaniPregled.getVremePocetka());
		boolean imaOperaciju = DateChecker.daLiLekarImaOperaciju(lekar,
				rezervisaniPregled.getVremePocetka().toLocalDate());

		if (!imaOdsustvo && !imaOvajTerminZakazan && !imaOperaciju) {

			rezervisaniPregled.setStatus(StatusPregledaOperacije.ZAKAZAN_PREGLED);

			rezervisaniPregled = pregledRepo.save(rezervisaniPregled);
			return Optional.of(new PregledDTO(rezervisaniPregled, rezervisaniPregled.getVremePocetka().toString(),
					rezervisaniPregled.getVremeZavrsetka().toString()));
		} else {
			return Optional.empty();
		}

	}

	@Override
	@Transactional
	public Optional<PregledDTO> otkaziRezevisaniPregled(Long idPregleda, String mail) {

		Pregled rezervisaniPregled = pregledRepo.getOne(idPregleda);
		if (!rezervisaniPregled.getPacijent().getEmail().equals(mail)) {
			System.out.println(
					"    mail's are not the same" + mail + " !=" + rezervisaniPregled.getPacijent().getEmail());
			return Optional.empty();
		}
		rezervisaniPregled.setStatus(StatusPregledaOperacije.OTKAZAN_PREGLED);
		rezervisaniPregled = pregledRepo.save(rezervisaniPregled);
		return Optional.of(new PregledDTO(rezervisaniPregled, rezervisaniPregled.getVremePocetka().toString(),
				rezervisaniPregled.getVremeZavrsetka().toString()));
	}

	@Override
	@Transactional
	public Optional<PregledDTO> otkaziPregled(PregledDTO pregledDTO) {

		Optional<Pregled> pregled = pregledRepo.findById(pregledDTO.getIdPregleda());

		if (!pregled.isPresent() || pregled.get().getStatus() != StatusPregledaOperacije.ZAKAZAN_PREGLED) {
			return Optional.empty();
		}
		
		LocalDateTime now = LocalDateTime.now();
		now=now.plusDays(1);
		if(now.isAfter(pregled.get().getVremePocetka())) {
//			TODO vrati info na front
			System.out.println(" mora biti barem 24 sata pre pregleda da bi se odkazao");
			System.out.println(now + "\n" +pregled.get().getVremePocetka()) ;
			return Optional.empty();
		}
		else {
			System.out.println("proslo, mora biti barem 24 sata pre pregleda da bi se odkazao");
			System.out.println(now + "\n" +pregled.get().getVremePocetka()) ;
			
		}
		
		pregled.get().setStatus(StatusPregledaOperacije.OTKAZAN_PREGLED);

		Pregled p = pregled.get();
		p = pregledRepo.save(p);
		return Optional.of(new PregledDTO(p, null, null));
	}

	@Override
	@Transactional
	public Optional<PregledDTO> oceniLekaraPregled(PregledDTO pregledDTO) {

		Optional<Pregled> pregled = pregledRepo.findById(pregledDTO.getIdPregleda());
		if (!pregled.isPresent() || pregled.get().getStatus() != StatusPregledaOperacije.IZVRSEN_PREGLED
				|| pregledDTO.getOcenaLekara() == null
				|| (pregledDTO.getOcenaLekara() != 5 && pregledDTO.getOcenaLekara() != 4
						&& pregledDTO.getOcenaLekara() != 3 && pregledDTO.getOcenaLekara() != 2
						&& pregledDTO.getOcenaLekara() != 1)) {
			return Optional.empty();
		}

		pregled.get().setOcenaLekara(pregledDTO.getOcenaLekara());
		Pregled p = pregled.get();
		p = pregledRepo.save(p);

//		u ovom momentu update golobalnu ocenu LEKARA- nalazi se u svakom lekaru
//		Lekar lekar = korisnikService.findLekarById(pregledDTO.getIdLekara());
//		korisnikService.updateLekarOcena(lekar);
		korisnikService.updateLekarOcena(p.getLekar());

		return Optional.of(new PregledDTO(p, null, null));
	}

	@Override
	@Transactional
	public Optional<PregledDTO> oceniKlinikuPregled(PregledDTO pregledDTO) {

		Optional<Pregled> pregled = pregledRepo.findById(pregledDTO.getIdPregleda());

		if (!pregled.isPresent() || pregled.get().getStatus() != StatusPregledaOperacije.IZVRSEN_PREGLED
				|| pregledDTO.getOcenaKilinike() == null
				|| (pregledDTO.getOcenaKilinike() != 5 && pregledDTO.getOcenaKilinike() != 4
						&& pregledDTO.getOcenaKilinike() != 3 && pregledDTO.getOcenaKilinike() != 2
						&& pregledDTO.getOcenaKilinike() != 1)) {
			return Optional.empty();
		}

		pregled.get().setOcenaKilinike(pregledDTO.getOcenaKilinike());

		Pregled p = pregled.get();
		p = pregledRepo.save(p);

//		 u ovom momentu update golobalnu ocenu KLINIKE- nalazi se u svakoj klinici
//		Lekar lekar = korisnikService.findLekarById(pregledDTO.getIdLekara());
//		klinikaService.updateKlinikaOcena(lekar.getKlinika());
		klinikaService.updateKlinikaOcena(p.getKlinika());

		return Optional.of(new PregledDTO(p, null, null));
	}

	@Override
	public List<PregledDTO> getAllBrziPregledi() {
		List<PregledDTO> resultPregledDTO = new ArrayList<>();
		List<Pregled> pregledi = pregledRepo.findByStatus(StatusPregledaOperacije.BRZI_PREGLED);
		for (Pregled p : pregledi) {
			resultPregledDTO
					.add(new PregledDTO(p, p.getVremePocetka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
							p.getVremeZavrsetka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
							p.getLekar().getIme(), p.getLekar().getPrezime(),
							p.getLekar().getSpecijalizacija().toString(), p.getKlinika().getNaziv(),
							p.getKlinika().getGrad(), p.getKlinika().getUlica(), p.getKlinika().getBrojUlice(),
							p.getLekar().getOcenaLekar(), p.getKlinika().getOcenaKlinike()));
		}
		return resultPregledDTO;
	}

	@Override
	@Transactional
	public Optional<PregledDTO> zakaziBrziPregledIPosaljiMail(BrziPregledDTO brziPregldDTO) {

		Optional<Pregled> pregled = pregledRepo.findById(brziPregldDTO.getIdPregleda());
		if (!pregled.isPresent() ) {
			return Optional.empty();
		}
//		pregled je vec zakazn 
		if(pregled.get().getStatus().equals(StatusPregledaOperacije.ZAKAZAN_PREGLED) || pregled.get().getPacijent() !=null) {
			return Optional.empty();
		}

		Pacijent pacijent = korisnikService.findPacijentById(brziPregldDTO.getIdPacijent());
		pregled.get().setPacijent(pacijent);
		
		pregled.get().setStatus(StatusPregledaOperacije.ZAKAZAN_PREGLED);
		Pregled p = pregled.get();
		p = pregledRepo.save(p);

		emailService.sendBrziPregledMail(p);

		return Optional.of(new PregledDTO(p, p.getVremePocetka().toString(), p.getVremeZavrsetka().toString()));
	}

	@Override
	public List<PregledDTO> getBolestiPacijent(Long idKorisnik) {
		List<Pregled> pregledi = pregledRepo.findByIdPacijentDijagnozaNotNull(idKorisnik);
		List<PregledDTO> pregledDTO= new ArrayList<>();
		for (Pregled pregled : pregledi) {
			pregledDTO.add(new PregledDTO(pregled.getVremePocetka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), pregled.getDijagnoza().getNazivDijagnoza()));
		}
		
		return pregledDTO;
	}

}
