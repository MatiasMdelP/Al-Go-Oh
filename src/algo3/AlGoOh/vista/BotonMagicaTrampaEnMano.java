package algo3.AlGoOh.vista;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.handlers.BotonMagicaTrampaEnManoEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class BotonMagicaTrampaEnMano extends Button {
	
	private Carta carta;
	
	public BotonMagicaTrampaEnMano(int altoCarta, int anchoCarta, Carta cartaPasada) {
		carta = cartaPasada;

		this.setText(carta.obtenerNombre());
		this.setMinHeight(altoCarta);
		this.setMaxHeight(anchoCarta);
		this.setPrefSize(anchoCarta, altoCarta);
		BotonMagicaTrampaEnManoEventHandler botonMagicaTrampaEnManoEventHandleroEventHandler = new BotonMagicaTrampaEnManoEventHandler(cartaPasada);
		this.setOnAction(botonMagicaTrampaEnManoEventHandleroEventHandler);
		
	}

	public void cargarImagen() {
		if (carta == null) {
			this.setDisable(true);
			return;
		}
		Image imagenCarta = new Image("file:src/algo3/AlGoOh/vista/cartas/" + carta.obtenerNombre() + ".png");
		BackgroundImage imagenDeLaCarta = new BackgroundImage(imagenCarta, BackgroundRepeat.REPEAT, 
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagenDeLaCarta));
	}
		
}
