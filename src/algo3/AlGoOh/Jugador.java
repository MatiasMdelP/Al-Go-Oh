package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	private int puntosDeVida;
	private Campo campo;
	//private List<Monstruo> monstruos = new ArrayList<Monstruo>();
	
	
	
	public Jugador() {
		puntosDeVida = 8000;
	}

	public int obtenerPuntosDeVida() {
		return puntosDeVida;
	}

	public void agregarMonstruoEnAtaque(Monstruo monstruo) {
		campo.agregarMonstruoEnAtaque(monstruo);;
	}

	public void agregarMonstruoEnDefensa(Monstruo monstruo) {
		campo.agregarMonstruoEnDefensa(monstruo);
	}
	
	public void atacar(Jugador oponente, int nroMonstruoAtacante, int nroMonstruoAtacado) {
		Monstruo atacante = campo.getMonstruo(nroMonstruoAtacante);
		int diferenciaDePuntos = oponente.atacarse(atacante, nroMonstruoAtacado);
		puntosDeVida -= diferenciaDePuntos;
	
	}
	
	public int atacarse(Monstruo atacante, int nroMonstruoAtacado) {
		
		int diferenciaDePuntos = campo.atacarMonstruo(nroMonstruoAtacado, atacante);
		
		if (diferenciaDePuntos > 0) {
			puntosDeVida -= diferenciaDePuntos;
			return 0;
		}
		
		return -1*diferenciaDePuntos;
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
