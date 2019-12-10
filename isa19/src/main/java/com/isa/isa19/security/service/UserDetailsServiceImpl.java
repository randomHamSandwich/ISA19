package com.isa.isa19.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.isa.isa19.model.Pacijent;
import com.isa.isa19.repository.PacijentRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {

	@Autowired
	PacijentRepo pacijentRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Pacijent pacijent= pacijentRepo.findByEmail(email).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + email));

		return UserDetailsImpl.build(pacijent);
	}
	
	

}
