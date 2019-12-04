package com.isa.isa19.dto;

import com.isa.isa19.model.Usluga;

public class UslugaDTO {
	private Long idSuluge;
	private int nazivUsluge;
	private int opisUsluge;
	private float cena;

	public UslugaDTO(Usluga u) {
		this(u.getIdSuluge(), u.getNazivUsluge(), u.getOpisUsluge(), u.getCena());
	}
	
	public UslugaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UslugaDTO(Long idSuluge, int nazivUsluge, int opisUsluge, float cena) {
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

	public int getNazivUsluge() {
		return nazivUsluge;
	}

	public void setNazivUsluge(int nazivUsluge) {
		this.nazivUsluge = nazivUsluge;
	}

	public int getOpisUsluge() {
		return opisUsluge;
	}

	public void setOpisUsluge(int opisUsluge) {
		this.opisUsluge = opisUsluge;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

}
