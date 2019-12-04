/***********************************************************************
 * Module:  Pregled.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class Pregled
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
import javax.persistence.OneToMany;

@Entity
public class Pregled {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPregleda;
	
	@Column(nullable = true)
	private java.util.Date vremePocetka;
	
	@Column(nullable = true)
	private java.util.Date vremeZavrsetka;
	
	@Column(nullable = true)
	private float cena;
	
	@Column(nullable = true)
	private float popust;
	
	@Column(nullable = true)
	private float cenaSaPopustom;
	
	@Column(nullable = true)
	private int ocenaLekara;
	
	@Column(nullable = true)
	private int ocenaKilinike;
	
	@Column(nullable = true)
	private Status status;
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "id_pacijent")
	private Pacijent pacijent;

	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "id_medicinskaSestra")
	private MedicinskaSestra medicinskaSestra;

	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "id_lekar")
	private Lekar lekar;

	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "id_sala")
	private Sala sala;
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "id_dijagnoza")
	private Dijagnoza dijagnoza;
	
	//N - M ka Leku
	@ManyToMany
	@JoinTable(name = "terapija", 
	joinColumns=@JoinColumn( name = "id_pregled"),
	inverseJoinColumns = @JoinColumn(name= "id_lek"))
	private Set<Lek> lek;

	public Long getIdPregleda() {
		return idPregleda;
	}

	public void setIdPregleda(Long idPregleda) {
		this.idPregleda = idPregleda;
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

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public float getPopust() {
		return popust;
	}

	public void setPopust(float popust) {
		this.popust = popust;
	}

	public float getCenaSaPopustom() {
		return cenaSaPopustom;
	}

	public void setCenaSaPopustom(float cenaSaPopustom) {
		this.cenaSaPopustom = cenaSaPopustom;
	}

	public int getOcenaLekara() {
		return ocenaLekara;
	}

	public void setOcenaLekara(int ocenaLekara) {
		this.ocenaLekara = ocenaLekara;
	}

	public int getOcenaKilinike() {
		return ocenaKilinike;
	}

	public void setOcenaKilinike(int ocenaKilinike) {
		this.ocenaKilinike = ocenaKilinike;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Pacijent getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

	public MedicinskaSestra getMedicinskaSestra() {
		return medicinskaSestra;
	}

	public void setMedicinskaSestra(MedicinskaSestra medicinskaSestra) {
		this.medicinskaSestra = medicinskaSestra;
	}

	public Lekar getLekar() {
		return lekar;
	}

	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Dijagnoza getDijagnoza() {
		return dijagnoza;
	}

	public void setDijagnoza(Dijagnoza dijagnoza) {
		this.dijagnoza = dijagnoza;
	}

	public Set<Lek> getLek() {
		return lek;
	}

	public void setLek(Set<Lek> lek) {
		this.lek = lek;
	}

	public Pregled() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}