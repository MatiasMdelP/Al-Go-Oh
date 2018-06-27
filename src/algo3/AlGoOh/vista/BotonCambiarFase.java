package algo3.AlGoOh.vista;

import algo3.AlGoOh.handlers.BotonCambiarFaseEventHandler;
import algo3.AlGoOh.modelo.AlGoOh;
import javafx.scene.control.Button;

public class BotonCambiarFase extends Button {

	public BotonCambiarFase(AlGoOh alGoOh) {
		this.setText("Pasar a la siguiente fase");
		this.setStyle("-fx-base: #00005F; -fx-text-fill: #FFFFFF;");
		BotonCambiarFaseEventHandler botonCambiarFaseEventHandler = new BotonCambiarFaseEventHandler(alGoOh);
		this.setOnAction(botonCambiarFaseEventHandler);
	}
}
