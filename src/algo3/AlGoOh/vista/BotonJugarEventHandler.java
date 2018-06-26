package algo3.AlGoOh.vista;

import algo3.AlGoOh.AlGoOh;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
   
    private TextField textoJugador1;
    private TextField textoJugador2;
    
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
            Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);
    		stage.setScene(escenaJuego);
    		stage.setFullScreenExitHint("");
    		stage.setFullScreen(true);
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
