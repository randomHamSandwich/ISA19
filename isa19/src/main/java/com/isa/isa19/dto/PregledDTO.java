package com.isa.isa19.dto;

import java.util.Calendar;
import java.util.Date;

import com.isa.isa19.model.Pregled;

public class PregledDTO {
	private Long idPregleda;
	private Calendar vremePocetka;
	private Calendar vremeZavrsetka;
//	private Float cena;
	private Float popust;
	private Float cenaSaPopustom;
	private Integer ocenaLekara;
	private Integer ocenaKilinike;

	public PregledDTO(Pregled p) {
		this(p.getIdPregleda(), p.getVremePocetka(), p.getVremeZavrsetka(), p.getPopust(), p.getCenaSaPopustom(),
				p.getOcenaLekara(), p.getOcenaKilinike());
	}

	public PregledDTO() {
		super();
	}

	public PregledDTO(Long idPregleda, Calendar vremePocetka, Calendar vremeZavrsetka, Float popust,
			Float cenaSaPopustom, Integer ocenaLekara, Integer ocenaKilinike) {
		super();
		this.idPregleda = idPregleda;
		this.vremePocetka = vremePocetka;
		this.vremeZavrsetka = vremeZavrsetka;
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

	public Float getPopust() {
		return popust;
	}

	public void setPopust(Float popust) {
		this.popust = popust;
	}

	public Float getCenaSaPopustom() {
		return cenaSaPopustom;
	}

	public void setCenaSaPopustom(Float cenaSaPopustom) {
		this.cenaSaPopustom = cenaSaPopustom;
	}

	public Integer getOcenaLekara() {
		return ocenaLekara;
	}

	public void setOcenaLekara(Integer ocenaLekara) {
		this.ocenaLekara = ocenaLekara;
	}

	public Integer getOcenaKilinike() {
		return ocenaKilinike;
	}

	public void setOcenaKilinike(Integer ocenaKilinike) {
		this.ocenaKilinike = ocenaKilinike;
	}

}
