package algo3.AlGoOh.handlers;

import javax.swing.JOptionPane;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.MonstruosInsuficientesParaSacrificioException;
import algo3.AlGoOh.Exceptions.ZonaNoTieneMasEspacioException;
import algo3.AlGoOh.modelo.AlGoOh;
import algo3.AlGoOh.vista.MensajesDeAlerta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCartaEnManoEventHandler extends BotonCarta implements EventHandler<ActionEvent>{
	
	private Carta carta;
	private MensajesDeAlerta mensajesDeAlerta = new MensajesDeAlerta();
	
	public BotonCartaEnManoEventHandler(Carta cartaPasada) {
		carta = cartaPasada;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Agregar Monstruo al campo", "Agregar Magica al campo", "Agregar Trampa al campo", "Agregar carta de Campo", "Cancelar"};
		int eleccion = obtenerOpcionMenu(options,"Que accion quiere realizar?", "Accion");
		
		try {
			switch (eleccion) {
				case 0: AlGoOh.getInstance().agregarMonstruoAlCampo(carta);
						break;
				case 1: agregarMagicaBocaArribaOBocaAbajo();
						break;
				case 2: AlGoOh.getInstance().agregarCartaTrampa(carta);
						break;
				case 3: AlGoOh.getInstance().agregarCartaCampo(carta);
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
	
	private void agregarMagicaBocaArribaOBocaAbajo() {
		String[] options = {"Boca Arriba", "Boca Abajo"};
		int eleccion = obtenerOpcionMenu(options,"Como desea colocar la carta Magica?", "Accion");
		switch (eleccion) {
			case 0: AlGoOh.getInstance().agregarCartaMagicaBocaArriba(carta);
					break;
			case 1: AlGoOh.getInstance().agregarCartaMagicaBocaAbajo(carta);
					break;
		}
	}
}
