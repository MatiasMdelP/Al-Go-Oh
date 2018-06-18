package algo3.AlGoOh;

import java.util.List;

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
	
//	public void efectuarSacrificios(List<Monstruo> monstruos) {
//		int cantidadDeSacrificios = sacrificios;
//		for (Monstruo monstruo : monstruos) {
//			if (! monstruo.estaEnElCementerio) {
//				monstruo.mandarAlCementerio();
//				cantidadDeSacrificios -= 1;
//			}
//			if (cantidadDeSacrificios == 0) {
//				break;
//			}
//		}
//	}
	


}
