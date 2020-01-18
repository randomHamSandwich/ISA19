package com.isa.isa19.dto;

import com.isa.isa19.model.Klinika;

public class KlinikaDTO {

	private Long idKlinika;
	private String naziv;
	private String ulica;
	private String brojUlice;
	private String grad;
	private String drzava;
	private String opis;
	private Float ocenaKlinike;

	public KlinikaDTO(Klinika k) {
		this(k.getIdKlinika(), k.getNaziv(), k.getUlica(), k.getBrojUlice(), k.getGrad(), k.getDrzava(), k.getOpis(),
				k.getOcenaKlinike());
	}

	public KlinikaDTO() {
		super();
	}

	public KlinikaDTO(Long idKlinika, String naziv, String ulica, String brojUlice, String grad, String drzava,
			String opis, Float ocenaKlinike) {
		super();
		this.idKlinika = idKlinika;
		this.naziv = naziv;
		this.ulica = ulica;
		this.brojUlice = brojUlice;
		this.grad = grad;
		this.drzava = drzava;
		this.opis = opis;
		this.ocenaKlinike = ocenaKlinike;
	}

	public Long getIdKlinika() {
		return idKlinika;
	}

	public void setIdKlinika(Long idKlinika) {
		this.idKlinika = idKlinika;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBrojUlice() {
		return brojUlice;
	}

	public void setBrojUlice(String brojUlice) {
		this.brojUlice = brojUlice;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Float getOcenaKlinike() {
		return ocenaKlinike;
	}

	public void setOcenaKlinike(Float ocenaKlinike) {
		this.ocenaKlinike = ocenaKlinike;
	}

}
