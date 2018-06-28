package algo3.AlGoOh.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Efectos.EfectoAgujeroOscuro;
import algo3.AlGoOh.vista.BotonMagicaTrampaEnCampo;
import algo3.AlGoOh.vista.BotonMagicaTrampaEnMano;
import algo3.AlGoOh.vista.BotonMonstruoEnCampo;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	
	private List<BotonMonstruoEnCampo> botonesMonstruosJugadorSuperior = new ArrayList<BotonMonstruoEnCampo>();
	private List<BotonMagicaTrampaEnCampo> botonesCartasJugadorSuperior = new ArrayList<BotonMagicaTrampaEnCampo>();
	
	private List<BotonMonstruoEnCampo> botonesMonstruosJugadorInferior = new ArrayList<BotonMonstruoEnCampo>();
	private List<BotonMagicaTrampaEnCampo> botonesCartasJugadorInferior = new ArrayList<BotonMagicaTrampaEnCampo>();
	
	public Tablero(int anchoCartaIngresado, int altoCartaIngresado) {
		anchoCarta = anchoCartaIngresado;
		altoCarta = altoCartaIngresado;
		
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
						
			BotonMagicaTrampaEnCampo botonMyTOponente = new BotonMagicaTrampaEnCampo(altoCarta, anchoCarta);
			super.add(botonMyTOponente, i, 1);
			super.setMargin(botonMyTOponente, espacioEntrePosiciones);
			this.botonesCartasJugadorSuperior.add(botonMyTOponente);
			
			
			BotonMonstruoEnCampo botonMonstruoOponente = new BotonMonstruoEnCampo(altoCarta, anchoCarta);
			super.add(botonMonstruoOponente, i, 2);
			super.setMargin(botonMonstruoOponente, espacioEntrePosiciones);
			this.botonesMonstruosJugadorSuperior.add(botonMonstruoOponente);
			
			
			BotonMonstruoEnCampo botonMonstruoJugador = new BotonMonstruoEnCampo(altoCarta, anchoCarta);
			super.add(botonMonstruoJugador, i, 3);
			super.setMargin(botonMonstruoJugador, espacioEntrePosiciones);
			this.botonesMonstruosJugadorInferior.add(botonMonstruoJugador);
			
			
			BotonMagicaTrampaEnCampo botonMyTJugador = new BotonMagicaTrampaEnCampo(altoCarta, anchoCarta);
			super.add(botonMyTJugador, i, 4);
			super.setMargin(botonMyTJugador,  espacioEntrePosiciones);
			this.botonesCartasJugadorInferior.add(botonMyTJugador);
		}
		
		ScrollPane scrollPane = new ScrollPane();
		super.add(scrollPane, 8, 3);
		super.setMargin(scrollPane, espacioEntrePosiciones);
		
		HBox contenedorHorizontal = new HBox();
		
		List<Carta> cartasEnMano = new ArrayList<Carta>();
		Carta agujeroOscuro1 = new Carta("Agujero Oscuro", new EfectoAgujeroOscuro());
		Carta agujeroOscuro2 = new Carta("Agujero Oscuro", new EfectoAgujeroOscuro());
		Carta agujeroOscuro3 = new Carta("Agujero Oscuro", new EfectoAgujeroOscuro());

     	cartasEnMano.add(agujeroOscuro1);
     	cartasEnMano.add(agujeroOscuro2);
     	cartasEnMano.add(agujeroOscuro3);
		
    	for (Carta unaCarta : cartasEnMano) {
    		BotonMagicaTrampaEnMano nuevo = new BotonMagicaTrampaEnMano(150, 100, unaCarta);
    		nuevo.cargarImagen();
    		contenedorHorizontal.getChildren().add(nuevo);
    	}
    	
    	contenedorHorizontal.setSpacing(0);
    	contenedorHorizontal.setPadding(new Insets(20));
		
		scrollPane.setContent(contenedorHorizontal);
		
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
	
	public void actualizarTablero() {
		
	}
}
