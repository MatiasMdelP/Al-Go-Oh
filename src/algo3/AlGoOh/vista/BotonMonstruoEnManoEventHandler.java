package algo3.AlGoOh.vista;

import javax.swing.JOptionPane;

import algo3.AlGoOh.EfectoVacio;
import algo3.AlGoOh.InvocacionNormal;
import algo3.AlGoOh.Monstruo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMonstruoEnManoEventHandler implements EventHandler<ActionEvent>{

	private Monstruo monstruo = new Monstruo("", new EfectoVacio(), new InvocacionNormal(), 500, 500);
	
	public BotonMonstruoEnManoEventHandler(/*Monstruo unMonstruo*/) {
		//monstruo = unMonstruo;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		JOptionPane cuadro = new JOptionPane();
		cuadro.setMessageType(1);

		String[] options = {"Invocar en Ataque", "Invocar en Defensa", "Cancelar"};
		int seleccion = JOptionPane.showOptionDialog(null, "Que acción quiere realizar?", "Acción", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if (seleccion == 0) {
			monstruo.colocarEnPosicionAtaque();
			formaDeColocarLaCarta();
		} else if (seleccion == 1) {
			monstruo.colocarEnPosicionDefensa();
			formaDeColocarLaCarta();
		} 
    }
	
	public void formaDeColocarLaCarta() {
		String[] options = {"Boca Abajo", "Boca Arriba"};
		int eleccion = JOptionPane.showOptionDialog(null, "En que posición quiere colocar la carta?", "Acción", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if (eleccion == 0) {
			monstruo.darVuelta();
		}
	}
}
