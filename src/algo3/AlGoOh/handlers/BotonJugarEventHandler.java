package algo3.AlGoOh.handlers;

import java.io.File;

import algo3.AlGoOh.vista.Audio;
import algo3.AlGoOh.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
   
    private TextField textoJugador1;
    private TextField textoJugador2;
	private MediaPlayer mediaPlayer;
    
    public BotonJugarEventHandler(Stage stage, TextField jugador1, TextField jugador2) {
        this.stage = stage;
        textoJugador1 = jugador1;
        textoJugador2 = jugador2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	if ((this.textoJugador1.getText().trim().equals("")) || (this.textoJugador2.getText().trim().equals(""))) {
    		debeIngresarLosNombresDeLosJugadores();
    	} else {
    		ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage);
    		contenedorPrincipal.setNombresDeJugadores(textoJugador1.getText().trim(), textoJugador2.getText().trim());
            Scene escenaJuego = new Scene(contenedorPrincipal, 1300, 650);
    		stage.setScene(escenaJuego);
    		stage.setMaximized(true);
    		contenedorPrincipal.determinarQuienComienza();
    		Audio.reproducirBatalla();
    	}
    }
    
    private void debeIngresarLosNombresDeLosJugadores() {
    	 Alert alert = new Alert(AlertType.WARNING, ""
  				+ "Debe ingresar los nombres de los dos jugadores.\n"
 				);
         alert.setTitle("Error");
         alert.setHeaderText("");

         alert.showAndWait();
	}
}
