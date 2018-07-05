package algo3.AlGoOh.vista;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MensajesDeAlerta {

	public void alertaSacrificiosInsuficientes() {
		Alert alert = new Alert(AlertType.WARNING,""
				+ "Antes de invocar al monstruo debe hacer los sacrificios necesarios. \n"
				);
        alert.setTitle("Sacrificion insuficientes...");

        alert.showAndWait();
	}
	
	public void alertaNoHayMasEspacioEnLaZona() {
		Alert alert = new Alert(AlertType.WARNING,""
				+ "No se puede invocar mas invocar esta carta porque no \n"
				+ "hay mas espacio en el campo. \n"
				);
        alert.setTitle("Zona sin lugar...");

        alert.showAndWait();
	}
	
	public void alertaAccionInvalidaEnFase() {
		Alert alert = new Alert(AlertType.WARNING,""
				+ "Accion invalida para esta fase del juego. \n"
				);
        alert.setTitle("Accion en fase invalida...");

        alert.showAndWait();
	}
	
}
