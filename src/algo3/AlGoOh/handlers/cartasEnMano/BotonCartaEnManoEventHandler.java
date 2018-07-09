package algo3.AlGoOh.handlers.cartasEnMano;

import javax.swing.JOptionPane;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Monstruo;
import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.MonstruosInsuficientesParaSacrificioException;
import algo3.AlGoOh.Exceptions.ZonaNoTieneMasEspacioException;
import algo3.AlGoOh.handlers.BotonCarta;
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
				case 0: agregarMonstruoAlCampo();
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
	
	private void agregarMonstruoAlCampo() {
		/*String[] options = {"Posicion Ataque", "Posicion Defensa"};
		int eleccion = obtenerOpcionMenu(options,"En que posicion desea colocar el Monstruo?", "Accion");
		
		switch (eleccion) {
			case 0: AlGoOh.getInstance().agregarMonstruoEnAtaque(carta);
					break;
			case 1: AlGoOh.getInstance().agregarMonstruoEnDefensa(carta);
					break;
		}*/
		Monstruo cartaMonstruo = (Monstruo) carta;
		int respuestaBoca = preguntarColocacionDeCarta();
		if (respuestaBoca == 1) {
			cartaMonstruo.invocarBocaAbajo();
		}
		AlGoOh.getInstance().agregarMonstruoEnAtaque(cartaMonstruo);
	}
	
	private void agregarMagicaBocaArribaOBocaAbajo() {
		int eleccion = preguntarColocacionDeCarta();
		switch (eleccion) {
			case 0: AlGoOh.getInstance().agregarCartaMagicaBocaArriba(carta);
					break;
			case 1: AlGoOh.getInstance().agregarCartaMagicaBocaAbajo(carta);
					break;
		}
	}
}
