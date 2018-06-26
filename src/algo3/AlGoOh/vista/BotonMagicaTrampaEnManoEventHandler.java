package algo3.AlGoOh.vista;

import javax.swing.JOptionPane;

import algo3.AlGoOh.Carta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMagicaTrampaEnManoEventHandler implements EventHandler<ActionEvent>{

	private Carta carta;
	
	public BotonMagicaTrampaEnManoEventHandler(Carta cartaPasada) {
		carta = cartaPasada;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Agregar al campo", "Cancelar"};
		int eleccion =JOptionPane.showOptionDialog(null, "Que acci�n quiere realizar?", "Acci�n", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if (eleccion == 0) {
			
		}
    }
}
