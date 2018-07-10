package algo3.AlGoOh.vista;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.handlers.BotonCarta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class BotonCartaEnMano extends Button{

	private Carta carta;
	
	@SuppressWarnings("unchecked")
	public BotonCartaEnMano(int anchoCarta, int altoCarta, Carta unaCarta) {
		super.setPrefSize(anchoCarta,altoCarta);
		BotonCarta handler = unaCarta.getHandler();
		this.setOnAction((EventHandler<ActionEvent>) handler);
		carta = unaCarta;
	}
	
	public void cargarImagen() {
		Image imagenCarta = new Image("file:src/algo3/AlGoOh/vista/cartas/" + carta.obtenerNombre() + ".png");
		BackgroundImage imagenDeLaCarta = new BackgroundImage(imagenCarta, BackgroundRepeat.REPEAT, 
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagenDeLaCarta));
	}
	
}
