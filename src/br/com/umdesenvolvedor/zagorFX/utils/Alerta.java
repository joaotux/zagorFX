package br.com.umdesenvolvedor.zagorFX.utils;

import java.util.logging.Logger;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;

public class Alerta {
	static Logger log = Logger.getLogger("LogInfromação");

	public static void alerta(String mensagem, AlertType alertType, Window window) {
		Alert alert = new Alert(alertType);
		alert.setContentText(mensagem);
		alert.initOwner(window);
		alert.show();

		if (alertType.equals(AlertType.ERROR) || alertType.equals(AlertType.WARNING)) {
			log.severe(mensagem);
		}
	}
}
