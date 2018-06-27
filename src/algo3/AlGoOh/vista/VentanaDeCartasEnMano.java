package algo3.AlGoOh.vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.InvocacionNormal;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Monstruo;
import algo3.AlGoOh.Efectos.EfectoAgujeroOscuro;
import algo3.AlGoOh.Efectos.EfectoVacio;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VentanaDeCartasEnMano extends Application {

	private Scene scene;
	private Jugador jugador = new Jugador();
	private int anchoCarta = 100;
	private int altoCarta = 150;
	private List<Carta> cartasEnMano = new ArrayList<Carta>();
	
	/*public VentanaDeCartasEnMano(Jugador jugadorIngresado) throws Exception{
		jugador = jugadorIngresado;
		cartasEnMano = jugador.getListaDeCartasEnMano();
		start(new Stage());
	}*/
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(final Stage stage) throws Exception {
    	stage.setTitle("Cartas en Mano: ");
    	stage.setFullScreen(false);
        
    	configurarMano();
    	
        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.setMaximized(false);
        stage.show();
    }
    
    private void configurarMano() {
    	
    	HBox contenedorHorizontal = new HBox();
    	             	
    	for (Carta unaCarta : cartasEnMano) {
    		BotonMagicaTrampaEnMano nuevo = new BotonMagicaTrampaEnMano(150, 100, unaCarta);
    		nuevo.cargarImagen();
    		contenedorHorizontal.getChildren().add(nuevo);
    	}
    	
    	contenedorHorizontal.setSpacing(10);
    	contenedorHorizontal.setPadding(new Insets(20));
    	scene = new Scene(contenedorHorizontal, 1300, 200);        
    }
    
    public void actualizarCartasEnMano(Jugador jugadorActual) {
    	jugador = jugadorActual;
    	configurarMano();
    }
}

//Faltaria agregar esto que habia en mano.

/*public Button crearBotonCarta(Carta carta) {
	//Estara bien hacer esto? Porque creo que no hay otra forma... A menos que creemos metodos para preguntarles que son...
	if( carta.getClass() == Monstruo.class) {
		BotonMonstruoEnMano nuevoBoton = new BotonMonstruoEnMano(altoCarta, anchoCarta, carta);
		nuevoBoton.cargarImagen();
		return nuevoBoton;
	} 
	BotonMagicaTrampaEnMano nuevoBotonCarta = new BotonMagicaTrampaEnMano(altoCarta, anchoCarta, carta);
	nuevoBotonCarta.cargarImagen();
	return nuevoBotonCarta;
}*/

//Se me ocurrio hacer esto, pero no se si va a entrar alguna vez al mosntruo
/*
private BotonMonstruoEnMano crearBoton(Monstruo cartaMonstruo) {
	BotonMonstruoEnMano nuevoBoton = new BotonMonstruoEnMano(altoCarta, anchoCarta, cartaMonstruo);
	nuevoBoton.cargarImagen();
	return nuevoBoton;
}

private BotonCartaEnMano crearBoton(Carta unaCarta) {
	BotonCartaEnMano nuevoBotonCarta = new BotonCartaEnMano(altoCarta, anchoCarta, unaCarta);
	nuevoBotonCarta.cargarImagen();
	return nuevoBotonCarta;
}*/
