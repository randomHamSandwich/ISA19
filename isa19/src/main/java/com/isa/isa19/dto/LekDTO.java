package com.isa.isa19.dto;

import com.isa.isa19.model.Lek;

public class LekDTO {
	
	private Long idLek;
	private String naziv;
	

	public LekDTO(Lek l) {
		this(l.getIdLek(), l.getNaziv());
	}


	public Long getIdLek() {
		return idLek;
	}


	public void setIdLek(Long idLek) {
		this.idLek = idLek;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public LekDTO(Long idLek, String naziv) {
		super();
		this.idLek = idLek;
		this.naziv = naziv;
	}


	public LekDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
