package algo3.AlGoOh.vista;

import java.io.File;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MensajesDeAlerta {


	
	public void alertaSacrificiosInsuficientes() {
		Audio.reproducirAlerta() ;
		Alert alert = new Alert(AlertType.WARNING,""
				+ "Antes de invocar al monstruo debe hacer los sacrificios necesarios. \n"
				);
        alert.setTitle("Sacrificion insuficientes...");
        alert.showAndWait();
	}
	
	public void alertaNoHayMasEspacioEnLaZona() {
		Audio.reproducirAlerta() ;
		Alert alert = new Alert(AlertType.WARNING,""
				+ "No se puede invocar mas invocar esta carta porque no \n"
				+ "hay mas espacio en el campo. \n"
				);
        alert.setTitle("Zona sin lugar...");
        alert.showAndWait();
	}
	
	public void alertaAccionInvalidaEnFase() {
		Audio.reproducirAlerta() ;
		Alert alert = new Alert(AlertType.WARNING,""
				+ "Accion invalida para esta fase del juego. \n"
				);
        alert.setTitle("Accion en fase invalida...");
        alert.showAndWait();
	}
	
}
