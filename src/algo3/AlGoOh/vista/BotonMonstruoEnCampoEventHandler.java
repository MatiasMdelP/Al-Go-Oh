package algo3.AlGoOh.vista;

import javax.swing.JOptionPane;

import algo3.AlGoOh.Monstruo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMonstruoEnCampoEventHandler implements EventHandler<ActionEvent>{

	private Monstruo monstruo;
	
	public BotonMonstruoEnCampoEventHandler(Monstruo unMonstruo) {
		monstruo = unMonstruo;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Atacar", "Poner en Ataque", "Poner en Defensa", "Dar vuelta", "Ofrecer como sacrificio", "Cancelar"};
		int seleccion = JOptionPane.showOptionDialog(null, "Que acción quiere realizar?", "Acción", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (seleccion == 0) {
			
		} else if (seleccion == 1) {
			monstruo.colocarEnPosicionAtaque();
		} else if (seleccion == 2){
			monstruo.colocarEnPosicionDefensa();
		} else if (seleccion == 3) {
			monstruo.darVuelta();
		}
    }

}
