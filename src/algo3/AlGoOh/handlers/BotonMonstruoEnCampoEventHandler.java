package algo3.AlGoOh.handlers;

import javax.swing.JOptionPane;
import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.MonstruoInvocadoEnTurnoActualException;
import algo3.AlGoOh.Exceptions.MonstruoNoPuedeAtacarException;
import algo3.AlGoOh.modelo.AlGoOh;
import algo3.AlGoOh.vista.BotonMonstruoEnCampo;
import algo3.AlGoOh.vista.MensajesDeAlerta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMonstruoEnCampoEventHandler extends BotonCarta implements EventHandler<ActionEvent>{

	private int posicion;
	private BotonMonstruoEnCampo botonMonstruoEnCampo;
	private MensajesDeAlerta mensajesDeAlerta = new MensajesDeAlerta();
	
	public BotonMonstruoEnCampoEventHandler(int unaPosicion, BotonMonstruoEnCampo unBoton) {
		posicion = unaPosicion;
		botonMonstruoEnCampo = unBoton;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Atacar", "Poner en Ataque", "Poner en Defensa", "Dar vuelta", "Ofrecer como sacrificio", "Cancelar"};
		int eleccion = obtenerOpcionMenu(options,"Que accion quiere realizar?", "Accion");
		try {
			switch (eleccion) {
				case 0: opcionesParaAtacar();
						break;
				case 1: AlGoOh.getInstance().ponerEnPosicionAtaque(posicion);
						//botonMonstruoEnCampo.setRotate(0);
						break;
				case 2: AlGoOh.getInstance().ponerEnPosicionDefensa(posicion);
						//botonMonstruoEnCampo.setRotate(90);
						break;
				case 3: AlGoOh.getInstance().darVueltaMonstruo(posicion);
						break;
				case 4: AlGoOh.getInstance().agregarMonstruoASacrificar(posicion);
						break;
			default:
				break;
			}
		} catch (AccionInvalidaEnEstaFaseException e) {
			mensajesDeAlerta.alertaAccionInvalidaEnFase();
		} catch (MonstruoInvocadoEnTurnoActualException e) {
			mensajesDeAlerta.alertaAccionDeMonstruoProhibidaEnTurno();
		} catch (MonstruoNoPuedeAtacarException e) {
			mensajesDeAlerta.alertaMonstruoNoPuedeAtacar();
		}
		
    }

	private void opcionesParaAtacar() {
		String[] options = {"0", "1", "2", "3", "4"};
		int eleccion = obtenerOpcionMenu(options,"Seleccione posicion del monstruo a atacar", "Atacar a:");
		
		switch (eleccion) {
			case 0: 	AlGoOh.getInstance().atacar(posicion, 0);
						break;
			case 1: 	AlGoOh.getInstance().atacar(posicion, 1);
						break;
			case 2: 	AlGoOh.getInstance().atacar(posicion, 2);
						break;
			case 3: 	AlGoOh.getInstance().atacar(posicion, 3);
						break;
			case 4: 	AlGoOh.getInstance().atacar(posicion, 4);
						break;
		default:
			break;
		}
	}
}
