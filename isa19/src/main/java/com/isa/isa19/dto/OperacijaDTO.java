package com.isa.isa19.dto;

import java.time.LocalDate;
import java.util.Calendar;

import com.isa.isa19.model.Operacija;

public class OperacijaDTO {

	private Long idOperacija;
	private String vremePocetka;
	private String vremeZavrsetka;
	private Integer ocenaKlinke;
	private Integer ocenaLekara;

	public OperacijaDTO(Operacija o) {
		this(o.getIdOperacija(), o.getVremePocetka().toString(), o.getVremeZavrsetka().toString(), o.getOcenaKlinke(), o.getOcenaLekara());
	}

	public OperacijaDTO() {
		super();
	}

	public OperacijaDTO(Long idOperacija, String vremePocetka, String vremeZavrsetka, Integer ocenaKlinke, Integer ocenaLekara) {
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
