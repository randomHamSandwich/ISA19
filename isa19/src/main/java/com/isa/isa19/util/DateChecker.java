package com.isa.isa19.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.isa.isa19.model.KalendarDogadjaja;
import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Operacija;
import com.isa.isa19.model.Pregled;
import com.isa.isa19.model.StatusPregledaOperacije;
import com.isa.isa19.model.TipDogadjajaKalendar;

public class DateChecker {

	public DateChecker() {
		super();
	}

	public static boolean daLiLekarImaOdsustvo(Lekar lekar, LocalDate specifiedDate) {
		System.out.println("jesam li u transactional: "+TransactionSynchronizationManager.isActualTransactionActive());
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
	public static boolean daLiLekarImaZakazaneIliBrzePreglede(Lekar lekar, LocalDate specifiedDate) {
		boolean result = false;
		int pregledCounter = 0;
		for (Pregled pregled : lekar.getPregled()) {

			if ((pregled.getStatus().equals(StatusPregledaOperacije.ZAKAZAN_PREGLED) || pregled.getStatus().equals(StatusPregledaOperacije.BRZI_PREGLED))
					&& isDateBetweenDate(pregled.getVremePocetka().toLocalDate(),
							pregled.getVremeZavrsetka().toLocalDate(), specifiedDate)) {
				pregledCounter++;
			}
		}
//		System.out.println("-------------- pregledCounter kje :" + pregledCounter);
		if (pregledCounter >= 16) {
			result = true;
		}
		return result;
	}
	
//	public static boolean daliLekarImaBrziPregled(Lekar lekar, LocalDate specifiedDate) {
//		boolean result = false;
//		
//		for(Pregled pregled :lekar.getPregled()) {
//			if(pregled.getStatus().equals(StatusPregledaOperacije.BRZI_PREGLED)
//					&& pregled.getVremePocetka().equals(specifiedDate)) {
//				result =true;
//				break;
//			}
//		}
//		
//		return result;
//	}
//	
	
	public static boolean daLiLekarImaZakazanIliBrziPregledTerminIliRezervisan(Lekar lekar, LocalDateTime start) {
		boolean result =false;
		for(Pregled pregled : lekar.getPregled()) {
			if((pregled.getStatus().equals(StatusPregledaOperacije.ZAKAZAN_PREGLED) ||  pregled.getStatus().equals(StatusPregledaOperacije.BRZI_PREGLED)
					||   pregled.getStatus().equals(StatusPregledaOperacije.REZERVISAN_PREGLED))
					&& pregled.getVremePocetka().equals(start)) {
				result= true;
				break;
			}
		}
		return result;
	}
	
	


	public static boolean daLiLekarImaOperaciju(Lekar lekar, LocalDate specifiedDate) {
		boolean result = false;
		for (Operacija operacija : lekar.getOperacija()) {
			if (operacija.getStatus().equals(StatusPregledaOperacije.ZAKAZANA_OPERACIJA)
					&& isDateBetweenDate(operacija.getVremePocetka().toLocalDate(),
							operacija.getVremeZavrsetka().toLocalDate(), specifiedDate)) {
				result = true;
			}
		}
		return result;
	}



	public static boolean isDateBetweenDate(LocalDate startDate, LocalDate endDate, LocalDate specifiedDate) {
		return (startDate.isBefore(specifiedDate) && endDate.isAfter(specifiedDate)) || startDate.equals(specifiedDate)
				|| endDate.equals(specifiedDate);
	}

	public static boolean isDateBetweenDateAndTime(LocalDateTime startDateTime, LocalDateTime endDateTime,
			LocalDateTime specifiedDateTime) {
		return (startDateTime.isBefore(specifiedDateTime) && endDateTime.isAfter(specifiedDateTime))
				|| startDateTime.equals(specifiedDateTime) || endDateTime.equals(specifiedDateTime);
	}

	public static LocalDate parseToLocalDate(String date) {
		String dateString = date.substring(4, 15);
		return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("MMM dd yyyy"));
	}

	public static LocalDate parseChoppedDateToLocalDate(String date) {
		return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public static LocalDateTime parseToLocalDateAndTime(String date, String time) {
		String dateTimeString = date.substring(4, 15);
		dateTimeString += " " + time;
		return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("MMM dd yyyy HH mm"));
	}
	
	public static LocalDateTime parseChoppedDateToLocalDateAndTime(String date, String time) {
		return LocalDateTime.parse(date+" " + time, DateTimeFormatter.ofPattern("dd-MM-yyyy HH mm"));
	}




}
