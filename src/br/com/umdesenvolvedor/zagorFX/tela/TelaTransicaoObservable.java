package br.com.umdesenvolvedor.zagorFX.tela;

import java.util.ArrayList;
import java.util.List;

import br.com.umdesenvolvedor.zagorFX.interfaces.ITelaObservable;
import javafx.fxml.FXMLLoader;

public class TelaTransicaoObservable {
	private static List<ITelaObservable> listner = new ArrayList<>();

	public static void addObservableTela(ITelaObservable observable) {

		for (int i = 0; i < listner.size(); i++) {
			if (listner.get(i).getClass().equals(observable.getClass())) {
				listner.remove(i);
			}
		}

		listner.add(observable);
	}

	public static void notificaTela(Object tela, FXMLLoader fxmlLoader) {
		for (ITelaObservable x : listner) {
			x.executa(tela, fxmlLoader);
		}
	}

}
