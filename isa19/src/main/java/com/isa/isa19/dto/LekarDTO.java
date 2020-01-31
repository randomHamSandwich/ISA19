package com.isa.isa19.dto;

import java.util.List;

import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Specijalizacija;

public class LekarDTO {

	public Long idOsoba;
	public String ime;
	public String prezime;
	private Float ocenaLekar;
	private Specijalizacija specijalizacija;
	private Long idKlinika;
	private String klinikaNaziv;
	
	private Float cena;
	private List<String> slobodniTermini;
	
    private String klinikaUlica;
	private String klinikaBrojUlice;
	private String klinikaGrad;
	private String klinikaDrzava;
	private Float ocenaKlinike;

	public LekarDTO(Lekar l) {
		this(l.getIdOsoba(), l.getIme(), l.getPrezime(), l.getOcenaLekar(), l.getSpecijalizacija(),
				l.getKlinika().getIdKlinika(), l.getKlinika().getNaziv());
	}
	


	public LekarDTO(Lekar l, Float cena) {
		this(l.getIdOsoba(), l.getIme(), l.getPrezime(), l.getOcenaLekar(), l.getSpecijalizacija(),
				l.getKlinika().getIdKlinika(), l.getKlinika().getNaziv());
		this.cena = cena;
	}

	public LekarDTO(Lekar l, List<String> slobodniTermini) {
		this(l.getIdOsoba(), l.getIme(), l.getPrezime(), l.getOcenaLekar(), l.getSpecijalizacija(),
				l.getKlinika().getIdKlinika(), l.getKlinika().getNaziv());
		this.slobodniTermini = slobodniTermini;
	}

	public LekarDTO(Lekar l, Float cena, List<String> slobodniTermini) {
		this(l.getIdOsoba(), l.getIme(), l.getPrezime(), l.getOcenaLekar(), l.getSpecijalizacija(),
				l.getKlinika().getIdKlinika(), l.getKlinika().getNaziv());
		this.cena = cena;
		this.slobodniTermini = slobodniTermini;
	}
	
	public LekarDTO(Lekar l, Float cena, List<String> slobodniTermini, String klinikaGrad) {
		this(l.getIdOsoba(), l.getIme(), l.getPrezime(), l.getOcenaLekar(), l.getSpecijalizacija(),
				l.getKlinika().getIdKlinika(), l.getKlinika().getNaziv());
		this.cena = cena;
		this.slobodniTermini = slobodniTermini;
		
		this.klinikaGrad =klinikaGrad;
		this.klinikaDrzava= l.getKlinika().getDrzava();
		this.klinikaBrojUlice=l.getKlinika().getBrojUlice();
		this.klinikaUlica = l.getKlinika().getUlica();
		this.ocenaKlinike = l.getKlinika().getOcenaKlinike();
	}

	public LekarDTO(Long idOsoba, String ime, String prezime, Float ocenaLekar, Specijalizacija specijalizacija,
			Long idKlinika, String klinikaNaziv) {
		super();
		this.idOsoba = idOsoba;
		this.ime = ime;
		this.prezime = prezime;
		this.ocenaLekar = ocenaLekar;
		this.specijalizacija = specijalizacija;
		this.idKlinika = idKlinika;
		this.klinikaNaziv = klinikaNaziv;
	}

	public Long getIdOsoba() {
		return idOsoba;
	}

	public void setIdOsoba(Long idOsoba) {
		this.idOsoba = idOsoba;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Float getOcenaLekar() {
		return ocenaLekar;
	}

	public void setOcenaLekar(Float ocenaLekar) {
		this.ocenaLekar = ocenaLekar;
	}

	public Specijalizacija getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(Specijalizacija specijalizacija) {
		this.specijalizacija = specijalizacija;
	}

	public Long getIdKlinika() {
		return idKlinika;
	}

	public void setIdKlinika(Long idKlinika) {
		this.idKlinika = idKlinika;
	}

	public String getKlinikaNaziv() {
		return klinikaNaziv;
	}

	public void setKlinikaNaziv(String klinikaNaziv) {
		this.klinikaNaziv = klinikaNaziv;
	}

	public Float getCena() {
		return cena;
	}

	public void setCena(Float cena) {
		this.cena = cena;
	}

	public List<String> getSlobodniTermini() {
		return slobodniTermini;
	}

	public void setSlobodniTermini(List<String> slobodniTermini) {
		this.slobodniTermini = slobodniTermini;
	}

	public String getKlinikaUlica() {
		return klinikaUlica;
	}

	public void setKlinikaUlica(String klinikaUlica) {
		this.klinikaUlica = klinikaUlica;
	}

	public String getKlinikaBrojUlice() {
		return klinikaBrojUlice;
	}

	public void setKlinikaBrojUlice(String klinikaBrojUlice) {
		this.klinikaBrojUlice = klinikaBrojUlice;
	}

	public String getKlinikaGrad() {
		return klinikaGrad;
	}

	public void setKlinikaGrad(String klinikaGrad) {
		this.klinikaGrad = klinikaGrad;
	}

	public String getKlinikaDrzava() {
		return klinikaDrzava;
	}

	public void setKlinikaDrzava(String klinikaDrzava) {
		this.klinikaDrzava = klinikaDrzava;
	}

	public Float getOcenaKlinike() {
		return ocenaKlinike;
	}

	public void setOcenaKlinike(Float ocenaKlinike) {
		this.ocenaKlinike = ocenaKlinike;
	}
	
	

}
