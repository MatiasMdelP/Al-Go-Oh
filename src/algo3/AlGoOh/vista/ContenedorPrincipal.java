package algo3.AlGoOh.vista;

import javax.swing.JButton;

import algo3.AlGoOh.AlGoOh;
import algo3.AlGoOh.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    private BarraDeMenu menuBar;
    //VistaRobot vistaRobot;
    //Canvas canvasCentral;
    private Tablero tablero;
    VBox contenedorCentral;
    private AlGoOh juegoAlGoOh;

    public ContenedorPrincipal(Stage stage/*, Robot robot*/) {
    	
        this.setMenu(stage);
        this.setCentro(/*robot*/);
        //this.setConsola();
        this.setBotonera(new Jugador(), new Jugador());
        this.setMinSize(1100, 700);
        stage.setFullScreen(false);
        this.setPrefSize(1100, 7000);
    }

    private void setBotonera(Jugador jugador1, Jugador jugador2) {
    
    	Label etiqJugador1 = new Label();
    	etiqJugador1.setText("JUGADOR 1: \n"
    			+ jugador1.obtenerPuntosDeVida());
    	etiqJugador1.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        etiqJugador1.setTextFill(Color.web("#000000"));
    	
    	Label etiqJugador2 = new Label();
    	etiqJugador2.setText("JUGADOR 2: \n"
    			+ jugador2.obtenerPuntosDeVida());
    	etiqJugador2.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
    	etiqJugador2.setTextFill(Color.web("#000000"));
    	
    	BotonFinalizarTurno botonPasarTurno = new BotonFinalizarTurno(juegoAlGoOh);
    	
    	BotonCambiarFase botonCambiarFase = new BotonCambiarFase(juegoAlGoOh);
    	
    	VBox contenedorDeBotones = new VBox(botonPasarTurno, botonCambiarFase);
    	contenedorDeBotones.setSpacing(20);
    	
        VBox contenedorVertical = new VBox(etiqJugador1, contenedorDeBotones, etiqJugador2);
        contenedorVertical.setSpacing(200);
        contenedorVertical.setPadding(new Insets(15));
        //Image imagen = new Image("file:src/algo3/AlGoOh/vista/tablero.png");
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        
        //contenedorVertical.setBackground(new Background(imagenDeFondo));
        this.setLeft(contenedorVertical);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro(/*Robot robot*/) {

    	tablero = new Tablero();
        //canvasCentral = new Canvas(460, 220);
        //vistaRobot = new VistaRobot(robot, canvasCentral);
        //vistaRobot.dibujar();

        //contenedorCentral = new VBox(canvasCentral);
        //contenedorCentral.setAlignment(Pos.CENTER);
        //contenedorCentral.setSpacing(20);
        //contenedorCentral.setPadding(new Insets(25));
        Image imagen = new Image("file:src/algo3/AlGoOh/vista/tablero.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        tablero.setBackground(new Background(imagenDeFondo));

        this.setCenter(tablero);
    }

    /*private void setConsola() {
        //  cambiar por el modelo de Consola...
        Label etiqueta = new Label();
        etiqueta.setText("consola...");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);
        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black;");
        this.setBottom(contenedorConsola);
    }*/

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}

