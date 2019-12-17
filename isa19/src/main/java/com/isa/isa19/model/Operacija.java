
/***********************************************************************
 * Module:  Operacija.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class Operacija
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Operacija {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOperacija;

	@Column
	private java.util.Date vremePocetka;
	@Column
	private java.util.Date vremeZavrsetka;
	@Column
	private int ocenaKlinke;
	@Column
	private int ocenaLekara;


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pacijent")
	private Pacijent pacijent;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "lekar_operacija", joinColumns = @JoinColumn(name = "id_operacija"), inverseJoinColumns = @JoinColumn(name = "id_lekar"))
	private Set<Lekar> lekar;

	@ManyToMany //
	@JoinTable(name = "medicinska_sestra_operacija", joinColumns = @JoinColumn(name = "id_operacija"), inverseJoinColumns = @JoinColumn(name = "id_medicinska_sestra"))
	private Set<MedicinskaSestra> medicinskaSestra;

	public Operacija() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operacija(Long idOperacija, Date vremePocetka, Date vremeZavrsetka, int ocenaKlinke, int ocenaLekara,
			Pacijent pacijent, Set<Lekar> lekar, Set<MedicinskaSestra> medicinskaSestra) {
		super();
		this.idOperacija = idOperacija;
		this.vremePocetka = vremePocetka;
		this.vremeZavrsetka = vremeZavrsetka;
		this.ocenaKlinke = ocenaKlinke;
		this.ocenaLekara = ocenaLekara;
		this.pacijent = pacijent;
		this.lekar = lekar;
		this.medicinskaSestra = medicinskaSestra;
	}

	public Long getIdOperacija() {
		return idOperacija;
	}

	public void setIdOperacija(Long idOperacija) {
		this.idOperacija = idOperacija;
	}

	public java.util.Date getVremePocetka() {
		return vremePocetka;
	}

	public void setVremePocetka(java.util.Date vremePocetka) {
		this.vremePocetka = vremePocetka;
	}

	public java.util.Date getVremeZavrsetka() {
		return vremeZavrsetka;
	}

	public void setVremeZavrsetka(java.util.Date vremeZavrsetka) {
		this.vremeZavrsetka = vremeZavrsetka;
	}

	public int getOcenaKlinke() {
		return ocenaKlinke;
	}

	public void setOcenaKlinke(int ocenaKlinke) {
		this.ocenaKlinke = ocenaKlinke;
	}

	public int getOcenaLekara() {
		return ocenaLekara;
	}

	public void setOcenaLekara(int ocenaLekara) {
		this.ocenaLekara = ocenaLekara;
	}

	public Pacijent getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

	public Set<Lekar> getLekar() {
		return lekar;
	}

	public void setLekar(Set<Lekar> lekar) {
		this.lekar = lekar;
	}

	public Set<MedicinskaSestra> getMedicinskaSestra() {
		return medicinskaSestra;
	}

	public void setMedicinskaSestra(Set<MedicinskaSestra> medicinskaSestra) {
		this.medicinskaSestra = medicinskaSestra;
	}

	

}