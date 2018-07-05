package algo3.AlGoOh.handlers;

import javax.swing.JOptionPane;

import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.modelo.AlGoOh;
import algo3.AlGoOh.vista.MensajesDeAlerta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMagicaTrampaEnCampoEventHandler implements EventHandler<ActionEvent>{

	private int posicion;
	private MensajesDeAlerta mensajesDeAlerta = new MensajesDeAlerta();

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
		try {
			if (eleccion == 0) {
				AlGoOh.getInstance().darVueltaCartaMagica(posicion);
			}
		} catch (AccionInvalidaEnEstaFaseException e) {
			mensajesDeAlerta.alertaAccionInvalidaEnFase();
		}
    }
}
