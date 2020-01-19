package com.isa.isa19.dto;

import java.util.Calendar;
import java.util.Date;

import com.isa.isa19.model.Operacija;

public class OperacijaDTO {

	private Long idOperacija;
	private Calendar vremePocetka;
	private Calendar vremeZavrsetka;
	private Integer ocenaKlinke;
	private Integer ocenaLekara;

	public OperacijaDTO(Operacija o) {
		this(o.getIdOperacija(), o.getVremePocetka(), o.getVremeZavrsetka(), o.getOcenaKlinke(), o.getOcenaLekara());
	}

	public OperacijaDTO() {
		super();
	}

	public OperacijaDTO(Long idOperacija, Calendar vremePocetka, Calendar vremeZavrsetka, Integer ocenaKlinke, Integer ocenaLekara) {
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

	public Integer getOcenaKlinke() {
		return ocenaKlinke;
	}

	public void setOcenaKlinke(Integer ocenaKlinke) {
		this.ocenaKlinke = ocenaKlinke;
	}

	public Integer getOcenaLekara() {
		return ocenaLekara;
	}

	public void setOcenaLekara(Integer ocenaLekara) {
		this.ocenaLekara = ocenaLekara;
	}



}
