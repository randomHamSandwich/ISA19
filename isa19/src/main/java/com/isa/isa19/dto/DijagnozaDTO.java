package com.isa.isa19.dto;

import com.isa.isa19.model.Dijagnoza;

public class DijagnozaDTO {

	public Long idDijagnoza;
	public java.lang.String nazivDijagnoza;

	public DijagnozaDTO(Dijagnoza d) {
		this(d.getIdDijagnoza(), d.getNazivDijagnoza());
	}

	public DijagnozaDTO(Long idDijagnoza, String nazivDijagnoza) {
		super();
		this.idDijagnoza = idDijagnoza;
		this.nazivDijagnoza = nazivDijagnoza;
	}

	public DijagnozaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdDijagnoza() {
		return idDijagnoza;
	}

	public void setIdDijagnoza(Long idDijagnoza) {
		this.idDijagnoza = idDijagnoza;
	}

	public java.lang.String getNazivDijagnoza() {
		return nazivDijagnoza;
	}

	public void setNazivDijagnoza(java.lang.String nazivDijagnoza) {
		this.nazivDijagnoza = nazivDijagnoza;
	}

}
