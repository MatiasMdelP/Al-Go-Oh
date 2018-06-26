package algo3.AlGoOh.vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class BotonMagicaTrampaEnMano extends Button {

	public BotonMagicaTrampaEnMano(int altoCarta, int anchoCarta) {
		this.setText("Magica y Trampa");
		this.setMinHeight(altoCarta);
		this.setMaxHeight(anchoCarta);
		this.setPrefSize(anchoCarta, altoCarta);
		BotonMagicaTrampaEnManoEventHandler botonMagicaTrampaEnManoEventHandleroEventHandler = new BotonMagicaTrampaEnManoEventHandler();
		this.setOnAction(botonMagicaTrampaEnManoEventHandleroEventHandler);
		
	}

}
