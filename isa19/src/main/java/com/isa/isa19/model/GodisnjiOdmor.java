/***********************************************************************
 * Module:  GodisnjiOdmor.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class GodisnjiOdmor
 ***********************************************************************/
package com.isa.isa19.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GodisnjiOdmor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idGodisnjiOdmor;

	@Column
	private java.util.Date pocetakRadnogVremena;

	@Column
	private java.util.Date krajRadnogVremena;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "id_medicinskoOsoblje")
	private MedicinskoOsoblje medicinskoOsoblje;

	public long getIdGodisnjiOdmor() {
		return idGodisnjiOdmor;
	}

	public void setIdGodisnjiOdmor(long idGodisnjiOdmor) {
		this.idGodisnjiOdmor = idGodisnjiOdmor;
	}

	public java.util.Date getPocetakRadnogVremena() {
		return pocetakRadnogVremena;
	}

	public void setPocetakRadnogVremena(java.util.Date pocetakRadnogVremena) {
		this.pocetakRadnogVremena = pocetakRadnogVremena;
	}

	public java.util.Date getKrajRadnogVremena() {
		return krajRadnogVremena;
	}

	public void setKrajRadnogVremena(java.util.Date krajRadnogVremena) {
		this.krajRadnogVremena = krajRadnogVremena;
	}

	public MedicinskoOsoblje getMedicinskoOsoblje() {
		return medicinskoOsoblje;
	}

	public void setMedicinskoOsoblje(MedicinskoOsoblje medicinskoOsoblje) {
		this.medicinskoOsoblje = medicinskoOsoblje;
	}

	public GodisnjiOdmor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}