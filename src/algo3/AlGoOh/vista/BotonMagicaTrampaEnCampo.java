package algo3.AlGoOh.vista;

import algo3.AlGoOh.Carta;
import algo3.AlgoOh.handlers.BotonMagicaTrampaEnCampoEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class BotonMagicaTrampaEnCampo extends Button {

	private Carta unaCarta;
	public BotonMagicaTrampaEnCampo(int altoCarta, int anchoCarta) {
		this.setText("Magica/ \n"
				+ "Trampa");
		this.setMinHeight(altoCarta);
		this.setMaxHeight(anchoCarta);
		this.setPrefSize(anchoCarta, altoCarta);
		BotonMagicaTrampaEnCampoEventHandler botonMagicaTrampaEnCampoEventHandler = new BotonMagicaTrampaEnCampoEventHandler();
		this.setOnAction(botonMagicaTrampaEnCampoEventHandler);
		this.setStyle("-fx-base: #25d19d");
	}
}
/*if (unaCarta == null) {
this.setDisable(true);
} else {
Image imagenMonstruo = new Image("file:src/algo3/AlGoOh/vista/" + unaCarta.obtenerNombre() + ".png");
BackgroundImage imagenDelMonstruo = new BackgroundImage(imagenMonstruo, BackgroundRepeat.REPEAT, 
	BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    
this.setBackground(new Background(imagenDelMonstruo));
}*/