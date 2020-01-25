package com.isa.isa19.dto;

import com.isa.isa19.model.Pregled;

public class PregledDTO {
	private Long idPregleda;
	private String vremePocetka;
	private String vremeZavrsetka;
	private Float popust;
	private Float cenaSaPopustom;
	private Integer ocenaLekara;
	private Integer ocenaKilinike;

	public PregledDTO(Pregled p, String pocetak, String kraj) {
		this(p.getIdPregleda(), pocetak, kraj, p.getPopust(), p.getCenaSaPopustom(),
				p.getOcenaLekara(), p.getOcenaKilinike());
	}

	public PregledDTO() {
		super();
	}

	public PregledDTO(Long idPregleda, String vremePocetka, String vremeZavrsetka, Float popust,
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

	public String getVremePocetka() {
		return vremePocetka;
	}

	public void setVremePocetka(String vremePocetka) {
		this.vremePocetka = vremePocetka;
	}

	public String getVremeZavrsetka() {
		return vremeZavrsetka;
	}

	public void setVremeZavrsetka(String vremeZavrsetka) {
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
