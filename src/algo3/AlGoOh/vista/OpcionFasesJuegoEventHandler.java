package algo3.AlGoOh.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionFasesJuegoEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
       
        Alert alert = new Alert(AlertType.CONFIRMATION,""
				+ "Fase inicial : Se debe tomar una carta del mazo.\n"
				+ "Fase de preparacion: En esta fase, es el momento de poner cartas en el campo.\n"
				+ "Se pueden colocar tantas cartas de magia y trampa como se quiera, pero solo una invocacion de monstruo.\n"
				+ "Fase de ataque: Se pueden realizar tantos ataques como quiera, pero cada monstruo puede atacar una vez.\n"
				+ "Fase de trampas: Esta fase se activan una carta Trampa (de izquierda a derecha) luego de cada ataque. \n"
				+ "En una fase de ataque hay tantas fase de trampas como cantidad de ataques efectuados).\n"
				+ "Fase final: Se pueden activar las cartas de magia.\n"
				);
        alert.setTitle("Sobre las Fases del Juego...");
        alert.setHeaderText("Fases de Juego:");

        alert.showAndWait();
    }
}

/*(no se puede cambiar la posici�n del monstruo ni voltearla el mismo turno que es colocada en el campo).*/
