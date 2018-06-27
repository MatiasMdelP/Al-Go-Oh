package algo3.AlgoOh.handlers;

import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMagicaTrampaEnCampoEventHandler implements EventHandler<ActionEvent>{

	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Dar vuelta", "Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(null, "Que accion quiere realizar?", "Accion", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if (eleccion == 0) {
			
		}
    }
}
