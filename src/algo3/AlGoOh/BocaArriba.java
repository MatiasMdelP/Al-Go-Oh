package algo3.AlGoOh;

public class BocaArriba implements Boca {

	@Override
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
}
