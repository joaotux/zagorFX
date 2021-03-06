package br.com.umdesenvolvedor.zagorFX.utils;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerta {
	
	public static void alerta(String mensagem, AlertType alertType, Scene scene) {
		Alert alert = new Alert(alertType);
		alert.setContentText(mensagem);
		alert.initOwner(scene.getWindow());
		alert.show();

		if (alertType.equals(AlertType.ERROR) || alertType.equals(AlertType.WARNING)) {
			throw new RuntimeException(mensagem);
		}
	}
}
