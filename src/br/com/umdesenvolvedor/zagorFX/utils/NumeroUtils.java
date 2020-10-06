package br.com.umdesenvolvedor.zagorFX.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumeroUtils {

	private static NumberFormat format;

	/*
	 * Converte String em BigDecimal
	 * 
	 */
	public static BigDecimal stringToBigDecimal(String valor) {
		format = NumberFormat.getInstance(new Locale("pt", "BR"));

		Double dValor = null;

		try {

			dValor = valor.isEmpty() ? 0.0 : format.parse(valor.replace("R$ ", "")).doubleValue();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return new BigDecimal(dValor.toString());
	}

	public static String bigDecimalToString(BigDecimal valor) {
		format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

		if (valor == null)
			throw new NullPointerException("Valor está nulo, verifique.");

		return format.format(valor);
	}

}
