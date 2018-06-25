package algo3.AlGoOh.vista;

import java.util.List;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

public class Mano extends TilePane{

	private Jugador jugador;
	private int anchoCarta;
	private int altoCarta;
	
	
	public Mano(Jugador jugadorIngresado, int anchoCartaIngresado, int altoCartaIngresado) {
		jugador = jugadorIngresado;
		anchoCarta = anchoCartaIngresado;
		altoCarta = altoCartaIngresado;
		
		Insets espacioEntreCartas = new Insets(10,10,10,10);
		
		List<Carta> cartasEnMano = jugador.getListaDeCartasEnMano();
		
		for( Carta carta : cartasEnMano ) {
			
			Button botonCarta = this.crearBotonCarta(carta);
			super.getChildren().add(botonCarta);
			super.setMargin(botonCarta, espacioEntreCartas);
		
		}	
		
	}


	private Button crearBotonCarta(Carta carta) {
		Button botonNuevo = new BotonCartaEnMano(carta, anchoCarta, altoCarta);
		return botonNuevo;
	}
	
}
