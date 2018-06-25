package algo3.AlGoOh.vista;

import algo3.AlGoOh.AlGoOh;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonFinalizarTurnoEventHandler implements EventHandler<ActionEvent>{

	private AlGoOh juego;
	
	public BotonFinalizarTurnoEventHandler(AlGoOh unJuego) {
		juego = unJuego;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		juego.finalizarTurno();
    }

}
