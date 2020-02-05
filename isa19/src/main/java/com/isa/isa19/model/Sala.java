/***********************************************************************
 * Module:  Sala.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class Sala
 ***********************************************************************/
package com.isa.isa19.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSala;

	@Column
	private String nazivSala;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_klinika")
	private Klinika klinika;

	@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
	private Set<Pregled> pregled;

	public Sala() {
		super();
	}

	public Sala(Long idSala, String nazivSala, Klinika klinika, Set<Pregled> pregled) {
		super();
		this.idSala = idSala;
		this.nazivSala = nazivSala;
		this.klinika = klinika;
		this.pregled = pregled;
	}

	public Long getIdSala() {
		return idSala;
	}

	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}

	public Set<Pregled> getPregled() {
		return pregled;
	}

	public void setPregled(Set<Pregled> pregled) {
		this.pregled = pregled;
	}

	public String getNazivSala() {
		return nazivSala;
	}

	public void setNazivSala(String nazivSala) {
		this.nazivSala = nazivSala;
	}

}