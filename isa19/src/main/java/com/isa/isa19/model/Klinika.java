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
	private int naziv;
	@Column
	private String adresa;
	@Column
	private String brojAdrese;
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
	
	@OneToMany(mappedBy = "klinika")
	private Set<MedicinskoOsoblje> medicinskoOsoblje;
	
	@OneToMany(mappedBy = "klinika")
	private Set<Sala> sala;

	public Long getIdKlinika() {
		return idKlinika;
	}

	public void setIdKlinika(Long idKlinika) {
		this.idKlinika = idKlinika;
	}

	public int getNaziv() {
		return naziv;
	}

	public void setNaziv(int naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrojAdrese() {
		return brojAdrese;
	}

	public void setBrojAdrese(String brojAdrese) {
		this.brojAdrese = brojAdrese;
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

	public Set<MedicinskoOsoblje> getMedicinskoOsoblje() {
		return medicinskoOsoblje;
	}

	public void setMedicinskoOsoblje(Set<MedicinskoOsoblje> medicinskoOsoblje) {
		this.medicinskoOsoblje = medicinskoOsoblje;
	}

	public Set<Sala> getSala() {
		return sala;
	}

	public void setSala(Set<Sala> sala) {
		this.sala = sala;
	}

	public Klinika() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}