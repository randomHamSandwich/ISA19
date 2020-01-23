package com.isa.isa19.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class KalendarDogadjaja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idKalendar;

	@Column
	private LocalDate pocetak;

	@Column
	private LocalDate kraj;

	@Enumerated(EnumType.STRING)
	private TipDogadjajaKalendar tipDogadjaja;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_medicinsko_osoblje", nullable = true)
	private Lekar lekar;

	public KalendarDogadjaja() {
		super();
	}

	public KalendarDogadjaja(Long idKalendar, LocalDate pocetak, LocalDate kraj, TipDogadjajaKalendar tipDogadjaja,
			Lekar lekar) {
		super();
		this.idKalendar = idKalendar;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.tipDogadjaja = tipDogadjaja;
		this.lekar = lekar;
	}

	public Long getIdKalendar() {
		return idKalendar;
	}

	public void setIdKalendar(Long idKalendar) {
		this.idKalendar = idKalendar;
	}

	public LocalDate getPocetak() {
		return pocetak;
	}

	public void setPocetak(LocalDate pocetak) {
		this.pocetak = pocetak;
	}

	public LocalDate getKraj() {
		return kraj;
	}

	public void setKraj(LocalDate kraj) {
		this.kraj = kraj;
	}

	public TipDogadjajaKalendar getTipDogadjaja() {
		return tipDogadjaja;
	}

	public void setTipDogadjaja(TipDogadjajaKalendar tipDogadjaja) {
		this.tipDogadjaja = tipDogadjaja;
	}

	public Lekar getLekar() {
		return lekar;
	}

	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}

}
