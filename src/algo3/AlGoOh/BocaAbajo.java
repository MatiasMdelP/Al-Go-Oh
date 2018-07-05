package algo3.AlGoOh;

import algo3.AlGoOh.Efectos.Efecto;
import algo3.AlGoOh.Exceptions.MonstruoNoPuedeAtacarException;

public class BocaAbajo implements Boca {

	public Boca darVuelta() {
		return new BocaArriba();
	}

	public boolean getEstado() {
		return true;
	}

	public Boca ponerBocaAbajo() {
		return this;
	}

	public void verificarEstado() {
		throw new MonstruoNoPuedeAtacarException();
	}

	public Boca realizarEfectoDeVolteo(Efecto efecto, Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		Boca boca = darVuelta();
		efecto.realizarEfectoDeVolteo(campo, campoOponente, unJugador, oponente);
		return boca;
	}
	
}
