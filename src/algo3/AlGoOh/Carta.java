package algo3.AlGoOh;

public abstract class Carta {
	protected boolean estaEnElCementerio;

	public Carta() {
		estaEnElCementerio = false;
	}
	public void mandarAlCementerio() {
		estaEnElCementerio = true;
	}

	public boolean estaEnElCementerio() {
		return estaEnElCementerio;
	}


}
