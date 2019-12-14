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

@Entity
public class Klinika {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idKlinika;
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
	private float ocenaKlinike;

	@OneToMany(mappedBy = "klinika")
	private Set<Usluga> usluga;

	@OneToMany(mappedBy = "klinika")
	private Set<AdministratorKlinike> administratorKlinike;
//	nije vishe snigleTable medicniskop osbolje nego svi useri su SingleTable korisnik
//	@OneToMany(mappedBy = "klinika")
//	private Set<MedicinskoOsoblje> medicinskoOsoblje;

	// TODO URADI POSLE BRISANJA @@MappedSuperclass    	
	@OneToMany(mappedBy = "klinika")
	private Set<Korisnik> korisnik;

	@OneToMany(mappedBy = "klinika")
	private Set<Sala> sala;

	public Klinika() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Klinika(Long idKlinika, String naziv, String ulica, String brojUlice, String grad, String drzava,
			String opis, float ocenaKlinike, Set<Usluga> usluga, Set<AdministratorKlinike> administratorKlinike,
			Set<Sala> sala) {
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
		this.administratorKlinike = administratorKlinike;
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

	public float getOcenaKlinike() {
		return ocenaKlinike;
	}

	public void setOcenaKlinike(float ocenaKlinike) {
		this.ocenaKlinike = ocenaKlinike;
	}

	public Set<Usluga> getUsluga() {
		return usluga;
	}

	public void setUsluga(Set<Usluga> usluga) {
		this.usluga = usluga;
	}

	public Set<AdministratorKlinike> getAdministratorKlinike() {
		return administratorKlinike;
	}

	public void setAdministratorKlinike(Set<AdministratorKlinike> administratorKlinike) {
		this.administratorKlinike = administratorKlinike;
	}

	public Set<Sala> getSala() {
		return sala;
	}

	public void setSala(Set<Sala> sala) {
		this.sala = sala;
	}



	

}