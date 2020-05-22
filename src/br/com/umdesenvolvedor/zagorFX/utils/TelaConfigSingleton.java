package br.com.umdesenvolvedor.zagorFX.utils;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class TelaConfigSingleton {

	private static TelaConfigSingleton instancia;
	GraphicsDevice gd;
	private int telaLargura;
	private int telaAltura;

	private TelaConfigSingleton() {
		gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		telaLargura = gd.getDisplayMode().getWidth();
		telaAltura = gd.getDisplayMode().getHeight();
	}

	public static synchronized TelaConfigSingleton getInstance() {
		if (instancia == null) {
			instancia = new TelaConfigSingleton();
		}

		return instancia;
	}

	public int getTelaLargura() {
		return telaLargura;
	}

	public int getTelaAltura() {
		return telaAltura;
	}

}
