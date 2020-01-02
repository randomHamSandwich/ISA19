
/***********************************************************************
 * Module:  Korisnik.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/
package com.isa.isa19.model;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(name="tipp", discriminatorType=STRING)
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
	@Enumerated(EnumType.STRING)
	private StatusKorisnika statusKorisnika;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "korisnik_role", joinColumns = @JoinColumn(name = "idOsoba"), inverseJoinColumns = @JoinColumn(name = "idRola"))
	private Set<Roles> roles = new HashSet<>();
// TODO URADI POSLE BRISANJA @@MappedSuperclass    
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_klinika")
	private Klinika klinika;

	public Korisnik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Korisnik(long idOsoba, String email, String lozinka, String ime, String prezime, String ulica,
			String brojUlice, String grad, String drzava, String brojTelefona, String jmbg,
			StatusKorisnika statusKorisnika, Set<Roles> roles) {
		super();
		this.idOsoba = idOsoba;
		this.email = email;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.ulica = ulica;
		this.brojUlice = brojUlice;
		this.grad = grad;
		this.drzava = drzava;
		this.brojTelefona = brojTelefona;
		this.jmbg = jmbg;
		this.statusKorisnika = statusKorisnika;
		this.roles = roles;
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

	public StatusKorisnika getStatusKorisnika() {
		return statusKorisnika;
	}

	public void setStatusKorisnika(StatusKorisnika statusKorisnika) {
		this.statusKorisnika = statusKorisnika;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

}