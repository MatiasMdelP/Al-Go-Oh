package algo3.AlGoOh.vista;

import algo3.AlGoOh.Carta;
import javafx.scene.control.Button;

public class BotonCartaEnMano extends Button{

	private Carta carta;
	
	public BotonCartaEnMano(Carta carta, int anchoCarta, int altoCarta) {
		super.setPrefSize(anchoCarta,altoCarta);
		BotonCartaEnManoEventHandler botonCartaEnManoEventHandler = new BotonCartaEnManoEventHandler();
		this.setOnAction(botonCartaEnManoEventHandler);
	
	}
}
