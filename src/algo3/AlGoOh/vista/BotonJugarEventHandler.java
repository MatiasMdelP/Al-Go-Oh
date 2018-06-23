package algo3.AlGoOh.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene proximaEscena;

    private TextField textoJugador1;
    private TextField textoJugador2;
    
    public BotonJugarEventHandler(Stage stage, Scene proximaEscena, TextField jugador1, TextField jugador2) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        textoJugador1 = jugador1;
        textoJugador2 = jugador2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	if ((this.textoJugador1.getText().trim().equals("")) || (this.textoJugador2.getText().trim().equals(""))) {
    		debeIngresarLosNombresDeLosJugadores();
    	} else {
    		stage.setScene(proximaEscena);
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
