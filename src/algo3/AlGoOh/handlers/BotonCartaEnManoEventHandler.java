package algo3.AlGoOh.handlers;

import javax.swing.JOptionPane;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.MonstruosInsuficientesParaSacrificioException;
import algo3.AlGoOh.Exceptions.ZonaNoTieneMasEspacioException;
import algo3.AlGoOh.modelo.AlGoOh;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BotonCartaEnManoEventHandler implements EventHandler<ActionEvent>{
	
	private Carta carta;
	
	public BotonCartaEnManoEventHandler(Carta cartaPasada) {
		carta = cartaPasada;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Agregar Monstruo al campo", "Agregar Magica al campo", "Agregar Trampa al campo", "Agregar carta de Campo", "Cancelar"};
		int eleccion =JOptionPane.showOptionDialog(null, "Que accion quiere realizar?", "Accion", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		switch (eleccion) {
		case 0: try {
					AlGoOh.getInstance().agregarMonstruoAlCampo(carta);
				} catch (MonstruosInsuficientesParaSacrificioException e) {
					alertaSacrificiosInsuficientes();
				} catch (ZonaNoTieneMasEspacioException e) {
					alertaNoHayMasEspacioEnLaZona();
				} catch (AccionInvalidaEnEstaFaseException e) {
					alertaAccionInvalidaEnFase();
				}
				break;
		case 1:
		case 2: try {
					AlGoOh.getInstance().agregarCartaTrampa(carta);
				} catch (ZonaNoTieneMasEspacioException e) {
					alertaNoHayMasEspacioEnLaZona();
				} catch (AccionInvalidaEnEstaFaseException e) {
					alertaAccionInvalidaEnFase();
				}
				break;
		case 3:
		default:
			break;
		}
    }
	private void alertaSacrificiosInsuficientes() {
		Alert alert = new Alert(AlertType.WARNING,""
				+ "Antes de invocar al monstruo debe hacer los sacrificios necesarios. \n"
				);
        alert.setTitle("Sacrificion insuficientes...");

        alert.showAndWait();
	}
	
	private void alertaNoHayMasEspacioEnLaZona() {
		Alert alert = new Alert(AlertType.WARNING,""
				+ "No se puede invocar mas invocar esta carta porque no \n"
				+ "hay mas espacio en el campo. \n"
				);
        alert.setTitle("Zona sin lugar...");

        alert.showAndWait();
	}
	
	private void alertaAccionInvalidaEnFase() {
		Alert alert = new Alert(AlertType.WARNING,""
				+ "No se pueden invocar monstruos en esta fase. \n"
				);
        alert.setTitle("Accion en fase invalida...");

        alert.showAndWait();
	}
}
