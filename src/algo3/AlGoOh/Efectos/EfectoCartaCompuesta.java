package algo3.AlGoOh.Efectos;

import algo3.AlGoOh.Campo;
import algo3.AlGoOh.Estado;
import algo3.AlGoOh.Jugador;
import algo3.AlgoOh.Exceptions.InterrumpirAtaqueException;

public class EfectoCartaCompuesta implements Efecto {

	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {

	}

	@Override
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente)
			throws InterrumpirAtaqueException {

	}

	@Override
	public void modificarEstado(Estado estado) {
		estado.agregarComponenteCartaCompuesta();

	}

}
