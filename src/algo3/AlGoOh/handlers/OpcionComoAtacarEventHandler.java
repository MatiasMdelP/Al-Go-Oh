package algo3.AlGoOh.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionComoAtacarEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
       
        Alert alert = new Alert(AlertType.INFORMATION,""
				+ "El primer paso es hacer clic sobre el monstruo con el que desea realizar el ataque, y selecccionar la opcion 'Atacar'.\n"
				+ "Luego, en el nuevo cuadro de dialogo, elegir el numero de monstruo de su oponente al que quiere atacar. \n"
				+ "(Las posiciones comienzan con el 0 y van de izquiera a derecha).\n"
				);
        alert.setTitle("Atacar...");
        alert.setHeaderText("Como realizar un ataque:");

        alert.showAndWait();
    }

}
