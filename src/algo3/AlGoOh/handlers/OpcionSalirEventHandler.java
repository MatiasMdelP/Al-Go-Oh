package algo3.AlGoOh.handlers;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OpcionSalirEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
    	int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?", "Alerta!", JOptionPane.YES_NO_OPTION);
    	if (respuesta == 0) {
    		System.exit(0);
    	}
    }
}
