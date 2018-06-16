package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.List;

public class Mazo {

	private List<Carta> baraja = new ArrayList<Carta>();
	
	public Carta tomarUnaCarta() {
		if (seQuedoSinCartas()) {
			throw new ElMazoNoTieneCartasException();
		}
		
		return (baraja.remove(0));
	}
	
	public void agregarUnaCartaAlMazo(Carta unaCarta) {
		baraja.add(unaCarta);
	}
	
	public boolean seQuedoSinCartas() {
		return (baraja.isEmpty());
	}

	public void inicializarMazo() {
		
	}
}
