package algo3.AlGoOh;

public class Magica extends Carta {
	
	private Efecto efecto;


	public Magica(Efecto efecto) {
		super();
		this.efecto = efecto;
		bocaAbajo = true;
	}
	
	public void darVuelta() {
		bocaAbajo = !bocaAbajo;
		realizarEfecto();
	}

	
	public boolean realizarEfecto() {
		efecto.realizarse();
		return !bocaAbajo;
	}
}