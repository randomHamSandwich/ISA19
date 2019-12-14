package com.isa.isa19.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.isa19.model.Korisnik;
import com.isa.isa19.model.Lek;
import com.isa.isa19.model.Pacijent;
import com.isa.isa19.model.StatusKorisnika;
import com.isa.isa19.service.KorisnikService;
import com.isa.isa19.service.PacijentService;

@RestController
@RequestMapping("/api/auth/activate")
public class AccountActivationController {
	
	@Autowired
	private KorisnikService korisnikService;
	

	@GetMapping(value = "/{mail}")
	public void getStudent(@PathVariable String mail) {
		Optional<Korisnik> korisnik = korisnikService.findByEmail(mail);

		if (!korisnik.isPresent()) {
			
			System.out.println("korisnik sa "+mail+"  email ne postoji ");
			return;
		}
		
		if(korisnik.get().getStatusKorisnika()== StatusKorisnika.NOT_ACTIVATED) {
			korisnik.get().setStatusKorisnika(StatusKorisnika.ACTIVATED_IN_USE);
			Korisnik k = korisnik.get();
			k = korisnikService.save(k);
			System.out.println("nalog korisnika aktiviran");
		}
		
	}


}
