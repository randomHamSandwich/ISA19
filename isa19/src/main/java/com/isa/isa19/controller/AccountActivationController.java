package com.isa.isa19.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.isa19.model.Lek;
import com.isa.isa19.model.Pacijent;
import com.isa.isa19.model.StatusKorisnika;
import com.isa.isa19.service.PacijentService;

@RestController
@RequestMapping("/api/auth/activate")
public class AccountActivationController {
	
	@Autowired
	private PacijentService pacijentService;
	

	@GetMapping(value = "/{mail}")
	public void getStudent(@PathVariable String mail) {
		Optional<Pacijent> pacijent = pacijentService.findByEmail(mail);

		if (!pacijent.isPresent()) {
			
			System.out.println("korisnik sa "+mail+"  email ne postoji ");
			return;
		}
		
		if(pacijent.get().getStatusKorisnika()== StatusKorisnika.NOT_ACTIVATED) {
			pacijent.get().setStatusKorisnika(StatusKorisnika.ACTIVATED_IN_USE);
			Pacijent p = pacijent.get();
			p = pacijentService.save(p);
			System.out.println("nalog korisnika aktiviran");
		}
		
	}


}
