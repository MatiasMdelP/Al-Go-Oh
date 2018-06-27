package algo3.AlGoOh.Efectos;

import algo3.AlGoOh.Campo;
import algo3.AlGoOh.Estado;
import algo3.AlGoOh.Jugador;
import algo3.AlgoOh.Exceptions.InterrumpirAtaqueException;

public class EfectoCilindroMagico implements Efecto {

	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		int danio = campoOponente.calcularDanio();
		oponente.reducirVida(danio);
	}

	public void realizarEfectoDeVolteo (Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException {
		this.realizarse(campo, campoOponente, unJugador, oponente);
		throw new InterrumpirAtaqueException();
	}
	
	@Override
	public void modificarEstado(Estado estado) {
	}
}
