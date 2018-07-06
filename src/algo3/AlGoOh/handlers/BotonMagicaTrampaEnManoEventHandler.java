package algo3.AlGoOh.handlers;

import javax.swing.JOptionPane;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.ZonaNoTieneMasEspacioException;
import algo3.AlGoOh.modelo.AlGoOh;
import algo3.AlGoOh.modelo.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMagicaTrampaEnManoEventHandler extends BotonCarta implements EventHandler<ActionEvent>{

	private Carta carta;
	private Tablero tablero;
	
	public BotonMagicaTrampaEnManoEventHandler(Carta cartaPasada, Tablero tableroPasado) {
		carta = cartaPasada;
		tablero = tableroPasado;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Agregar al campo", "Cancelar"};
		int eleccion = obtenerOpcionMenu(options,"Que accion quiere realizar?", "Accion");
		
		if (eleccion == 0) {
			try {
				AlGoOh.getInstance().jugadorActual.agregarCartaMagicaBocaArriba(carta);
			} catch (ZonaNoTieneMasEspacioException | AccionInvalidaEnEstaFaseException e) {
				e.printStackTrace();
			}
			tablero.actualizarTablero(AlGoOh.getInstance().jugadorActual);
		}
    }
}
