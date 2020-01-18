package com.isa.isa19.dto;

import com.isa.isa19.model.Korisnik;
import com.isa.isa19.model.Pacijent;

public class PacijentDTO {

	private Long idOsoba;
	private String email;
	private String lozinka;
	private String ime;
	private String prezime;
	private String ulica;
	private String brojUlice;
	private String grad;
	private String drzava;
	private String brojTelefona;
	private String jmbg;

	public PacijentDTO(Pacijent p) {
		this(((Korisnik) p).getIdOsoba(), ((Korisnik) p).getEmail(), ((Korisnik) p).getLozinka(),
				((Korisnik) p).getIme(), ((Korisnik) p).getPrezime(), ((Korisnik) p).getUlica(),
				((Korisnik) p).getBrojUlice(), ((Korisnik) p).getGrad(), ((Korisnik) p).getDrzava(),
				((Korisnik) p).getBrojTelefona(), ((Korisnik) p).getJmbg());
	}

	public PacijentDTO() {
		super();
	}

	public PacijentDTO(Long idOsoba, String email, String lozinka, String ime, String prezime, String ulica,
			String brojUlice, String grad, String drzava, String brojTelefona, String jmbg) {
		super();
		this.idOsoba = idOsoba;
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
	}

	public Long getIdOsoba() {
		return idOsoba;
	}

	public void setIdOsoba(Long idOsoba) {
		this.idOsoba = idOsoba;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBrojUlice() {
		return brojUlice;
	}

	public void setBrojUlice(String brojUlice) {
		this.brojUlice = brojUlice;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

}
