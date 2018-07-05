package algo3.AlGoOh.handlers;

import algo3.AlGoOh.modelo.AlGoOh;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCambiarFaseEventHandler implements EventHandler<ActionEvent>{

	private AlGoOh juego;
	
	public BotonCambiarFaseEventHandler(AlGoOh unJuego) {
		juego = unJuego;
	}
	
    public void handle(ActionEvent actionEvent) {
		juego.pasarALaSiguienteFase();
    }

}
