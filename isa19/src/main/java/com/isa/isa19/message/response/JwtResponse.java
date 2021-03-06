package com.isa.isa19.message.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private String idKorisnik;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtResponse(String accessToken, String username, Collection<? extends GrantedAuthority> authorities, String idKorsnik) {
		this.token = accessToken;
		this.username = username;
		this.authorities = authorities;
		this.idKorisnik = idKorsnik;
	}

	public String getIdKorisnik() {
		return idKorisnik;
	}

	public void setIdKorisnik(String idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
}