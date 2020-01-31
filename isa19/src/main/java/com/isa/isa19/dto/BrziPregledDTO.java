package com.isa.isa19.dto;

public class BrziPregledDTO {

	private Long idPregleda;
	private Long idPacijent;

	public BrziPregledDTO() {
		super();
	}

	public BrziPregledDTO(Long idPregleda, Long idPacijent) {
		super();
		this.idPregleda = idPregleda;
		this.idPacijent = idPacijent;
	}

	public Long getIdPregleda() {
		return idPregleda;
	}

	public void setIdPregleda(Long idPregleda) {
		this.idPregleda = idPregleda;
	}

	public Long getIdPacijent() {
		return idPacijent;
	}

	public void setIdPacijent(Long idPacijent) {
		this.idPacijent = idPacijent;
	}

}
