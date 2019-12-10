
/***********************************************************************
 * Module:  Korisnik.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/
package com.isa.isa19.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//public abstract class Korisnik {
@MappedSuperclass
public class Korisnik {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOsoba;
	@Column(unique = true, length = 50)
	private java.lang.String email;
//    @NotBlank
//    @Size(max = 60)
	@Column
	private java.lang.String lozinka;
	@Column
	private java.lang.String ime;
	@Column
	private java.lang.String prezime;
	@Column
	private java.lang.String ulica;
	@Column
	private java.lang.String brojUlice;
	@Column
	private java.lang.String grad;
	@Column
	private java.lang.String drzava;
	@Column
	private java.lang.String brojTelefona;
	@Column
	private java.lang.String jmbg;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "korisnik_role", 
    	joinColumns = @JoinColumn(name = "idOsoba"), 
    	inverseJoinColumns = @JoinColumn(name = "idRola"))
    private Set<Roles> roles = new HashSet<>();

	public Korisnik() {
	}

	public long getIdOsoba() {
		return idOsoba;
	}

	public void setIdOsoba(long idOsoba) {
		this.idOsoba = idOsoba;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getLozinka() {
		return lozinka;
	}

	public void setLozinka(java.lang.String lozinka) {
		this.lozinka = lozinka;
	}

	public java.lang.String getIme() {
		return ime;
	}

	public void setIme(java.lang.String ime) {
		this.ime = ime;
	}

	public java.lang.String getPrezime() {
		return prezime;
	}

	public void setPrezime(java.lang.String prezime) {
		this.prezime = prezime;
	}

	public java.lang.String getUlica() {
		return ulica;
	}

	public void setUlica(java.lang.String ulica) {
		this.ulica = ulica;
	}

	public java.lang.String getBrojUlice() {
		return brojUlice;
	}

	public void setBrojUlice(java.lang.String brojUlice) {
		this.brojUlice = brojUlice;
	}

	public java.lang.String getGrad() {
		return grad;
	}

	public void setGrad(java.lang.String grad) {
		this.grad = grad;
	}

	public java.lang.String getDrzava() {
		return drzava;
	}

	public void setDrzava(java.lang.String drzava) {
		this.drzava = drzava;
	}

	public java.lang.String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(java.lang.String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public java.lang.String getJmbg() {
		return jmbg;
	}

	public void setJmbg(java.lang.String jmbg) {
		this.jmbg = jmbg;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	

}