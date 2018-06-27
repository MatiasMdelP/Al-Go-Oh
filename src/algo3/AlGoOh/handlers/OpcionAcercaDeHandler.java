package algo3.AlGoOh.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionAcercaDeHandler implements EventHandler<ActionEvent>  {
    @Override
    public void handle(ActionEvent actionEvent) {
       
        Alert alert = new Alert(AlertType.INFORMATION,""
				+ "DEL CARRIL, Manuel           manueldelcarril@gmail.com\n"
				+ "ILLESCAS, Geronimo           gero17illescas@gmail.com\n"
				+ "MARCÃ“ DEL PONT, MatÃ­as       matiasmdelp@gmail.com\n"
				+ "ROMERO VÃ�ZQUEZ, Maximiliano  maxi9614@gmail.com\n"
				);
        alert.setTitle("Acerca de ");
        alert.setHeaderText("DiseÃ±ado por:");

        alert.showAndWait();
    }
}
