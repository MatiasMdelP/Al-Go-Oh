package algo3.AlGoOh;

public class Magica extends Carta {
	
	public boolean realizarEfecto() {
		if (bocaAbajo) {
			return false;
		}
		return true;
	}
}