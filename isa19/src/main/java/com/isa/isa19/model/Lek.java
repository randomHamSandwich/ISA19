/***********************************************************************
 * Module:  Lek.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class Lek
 ***********************************************************************/
package com.isa.isa19.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Lek {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLek;

	@Column
	private String naziv;

	// N-m ka pregldu
	@ManyToMany
	@JoinTable(name = "terapija", joinColumns = @JoinColumn(name = "id_lek"), inverseJoinColumns = @JoinColumn(name = "id_pregled"))
	private Set<Pregled> pregled;

	@ManyToMany
	@JoinTable(name = "alergije", joinColumns = @JoinColumn(name = "id_lek"), inverseJoinColumns = @JoinColumn(name = "id_karton"))
	private Set<Karton> karton;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_administartorKlinicnogCentra")
	private AdministartorKlinicnogCentra administartorKlinicnogCentra;

	public Lek() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lek(Long idLek, String naziv, Set<Pregled> pregled, Set<Karton> karton,
			AdministartorKlinicnogCentra administartorKlinicnogCentra) {
		super();
		this.idLek = idLek;
		this.naziv = naziv;
		this.pregled = pregled;
		this.karton = karton;
		this.administartorKlinicnogCentra = administartorKlinicnogCentra;
	}

	public Long getIdLek() {
		return idLek;
	}

	public void setIdLek(Long idLek) {
		this.idLek = idLek;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<Pregled> getPregled() {
		return pregled;
	}

	public void setPregled(Set<Pregled> pregled) {
		this.pregled = pregled;
	}

	public AdministartorKlinicnogCentra getAdministartorKlinicnogCentra() {
		return administartorKlinicnogCentra;
	}

	public void setAdministartorKlinicnogCentra(AdministartorKlinicnogCentra administartorKlinicnogCentra) {
		this.administartorKlinicnogCentra = administartorKlinicnogCentra;
	}

	public Set<Karton> getKarton() {
		return karton;
	}

	public void setKarton(Set<Karton> karton) {
		this.karton = karton;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLek == null) ? 0 : idLek.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lek other = (Lek) obj;
		if (idLek == null) {
			if (other.idLek != null)
				return false;
		} else if (!idLek.equals(other.idLek))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lek [idLek=" + idLek + ", naziv=" + naziv + "]";
	}

}