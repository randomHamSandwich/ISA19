package com.isa.isa19.dto;

public class LozinkeDTO {
	
	private String lozinkaStara;
	private String lozinkaNova;
	
	public LozinkeDTO() {
		super();
	}
	public LozinkeDTO(String lozinkaStara, String lozinkaNova) {
		super();
		this.lozinkaStara = lozinkaStara;
		this.lozinkaNova = lozinkaNova;
	}
	public String getLozinkaStara() {
		return lozinkaStara;
	}
	public void setLozinkaStara(String lozinkaStara) {
		this.lozinkaStara = lozinkaStara;
	}
	public String getLozinkaNova() {
		return lozinkaNova;
	}
	public void setLozinkaNova(String lozinkaNova) {
		this.lozinkaNova = lozinkaNova;
	}
	
	
	

}
