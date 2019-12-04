package com.isa.isa19.dto;

import java.util.Date;

import com.isa.isa19.model.Pregled;
import com.isa.isa19.model.Status;

public class PregledDTO {
	private Long idPregleda;
	private java.util.Date vremePocetka;
	private java.util.Date vremeZavrsetka;
	private float cena;
	private float popust;
	private float cenaSaPopustom;
	private int ocenaLekara;
	private int ocenaKilinike;
	private Status status;

	public PregledDTO(Pregled p) {
		this(p.getIdPregleda(), p.getVremePocetka(), p.getVremeZavrsetka(), p.getCena(), p.getPopust(),
				p.getCenaSaPopustom(), p.getOcenaLekara(), p.getOcenaKilinike(), p.getStatus());
		// TODO Auto-generated constructor stub
	}

	public PregledDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PregledDTO(Long idPregleda, Date vremePocetka, Date vremeZavrsetka, float cena, float popust,
			float cenaSaPopustom, int ocenaLekara, int ocenaKilinike, Status status) {
		super();
		this.idPregleda = idPregleda;
		this.vremePocetka = vremePocetka;
		this.vremeZavrsetka = vremeZavrsetka;
		this.cena = cena;
		this.popust = popust;
		this.cenaSaPopustom = cenaSaPopustom;
		this.ocenaLekara = ocenaLekara;
		this.ocenaKilinike = ocenaKilinike;
		this.status = status;
	}

	public Long getIdPregleda() {
		return idPregleda;
	}

	public void setIdPregleda(Long idPregleda) {
		this.idPregleda = idPregleda;
	}

	public java.util.Date getVremePocetka() {
		return vremePocetka;
	}

	public void setVremePocetka(java.util.Date vremePocetka) {
		this.vremePocetka = vremePocetka;
	}

	public java.util.Date getVremeZavrsetka() {
		return vremeZavrsetka;
	}

	public void setVremeZavrsetka(java.util.Date vremeZavrsetka) {
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
