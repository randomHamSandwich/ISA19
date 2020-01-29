package com.isa.isa19.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import com.isa.isa19.model.Operacija;
import com.isa.isa19.model.Lekar;

public class OperacijaDTO {

	private Long idOperacija;
	private String vremePocetka;
	private String vremeZavrsetka;
	private Integer ocenaKlinke;
	private Integer ocenaLekara;
	private List<String> lekari;
	private String nazivKlinike;
	private String gradKlionike;
	private String ulicaKlinike;
	private String brojUliceKlinike;
	private String specijalizacija;

	public OperacijaDTO(Operacija o) {
		this(o.getIdOperacija(), o.getVremePocetka().toString(), o.getVremeZavrsetka().toString(), o.getOcenaKlinke(), o.getOcenaLekara());
	}
	
	public OperacijaDTO(Operacija o, String pocetak, Collection<Lekar> lekari) {
		this(o.getIdOperacija(), pocetak, o.getVremeZavrsetka().toString(), o.getOcenaKlinke(), o.getOcenaLekara());
		this.nazivKlinike = o.getKlinika().getNaziv();
		this.gradKlionike = o.getKlinika().getGrad();
		this.ulicaKlinike = o.getKlinika().getUlica();
		this.brojUliceKlinike = o.getKlinika().getBrojUlice();
		this.lekari = new ArrayList<String>();
		for(Lekar l : lekari) {
			this.lekari.add(l.getIme()+" "+ l.getPrezime());
			this.setSpecijalizacija(l.getSpecijalizacija().toString());
		}
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

	public List<String> getLekari() {
		return lekari;
	}

	public void setLekari(List<String> lekari) {
		this.lekari = lekari;
	}

	public String getNazivKlinike() {
		return nazivKlinike;
	}

	public void setNazivKlinike(String nazivKlinike) {
		this.nazivKlinike = nazivKlinike;
	}

	public String getGradKlionike() {
		return gradKlionike;
	}

	public void setGradKlionike(String gradKlionike) {
		this.gradKlionike = gradKlionike;
	}

	public String getUlicaKlinike() {
		return ulicaKlinike;
	}

	public void setUlicaKlinike(String ulicaKlinike) {
		this.ulicaKlinike = ulicaKlinike;
	}

	public String getBrojUliceKlinike() {
		return brojUliceKlinike;
	}

	public void setBrojUliceKlinike(String brojUliceKlinike) {
		this.brojUliceKlinike = brojUliceKlinike;
	}

	public String getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(String specijalizacija) {
		this.specijalizacija = specijalizacija;
	}



}
