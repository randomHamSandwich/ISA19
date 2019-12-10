/***********************************************************************
 * Module:  Pacijent.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class Pacijent
 ***********************************************************************/
package com.isa.isa19.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import net.bytebuddy.dynamic.TypeResolutionStrategy.Lazy;

@Entity
public class Pacijent extends Korisnik {
	@OneToMany(mappedBy = "pacijent", cascade = CascadeType.ALL)
	private Set<Pregled> pregled;

	@OneToMany(mappedBy = "pacijent", cascade = CascadeType.ALL)
	private Set<Operacija> operacija;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_karton")
	private Karton karton;

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

	public Karton getKarton() {
		return karton;
	}

	public void setKarton(Karton karton) {
		this.karton = karton;
	}

	public Pacijent() {
		super();
		// TODO Auto-generated constructor stub
	}

}