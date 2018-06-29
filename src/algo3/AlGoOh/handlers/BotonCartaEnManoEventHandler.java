package algo3.AlGoOh.handlers;

import javax.swing.JOptionPane;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.MonstruosInsuficientesParaSacrificioException;
import algo3.AlGoOh.Exceptions.ZonaNoTieneMasEspacioException;
import algo3.AlGoOh.modelo.AlGoOh;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCartaEnManoEventHandler implements EventHandler<ActionEvent>{
	
	private Carta carta;
	
	public BotonCartaEnManoEventHandler(Carta cartaPasada) {
		carta = cartaPasada;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Agregar al campo", "Cancelar"};
		int eleccion =JOptionPane.showOptionDialog(null, "Que accion quiere realizar?", "Accion", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if (eleccion == 0) {
			try {
				AlGoOh.getInstance().agregarCartaAlCampo(carta);
			} catch (MonstruosInsuficientesParaSacrificioException | ZonaNoTieneMasEspacioException
					| AccionInvalidaEnEstaFaseException e) {
				
			}
		}
    }
}
