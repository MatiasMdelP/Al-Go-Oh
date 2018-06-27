package algo3.AlgoOh.modelo;

import java.util.List;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Monstruo;
import algo3.AlGoOh.vista.BotonMagicaTrampaEnMano;
import algo3.AlGoOh.vista.BotonMonstruoEnMano;
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


	public Button crearBotonCarta(Carta carta) {
		
		//Estara bien hacer esto? Porque creo que no hay otra forma... A menos que creemos metodos para preguntarles que son...
		if( carta.getClass() == Monstruo.class) {
			return new BotonMonstruoEnMano(altoCarta, anchoCarta, carta);
		}
		return new BotonMagicaTrampaEnMano(altoCarta, anchoCarta, carta);
	}
	
}
