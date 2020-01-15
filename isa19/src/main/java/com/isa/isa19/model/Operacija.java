
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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	private Calendar vremePocetka;
	@Column
	private Calendar vremeZavrsetka;
	@Column
	private int ocenaKlinke;
	@Column
	private int ocenaLekara;
	@Column( nullable = true)
	@Enumerated(EnumType.STRING)
	private StatusPregledaOperacije status;


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
	}

	public Operacija(Long idOperacija, Calendar vremePocetka, Calendar vremeZavrsetka, int ocenaKlinke, int ocenaLekara,
			StatusPregledaOperacije status, Pacijent pacijent, Set<Lekar> lekar,
			Set<MedicinskaSestra> medicinskaSestra) {
		super();
		this.idOperacija = idOperacija;
		this.vremePocetka = vremePocetka;
		this.vremeZavrsetka = vremeZavrsetka;
		this.ocenaKlinke = ocenaKlinke;
		this.ocenaLekara = ocenaLekara;
		this.status = status;
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

	public Calendar getVremePocetka() {
		return vremePocetka;
	}

	public void setVremePocetka(Calendar vremePocetka) {
		this.vremePocetka = vremePocetka;
	}

	public Calendar getVremeZavrsetka() {
		return vremeZavrsetka;
	}

	public void setVremeZavrsetka(Calendar vremeZavrsetka) {
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

	public StatusPregledaOperacije getStatus() {
		return status;
	}

	public void setStatus(StatusPregledaOperacije status) {
		this.status = status;
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