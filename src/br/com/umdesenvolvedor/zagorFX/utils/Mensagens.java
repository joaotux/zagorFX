package br.com.umdesenvolvedor.zagorFX.utils;

import java.util.HashMap;
import java.util.Map;

public class Mensagens {
	private static Mensagens instancia;
	private static Map<String, String> mensagem = new HashMap<>();

	public Mensagens() {
		mensagem.put("001", "Dados salvos com sucesso!");
	}

	public static synchronized Mensagens getInstance() {
		if (instancia == null) {
			instancia = new Mensagens();
		}

		return instancia;
	}

	public String getMensager(String chave) {
		return mensagem.get(chave);
	}
}
