package br.com.umdesenvolvedor.zagorFX.utils;

public class StringUtils {
	
	public static String completaValorComZerosAEsquerda(String valor) {
		int numero = Integer.parseInt(valor) + 1;
		String sNumero = String.valueOf(numero);
		
		if(sNumero.length() < 9) {
			for(int i = sNumero.length(); i < 9; i++) {
				sNumero = "0" + sNumero;
			}
		}
		return sNumero;
	}
}
