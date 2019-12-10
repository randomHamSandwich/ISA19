package com.isa.isa19.security.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isa.isa19.model.Pacijent;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
	private Long id;
	private String email;
	@JsonIgnore
	private String lozinka;
	private String ime;
	private String prezime;
	private String ulica;
	private String brojUlice;
	private String grad;
	private String drzava;
	private String brojTelefona;
	private String jmbg;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String email, String lozinka, String ime, String prezime, String ulica,
			String brojUlice, String grad, String drzava, String brojTelefona, String jmbg,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.email = email;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.ulica = ulica;
		this.brojUlice = brojUlice;
		this.grad = grad;
		this.drzava = drzava;
		this.brojTelefona = brojTelefona;
		this.jmbg = jmbg;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Pacijent user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNazivRole().name())).collect(Collectors.toList());

		return new UserDetailsImpl(user.getIdOsoba(), user.getEmail(), user.getLozinka(), user.getIme(),
				user.getPrezime(), user.getUlica(), user.getBrojUlice(), user.getGrad(), user.getDrzava(),
				user.getBrojTelefona(), user.getJmbg(), authorities);

	}

	public Long getId() {
		return id;
	}

	public String getLozinka() {
		return lozinka;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getUlica() {
		return ulica;
	}

	public String getBrojUlice() {
		return brojUlice;
	}

	public String getGrad() {
		return grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public String getJmbg() {
		return jmbg;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public String getPassword() {
		return lozinka;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

}
