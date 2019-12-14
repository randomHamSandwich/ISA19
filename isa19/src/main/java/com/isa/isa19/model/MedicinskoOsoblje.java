/***********************************************************************
 * Module:  MedicinskoOsoblje.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class MedicinskoOsoblje
 ***********************************************************************/
package com.isa.isa19.model;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//@Entity
//@Inheritance(strategy=SINGLE_TABLE)
//@DiscriminatorColumn(name="tip", discriminatorType=STRING)
@Deprecated
public abstract class MedicinskoOsoblje  {
//	public abstract class MedicinskoOsoblje  extends Korisnik{

//	@OneToMany(mappedBy = "medicinskoOsoblje", cascade = CascadeType.ALL)
//	public Set<GodisnjiOdmor> godisnjiOdmor;
//
//	@OneToMany(mappedBy = "medicinskoOsoblje", cascade = CascadeType.ALL)
//	public Set<Odsutvo> odustvo;
//
//	@OneToMany(mappedBy = "medicinskoOsoblje", cascade = CascadeType.ALL)
//	public Set<RadniKalendar> radniKalendar;
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_klinika")
//	private Klinika klinika;
//
//	public Set<GodisnjiOdmor> getGodisnjiOdmor() {
//		return godisnjiOdmor;
//	}
//
//	public void setGodisnjiOdmor(Set<GodisnjiOdmor> godisnjiOdmor) {
//		this.godisnjiOdmor = godisnjiOdmor;
//	}
//
//	public Set<Odsutvo> getOdustvo() {
//		return odustvo;
//	}
//
//	public void setOdustvo(Set<Odsutvo> odustvo) {
//		this.odustvo = odustvo;
//	}
//
//	public Set<RadniKalendar> getRadniKalendar() {
//		return radniKalendar;
//	}
//
//	public void setRadniKalendar(Set<RadniKalendar> radniKalendar) {
//		this.radniKalendar = radniKalendar;
//	}
//
//	public Klinika getKlinika() {
//		return klinika;
//	}
//
//	public void setKlinika(Klinika klinika) {
//		this.klinika = klinika;
//	}

}