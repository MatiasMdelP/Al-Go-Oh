package algo3.AlGoOh.handlers;

import javax.swing.JOptionPane;

import algo3.AlGoOh.Monstruo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMonstruoEnCampoEventHandler implements EventHandler<ActionEvent>{

	private Monstruo monstruo;
	private int posicion;
	
	public BotonMonstruoEnCampoEventHandler(Monstruo unMonstruo, int unaPosicion) {
		monstruo = unMonstruo;
		posicion = unaPosicion;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Atacar", "Poner en Ataque", "Poner en Defensa", "Dar vuelta", "Ofrecer como sacrificio", "Cancelar"};
		int seleccion = JOptionPane.showOptionDialog(null, "Que accion quiere realizar?", "Accion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (seleccion == 0) {
			opcionesParaAtacar();
		} else if (seleccion == 1) {
			monstruo.colocarEnPosicionAtaque();
		} else if (seleccion == 2){
			monstruo.colocarEnPosicionDefensa();
		} else if (seleccion == 3) {
			monstruo.darVuelta();
		}
    }

	private void opcionesParaAtacar() {
		String[] carreras = {"0", "1", "2", "3", "4"};
		int respuesta = (int) JOptionPane.showInputDialog(null, "Seleccione posicion del monstruo a atacar", "Atacar a:", JOptionPane.DEFAULT_OPTION, null, carreras, carreras[0]);
	}
}
