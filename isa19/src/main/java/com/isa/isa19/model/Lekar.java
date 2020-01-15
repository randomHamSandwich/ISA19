/***********************************************************************
 * Module:  Lekar.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class Lekar
 ***********************************************************************/

package com.isa.isa19.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("LEKAR")
public class Lekar extends Korisnik {
	@Column(unique = false, nullable = true)
	private float ocenaLekar;

	@Column(unique = false, nullable = true)
	@Enumerated(EnumType.STRING)
	private Specijalizacija specijalizacija;

	@OneToMany(mappedBy = "lekar", cascade = CascadeType.ALL)
	private Set<Pregled> pregled;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "lekar_operacija", joinColumns = @JoinColumn(name = "id_lekar"), inverseJoinColumns = @JoinColumn(name = "id_operacija"))
	private Set<Operacija> operacija;

	@OneToMany(mappedBy = "lekar", cascade = CascadeType.ALL)
	public Set<KalendarDogadjaja> kalendarDogadjaja;

	public float getOcenaLekar() {
		return ocenaLekar;
	}

	public void setOcenaLekar(float ocenaLekar) {
		this.ocenaLekar = ocenaLekar;
	}

	public Specijalizacija getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(Specijalizacija specijalizacija) {
		this.specijalizacija = specijalizacija;
	}

	public Set<Pregled> getPregled() {
		return pregled;
	}

	public void setPregled(Set<Pregled> pregled) {
		this.pregled = pregled;
	}

	public Set<Operacija> getOperacija() {
		return operacija;
	}

	public void setOperacija(Set<Operacija> operacija) {
		this.operacija = operacija;
	}

	public Set<KalendarDogadjaja> getKalendarDogadjaja() {
		return kalendarDogadjaja;
	}

	public void setKalendarDogadjaja(Set<KalendarDogadjaja> kalendarDogadjaja) {
		this.kalendarDogadjaja = kalendarDogadjaja;
	}

	public Lekar(float ocenaLekar, Specijalizacija specijalizacija, Set<Pregled> pregled, Set<Operacija> operacija,
			Set<KalendarDogadjaja> kalendarDogadjaja) {
		super();
		this.ocenaLekar = ocenaLekar;
		this.specijalizacija = specijalizacija;
		this.pregled = pregled;
		this.operacija = operacija;
		this.kalendarDogadjaja = kalendarDogadjaja;
	}

	public Lekar() {
		super();
	}

}