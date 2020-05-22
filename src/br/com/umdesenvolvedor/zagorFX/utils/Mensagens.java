package br.com.umdesenvolvedor.zagorFX.utils;

import java.util.HashMap;
import java.util.Map;

public class Mensagens {
	private static Mensagens instancia;
	private static Map<Integer, String> mensagem = new HashMap<>();

	public Mensagens() {
		mensagem.put(001, "Dados incorretos, verifique!");
		mensagem.put(002, "Erro inesperado, chame o suporte!");
		mensagem.put(003, "Descrição é obrigatória!");
		mensagem.put(004, "Valor é obrigatório!");
		mensagem.put(005, "Nenhum registro selecionado!");
		mensagem.put(006, "Sigla é obrigatória!");
		mensagem.put(007, "Nome é obrigatório!");
		mensagem.put(8, "Data nascimento é obrigatório!");
		mensagem.put(9, "Quantidade é obrigatória!");
		mensagem.put(10, "Data é obrigatória!");
		mensagem.put(11, "Produto é obrigatório!");
		mensagem.put(12, "Caixa é obrigatório!");
		mensagem.put(13, "Ano é obrigatório!");
		mensagem.put(14, "Mês é obrigatório!");
		mensagem.put(15, "Situação é obrigatória!");
		mensagem.put(16, "Número é obrigatório!");
		mensagem.put(17, "Tipo é obrigatório!");
		mensagem.put(18, "Série é obrigatória!");
		mensagem.put(19, "Nenhum dado encontrado!");

		mensagem.put(200, "Dados salvos com sucesso!");
		mensagem.put(201, "Operação realizada com sucesso!");

		mensagem.put(300, "Deseja mesmo remover este registro?");
	}

	public static synchronized Mensagens getInstance() {
		if (instancia == null) {
			instancia = new Mensagens();
		}

		return instancia;
	}

	public String getMensager(Integer chave) {
		return mensagem.get(chave);
	}
}
