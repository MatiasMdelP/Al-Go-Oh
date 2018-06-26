package algo3.AlGoOh.vista;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Monstruo;
import javafx.scene.control.Button;

public class BotonMonstruoEnMano extends Button {

	private Monstruo unMonstruo;
	
	public BotonMonstruoEnMano(int altoCarta, int anchoCarta,Carta carta) {
		this.setText(unMonstruo.obtenerNombre());
		this.setMinHeight(altoCarta);
		this.setMaxHeight(anchoCarta);
		this.setPrefSize(anchoCarta, altoCarta);
		unMonstruo = (Monstruo) carta;//Este cast... Hace ruido...
		BotonMonstruoEnManoEventHandler botonMonstruoEnManoEventHandler = new BotonMonstruoEnManoEventHandler(unMonstruo);
		this.setOnAction(botonMonstruoEnManoEventHandler);
	}

}
