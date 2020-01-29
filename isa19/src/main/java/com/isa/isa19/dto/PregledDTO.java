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
	private Long idLekara;

	private String imeLekara;
	private String prezimeLekara;
	private String dijagnoza;
	private String specijalizacija;

	private String nazivKlinike;
	private String gradKlionike;
	private String ulicaKlinike;
	private String brojUliceKlinike;
	
	public PregledDTO(Pregled p, String pocetak, String kraj, String imeLekara, String prezimeLekara, String dijagnoza,
			String specijalizacija, String nazivKlinike) {
		this(p, pocetak, kraj);
		this.imeLekara = imeLekara;
		this.prezimeLekara = prezimeLekara;
		this.dijagnoza = dijagnoza;
		this.specijalizacija = specijalizacija;
		this.nazivKlinike=nazivKlinike;
	}

	public PregledDTO(Pregled p, String pocetak, String kraj, String imeLekara, String prezimeLekara, String dijagnoza,
			String specijalizacija) {
		this(p, pocetak, kraj);
		this.imeLekara = imeLekara;
		this.prezimeLekara = prezimeLekara;
		this.dijagnoza = dijagnoza;
		this.specijalizacija = specijalizacija;
	}

	public PregledDTO(Pregled p, String pocetak, String kraj, String imeLekara, String prezimeLekara,
			String specijalizacija, String nazivKlinike, String gradKlionike, String ulicaKlinike,
			String brojUliceKlinike) {
		this(p, pocetak, kraj);
		this.imeLekara = imeLekara;
		this.prezimeLekara = prezimeLekara;
		this.specijalizacija = specijalizacija;
		this.nazivKlinike = nazivKlinike;
		this.gradKlionike = gradKlionike;
		this.ulicaKlinike = ulicaKlinike;
		this.brojUliceKlinike = brojUliceKlinike;
	}

	public PregledDTO(Pregled p, String pocetak, String kraj) {
		this(p.getIdPregleda(), pocetak, kraj, p.getPopust(), p.getCenaSaPopustom(), p.getOcenaLekara(),
				p.getOcenaKilinike(), p.getLekar().getIdOsoba());
	}

	public PregledDTO() {
		super();
	}

	public PregledDTO(Long idPregleda, String vremePocetka, String vremeZavrsetka, Float popust, Float cenaSaPopustom,
			Integer ocenaLekara, Integer ocenaKilinike, Long idLekara) {
		super();
		this.idPregleda = idPregleda;
		this.vremePocetka = vremePocetka;
		this.vremeZavrsetka = vremeZavrsetka;
		this.popust = popust;
		this.cenaSaPopustom = cenaSaPopustom;
		this.ocenaLekara = ocenaLekara;
		this.ocenaKilinike = ocenaKilinike;
		this.idLekara = idLekara;
	}

	public Long getIdLekara() {
		return idLekara;
	}

	public void setIdLekara(Long idLekara) {
		this.idLekara = idLekara;
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

	public String getImeLekara() {
		return imeLekara;
	}

	public void setImeLekara(String imeLekara) {
		this.imeLekara = imeLekara;
	}

	public String getPrezimeLekara() {
		return prezimeLekara;
	}

	public void setPrezimeLekara(String prezimeLekara) {
		this.prezimeLekara = prezimeLekara;
	}

	public String getDijagnoza() {
		return dijagnoza;
	}

	public void setDijagnoza(String dijagnoza) {
		this.dijagnoza = dijagnoza;
	}

	public String getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(String specijalizacija) {
		this.specijalizacija = specijalizacija;
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

}
