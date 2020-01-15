
/***********************************************************************
 * Module:  MedicinskaSestra.java
 * Author:  Basaric Aleksandar
 * Purpose: Defines the Class MedicinskaSestra
 ***********************************************************************/

package com.isa.isa19.model;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("SESTRA")
public class MedicinskaSestra extends Korisnik{
	@ManyToMany
	@JoinTable(name = "medicinska_sestra_operacija", joinColumns = @JoinColumn(name = "id_medicinska_sestra"), inverseJoinColumns = @JoinColumn(name = "id_operacija"))
	private Set<Operacija> operacija;

	@OneToMany(mappedBy = "medicinskaSestra", cascade = CascadeType.ALL)
	private Set<Pregled> pregled;

	public MedicinskaSestra() {
		super();
	}

	public Set<Operacija> getOperacija() {
		return operacija;
	}

	public void setOperacija(Set<Operacija> operacija) {
		this.operacija = operacija;
	}

	public Set<Pregled> getPregled() {
		return pregled;
	}

	public void setPregled(Set<Pregled> pregled) {
		this.pregled = pregled;
	}
	
	

}