package algo3.AlGoOh.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.WildcardLoader;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Monstruo;
import algo3.AlGoOh.Efectos.EfectoAgujeroOscuro;
import algo3.AlGoOh.vista.BotonCartaEnMano;
import algo3.AlGoOh.vista.BotonMagicaTrampaEnCampo;
import algo3.AlGoOh.vista.BotonMagicaTrampaEnMano;
import algo3.AlGoOh.vista.BotonMonstruoEnCampo;
import algo3.AlGoOh.vista.ContenedorPrincipal;
import algo3.AlGoOh.vista.Mano;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tablero extends GridPane{

	private int anchoCarta;
	private int altoCarta;
	private AlGoOh juegoAlGoOh;
	private Jugador jugadorSuperior;
	private Jugador jugadorInferior;
	//private	Mano mano;
	
	private List<BotonMonstruoEnCampo> botonesMonstruosJugadorSuperior = new ArrayList<BotonMonstruoEnCampo>();
	private List<BotonMagicaTrampaEnCampo> botonesCartasJugadorSuperior = new ArrayList<BotonMagicaTrampaEnCampo>();
	
	private List<BotonMonstruoEnCampo> botonesMonstruosJugadorInferior = new ArrayList<BotonMonstruoEnCampo>();
	private List<BotonMagicaTrampaEnCampo> botonesCartasJugadorInferior = new ArrayList<BotonMagicaTrampaEnCampo>();
	
	public Tablero(int anchoCartaIngresado, int altoCartaIngresado, Jugador jugador1, Jugador jugador2) {
		anchoCarta = anchoCartaIngresado;
		altoCarta = altoCartaIngresado;
		jugadorSuperior = jugador1;
		jugadorInferior = jugador2;
		
		construirTablero();
		//this.setPrefSize(500, 500);
	}

	private void construirTablero() {
		Insets espacioEntrePosiciones = new Insets(10,10,10,10);
		
		StackPane mazoOponente = this.crearPosicionMazo();
		super.add(mazoOponente, 1, 1);
		super.setMargin(mazoOponente,espacioEntrePosiciones);
		
		StackPane campoOponente = this.crearPosicionCampoVacio();
		super.add(campoOponente, 7, 2);
		super.setMargin(campoOponente, espacioEntrePosiciones);
	
		StackPane campoJugador = this.crearPosicionCampoVacio();
		super.add(this.crearPosicionCampoVacio(), 1, 3);
		super.setMargin(campoJugador, espacioEntrePosiciones);
		
		StackPane mazoJugador = this.crearPosicionMazo();
		super.add(mazoJugador, 7, 4);
		super.setMargin(campoJugador, espacioEntrePosiciones);
		
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
	}
	
	private StackPane crearPosicionMonstruoVacia() {
		StackPane pilaADibujar = new StackPane();
		
		Rectangle rectangulo = new Rectangle();
		rectangulo.setStroke(Color.BLACK);
		rectangulo.setWidth(anchoCarta);
		rectangulo.setHeight(altoCarta);
		rectangulo.setFill(Color.BROWN);
		rectangulo.fillProperty();

		Rectangle rectanguloDefensa = new Rectangle();
		rectanguloDefensa.setFill(Color.TRANSPARENT);
		rectanguloDefensa.setStroke(Color.BLACK);
		rectanguloDefensa.setStrokeWidth(3); 	
		rectanguloDefensa.setWidth(altoCarta);
		rectanguloDefensa.setHeight(anchoCarta);
		rectanguloDefensa.getStrokeDashArray().addAll(25d, 10d);
		
		Text m = new Text("Monstruo");
		
		pilaADibujar.getChildren().addAll(rectangulo,rectanguloDefensa, m);
		return pilaADibujar;
	}

	private StackPane crearPosicionMagicaYTrampaVacia() {
		
		StackPane pilaADibujar = new StackPane();
		
		Rectangle rectangulo = new Rectangle();
		rectangulo.setStroke(Color.BLACK);
		rectangulo.setWidth(anchoCarta);
		rectangulo.setHeight(altoCarta);
		rectangulo.setFill(Color.DARKCYAN);
		rectangulo.fillProperty();

		Text m = new Text("Magica/Trampa");
		
		pilaADibujar.getChildren().addAll(rectangulo, m);
		return pilaADibujar;		
	}

	private StackPane crearPosicionCampoVacio() {
		StackPane pilaADibujar = new StackPane();
		
		Rectangle rectangulo = new Rectangle();
		rectangulo.setStroke(Color.BLACK);
		rectangulo.setWidth(anchoCarta);
		rectangulo.setHeight(altoCarta);
		rectangulo.setFill(Color.GREEN);
		rectangulo.fillProperty();

		Text m = new Text("Campo");
		pilaADibujar.getChildren().addAll(rectangulo, m);
		return pilaADibujar;
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
		
		//mano.actualizarMano();
	}
	
	public void actualizarTablero(Jugador jugadorActual) {
		actualizarBotonesMonstruo(jugadorInferior.getListaDeCartasEnZonaMonstruo(), botonesMonstruosJugadorInferior);
		actualizarBotonesMagicaTrampa(jugadorInferior.getListaDeCartasEnZonaMagicaTrampa(), botonesCartasJugadorInferior);
		
		actualizarBotonesMonstruo(jugadorSuperior.getListaDeCartasEnZonaMonstruo(), botonesMonstruosJugadorSuperior);
		actualizarBotonesMagicaTrampa(jugadorSuperior.getListaDeCartasEnZonaMagicaTrampa(), botonesCartasJugadorSuperior);
		
		if (jugadorActual == jugadorSuperior) {
			for (BotonMagicaTrampaEnCampo unBoton : botonesCartasJugadorInferior) {
				unBoton.deshabilitarBoton();
			}
			for (BotonMonstruoEnCampo unBoton : botonesMonstruosJugadorInferior) {
				unBoton.deshabilitarBoton();
			}
		} else {
			for (BotonMagicaTrampaEnCampo unBoton : botonesCartasJugadorSuperior) {
				unBoton.deshabilitarBoton();
			}
			for (BotonMonstruoEnCampo unBoton : botonesMonstruosJugadorSuperior) {
				unBoton.deshabilitarBoton();
			}
		}		
	}
	
	private void actualizarBotonesMagicaTrampa(List<Carta> listaCartasZona, List<BotonMagicaTrampaEnCampo> botonesMagicaTrampa) {
		int variableTemporal = 0;
		for (int i = 0; i < listaCartasZona.size(); i++){
			Carta uno = listaCartasZona.get(i);
			botonesMagicaTrampa.get(i).cargarImagen(uno.obtenerNombre());
			variableTemporal++;
		}
		while (variableTemporal <= 4) {
			botonesMagicaTrampa.get(variableTemporal).cargarImagen("");
			variableTemporal++;
		}
		
		dibujarCartasEnMano();
	}
	
	private void actualizarBotonesMonstruo(List<Monstruo> listaCartasZona, List<BotonMonstruoEnCampo> botonesMonstruosJugador) {
		int variableTemporal = 0;
		for (int i = 0; i < listaCartasZona.size(); i++){
			Monstruo unMonstruo = listaCartasZona.get(i);
			if (unMonstruo.estaBocaAbajo()) {
				botonesMonstruosJugador.get(i).cargarImagen("cartaBocaAbajo");
			} else {
				botonesMonstruosJugador.get(i).cargarImagen(unMonstruo.obtenerNombre());
			}
			variableTemporal++;
		}
		while (variableTemporal <= 4) {
			botonesMonstruosJugador.get(variableTemporal).cargarImagen("");
			variableTemporal++;
		}
		
		dibujarCartasEnMano();
	}
}
