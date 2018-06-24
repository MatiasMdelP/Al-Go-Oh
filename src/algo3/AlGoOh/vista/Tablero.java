package algo3.AlGoOh.vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Tablero extends GridPane{

	public Tablero() {

		super.add(this.crearPosicionMazo(), 1, 1);
		super.add(this.crearPosicionCampoVacio(), 7, 2);
		super.add(this.crearPosicionCampoVacio(), 1, 3);
		super.add(this.crearPosicionMazo(), 7, 4);
		for(int i=2; i<7; i++) {
			super.add(this.crearPosicionMagicaYTrampaVacia(), i, 1);			
			super.add(this.crearPosicionMonstruoVacia(), i, 2);
			super.add(this.crearPosicionMonstruoVacia(), i, 3);
			super.add(this.crearPosicionMagicaYTrampaVacia(), i, 4);
		}
	
	}



	public StackPane crearPosicionMonstruoVacia() {
		StackPane pilaADibujar = new StackPane();
		
		Rectangle rectangulo = new Rectangle();
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
		pilaADibujar.getChildren().addAll(mazo, m);
		return pilaADibujar;
	}
}
