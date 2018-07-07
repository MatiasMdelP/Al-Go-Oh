package algo3.AlGoOh.vista;

import javax.swing.JOptionPane;

import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.modelo.AlGoOh;
import algo3.AlGoOh.modelo.Tablero;
import javafx.geometry.Insets;
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
    private Tablero tablero;
    //private Mano mano;
    private int anchoCarta = 100;
    private int altoCarta = 150;
    VBox contenedorCentral;
    String nombreJugador1;
    String nombreJugador2;
    Jugador jugador1 = new Jugador();
    Jugador jugador2 = new Jugador();
    private AlGoOh juegoAlGoOh = AlGoOh.getInstance();

    public ContenedorPrincipal(Stage stage) {
    	
        this.setMenu(stage);
        this.setCentro();
        //this.setConsola();
        this.setBotonera();
        this.setMinSize(1100, 700);
        stage.setFullScreen(true);
        this.setPrefSize(1100, 7000);
    }
    
    public void setNombresDeJugadores(String unNombre, String otroNombre) {
    	nombreJugador1 = unNombre;
    	nombreJugador2 = otroNombre;
        this.setBotonera();
    }
    
    private void setBotonera() {
    	Label etiqJugador1 = crearLabelJugador(nombreJugador1, jugador1);
    	Label etiqJugador2 = crearLabelJugador(nombreJugador2, jugador2);
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

    private Label crearLabelJugador(String nombreJugador, Jugador jugador) {
    	Label label = new Label();
    	int vidaJugador = jugador.obtenerPuntosDeVida();
    	label.setText(nombreJugador + ": \n" + vidaJugador);
    	label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
    	if (vidaJugador > 5000) {
    		label.setTextFill(Color.web("#000000")); // negro
    	}
    	else if(vidaJugador > 3000){
    		label.setTextFill(Color.web("#ffff00")); // amarillo
    	}
    	else {
    		label.setTextFill(Color.web("#ff0000")); //rojo
    	}
    	
        return label;
    }
    
    public void actualizarDatosDeJugadores() {
    	setBotonera();
    }
    
    public void ganadorDelJuego(Jugador unJugador) {
    	if (unJugador == jugador1) {
    		ganador(nombreJugador1);
    	} else {
    		ganador(nombreJugador2);
    	}
    }
    
    private void ganador(String nombreDelGanador) {
		/*Alert alert = new Alert(AlertType.INFORMATION,""
				+ "FELICITACIONES " + nombreDelGanador.toUpperCase() + "!!!! HAS GANADO LA PARTIDA."
				);
        alert.setTitle("Fin del juego");

        alert.showAndWait();*/
    	String ganador = "FELICITACIONES " + nombreDelGanador.toUpperCase() + "!!!! HAS GANADO LA PARTIDA.";
    	String[] options = {"Juego nuevo", "Salir"};
    	Audio.reproducirVictoria();
		int eleccion =JOptionPane.showOptionDialog(null, ganador, "Fin del Juego", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		switch (eleccion) {
			case 0: jugador1 = new Jugador();
					jugador2 = new Jugador();
					this.setCentro();
					break;
			case 1: System.exit(0);
					break;
		}
	}
    
    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro() {
    	
    	try {
    		juegoAlGoOh.cargarJugadores(jugador1, jugador2, this);
		} catch (Exception e) {
			System.out.println("Error");
		}
    	//mano = new Mano(anchoCarta, altoCarta);
    	tablero = new Tablero(anchoCarta, altoCarta, jugador1, jugador2);
    	juegoAlGoOh.cargarTablero(tablero);
    	
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
        //super.setMargin(tablero, new Insets(10,10,10,10));
    	//this.setBottom(mano);
    	//super.setAlignment(mano, Pos.BOTTOM_CENTER);
    	//super.setMargin(mano, new Insets(10,10,10,10));
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}

