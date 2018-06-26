package algo3.AlGoOh.vista;

import algo3.AlGoOh.AlGoOh;
import javafx.scene.control.Button;

public class BotonFinalizarTurno extends Button {

	public BotonFinalizarTurno(AlGoOh alGoOh) {
		this.setText("Finalizar turno");
		this.setStyle("-fx-base: #00005F; -fx-text-fill: #FFFFFF;");
		BotonFinalizarTurnoEventHandler botonFinalizarTurnoEventHandler = new BotonFinalizarTurnoEventHandler(alGoOh);
		this.setOnAction(botonFinalizarTurnoEventHandler);
	}
}
