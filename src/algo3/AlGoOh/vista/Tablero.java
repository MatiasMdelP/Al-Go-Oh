package algo3.AlGoOh.vista;

import java.util.ArrayList;

import javax.swing.JPanel;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Tablero extends GridPane{

	private int anchoCarta = 100;
	private int altoCarta = 150;
	
	
	public Tablero() {
		
		
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
			
			//StackPane magicaYTrampaOponente = this.crearPosicionMagicaYTrampaVacia();
			//super.add(magicaYTrampaOponente, i, 1);
			BotonMagicaTrampaEnCampo botonMyTOponente = new BotonMagicaTrampaEnCampo(altoCarta, anchoCarta);
			
			super.add(botonMyTOponente, i, 1);
			//super.setMargin(nuevoBoton, espacioEntrePosiciones);
			super.setMargin(/*magicaYTrampaOponente,*/ botonMyTOponente, espacioEntrePosiciones);
			
			//StackPane monstruoOponente = this.crearPosicionMonstruoVacia();
			//super.add(monstruoOponente, i, 2);
			BotonMonstruoEnCampo botonMonstruoOponente = new BotonMonstruoEnCampo(altoCarta, anchoCarta);
			
			super.add(botonMonstruoOponente, i, 2);
			super.setMargin(/*monstruoOponente,*/ botonMonstruoOponente, espacioEntrePosiciones);
			
			//StackPane monstruoJugador = this.crearPosicionMonstruoVacia();
			//super.add(monstruoJugador, i, 3);
			BotonMonstruoEnCampo botonMonstruoJugador = new BotonMonstruoEnCampo(altoCarta, anchoCarta);
			super.add(botonMonstruoJugador, i, 3);
			super.setMargin(/*monstruoOponente,*/ botonMonstruoJugador, espacioEntrePosiciones);
			
			//StackPane magicaYTrampaJugador = this.crearPosicionMagicaYTrampaVacia();
			//super.add(magicaYTrampaJugador, i, 4);
			BotonMagicaTrampaEnCampo botonMyTJugador = new BotonMagicaTrampaEnCampo(altoCarta, anchoCarta);
			super.add(botonMyTJugador, i, 4);
			super.setMargin(/*monstruoJugador,*/botonMyTJugador,  espacioEntrePosiciones);
		}
		
	}



	public StackPane crearPosicionMonstruoVacia() {
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

	public StackPane crearPosicionMagicaYTrampaVacia() {
		
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

	public StackPane crearPosicionCampoVacio() {
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

	public StackPane crearPosicionMazo() {
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
}
