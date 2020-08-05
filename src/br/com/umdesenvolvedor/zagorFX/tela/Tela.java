package br.com.umdesenvolvedor.zagorFX.tela;

import br.com.umdesenvolvedor.zagorFX.interfaces.ITela;

@SuppressWarnings("unchecked")
public class Tela implements ITela {
	private Object tela;
	private Object valor;

	public Tela(Object tela, Object valor) {
		this.tela = tela;
		this.valor = valor;
	}

	public Tela(Object tela) {
		this.tela = tela;
		this.valor = null;
	}

	@Override
	public <T> T tela() {
		return (T) tela;
	}

	@Override
	public <T> T valor() {
		return (T) valor;
	}

	public Object getTela() {
		return tela;
	}

	public Object getValor() {
		return valor;
	}
}
