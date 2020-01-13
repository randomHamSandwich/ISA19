package com.isa.isa19.dto;

import java.util.Calendar;
import java.util.Date;

import com.isa.isa19.model.Pregled;

public class PregledDTO {
	private Long idPregleda;
	private Calendar vremePocetka;
	private Calendar vremeZavrsetka;
	private float cena;
	private float popust;
	private float cenaSaPopustom;
	private int ocenaLekara;
	private int ocenaKilinike;

	public PregledDTO(Pregled p) {
		this(p.getIdPregleda(), p.getVremePocetka(), p.getVremeZavrsetka(), p.getCena(), p.getPopust(),
				p.getCenaSaPopustom(), p.getOcenaLekara(), p.getOcenaKilinike());
		// TODO Auto-generated constructor stub
	}

	public PregledDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PregledDTO(Long idPregleda, Calendar vremePocetka, Calendar vremeZavrsetka, float cena, float popust,
			float cenaSaPopustom, int ocenaLekara, int ocenaKilinike) {
		super();
		this.idPregleda = idPregleda;
		this.vremePocetka = vremePocetka;
		this.vremeZavrsetka = vremeZavrsetka;
		this.cena = cena;
		this.popust = popust;
		this.cenaSaPopustom = cenaSaPopustom;
		this.ocenaLekara = ocenaLekara;
		this.ocenaKilinike = ocenaKilinike;
	}

	public Long getIdPregleda() {
		return idPregleda;
	}

	public void setIdPregleda(Long idPregleda) {
		this.idPregleda = idPregleda;
	}

	public Calendar getVremePocetka() {
		return vremePocetka;
	}

	public void setVremePocetka(Calendar vremePocetka) {
		this.vremePocetka = vremePocetka;
	}

	public Calendar getVremeZavrsetka() {
		return vremeZavrsetka;
	}

	public void setVremeZavrsetka(Calendar vremeZavrsetka) {
		this.vremeZavrsetka = vremeZavrsetka;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public float getPopust() {
		return popust;
	}

	public void setPopust(float popust) {
		this.popust = popust;
	}

	public float getCenaSaPopustom() {
		return cenaSaPopustom;
	}

	public void setCenaSaPopustom(float cenaSaPopustom) {
		this.cenaSaPopustom = cenaSaPopustom;
	}

	public int getOcenaLekara() {
		return ocenaLekara;
	}

	public void setOcenaLekara(int ocenaLekara) {
		this.ocenaLekara = ocenaLekara;
	}

	public int getOcenaKilinike() {
		return ocenaKilinike;
	}

	public void setOcenaKilinike(int ocenaKilinike) {
		this.ocenaKilinike = ocenaKilinike;
	}

	

}
