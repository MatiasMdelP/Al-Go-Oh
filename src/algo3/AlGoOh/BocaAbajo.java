package algo3.AlGoOh;

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
	
}
