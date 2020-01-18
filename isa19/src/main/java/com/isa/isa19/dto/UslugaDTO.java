package com.isa.isa19.dto;

import com.isa.isa19.model.Usluga;

public class UslugaDTO {
	private Long idSuluge;
	private String nazivUsluge;
	private String opisUsluge;
	private Float cena;

	public UslugaDTO(Usluga u) {
		this(u.getIdSuluge(), u.getNazivUsluge(), u.getOpisUsluge(), u.getCena());
	}
	
	public UslugaDTO() {
		super();
	}

	public UslugaDTO(Long idSuluge, String nazivUsluge, String opisUsluge, Float cena) {
		super();
		this.idSuluge = idSuluge;
		this.nazivUsluge = nazivUsluge;
		this.opisUsluge = opisUsluge;
		this.cena = cena;
	}

	public Long getIdSuluge() {
		return idSuluge;
	}

	public void setIdSuluge(Long idSuluge) {
		this.idSuluge = idSuluge;
	}

	public String getNazivUsluge() {
		return nazivUsluge;
	}

	public void setNazivUsluge(String nazivUsluge) {
		this.nazivUsluge = nazivUsluge;
	}

	public String getOpisUsluge() {
		return opisUsluge;
	}

	public void setOpisUsluge(String opisUsluge) {
		this.opisUsluge = opisUsluge;
	}

	public Float getCena() {
		return cena;
	}

	public void setCena(Float cena) {
		this.cena = cena;
	}


}
