package com.isa.isa19.dto;

import com.isa.isa19.model.AdministratorKlinike;
import com.isa.isa19.model.Korisnik;

public class AdministratorKlinikeDTO {

	public long idOsoba;
	public java.lang.String email;
	public java.lang.String lozinka;
	public java.lang.String ime;
	public java.lang.String prezime;
	public java.lang.String ulica;
	public java.lang.String brojUlice;
	public java.lang.String grad;
	public java.lang.String drzava;
	public java.lang.String brojTelefona;
	public java.lang.String jmbg;

	public AdministratorKlinikeDTO(AdministratorKlinike a) {

		this(((Korisnik) a).getIdOsoba(), ((Korisnik) a).getEmail(), ((Korisnik) a).getLozinka(),
				((Korisnik) a).getIme(), ((Korisnik) a).getPrezime(), ((Korisnik) a).getUlica(),
				((Korisnik) a).getBrojUlice(), ((Korisnik) a).getGrad(), ((Korisnik) a).getDrzava(),
				((Korisnik) a).getBrojTelefona(), ((Korisnik) a).getJmbg());

	}

	public AdministratorKlinikeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdministratorKlinikeDTO(long idOsoba, String email, String lozinka, String ime, String prezime, String ulica,
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
