package algo3.AlGoOh;

import java.beans.IntrospectionException;
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
	
			Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", null, 3,new InvocacionNormal(), 600, 900);
			Monstruo monoAcrobata = new Monstruo("Mono Acrobata", null, 3,new InvocacionNormal(), 1000, 1800);
			Monstruo dragonBlanco = new Monstruo("Dragon Blanco De Ojos Azules", null, 8, new Invocacion2Sacrificios(), 3000, 2500);
			Magica agujeroOscuro = new Magica("Agujero Oscuro", new EfectoAgujeroOscuro());
			Monstruo dragonDefinitivo = new Monstruo("Dragon Definitivo De Ojos Azules", null, 12, 
					new InvocacionDragonDefinitivoDeOjosAzules(), 4500, 3800);
		
			agregarUnaCartaAlMazo(huevoMonstruoso);
			agregarUnaCartaAlMazo(monoAcrobata);
			agregarUnaCartaAlMazo(agujeroOscuro);
			agregarUnaCartaAlMazo(dragonBlanco);
			agregarUnaCartaAlMazo(dragonDefinitivo);
	}
}
