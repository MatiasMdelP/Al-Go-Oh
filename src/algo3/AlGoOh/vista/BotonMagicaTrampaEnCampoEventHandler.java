package algo3.AlGoOh.vista;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BotonMagicaTrampaEnCampoEventHandler implements EventHandler<ActionEvent>{

	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Dar vuelta", "Cancelar"};
		cuadro.showOptionDialog(null, "Que acci�n quiere realizar?", "Acci�n", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
    }
}
