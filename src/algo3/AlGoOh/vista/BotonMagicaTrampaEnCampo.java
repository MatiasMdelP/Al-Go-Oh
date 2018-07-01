package algo3.AlGoOh.vista;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.handlers.BotonMagicaTrampaEnCampoEventHandler;
import algo3.AlGoOh.modelo.AlGoOh;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class BotonMagicaTrampaEnCampo extends Button {

	private Carta unaCarta = null;
	private AlGoOh juegoDeAlGoOh;


	public BotonMagicaTrampaEnCampo(int altoCarta, int anchoCarta, int posicion) {
		this.setText("Magica/ \n"
				+ "Trampa");
		this.setMinHeight(altoCarta);
		this.setMaxHeight(anchoCarta);
		this.setPrefSize(anchoCarta, altoCarta);
		BotonMagicaTrampaEnCampoEventHandler botonMagicaTrampaEnCampoEventHandler = new BotonMagicaTrampaEnCampoEventHandler(posicion);
		this.setOnAction(botonMagicaTrampaEnCampoEventHandler);
		
	}
	
	public void cargarImagen(String nombreDeLaCarta) {
		if (nombreDeLaCarta == "") {
			deshabilitarBoton();
			this.setText("Magica/ \n"
					+ "Trampa");
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

	public void cargarCartaEnBoton(Carta cartaADepositar) {
		unaCarta = cartaADepositar;
	}
	
	public void actualizarBoton() {
		if (unaCarta == null) {
			this.setDisable(true);
		} else {
			Image imagenMonstruo = new Image("file:src/algo3/AlGoOh/vista/cartas" + unaCarta.obtenerNombre() + ".png");
			BackgroundImage imagenDelMonstruo = new BackgroundImage(imagenMonstruo, BackgroundRepeat.REPEAT, 
				BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			this.setBackground(new Background(imagenDelMonstruo));
		}	    
	}
}