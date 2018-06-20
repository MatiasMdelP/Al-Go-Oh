package algo3.AlGoOh;


public class Estrellas {
	
	private int estrellas;
	private int sacrificios;
	
	public Estrellas(int cantidadDeEstrellas) {
		estrellas = cantidadDeEstrellas;
		if (estrellas > 6) {
			sacrificios = 2;
		}
		else if (estrellas > 4) {
			sacrificios = 1;
		}
		else {
			sacrificios = 0;
		}
	}

}
