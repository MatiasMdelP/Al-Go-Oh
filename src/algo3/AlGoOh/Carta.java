package algo3.AlGoOh;

public abstract class Carta {
	
	protected boolean bocaAbajo;
	protected boolean estaEnElCementerio;

	public Carta() {
		bocaAbajo = false;
		estaEnElCementerio = false;
	}
	public void mandarAlCementerio() {
		estaEnElCementerio = true;
	}

	public boolean estaEnElCementerio() {
		return estaEnElCementerio;
	}

	public boolean estaBocaAbajo() {
		return bocaAbajo;
	}
	
	public void darVuelta() {
		bocaAbajo = !bocaAbajo;
	}

}
