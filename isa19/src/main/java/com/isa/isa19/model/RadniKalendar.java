
/***********************************************************************
 * Module:  RadniKalendar.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class RadniKalendar
 ***********************************************************************/
package com.isa.isa19.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//@Entity
public class RadniKalendar {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idRadnoVreme;
//
//	@Column
//	private java.util.Date pocetakRadnogVremena;
//
//	@Column
//	private java.util.Date krajRadnogVremena;
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_medicinskoOsoblje")
//	private MedicinskoOsoblje medicinskoOsoblje;
//
//	public Long getIdRadnoVreme() {
//		return idRadnoVreme;
//	}
//
//	public void setIdRadnoVreme(Long idRadnoVreme) {
//		this.idRadnoVreme = idRadnoVreme;
//	}
//
//	public java.util.Date getPocetakRadnogVremena() {
//		return pocetakRadnogVremena;
//	}
//
//	public void setPocetakRadnogVremena(java.util.Date pocetakRadnogVremena) {
//		this.pocetakRadnogVremena = pocetakRadnogVremena;
//	}
//
//	public java.util.Date getKrajRadnogVremena() {
//		return krajRadnogVremena;
//	}
//
//	public void setKrajRadnogVremena(java.util.Date krajRadnogVremena) {
//		this.krajRadnogVremena = krajRadnogVremena;
//	}
//
//	public MedicinskoOsoblje getMedicinskoOsoblje() {
//		return medicinskoOsoblje;
//	}
//
//	public void setMedicinskoOsoblje(MedicinskoOsoblje medicinskoOsoblje) {
//		this.medicinskoOsoblje = medicinskoOsoblje;
//	}
//
//	public RadniKalendar() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	

}