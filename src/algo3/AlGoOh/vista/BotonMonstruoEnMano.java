package algo3.AlGoOh.vista;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Monstruo;
import algo3.AlGoOh.handlers.BotonMonstruoEnManoEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

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

	public BotonMonstruoEnMano(int altoCarta, int anchoCarta, Monstruo carta) {
		//this.setText(unMonstruo.obtenerNombre());
		this.setMinHeight(altoCarta);
		this.setMaxHeight(anchoCarta);
		this.setPrefSize(anchoCarta, altoCarta);
		unMonstruo = carta;//Este cast... Hace ruido...
		BotonMonstruoEnManoEventHandler botonMonstruoEnManoEventHandler = new BotonMonstruoEnManoEventHandler(unMonstruo);
		this.setOnAction(botonMonstruoEnManoEventHandler);
	}
	
	public void cargarImagen() {
		if (unMonstruo == null) {
			this.setDisable(true);
			return;
		}
		Image imagenCarta = new Image("file:src/algo3/AlGoOh/vista/cartas/" + unMonstruo.obtenerNombre() + ".png");
		BackgroundImage imagenDeLaCarta = new BackgroundImage(imagenCarta, BackgroundRepeat.REPEAT, 
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagenDeLaCarta));

	}

}
