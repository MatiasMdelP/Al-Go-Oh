package algo3.AlGoOh;

public abstract class Carta {
	
	protected boolean bocaAbajo;
	protected boolean estaEnElCementerio;
	protected String nombre;
	protected Efecto efecto;
	protected Campo campo;
	protected Campo campoOponente;

	public Carta(String nombreDeLaCarta) {
		nombre = nombreDeLaCarta;
		bocaAbajo = false;
		estaEnElCementerio = false;
	}
		
	public void mandarAlCementerio(){
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
	
	public boolean seLlama(String nombreDeUnaCarta) {
		return (nombreDeUnaCarta == nombre);
	}
	
	public void agregarAlCampo(Campo unCampo, Campo unCampoOponente) {
		campo = unCampo;
		campoOponente = unCampoOponente;
	}
}
