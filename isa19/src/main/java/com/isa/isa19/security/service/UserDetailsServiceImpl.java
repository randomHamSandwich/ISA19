package com.isa.isa19.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.isa.isa19.model.Korisnik;
import com.isa.isa19.repository.KorisnikRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	KorisnikRepo korisnikRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws AuthenticationException {

		Korisnik korisnik = korisnikRepo.findByEmail(email).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + email));

		switch (korisnik.getStatusKorisnika()) {
		case DELETED:
			throw new DisabledException(
					"This account was deleated contact adminstrator for more information\n" + email);
		case NOT_ACTIVATED:
			throw new DisabledException("Activate your account by clickng on activation link in your maik \n" + email);

		case ACTIVATED_IN_USE:
			break;
		default:
			throw new BadCredentialsException("Bad status in DB");
		}

		return UserDetailsImpl.build(korisnik);
	}

}
