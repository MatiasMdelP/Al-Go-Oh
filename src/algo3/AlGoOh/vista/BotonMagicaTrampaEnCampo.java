package algo3.AlGoOh.vista;

import javafx.scene.control.Button;

public class BotonMagicaTrampaEnCampo extends Button {

	public BotonMagicaTrampaEnCampo(int altoCarta, int anchoCarta) {
		this.setText("Magica y Trampa");
		this.setMinHeight(altoCarta);
		this.setMaxHeight(anchoCarta);
		this.setPrefSize(anchoCarta, altoCarta);
		BotonMagicaTrampaEnCampoEventHandler botonMagicaTrampaEnCampoEventHandler = new BotonMagicaTrampaEnCampoEventHandler();
		this.setOnAction(botonMagicaTrampaEnCampoEventHandler);
	}
}
