package algo3.AlGoOh.handlers;

import javax.swing.JOptionPane;

import algo3.AlGoOh.Monstruo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMonstruoEnManoEventHandler implements EventHandler<ActionEvent>{

	private Monstruo monstruo;
	
	public BotonMonstruoEnManoEventHandler(Monstruo unMonstruo) {
		monstruo = unMonstruo;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Invocar en Ataque", "Invocar en Defensa", "Cancelar"};
		int seleccion = JOptionPane.showOptionDialog(null, "Que accion quiere realizar?", "Accion", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if (seleccion == 0) {
			monstruo.colocarEnPosicionAtaque();
		} else if (seleccion == 1) {
			monstruo.colocarEnPosicionDefensa();
		} 
		formaDeColocarLaCarta();
    }
	
	public void formaDeColocarLaCarta() {
		String[] options = {"Boca Abajo", "Boca Arriba"};
		int eleccion = JOptionPane.showOptionDialog(null, "En que posicion quiere colocar la carta?", "Accion", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if (eleccion == 0) {
			monstruo.darVuelta();
		}
	}
}
