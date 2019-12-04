package com.isa.isa19.dto;

import java.util.Date;

import com.isa.isa19.model.RadniKalendar;
public class RadniKalendarDTO {
	
	private Long idRadnoVreme;
	private java.util.Date pocetakRadnogVremena;
	private java.util.Date krajRadnogVremena;

	public RadniKalendarDTO(RadniKalendar k) {
		this(k.getIdRadnoVreme(), k.getPocetakRadnogVremena(), k.getKrajRadnogVremena());
		// TODO Auto-generated constructor stub
	}
	
	public RadniKalendarDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RadniKalendarDTO(Long idRadnoVreme, Date pocetakRadnogVremena, Date krajRadnogVremena) {
		super();
		this.idRadnoVreme = idRadnoVreme;
		this.pocetakRadnogVremena = pocetakRadnogVremena;
		this.krajRadnogVremena = krajRadnogVremena;
	}
	public Long getIdRadnoVreme() {
		return idRadnoVreme;
	}
	public void setIdRadnoVreme(Long idRadnoVreme) {
		this.idRadnoVreme = idRadnoVreme;
	}
	public java.util.Date getPocetakRadnogVremena() {
		return pocetakRadnogVremena;
	}
	public void setPocetakRadnogVremena(java.util.Date pocetakRadnogVremena) {
		this.pocetakRadnogVremena = pocetakRadnogVremena;
	}
	public java.util.Date getKrajRadnogVremena() {
		return krajRadnogVremena;
	}
	public void setKrajRadnogVremena(java.util.Date krajRadnogVremena) {
		this.krajRadnogVremena = krajRadnogVremena;
	}

	

}
