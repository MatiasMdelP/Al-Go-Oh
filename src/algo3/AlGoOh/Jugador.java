package algo3.AlGoOh;

import java.util.ArrayList;

public class Jugador {
	
	private int puntosDeVida;
	private ArrayList<Monstruo> monstruos = new ArrayList();
	
	public Jugador() {
		puntosDeVida = 8000;
	}

	public int obtenerPuntosDeVida() {
		return puntosDeVida;
	}

	public void descontarPuntosDeVida(int puntosPerdidos) {
		puntosDeVida = puntosDeVida - puntosPerdidos; // Despues hay que chequear como hacer si (puntosPerdidos > puntosDeVida)
	}

	public void agregarMounstro(Monstruo huevoMonstruoso) {
		monstruos.add(huevoMonstruoso);
	}

	public void atacar(int nroDeMonstruo, Monstruo monstruoAtacante) {
		int diferenciaDePuntos = monstruoAtacante.atacar(monstruos.get(nroDeMonstruo));
		
		if (diferenciaDePuntos > 0) {
			puntosDeVida -= diferenciaDePuntos;
		}
	}
}
