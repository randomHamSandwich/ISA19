/***********************************************************************
 * Module:  AdministratorKlinike.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class AdministratorKlinike
 ***********************************************************************/
package com.isa.isa19.model;
import java.util.*;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("AK")
public class AdministratorKlinike extends Korisnik {
	
//vec postoji idKlinike u Korisnik tabeli	
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="id_klinika_admin" ,nullable =true)
//	private Klinika klinika;
//
//	public Klinika getKlinika() {
//		return klinika;
//	}
//
//	public void setKlinika(Klinika klinika) {
//		this.klinika = klinika;
//	}
//
//	public AdministratorKlinike() {
//		super();
//	}
	
	
	
	
}