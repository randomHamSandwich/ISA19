/***********************************************************************
 * Module:  Sala.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class Sala
 ***********************************************************************/
package com.isa.isa19.model;

import java.util.*;

import javax.persistence.CascadeType;
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
	public Long idSala;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_klinika")
	private Klinika klinika;

	@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
	private Set<Pregled> pregled;

	public Sala(Long idSala, Klinika klinika, Set<Pregled> pregled) {
		super();
		this.idSala = idSala;
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

	
	
}