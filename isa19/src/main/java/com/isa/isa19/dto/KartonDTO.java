package com.isa.isa19.dto;
import com.isa.isa19.model.Karton;
public class KartonDTO {
	
	private Long idKarton;
	private int visina;
	private int tezina;
	private int krvnaGrupa;
	
	public KartonDTO(Karton k) {
		this(k.getIdKarton(), k.getVisina(), k.getTezina(), k.getKrvnaGrupa());
	}
	
	public KartonDTO() {
		super();
	}
	public KartonDTO(Long idKarton, int visina, int tezina, int krvnaGrupa) {
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
	public int getVisina() {
		return visina;
	}
	public void setVisina(int visina) {
		this.visina = visina;
	}
	public int getTezina() {
		return tezina;
	}
	public void setTezina(int tezina) {
		this.tezina = tezina;
	}
	public int getKrvnaGrupa() {
		return krvnaGrupa;
	}
	public void setKrvnaGrupa(int krvnaGrupa) {
		this.krvnaGrupa = krvnaGrupa;
	}
	
	

}
