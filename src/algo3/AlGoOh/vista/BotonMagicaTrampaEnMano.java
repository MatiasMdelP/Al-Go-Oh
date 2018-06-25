package algo3.AlGoOh.vista;

import javafx.scene.control.Button;

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
