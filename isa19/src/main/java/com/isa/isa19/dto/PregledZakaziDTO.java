package com.isa.isa19.dto;

public class PregledZakaziDTO {

	private String idLekar;
	private String date;
	private String time;
	private String idPacijent;

	public PregledZakaziDTO() {
		super();
	}

	public PregledZakaziDTO(String idLekar, String date, String time, String idPacijent) {
		super();
		this.idLekar = idLekar;
		this.date = date;
		this.time = time;
		this.idPacijent = idPacijent;
	}

	public String getIdLekar() {
		return idLekar;
	}

	public void setIdLekar(String idLekar) {
		this.idLekar = idLekar;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getIdPacijent() {
		return idPacijent;
	}

	public void setIdPacijent(String idPacijent) {
		this.idPacijent = idPacijent;
	}

	
}
