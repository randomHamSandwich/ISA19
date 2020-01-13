package com.isa.isa19.dto;

import java.util.Calendar;
import java.util.Date;

import com.isa.isa19.model.Operacija;

public class OperacijaDTO {

	private Long idOperacija;
	private Calendar vremePocetka;
	private Calendar vremeZavrsetka;
	private int ocenaKlinke;
	private int ocenaLekara;

	public OperacijaDTO(Operacija o) {
		this(o.getIdOperacija(), o.getVremePocetka(), o.getVremeZavrsetka(), o.getOcenaKlinke(), o.getOcenaLekara());
	}

	public OperacijaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OperacijaDTO(Long idOperacija, Calendar vremePocetka, Calendar vremeZavrsetka, int ocenaKlinke, int ocenaLekara) {
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
