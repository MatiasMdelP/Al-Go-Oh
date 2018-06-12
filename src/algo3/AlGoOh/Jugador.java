package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	private int puntosDeVida;
	private Campo campo;
	private List<Monstruo> monstruos = new ArrayList<Monstruo>();
	int VIDA = 8000;
	
	
	public Jugador(Campo campo) {
		puntosDeVida = VIDA;
		this.campo = campo;
	}

	public int obtenerPuntosDeVida() {
		return puntosDeVida;
	}

	public void agregarMonstruoEnAtaque(Monstruo monstruo) {
		campo.agregarMonstruoEnAtaque(monstruo);
		monstruos.add(monstruo);
	}

	public void agregarMonstruoEnDefensa(Monstruo monstruo) {
		campo.agregarMonstruoEnDefensa(monstruo);
		monstruos.add(monstruo);
	}
	
	public void agregarMagicaBocaArriba(Carta carta) {
		campo.agregarMagicaBocaArriba(carta);
	}
	
	public void atacar(Jugador oponente, int nroMonstruoAtacante, int nroMonstruoAtacado) {
		int diferenciaDePuntos = oponente.atacarse(nroMonstruoAtacante, nroMonstruoAtacado);
		
		if (diferenciaDePuntos > 0) {
			puntosDeVida -= diferenciaDePuntos;
		}
	}
	
	public int atacarse(int nroMonstruoAtacante, int nroMonstruoAtacado) {
		int diferenciaDePuntos = campo.combatir(nroMonstruoAtacante,nroMonstruoAtacado);
		
		if (diferenciaDePuntos < 0) {
			puntosDeVida += diferenciaDePuntos;
			return 0;
		}
		return diferenciaDePuntos;
	}
	
}	
//	public int atacar(int nroDeMonstruo, Monstruo monstruoAtacante) {
//		int diferenciaDePuntos = monstruoAtacante.atacar(monstruos.get(nroDeMonstruo));
//		
//		if (diferenciaDePuntos > 0) {
//			puntosDeVida -= diferenciaDePuntos;
//			return 0;
//		}
//		return -1*diferenciaDePuntos;
//	}
//
//	public void atacar(Jugador atacante, int nroDeMonstruoAtacante, int nroDeMonstruoAtacado) {
//		int diferenciaDePuntos = atacante.atacar(nroDeMonstruoAtacado, monstruos.get(nroDeMonstruoAtacante));
//		
//		if (diferenciaDePuntos > 0) {
///			puntosDeVida -= diferenciaDePuntos;
//		}
//	}
//}
