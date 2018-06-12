package algo3.AlGoOh;

public abstract class Carta {
	
	protected boolean bocaAbajo;
	protected boolean estaEnElCementerio;
	protected Campo campo;

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

	public void colocarEnCampo(Campo campo) {
		this.campo = campo;
	}
}
