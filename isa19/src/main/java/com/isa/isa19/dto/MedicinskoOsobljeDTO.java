package com.isa.isa19.dto;

import com.isa.isa19.model.MedicinskoOsoblje;
@Deprecated
public class MedicinskoOsobljeDTO {
	
	public long idOsoba;
	public java.lang.String email;
	public java.lang.String lozinka;
	public java.lang.String ime;
	public java.lang.String prezime;
	public java.lang.String ulica;
	public java.lang.String brojUlice;
	public java.lang.String grad;
	public java.lang.String drzava;
	public java.lang.String brojTelefona;
	public java.lang.String jmbg;
	public java.lang.String tip;
	
	public MedicinskoOsobljeDTO(long idOsoba, String email, String lozinka, String ime, String prezime, String ulica,
			String brojUlice, String grad, String drzava, String brojTelefona, String jmbg, String tip) {
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
		this.tip = tip;
	}
	public MedicinskoOsobljeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
//	public MedicinskoOsobljeDTO(MedicinskoOsoblje mo) {
//		this(mo.getIdOsoba(),mo.getEmail(),mo.getLozinka(),mo.getIme(),mo.getPrezime(),mo.getUlica(),mo.getBrojUlice(),mo.getGrad(),mo.getDrzava(),mo.getBrojTelefona(),mo.getJmbg(),"")
//	}
//	


}
