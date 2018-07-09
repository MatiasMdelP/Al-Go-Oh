package algo3.AlGoOh.handlers.cartasEnCampo;

import javax.swing.JOptionPane;

import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.handlers.BotonCarta;
import algo3.AlGoOh.modelo.AlGoOh;
import algo3.AlGoOh.vista.MensajesDeAlerta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMagicaTrampaEnCampoEventHandler extends BotonCarta implements EventHandler<ActionEvent>{

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
		int eleccion = obtenerOpcionMenu(options,"Que accion quiere realizar?", "Accion");
		try {
			if (eleccion == 0) {
				AlGoOh.getInstance().darVueltaCartaMagica(posicion);
			}
		} catch (AccionInvalidaEnEstaFaseException e) {
			mensajesDeAlerta.alertaAccionInvalidaEnFase();
		}
    }
}
