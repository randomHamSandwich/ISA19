package com.isa.isa19.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.isa.isa19.model.KalendarDogadjaja;
import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Operacija;
import com.isa.isa19.model.Pregled;
import com.isa.isa19.model.StatusPregledaOperacije;
import com.isa.isa19.model.TipDogadjajaKalendar;

public class DateChecker {

	public DateChecker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static boolean daLiLekarImaOdsustvo(Lekar lekar, LocalDate specifiedDate) {
		boolean result = false;
		for (KalendarDogadjaja kd : lekar.getKalendarDogadjaja()) {
			if (kd.getTipDogadjaja().equals(TipDogadjajaKalendar.ODOBRENI_ODMOR)
					&& isDateBetweenDate(kd.getPocetak(), kd.getKraj(), specifiedDate)) {
				result = true;
				break;
			}
		}
		return result;
	}

	// radno vreme je od 8 do 16 pregledi traju 30 min
	public static boolean daLiLekarImaPreglede(Lekar lekar, LocalDate specifiedDate) {
		boolean result = false;
		int pregledCounter = 0;
		for (Pregled pregled : lekar.getPregled()) {

			if (pregled.getStatus().equals(StatusPregledaOperacije.ZAKAZAN_PREGLED)
					&& isDateBetweenDate(pregled.getVremePocetka().toLocalDate(), pregled.getVremeZavrsetka().toLocalDate(), specifiedDate)) {
				pregledCounter++;
			}
		}
		System.out.println("-------------- pregledCounter kje :" + pregledCounter);
		if (pregledCounter == 16) {
			result = true;
		}
		return result;
	}

	public static boolean daLiLekarImaOperaciju(Lekar lekar, LocalDate specifiedDate) {
		boolean result = false;
		for (Operacija operacija : lekar.getOperacija()) {
			if ( operacija.getStatus().equals(StatusPregledaOperacije.ZAKAZANA_OPERACIJA) && isDateBetweenDate(operacija.getVremePocetka().toLocalDate(), operacija.getVremeZavrsetka().toLocalDate(), specifiedDate)) {
				result = true;
			}
		}
		return result;
	}

	public static boolean isDateBetweenDate(LocalDate startDate, LocalDate endDate, LocalDate specifiedDate) {
		return (startDate.isBefore(specifiedDate) && endDate.isAfter(specifiedDate)) || startDate.equals(specifiedDate)
				|| endDate.equals(specifiedDate);
	}
	
	public static boolean isDateBetweenDateAndTime(LocalDateTime startDateTime, LocalDateTime endDateTime, LocalDateTime specifiedDateTime) {
		return (startDateTime.isBefore(specifiedDateTime) && endDateTime.isAfter(specifiedDateTime)) || startDateTime.equals(specifiedDateTime)
				|| endDateTime.equals(specifiedDateTime);
	}
	
	public static LocalDate parseToLocalDate(String date) {
	String dateString = date.substring(4, 15);
	return  LocalDate.parse(dateString, DateTimeFormatter.ofPattern("MMM dd yyyy"));
	}
}