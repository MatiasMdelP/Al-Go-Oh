package algo3.AlGoOh.vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class BotonCartaDeCampo extends Button{

	public BotonCartaDeCampo(int altoCarta, int anchoCarta) {
		this.setText("Campo");
		this.setDisable(true);
		this.setMinHeight(altoCarta);
		this.setMaxHeight(anchoCarta);
		this.setPrefSize(anchoCarta, altoCarta);
	}
	
	public void cargarImagen(String nombreDeLaCarta) {
		/*Image imagen;
		if (nombreDeLaCarta == "") {
			this.setText("Campo");
			imagen = new Image("file:src/algo3/AlGoOh/vista/cartas/BotonNulo.png");
		} else {
			this.setText("");
			imagen = new Image("file:src/algo3/AlGoOh/vista/cartas/" + nombreDeLaCarta + ".png");
		}*/
		this.setText("");
		Image imagen = new Image("file:src/algo3/AlGoOh/vista/cartas/" + nombreDeLaCarta + ".png");
	    BackgroundImage imagenDeLaCarta = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, 
	    		BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	            
	    this.setBackground(new Background(imagenDeLaCarta));
	}
}
