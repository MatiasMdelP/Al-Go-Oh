package algo3.AlGoOh;

public abstract class Carta {
	
	protected boolean bocaAbajo;
	protected boolean estaEnElCementerio;
	protected Efecto efecto;
	protected Campo campo;
	protected Campo campoOponente;

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
	
	public boolean realizarEfecto() {
		efecto.realizarse(campo, campoOponente);
		this.mandarAlCementerio();
		return !bocaAbajo;
	}
	
	public void agregarAlCampo(Campo unCampo, Campo unCampoOponente) {
		campo = unCampo;
		campoOponente = unCampoOponente;
	}
}
