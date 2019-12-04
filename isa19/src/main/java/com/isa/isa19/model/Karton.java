/***********************************************************************
 * Module:  Karton.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class Karton
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
import javax.persistence.OneToOne;

@Entity
public class Karton {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idKarton;
	@Column(nullable = true)
	private int visina;
	@Column(nullable = true)
	private int tezina;
	@Column(nullable = true)
	private int krvnaGrupa;

//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_pacijent")
//	private Pacijent pacijent;
//	

	@OneToOne(mappedBy = "karton", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Pacijent pacijent;

	public Karton() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Karton(Long idKarton, int visina, int tezina, int krvnaGrupa, Pacijent pacijent) {
		super();
		this.idKarton = idKarton;
		this.visina = visina;
		this.tezina = tezina;
		this.krvnaGrupa = krvnaGrupa;
		this.pacijent = pacijent;
	}

	public Long getIdKarton() {
		return idKarton;
	}

	public void setIdKarton(Long idKarton) {
		this.idKarton = idKarton;
	}

	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		this.visina = visina;
	}

	public int getTezina() {
		return tezina;
	}

	public void setTezina(int tezina) {
		this.tezina = tezina;
	}

	public int getKrvnaGrupa() {
		return krvnaGrupa;
	}

	public void setKrvnaGrupa(int krvnaGrupa) {
		this.krvnaGrupa = krvnaGrupa;
	}

	public Pacijent getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

}