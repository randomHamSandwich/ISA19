/***********************************************************************
 * Module:  Odsutvo.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class Odsutvo
 ***********************************************************************/
package com.isa.isa19.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Odsutvo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOdsustvo;
	
	@Column
	private Date dan;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_medicinskoOsoblje")
	private MedicinskoOsoblje medicinskoOsoblje;

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

	public MedicinskoOsoblje getMedicinskoOsoblje() {
		return medicinskoOsoblje;
	}

	public void setMedicinskoOsoblje(MedicinskoOsoblje medicinskoOsoblje) {
		this.medicinskoOsoblje = medicinskoOsoblje;
	}
	
	

}