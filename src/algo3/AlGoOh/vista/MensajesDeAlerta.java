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
	
	public void alertaAccionDeMonstruoProhibidaEnTurno() {
		Audio.reproducirAlerta() ;
		Alert alert = new Alert(AlertType.ERROR,""
				+ "No puede realizar esta accion ya que invoco al Monstruo en el turno actual. \n"
				+ "Para poder hacerlo, debe esperar al siguiente turno. \n"
				);
        alert.setTitle("Accion prohibida en Monstruo...");
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
	
	public void alertaMonstruoNoPuedeAtacar() {
		Audio.reproducirAlerta() ;
		Alert alert = new Alert(AlertType.WARNING,""
				+ "Este monstruo no puede realizar un ataque. \n"
				+ "Esto se debe a que se encuentra en Posicion de Defensa, o porque ya realizo un ataque en este turno. \n"
				);
        alert.setTitle("Monstruo no puede atacar...");
        alert.showAndWait();
	}
	
}
