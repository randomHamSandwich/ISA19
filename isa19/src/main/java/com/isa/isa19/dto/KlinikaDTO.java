package com.isa.isa19.dto;

import com.isa.isa19.model.Klinika;

public class KlinikaDTO {

	private Long idKlinika;
	private int naziv;
	private String adresa;
	private String brojAdrese;
	private String grad;
	private String drzava;
	private String opis;
	private float ocenaKlinike;

	public KlinikaDTO(Klinika k) {
		this(k.getIdKlinika(), k.getNaziv(), k.getAdresa(), k.getBrojAdrese(), k.getGrad(), k.getDrzava(), k.getOpis(),
				k.getOcenaKlinike());
	}

	public KlinikaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KlinikaDTO(Long idKlinika, int naziv, String adresa, String brojAdrese, String grad, String drzava,
			String opis, float ocenaKlinike) {
		super();
		this.idKlinika = idKlinika;
		this.naziv = naziv;
		this.adresa = adresa;
		this.brojAdrese = brojAdrese;
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

	public int getNaziv() {
		return naziv;
	}

	public void setNaziv(int naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrojAdrese() {
		return brojAdrese;
	}

	public void setBrojAdrese(String brojAdrese) {
		this.brojAdrese = brojAdrese;
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

	public float getOcenaKlinike() {
		return ocenaKlinike;
	}

	public void setOcenaKlinike(float ocenaKlinike) {
		this.ocenaKlinike = ocenaKlinike;
	}

}
