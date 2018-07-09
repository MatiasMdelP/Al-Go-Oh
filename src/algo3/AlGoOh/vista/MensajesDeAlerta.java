package algo3.AlGoOh.vista;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MensajesDeAlerta {


	
	public void alertaSacrificiosInsuficientes() {
		imprimir("Antes de invocar al monstruo debe hacer los sacrificios necesarios. \n"
				,"Sacrificion insuficientes...");
	}
	
	public void alertaAccionDeMonstruoProhibidaEnTurno() {
		imprimir("No puede realizar esta accion ya que invoco al Monstruo en el turno actual. \n"
				+ "Para poder hacerlo, debe esperar al siguiente turno. \n","Accion prohibida en Monstruo...");
	} 
	
	public void alertaNoHayMasEspacioEnLaZona() {
		imprimir("No se puede invocar mas invocar esta carta porque no \n"
				+ "hay mas espacio en el campo. \n","Zona sin lugar...");
	}
	
	public void alertaAccionInvalidaEnFase() {
		imprimir("Accion invalida para esta fase del juego. \n","Accion en fase invalida...");
	}
	
	public void alertaMonstruoNoPuedeAtacar() {
		imprimir( "Este monstruo no puede realizar un ataque. \n"
				+ "Esto se debe a que se encuentra en Posicion de Defensa, o porque ya realizo un ataque en este turno. \n",
				"Monstruo no puede atacar...");
	}
	private void imprimir(String mensaje1, String mensaje2) {
		Audio.reproducirAlerta() ;
		Alert alert = new Alert(AlertType.WARNING,mensaje1);
        alert.setTitle(mensaje2);
        alert.showAndWait();
	}
}
