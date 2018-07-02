package algo3.AlGoOh.vista;

import java.util.List;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.modelo.AlGoOh;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

public class Mano extends ScrollPane{

	private int anchoCarta;
	private int altoCarta;
	
	
	Mano(int anchoCartaIngresado, int altoCartaIngresado){
		anchoCarta = anchoCartaIngresado;
		altoCarta = altoCartaIngresado;
	}

	public void actualizarMano() {
		
		HBox contenedorHorizontal = new HBox();
		
		List<Carta> cartasEnMano = AlGoOh.getInstance().jugadorActual.getListaDeCartasEnMano();
		
    	for (Carta unaCarta : cartasEnMano) {
    		BotonCartaEnMano cartaEnMano = new BotonCartaEnMano(anchoCarta, altoCarta, unaCarta);
    		cartaEnMano.cargarImagen();
    		contenedorHorizontal.getChildren().add(cartaEnMano);
    	}
		
		super.setContent(contenedorHorizontal);
		super.setPrefSize(anchoCarta*2.5, altoCarta);
	
	}
	
}
