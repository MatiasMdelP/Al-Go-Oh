package algo3.AlGoOh;

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
