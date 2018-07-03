package algo3.AlGoOh.handlers;

import javax.swing.JOptionPane;

import algo3.AlGoOh.Monstruo;
import algo3.AlGoOh.modelo.AlGoOh;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMonstruoEnCampoEventHandler implements EventHandler<ActionEvent>{

	private int posicion;
	
	public BotonMonstruoEnCampoEventHandler(int unaPosicion) {
		posicion = unaPosicion;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Atacar", "Poner en Ataque", "Poner en Defensa", "Dar vuelta", "Ofrecer como sacrificio", "Cancelar"};
		int seleccion = JOptionPane.showOptionDialog(null, "Que accion quiere realizar?", "Accion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		switch (seleccion) {
			case 0: opcionesParaAtacar();
					break;
			case 1: AlGoOh.getInstance().ponerEnPosicionAtaque(posicion);
					break;
			case 2: AlGoOh.getInstance().ponerEnPosicionDefensa(posicion);
					break;
			case 3: AlGoOh.getInstance().darVueltaMonstruo(posicion);
					break;
			case 4: AlGoOh.getInstance().agregarMonstruoASacrificar(posicion);
			default:
				break;
		}
		
    }

	private void opcionesParaAtacar() {
		String[] carreras = {"0", "1", "2", "3", "4"};
		String respuesta = (String) JOptionPane.showInputDialog(null, "Seleccione posicion del monstruo a atacar", "Atacar a:", JOptionPane.DEFAULT_OPTION, null, carreras, carreras[0]);
		//AlGoOh.getInstance().atacar(posicion, respuesta);
		switch (respuesta) {
			case "0": 	AlGoOh.getInstance().atacar(posicion, 0);
						break;
			case "1": 	AlGoOh.getInstance().atacar(posicion, 1);
						break;
			case "2": 	AlGoOh.getInstance().atacar(posicion, 2);
						break;
			case "3": 	AlGoOh.getInstance().atacar(posicion, 3);
						break;
			case "4": 	AlGoOh.getInstance().atacar(posicion, 4);
						break;
		default:
			break;
		}
	}
}
