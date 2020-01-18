
/***********************************************************************
 * Module:  Dijagnoza.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class Dijagnoza
 ***********************************************************************/

package com.isa.isa19.model;
import java.util.Set;
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
public class Dijagnoza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDijagnoza;
	@Column
	private String nazivDijagnoza;
	
	@Column
	private String opis;

	@OneToMany(mappedBy = "dijagnoza", cascade =CascadeType.ALL)
	public Set<Pregled> pregled;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_administartorKlinicnogCentra")
	private AdministartorKlinicnogCentra administartorKlinicnogCentra;

	public Long getIdDijagnoza() {
		return idDijagnoza;
	}

	public void setIdDijagnoza(Long idDijagnoza) {
		this.idDijagnoza = idDijagnoza;
	}

	public String getNazivDijagnoza() {
		return nazivDijagnoza;
	}

	public void setNazivDijagnoza(String nazivDijagnoza) {
		this.nazivDijagnoza = nazivDijagnoza;
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

	public Dijagnoza() {
		super();
	} 
	
	
	
	

}