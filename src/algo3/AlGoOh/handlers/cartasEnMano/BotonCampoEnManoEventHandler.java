package algo3.AlGoOh.handlers.cartasEnMano;

import javax.swing.JOptionPane;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.MonstruosInsuficientesParaSacrificioException;
import algo3.AlGoOh.Exceptions.ZonaNoTieneMasEspacioException;
import algo3.AlGoOh.handlers.BotonCarta;
import algo3.AlGoOh.modelo.AlGoOh;
import algo3.AlGoOh.vista.MensajesDeAlerta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCampoEnManoEventHandler extends BotonCarta implements EventHandler<ActionEvent>{

	private Carta carta;
	private MensajesDeAlerta mensajesDeAlerta = new MensajesDeAlerta();
	
	public BotonCampoEnManoEventHandler(Carta cartaPasada) {
		carta = cartaPasada;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Agregar al campo", "Cancelar"};
		int eleccion = obtenerOpcionMenu(options,"Que accion quiere realizar?", "Accion");
		try {
			switch (eleccion) {
				case 0: AlGoOh.getInstance().agregarCartaCampo(carta);
						break;
			}
			
		} catch (ZonaNoTieneMasEspacioException e) {
			mensajesDeAlerta.alertaNoHayMasEspacioEnLaZona();
		} catch (AccionInvalidaEnEstaFaseException e) {
			mensajesDeAlerta.alertaAccionInvalidaEnFase();
		} catch (MonstruosInsuficientesParaSacrificioException e) {
			mensajesDeAlerta.alertaSacrificiosInsuficientes();
		}
	}
}