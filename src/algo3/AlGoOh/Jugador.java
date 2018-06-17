package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	private int puntosDeVida;
	private Campo campo;
	int VIDA = 8000;	
	
	public Jugador(Campo unCampo) {
		campo = unCampo;
		puntosDeVida = VIDA;
	}
	
	public int obtenerPuntosDeVida() {
		return puntosDeVida;
	}

	public void agregarMonstruoEnAtaque(Monstruo monstruo) {
		monstruo.colocarEnPosicionAtaque();
		campo.agregarMonstruo(monstruo);
	}

	public void agregarMonstruoEnDefensa(Monstruo monstruo) {
		monstruo.colocarEnPosicionDefensa();
		campo.agregarMonstruo(monstruo);
	}
	
	public void atacarA(Jugador oponente, int nroMonstruoAtacante, int nroMonstruoAtacado) {
		int diferenciaDePuntos = oponente.atacarse(campo.obtenerMonstruo(nroMonstruoAtacante), nroMonstruoAtacado);
		
		if (diferenciaDePuntos > 0) {
			puntosDeVida -= diferenciaDePuntos;
		}
	}
	
	public int atacarse(Monstruo atacante, int nroMonstruoAtacado) {
		int diferenciaDePuntos = atacante.atacarA(campo.obtenerMonstruo(nroMonstruoAtacado));
		
		if (diferenciaDePuntos < 0) {
			puntosDeVida += diferenciaDePuntos;
			return 0;
		}
		return diferenciaDePuntos;
	}
	
	public void agregarCartaMagicaOTrampa(Magica cartaMagica) {
		campo.agregarMagicaOTrampa(cartaMagica);
	}

	public void activarMagicaOTrampa(int nroDeCarta) {
		campo.obtenerMagicaOTrampa(nroDeCarta).realizarEfecto();
	}

}









