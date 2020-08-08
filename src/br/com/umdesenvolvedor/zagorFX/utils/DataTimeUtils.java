package br.com.umdesenvolvedor.zagorFX.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class DataTimeUtils {

	public static Date stringToDate(String data) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Date dataFormatada = null;

		try {

			dataFormatada = format.parse(data);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dataFormatada;
	}

	// 2019-05-18 20:34:50.0
	public static String formataData(Date data, String mascara) {
		mascara = mascara != null ? mascara : "dd/MM/yyyy";

		DateFormat format = new SimpleDateFormat(mascara);

		String dataFormatada = null;

		dataFormatada = format.format(data);

		return dataFormatada;
	}

	public static String formataData(Date data) {
		return formataData(data, null);
	}

	public static String formatLocalDateToString(LocalDate data, String mascara) {
		mascara = mascara != null ? mascara : "dd/MM/yyyy";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(mascara).withZone(ZoneId.of("America/Porto_Velho"));

		return data.format(formatter);
	}

	public static String formatLocalDateToString(LocalDate data) {
		return formatLocalDateToString(data, null);
	}
	
	public static String formatLocalDateTimeToString(LocalDateTime data, String mascara) {
		mascara = mascara != null ? mascara : "dd/MM/yyyy HH:mm:ss";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(mascara).withZone(ZoneId.of("America/Porto_Velho"));
		return data.format(formatter);
	}
	
	public static String formatLocalDateTimeToString(LocalDateTime data) {
		return formatLocalDateTimeToString(data, null);
	}

	/**
	 * 
	 * @param horas hh:mm:ss
	 * 
	 * @return LocalTime
	 */
	public static LocalTime stringToLocalTime(String horas) {
		if (horas.equals(""))
			horas = "00:00:00";

		return LocalTime.parse(horas);
	}
	
	public static int diasEntreAsDatas(LocalDate dataInicial, LocalDate dataFinal) {
		DateTime inicio = new DateTime(dataInicial.getYear(), dataInicial.getMonth().getValue(), dataInicial.getDayOfMonth(), 0, 0);
		DateTime fim = new DateTime(dataFinal.getYear(), dataFinal.getMonth().getValue(), dataFinal.getDayOfMonth(), 0, 0);
		return Days.daysBetween(inicio, fim).getDays();
	}
	
	public static LocalDate incrementaData(int campo, int valor, LocalDate dataOrigem)
	{
		GregorianCalendar gcal = new GregorianCalendar();
		
		try
		{
			Date data = Date.from(dataOrigem.atStartOfDay(ZoneId.systemDefault()).toInstant());
			gcal.setTime(data);
			gcal.add(campo, valor);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return dateParaLocalDate(new Date(gcal.getTime().getTime()));
	}
	
	public static LocalDate dateParaLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
