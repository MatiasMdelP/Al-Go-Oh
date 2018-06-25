package algo3.AlGoOh.vista;

import algo3.AlGoOh.Monstruo;
import javafx.scene.control.Button;

public class BotonMonstruoEnMano extends Button {

	private Monstruo unMonstruo;
	
	public BotonMonstruoEnMano(int altoCarta, int anchoCarta) {
		this.setText("Monstruo");
		this.setMinHeight(altoCarta);
		this.setMaxHeight(anchoCarta);
		this.setPrefSize(anchoCarta, altoCarta);
		BotonMonstruoEnManoEventHandler botonMonstruoEnManoEventHandler = new BotonMonstruoEnManoEventHandler();
		this.setOnAction(botonMonstruoEnManoEventHandler);
		unMonstruo = null;
	}

}
