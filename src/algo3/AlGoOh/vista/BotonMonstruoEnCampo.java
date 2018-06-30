package algo3.AlGoOh.vista;

import algo3.AlGoOh.InvocacionNormal;
import algo3.AlGoOh.Monstruo;
import algo3.AlGoOh.Efectos.EfectoVacio;
import algo3.AlGoOh.handlers.BotonMonstruoEnCampoEventHandler;
import algo3.AlGoOh.modelo.AlGoOh;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class BotonMonstruoEnCampo extends Button {

	public BotonMonstruoEnCampo(int altoCarta, int anchoCarta, int posicion) {
		this.setText("Monstruo");
		this.setMinHeight(altoCarta);
		this.setMaxHeight(anchoCarta);
		this.setPrefSize(anchoCarta, altoCarta);
		BotonMonstruoEnCampoEventHandler botonMonstruoEnCampoEventHandler = new BotonMonstruoEnCampoEventHandler(posicion);
		this.setOnAction(botonMonstruoEnCampoEventHandler);
		//this.setStyle("-fx-base: #A52A2A");
	}
	
	public void cargarImagen(String nombreDeLaCarta) {
		if (nombreDeLaCarta == "") {
			deshabilitarBoton();
			this.setText("Monstruo");
			return;
		}
		this.setDisable(false);
		this.setText("");
		Image imagenMonstruo = new Image("file:src/algo3/AlGoOh/vista/cartas/" + nombreDeLaCarta + ".png");
	    BackgroundImage imagenDelMonstruo = new BackgroundImage(imagenMonstruo, BackgroundRepeat.REPEAT, 
	    		BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	            
	    this.setBackground(new Background(imagenDelMonstruo));
	}
	
	public void deshabilitarBoton() {
		this.setDisable(true);
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
