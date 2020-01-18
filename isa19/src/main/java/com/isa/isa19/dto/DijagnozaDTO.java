package com.isa.isa19.dto;

import com.isa.isa19.model.Dijagnoza;

public class DijagnozaDTO {

	public Long idDijagnoza;
	public String nazivDijagnoza;

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
	}

	public Long getIdDijagnoza() {
		return idDijagnoza;
	}

	public void setIdDijagnoza(Long idDijagnoza) {
		this.idDijagnoza = idDijagnoza;
	}

	public String getNazivDijagnoza() {
		return nazivDijagnoza;
	}

	public void setNazivDijagnoza(String nazivDijagnoza) {
		this.nazivDijagnoza = nazivDijagnoza;
	}

}
