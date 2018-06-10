package algo3.AlGoOh;

public class Magica extends Carta {
	private boolean bocaAbajo;

	public Magica() {
		bocaAbajo = false;
	}
	public boolean estaBocaAbajo() {
		return bocaAbajo;
	}
	public void darVuelta() {
		bocaAbajo = !bocaAbajo;
		
	}
}