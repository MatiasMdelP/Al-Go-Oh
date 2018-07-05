package algo3.AlGoOh;

import algo3.AlGoOh.Efectos.Efecto;

public class BocaArriba implements Boca {

	public Boca darVuelta() {
		return new BocaAbajo();
	}

	public boolean getEstado() {
		return false;
	}

	public Boca ponerBocaAbajo() {
		return new BocaAbajo();
	}
	
	public void verificarEstado() {
	}

	@Override
	public Boca realizarEfectoDeVolteo(Efecto efecto, Campo campo, Campo campoOponente, Jugador unJugador,
			Jugador oponente) {
		return this;
	}
}
