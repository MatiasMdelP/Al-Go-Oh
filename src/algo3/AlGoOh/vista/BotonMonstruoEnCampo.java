package algo3.AlGoOh.vista;

import algo3.AlGoOh.EfectoVacio;
import algo3.AlGoOh.InvocacionNormal;
import algo3.AlGoOh.Monstruo;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class BotonMonstruoEnCampo extends Button {

	private Monstruo unMonstruo;
	
	public BotonMonstruoEnCampo(int altoCarta, int anchoCarta) {
		this.setText("Monstruo");
		this.setMinHeight(altoCarta);
		this.setMaxHeight(anchoCarta);
		this.setPrefSize(anchoCarta, altoCarta);
		BotonMonstruoEnCampoEventHandler botonMonstruoEnCampoEventHandler = new BotonMonstruoEnCampoEventHandler(unMonstruo);
		this.setOnAction(botonMonstruoEnCampoEventHandler);
		this.setStyle("-fx-base: #A52A2A");
		unMonstruo = null;	
	}
	
	public void cargarMonstruo(Monstruo monstruoEnCampo) {
		unMonstruo = monstruoEnCampo;
	}
}

/*if (unMonstruo == null) {
	this.setDisable(true);
} else {
	Image imagenMonstruo = new Image("file:src/algo3/AlGoOh/vista/" + unMonstruo.obtenerNombre() + ".png");
    BackgroundImage imagenDelMonstruo = new BackgroundImage(imagenMonstruo, BackgroundRepeat.REPEAT, 
    		BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            
	this.setBackground(new Background(imagenDelMonstruo));
}*/
