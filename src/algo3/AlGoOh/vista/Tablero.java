package algo3.AlGoOh.vista;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Tablero extends GridPane{

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
			
			StackPane magicaYTrampaOponente = this.crearPosicionMagicaYTrampaVacia();
			super.add(magicaYTrampaOponente, i, 1);
			super.setMargin(magicaYTrampaOponente, espacioEntrePosiciones);
			
			StackPane monstruoOponente = this.crearPosicionMonstruoVacia();
			super.add(monstruoOponente, i, 2);
			super.setMargin(monstruoOponente,espacioEntrePosiciones);
			
			StackPane monstruoJugador = this.crearPosicionMonstruoVacia();
			super.add(monstruoJugador, i, 3);
			super.setMargin(monstruoJugador, espacioEntrePosiciones);
			
			StackPane magicaYTrampaJugador = this.crearPosicionMagicaYTrampaVacia();
			super.add(magicaYTrampaJugador, i, 4);
			super.setMargin(magicaYTrampaJugador, espacioEntrePosiciones);
		}
	
	}



	public StackPane crearPosicionMonstruoVacia() {
		StackPane pilaADibujar = new StackPane();
		
		Rectangle rectangulo = new Rectangle();
		rectangulo.setStroke(Color.BLACK);
		rectangulo.setWidth(150);
		rectangulo.setHeight(220);
		rectangulo.setFill(Color.BROWN);
		rectangulo.fillProperty();

		Text m = new Text("Monstruo");
		
		pilaADibujar.getChildren().addAll(rectangulo, m);
		return pilaADibujar;
	}

	public StackPane crearPosicionMagicaYTrampaVacia() {
		
		StackPane pilaADibujar = new StackPane();
		
		Rectangle rectangulo = new Rectangle();
		rectangulo.setStroke(Color.BLACK);
		rectangulo.setWidth(150);
		rectangulo.setHeight(220);
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
		rectangulo.setWidth(150);
		rectangulo.setHeight(220);
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
		mazo.setFitWidth(150);
		mazo.setFitHeight(220);

		Text m = new Text("Mazo");
		m.setFill(Color.WHITE);
		m.fillProperty();
		pilaADibujar.getChildren().addAll(mazo, m);
		return pilaADibujar;
	}
}
