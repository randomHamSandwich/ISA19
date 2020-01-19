/***********************************************************************
 * Module:  Karton.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class Karton
 ***********************************************************************/
package com.isa.isa19.model;

import java.util.Set;
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
import javax.persistence.OneToOne;

@Entity
public class Karton {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idKarton;
	@Column(nullable = true)
	private String visina;
	@Column(nullable = true)
	private String tezina;
	@Column(nullable = true)
	private String krvnaGrupa;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "alergije", joinColumns = @JoinColumn(name = "id_karton"), inverseJoinColumns = @JoinColumn(name = "id_lek"))
	private Set<Lek> lek;

//	izveshtaj o pregledu se nalazi u smom pregledu

//	@OneToOne(mappedBy = "karton", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
//	private Pacijent pacijent;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pacijent")
	private Pacijent pacijent;

	public Karton() {
		super();
	}

	public Karton(Long idKarton, String visina, String tezina, String krvnaGrupa, Set<Lek> lek, Pacijent pacijent) {
		super();
		this.idKarton = idKarton;
		this.visina = visina;
		this.tezina = tezina;
		this.krvnaGrupa = krvnaGrupa;
		this.lek = lek;
		this.pacijent = pacijent;
	}

	public Long getIdKarton() {
		return idKarton;
	}

	public void setIdKarton(Long idKarton) {
		this.idKarton = idKarton;
	}

	public String getVisina() {
		return visina;
	}

	public void setVisina(String visina) {
		this.visina = visina;
	}

	public String getTezina() {
		return tezina;
	}

	public void setTezina(String tezina) {
		this.tezina = tezina;
	}

	public String getKrvnaGrupa() {
		return krvnaGrupa;
	}

	public void setKrvnaGrupa(String krvnaGrupa) {
		this.krvnaGrupa = krvnaGrupa;
	}

	public Pacijent getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

	public Set<Lek> getLek() {
		return lek;
	}

	public void setLek(Set<Lek> lek) {
		this.lek = lek;
	}

}