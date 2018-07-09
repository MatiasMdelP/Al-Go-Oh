package algo3.AlGoOh.modelo;

import java.util.ArrayList;
import java.util.List;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.vista.BotonCampo;
import algo3.AlGoOh.vista.BotonCartaDeCampo;
import algo3.AlGoOh.vista.BotonCartaEnMano;
import algo3.AlGoOh.vista.BotonMagicaTrampaEnCampo;
import algo3.AlGoOh.vista.BotonMonstruoEnCampo;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Tablero extends GridPane{

	private int anchoCarta;
	private int altoCarta;
	private Jugador jugadorSuperior;
	private Jugador jugadorInferior;
	Label tituloFase = new Label();
		
	private BotonCartaDeCampo campoJugadorSuperior;
	private BotonCartaDeCampo campoJugadorInferior;
	
	private List<BotonCampo> botonesMonstruosJugadorSuperior = new ArrayList<BotonCampo>();
	private List<BotonCampo> botonesCartasJugadorSuperior = new ArrayList<BotonCampo>();
	
	private List<BotonCampo> botonesMonstruosJugadorInferior = new ArrayList<BotonCampo>();
	private List<BotonCampo> botonesCartasJugadorInferior = new ArrayList<BotonCampo>();
	
	public Tablero(int anchoCartaIngresado, int altoCartaIngresado, Jugador jugador1, Jugador jugador2) {
		anchoCarta = anchoCartaIngresado;
		altoCarta = altoCartaIngresado;
		jugadorSuperior = jugador1;
		jugadorInferior = jugador2;
		construirTablero();
	}

	private void construirTablero() {
		Insets espacioEntrePosiciones = new Insets(10,10,10,10);
		
		StackPane mazoOponente = this.crearPosicionMazo();
		super.add(mazoOponente, 1, 1);
		super.setMargin(mazoOponente,espacioEntrePosiciones);
		
		campoJugadorSuperior = new BotonCartaDeCampo(altoCarta, anchoCarta);
		super.add(campoJugadorSuperior, 7, 2);
		super.setMargin(campoJugadorSuperior, espacioEntrePosiciones);
	
		campoJugadorInferior = new BotonCartaDeCampo(altoCarta, anchoCarta);
		super.add(campoJugadorInferior, 1, 3);
		super.setMargin(campoJugadorInferior, espacioEntrePosiciones);
		
		StackPane mazoJugador = this.crearPosicionMazo();
		super.add(mazoJugador, 7, 4);
		super.setMargin(campoJugadorInferior, espacioEntrePosiciones);
		
		for(int i=2; i<7; i++) {
						
			BotonMagicaTrampaEnCampo botonMyTOponente = new BotonMagicaTrampaEnCampo(altoCarta, anchoCarta, i-2);
			super.add(botonMyTOponente, i, 1);
			super.setMargin(botonMyTOponente, espacioEntrePosiciones);
			this.botonesCartasJugadorSuperior.add(botonMyTOponente);
			
			BotonMonstruoEnCampo botonMonstruoOponente = new BotonMonstruoEnCampo(altoCarta, anchoCarta, i-2);
			super.add(botonMonstruoOponente, i, 2);
			super.setMargin(botonMonstruoOponente, espacioEntrePosiciones);
			this.botonesMonstruosJugadorSuperior.add(botonMonstruoOponente);
			
			
			BotonMonstruoEnCampo botonMonstruoJugador = new BotonMonstruoEnCampo(altoCarta, anchoCarta, i-2);
			super.add(botonMonstruoJugador, i, 3);
			super.setMargin(botonMonstruoJugador, espacioEntrePosiciones);
			this.botonesMonstruosJugadorInferior.add(botonMonstruoJugador);
			
			
			BotonMagicaTrampaEnCampo botonMyTJugador = new BotonMagicaTrampaEnCampo(altoCarta, anchoCarta, i-2);
			super.add(botonMyTJugador, i, 4);
			super.setMargin(botonMyTJugador,  espacioEntrePosiciones);
			this.botonesCartasJugadorInferior.add(botonMyTJugador);
		}
		
		dibujarCartasEnMano();
		generarDescripcionDeFase();
		super.add(tituloFase, 8, 1);
	}
	
	private StackPane crearPosicionMazo() {
		StackPane pilaADibujar = new StackPane();
		
		ImageView mazo = new ImageView();
		Image imagenDeCarta = new Image("file:src/algo3/AlGoOh/vista/cartaBocaAbajo.png");
		mazo.setImage(imagenDeCarta);
		mazo.setFitWidth(anchoCarta);
		mazo.setFitHeight(altoCarta);

		Text m = new Text("Mazo");
		m.setFill(Color.WHITE);
		m.fillProperty();
		pilaADibujar.getChildren().addAll(mazo, m);
		return pilaADibujar;
	}
	
	private void dibujarCartasEnMano() {
		ScrollPane scrollPane = new ScrollPane();
		super.add(scrollPane, 8, 3);
		
		HBox contenedorHorizontal = new HBox();
		
		List<Carta> cartasEnMano = AlGoOh.getInstance().jugadorActual.getListaDeCartasEnMano();
		
    	for (Carta unaCarta : cartasEnMano) {
    		BotonCartaEnMano cartaEnMano = new BotonCartaEnMano(anchoCarta, altoCarta, unaCarta);
    		cartaEnMano.cargarImagen();
    		contenedorHorizontal.getChildren().add(cartaEnMano);
    	}
		scrollPane.setContent(contenedorHorizontal);
		scrollPane.setPrefSize(anchoCarta*2.5, altoCarta);
	}
	
	public void actualizarTablero(Jugador jugadorActual) {
		actualizarBotones(jugadorInferior.getListaDeCartasEnZonaMonstruo(), botonesMonstruosJugadorInferior);
		actualizarBotones(jugadorInferior.getListaDeCartasEnZonaMagicaTrampa(), botonesCartasJugadorInferior);

		actualizarBotones(jugadorSuperior.getListaDeCartasEnZonaMonstruo(), botonesMonstruosJugadorSuperior);
		actualizarBotones(jugadorSuperior.getListaDeCartasEnZonaMagicaTrampa(), botonesCartasJugadorSuperior);
		
		if (jugadorActual == jugadorSuperior) {
			for (BotonCampo unBoton : botonesCartasJugadorInferior) {
				unBoton.deshabilitarBoton();
			}
			for (BotonCampo unBoton : botonesMonstruosJugadorInferior) {
				unBoton.deshabilitarBoton();
			}
		} else {
			for (BotonCampo unBoton : botonesCartasJugadorSuperior) {
				unBoton.deshabilitarBoton();
			}
			for (BotonCampo unBoton : botonesMonstruosJugadorSuperior) {
				unBoton.deshabilitarBoton();
			}
		}
		
		generarDescripcionDeFase();
	}
	
	public void agregarCartaCampo(Jugador jugadorActual) {
		if (jugadorActual == jugadorSuperior) {
			campoJugadorSuperior.cargarImagen(jugadorSuperior.getCartaDeCampo().obtenerNombre());
		} else {
			campoJugadorInferior.cargarImagen(jugadorInferior.getCartaDeCampo().obtenerNombre());
		}
	}
	
	private void generarDescripcionDeFase() {
		tituloFase.setText(AlGoOh.getInstance().getNombreDeFase());
		tituloFase.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
		tituloFase.setTextFill(Color.CYAN);
	}
	
	private void actualizarBotones(List<? extends Carta> listaCartasZona, List<BotonCampo> botones) {
		int variableTemporal = 0;
		for (int i = 0; i < listaCartasZona.size(); i++){
			Carta carta = listaCartasZona.get(i);
			if (carta.estaBocaAbajo()) {
				botones.get(i).cargarImagen("cartaBocaAbajo");
			} else {
				botones.get(i).cargarImagen(carta.obtenerNombre());
			}
			carta.rotarBoton((Button) botones.get(i));
			variableTemporal++;
		}
		while (variableTemporal <= 4) {
			botones.get(variableTemporal).cargarImagen("");
			variableTemporal++;
		}
		
		dibujarCartasEnMano();
	}
}
