package br.com.umdesenvolvedor.zagorFX.utils;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class Impressoras {
	private PrintService[] services = null;

	public PrintService[] getImpressoras() {
		services = PrintServiceLookup.lookupPrintServices(null, null);

		//debug
		for (PrintService ps : services) {
			System.out.println("Localizada no PC ~> " + ps.getName());
		}
		return services;
	}

	public PrintService[] getServices() {
		return services;
	}

	public static void main(String[] args) {
		Impressoras impressoras = new Impressoras();
		impressoras.getImpressoras();
	}
}


