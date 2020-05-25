package br.com.umdesenvolvedor.zagorFX.tela;

import java.util.ArrayList;
import java.util.List;

import br.com.umdesenvolvedor.zagorFX.interfaces.ITela;
import br.com.umdesenvolvedor.zagorFX.interfaces.ITelaObservable;

public class TelaNavegacaoObservable {
	private static List<ITelaObservable> listner = new ArrayList<>();

	public static void addObservableDados(ITelaObservable dados) {

		for (int i = 0; i < listner.size(); i++) {
			if (listner.get(i).getClass() == dados.getClass()) {
				listner.remove(dados);
			}
		}

		listner.add(dados);

//		if (listner.contains(dados)) {
//			System.out.println("já tinha a tela");
//		} else {
//			System.out.println("não tinha a tela");
//			listner.add(dados);
//		}
	}

	public static void notificaTela(ITela tela) {
		for (ITelaObservable x : listner) {
			x.executa(tela);
		}
	}
}
