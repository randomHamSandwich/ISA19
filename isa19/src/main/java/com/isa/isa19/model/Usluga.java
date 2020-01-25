/***********************************************************************
 * Module:  Usluga.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class Usluga
 ***********************************************************************/
package com.isa.isa19.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Usluga {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSuluge;
	
	@Column
	private String nazivUsluge;
	@Column
	private String opisUsluge;
	@Column
	private Float cena;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_klinika")
	private Klinika klinika;

	public Usluga() {
		super();
	}

	public Usluga(Long idSuluge, String nazivUsluge, String opisUsluge, Float cena, Klinika klinika) {
		super();
		this.idSuluge = idSuluge;
		this.nazivUsluge = nazivUsluge;
		this.opisUsluge = opisUsluge;
		this.cena = cena;
		this.klinika = klinika;
	}

	public Long getIdSuluge() {
		return idSuluge;
	}

	public void setIdSuluge(Long idSuluge) {
		this.idSuluge = idSuluge;
	}

	public String getNazivUsluge() {
		return nazivUsluge;
	}

	public void setNazivUsluge(String nazivUsluge) {
		this.nazivUsluge = nazivUsluge;
	}

	public String getOpisUsluge() {
		return opisUsluge;
	}

	public void setOpisUsluge(String opisUsluge) {
		this.opisUsluge = opisUsluge;
	}

	public Float getCena() {
		return cena;
	}

	public void setCena(Float cena) {
		this.cena = cena;
	}

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}

	
	
	
}