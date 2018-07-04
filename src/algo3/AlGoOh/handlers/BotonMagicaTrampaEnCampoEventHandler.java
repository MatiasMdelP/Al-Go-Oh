package algo3.AlGoOh.handlers;

import javax.swing.JOptionPane;

import algo3.AlGoOh.modelo.AlGoOh;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMagicaTrampaEnCampoEventHandler implements EventHandler<ActionEvent>{

	private int posicion;

	public BotonMagicaTrampaEnCampoEventHandler(int unaPosicion) {
		posicion = unaPosicion;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Dar vuelta", "Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(null, "Que accion quiere realizar?", "Accion", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if (eleccion == 0) {
			AlGoOh.getInstance().darVueltaCartaMagica(posicion);
		}
    }
}
