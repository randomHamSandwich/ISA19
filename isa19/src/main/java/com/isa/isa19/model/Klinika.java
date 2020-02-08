/***********************************************************************
 * Module:  Klinika.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class Klinika
 ***********************************************************************/
package com.isa.isa19.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Klinika {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idKlinika;
	
    @Version
    @Column( name = "version",nullable = false, columnDefinition = "int default 0")
    private int version;
	@Column
	private String naziv;
	@Column
	private String ulica;
	@Column
	private String brojUlice;
	@Column
	private String grad;
	@Column
	private String drzava;
	@Column
	private String opis;
	@Column
	private Float ocenaKlinike;

	@OneToMany(mappedBy = "klinika")
	private Set<Usluga> usluga;

	@OneToMany(mappedBy = "klinika")
	private Set<Operacija> operacije;

	@OneToMany(mappedBy = "klinika")
	private Set<Pregled> pregledi;

// korisnik zato sto moze da bude lekar, medicinska Sestra, administrator klinike
	@OneToMany(mappedBy = "klinika")
	private Set<Korisnik> korisnik;

	@OneToMany(mappedBy = "klinika")
	private Set<Sala> sala;

	public Klinika() {
		super();
	}

	public Klinika(Long idKlinika, String naziv, String ulica, String brojUlice, String grad, String drzava,
			String opis, Float ocenaKlinike, Set<Usluga> usluga, Set<Operacija> operacije, Set<Pregled> pregledi,
			Set<Korisnik> korisnik, Set<Sala> sala) {
		super();
		this.idKlinika = idKlinika;
		this.naziv = naziv;
		this.ulica = ulica;
		this.brojUlice = brojUlice;
		this.grad = grad;
		this.drzava = drzava;
		this.opis = opis;
		this.ocenaKlinike = ocenaKlinike;
		this.usluga = usluga;
		this.operacije = operacije;
		this.pregledi = pregledi;
		this.korisnik = korisnik;
		this.sala = sala;
	}

	public Long getIdKlinika() {
		return idKlinika;
	}

	public void setIdKlinika(Long idKlinika) {
		this.idKlinika = idKlinika;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Float getOcenaKlinike() {
		return ocenaKlinike;
	}

	public void setOcenaKlinike(Float ocenaKlinike) {
		this.ocenaKlinike = ocenaKlinike;
	}

	public Set<Usluga> getUsluga() {
		return usluga;
	}

	public void setUsluga(Set<Usluga> usluga) {
		this.usluga = usluga;
	}

	public Set<Sala> getSala() {
		return sala;
	}

	public void setSala(Set<Sala> sala) {
		this.sala = sala;
	}

	public Set<Operacija> getOperacije() {
		return operacije;
	}

	public void setOperacije(Set<Operacija> operacije) {
		this.operacije = operacije;
	}

	public Set<Korisnik> getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Set<Korisnik> korisnik) {
		this.korisnik = korisnik;
	}

	public Set<Pregled> getPregledi() {
		return pregledi;
	}

	public void setPregledi(Set<Pregled> pregledi) {
		this.pregledi = pregledi;
	}

	@Override
	public String toString() {
		return "Klinika [idKlinika=" + idKlinika + "]";
	}

}