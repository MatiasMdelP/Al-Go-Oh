package algo3.AlGoOh.handlers;

import javax.swing.JOptionPane;

import algo3.AlGoOh.Monstruo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMonstruoEnManoEventHandler extends BotonCarta implements EventHandler<ActionEvent> {

	private Monstruo monstruo;
	
	public BotonMonstruoEnManoEventHandler(Monstruo unMonstruo) {
		monstruo = unMonstruo;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Invocar en Ataque", "Invocar en Defensa", "Cancelar"};
		int eleccion = obtenerOpcionMenu(options,"Que accion quiere realizar?", "Accion");
		
		if (eleccion == 0) {
			monstruo.colocarEnPosicionAtaque();
		} else if (eleccion == 1) {
			monstruo.colocarEnPosicionDefensa();
		} 
		formaDeColocarLaCarta();
    }
	
	public void formaDeColocarLaCarta() {
		String[] options = {"Boca Abajo", "Boca Arriba"};
		int eleccion = obtenerOpcionMenu(options,"En que posicion quiere colocar la carta?", "Accion");
		if (eleccion == 0) {
			monstruo.darVuelta();
		}
	}
}
