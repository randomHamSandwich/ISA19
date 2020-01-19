package com.isa.isa19.dto;
import com.isa.isa19.model.Karton;
public class KartonDTO {
	
	private Long idKarton;
	private String visina;
	private String tezina;
	private String krvnaGrupa;
	
	public KartonDTO(Karton k) {
		this(k.getIdKarton(), k.getVisina(), k.getTezina(), k.getKrvnaGrupa());
	}
	
	public KartonDTO() {
		super();
	}
	public KartonDTO(Long idKarton, String visina, String tezina, String krvnaGrupa) {
		super();
		this.idKarton = idKarton;
		this.visina = visina;
		this.tezina = tezina;
		this.krvnaGrupa = krvnaGrupa;
	}
	public Long getIdKarton() {
		return idKarton;
	}
	public void setIdKarton(Long idKarton) {
		this.idKarton = idKarton;
	}
	public String getVisina() {
		return visina;
	}
	public void setVisina(String visina) {
		this.visina = visina;
	}
	public String getTezina() {
		return tezina;
	}
	public void setTezina(String tezina) {
		this.tezina = tezina;
	}
	public String getKrvnaGrupa() {
		return krvnaGrupa;
	}
	public void setKrvnaGrupa(String krvnaGrupa) {
		this.krvnaGrupa = krvnaGrupa;
	}
	
	

}
