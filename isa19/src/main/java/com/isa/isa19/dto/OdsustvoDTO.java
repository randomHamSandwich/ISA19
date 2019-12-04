package com.isa.isa19.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.isa.isa19.model.Odsutvo;;

public class OdsustvoDTO {
	
	private Long idOdsustvo;
	private Date dan;
	
	public OdsustvoDTO(Odsutvo o) {
		this(o.getIdOdsustvo(), o.getDan());
	}
	
	public OdsustvoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OdsustvoDTO(Long idOdsustvo, Date dan) {
		super();
		this.idOdsustvo = idOdsustvo;
		this.dan = dan;
	}
	public Long getIdOdsustvo() {
		return idOdsustvo;
	}
	public void setIdOdsustvo(Long idOdsustvo) {
		this.idOdsustvo = idOdsustvo;
	}
	public Date getDan() {
		return dan;
	}
	public void setDan(Date dan) {
		this.dan = dan;
	}
	
	

}
