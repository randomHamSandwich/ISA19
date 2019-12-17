package com.isa.isa19.dto;

import java.util.Date;

import com.isa.isa19.model.Operacija;

public class OperacijaDTO {

	private Long idOperacija;
	private java.util.Date vremePocetka;
	private java.util.Date vremeZavrsetka;
	private int ocenaKlinke;
	private int ocenaLekara;

	public OperacijaDTO(Operacija o) {
		this(o.getIdOperacija(), o.getVremePocetka(), o.getVremeZavrsetka(), o.getOcenaKlinke(), o.getOcenaLekara());
	}

	public OperacijaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OperacijaDTO(Long idOperacija, Date vremePocetka, Date vremeZavrsetka, int ocenaKlinke, int ocenaLekara) {
		super();
		this.idOperacija = idOperacija;
		this.vremePocetka = vremePocetka;
		this.vremeZavrsetka = vremeZavrsetka;
		this.ocenaKlinke = ocenaKlinke;
		this.ocenaLekara = ocenaLekara;
	}

	public Long getIdOperacija() {
		return idOperacija;
	}

	public void setIdOperacija(Long idOperacija) {
		this.idOperacija = idOperacija;
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

	public int getOcenaKlinke() {
		return ocenaKlinke;
	}

	public void setOcenaKlinke(int ocenaKlinke) {
		this.ocenaKlinke = ocenaKlinke;
	}

	public int getOcenaLekara() {
		return ocenaLekara;
	}

	public void setOcenaLekara(int ocenaLekara) {
		this.ocenaLekara = ocenaLekara;
	}

}
