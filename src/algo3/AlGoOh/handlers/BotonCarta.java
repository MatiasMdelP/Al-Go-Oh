package algo3.AlGoOh.handlers;

import javax.swing.JOptionPane;

import algo3.AlGoOh.audio.Audio;

public class BotonCarta {

	public static int obtenerOpcionMenu(String[] options,String mensaje,String titulo) {
		
		int seleccion = JOptionPane.showOptionDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		Audio.reproducirClick();
		return seleccion;
	}
	
	protected int preguntarColocacionDeCarta() {
		String[] options = {"Boca Arriba", "Boca Abajo"};
		return obtenerOpcionMenu(options,"Como desea colocar la carta?", "Accion");
	}
}
