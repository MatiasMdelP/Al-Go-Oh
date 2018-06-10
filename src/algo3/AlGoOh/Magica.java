package algo3.AlGoOh;

import java.util.function.BooleanSupplier;

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
	public boolean realizarEfecto() {
		if (bocaAbajo) {
			return false;
		}
		return true;
	}
}