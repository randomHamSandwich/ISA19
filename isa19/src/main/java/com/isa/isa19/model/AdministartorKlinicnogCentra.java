/***********************************************************************
 * Module:  AdministartorKlinicnogCentra.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class AdministartorKlinicnogCentra
 ***********************************************************************/

package com.isa.isa19.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class AdministartorKlinicnogCentra extends Korisnik {
	@OneToMany(mappedBy = "administartorKlinicnogCentra", cascade = CascadeType.ALL)
	public Set<Dijagnoza> dijagnoza;

	@OneToMany(mappedBy ="administartorKlinicnogCentra",cascade = CascadeType.ALL)
	public Set<Lek> lek;

	public Set<Dijagnoza> getDijagnoza() {
		return dijagnoza;
	}

	public void setDijagnoza(Set<Dijagnoza> dijagnoza) {
		this.dijagnoza = dijagnoza;
	}

	public Set<Lek> getLek() {
		return lek;
	}

	public void setLek(Set<Lek> lek) {
		this.lek = lek;
	}

	public AdministartorKlinicnogCentra() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}