package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	private int puntosDeVida;
	private List<Monstruo> monstruos = new ArrayList<Monstruo>();
	
	public Jugador() {
		puntosDeVida = 8000;
	}

	public int obtenerPuntosDeVida() {
		return puntosDeVida;
	}

	public void agregarMounstro(Monstruo huevoMonstruoso) {
		monstruos.add(huevoMonstruoso);
	}

	public int atacar(int nroDeMonstruo, Monstruo monstruoAtacante) {
		int diferenciaDePuntos = monstruoAtacante.atacar(monstruos.get(nroDeMonstruo));
		
		if (diferenciaDePuntos > 0) {
			puntosDeVida -= diferenciaDePuntos;
			return 0;
		}
		return -1*diferenciaDePuntos;
	}

	public void atacar(Jugador atacante, int nroDeMonstruoAtacante, int nroDeMonstruoAtacado) {
		int diferenciaDePuntos = atacante.atacar(nroDeMonstruoAtacado, monstruos.get(nroDeMonstruoAtacante));
		
		if (diferenciaDePuntos > 0) {
			puntosDeVida -= diferenciaDePuntos;
		}
	}
}
