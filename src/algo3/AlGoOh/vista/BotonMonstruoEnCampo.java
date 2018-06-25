package algo3.AlGoOh.vista;

import algo3.AlGoOh.EfectoVacio;
import algo3.AlGoOh.InvocacionNormal;
import algo3.AlGoOh.Monstruo;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;

public class BotonMonstruoEnCampo extends Button {

	private Monstruo unMonstruo;
	
	public BotonMonstruoEnCampo(int altoCarta, int anchoCarta) {
		this.setText("Monstruo");
		this.setMinHeight(altoCarta);
		this.setMaxHeight(anchoCarta);
		this.setPrefSize(anchoCarta, altoCarta);
		BotonMonstruoEnCampoEventHandler botonMonstruoEnCampoEventHandler = new BotonMonstruoEnCampoEventHandler(unMonstruo);
		this.setOnAction(botonMonstruoEnCampoEventHandler);
		unMonstruo = null;
	}
	
	public void cargarMonstruo(Monstruo monstruoEnCampo) {
		unMonstruo = monstruoEnCampo;
	}
	
	
}

