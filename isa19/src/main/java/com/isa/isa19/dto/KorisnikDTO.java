package com.isa.isa19.dto;

import com.isa.isa19.model.Korisnik;
import com.isa.isa19.model.Pacijent;
import com.isa.isa19.model.StatusKorisnika;

//@Deprecated
public class KorisnikDTO {

	public long idOsoba;
	private java.lang.String email;
	private java.lang.String lozinka;
	private java.lang.String ime;
	private java.lang.String prezime;
	private java.lang.String ulica;
	private java.lang.String brojUlice;
	private java.lang.String grad;
	private java.lang.String drzava;
	private java.lang.String brojTelefona;
	private java.lang.String jmbg;

	public KorisnikDTO(Korisnik k) {
		this(k.getIdOsoba(), k.getEmail(), k.getLozinka(), k.getIme(), k.getPrezime(), k.getUlica(), k.getBrojUlice(),
				k.getGrad(), k.getDrzava(), k.getBrojTelefona(), k.getJmbg());
	}

	public KorisnikDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KorisnikDTO(long idOsoba, String email, String lozinka, String ime, String prezime, String ulica,
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

	public long getIdOsoba() {
		return idOsoba;
	}

	public void setIdOsoba(long idOsoba) {
		this.idOsoba = idOsoba;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getLozinka() {
		return lozinka;
	}

	public void setLozinka(java.lang.String lozinka) {
		this.lozinka = lozinka;
	}

	public java.lang.String getIme() {
		return ime;
	}

	public void setIme(java.lang.String ime) {
		this.ime = ime;
	}

	public java.lang.String getPrezime() {
		return prezime;
	}

	public void setPrezime(java.lang.String prezime) {
		this.prezime = prezime;
	}

	public java.lang.String getUlica() {
		return ulica;
	}

	public void setUlica(java.lang.String ulica) {
		this.ulica = ulica;
	}

	public java.lang.String getBrojUlice() {
		return brojUlice;
	}

	public void setBrojUlice(java.lang.String brojUlice) {
		this.brojUlice = brojUlice;
	}

	public java.lang.String getGrad() {
		return grad;
	}

	public void setGrad(java.lang.String grad) {
		this.grad = grad;
	}

	public java.lang.String getDrzava() {
		return drzava;
	}

	public void setDrzava(java.lang.String drzava) {
		this.drzava = drzava;
	}

	public java.lang.String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(java.lang.String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public java.lang.String getJmbg() {
		return jmbg;
	}

	public void setJmbg(java.lang.String jmbg) {
		this.jmbg = jmbg;
	}
	
	

}
