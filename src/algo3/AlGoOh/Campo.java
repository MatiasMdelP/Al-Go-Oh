package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Campo {
	
	private List<Monstruo> zonaMonstruos = new ArrayList<Monstruo>();
	private List<Carta> zonaMagicasYTrampas = new ArrayList<Carta>();
	private List<Carta> cartasEnMano = new ArrayList<Carta>();
	private Mazo mazo;
	private DeCampo zonaDeCampo;
	
	public Campo(Mazo unMazoDeCartas) {
		mazo = unMazoDeCartas;
	}
	
	public Monstruo obtenerMonstruo(int nroDeMonstruo) {
		return zonaMonstruos.get(nroDeMonstruo);
	}
	
	public Carta obtenerMagicaOTrampa(int nroDeCarta) {
		return zonaMagicasYTrampas.get(nroDeCarta);
	}
	
	public void agregarMonstruo(Monstruo monstruo) throws MonstruosInsuficientesParaSacrificioException {
		monstruo.efectuarSacrificios(zonaMonstruos);
		zonaMonstruos.add(monstruo);
	}
	
	public void agregarMagicaOTrampa(Carta carta) {
		zonaMagicasYTrampas.add(carta);
	}
	
	public void tomarUnaCartaDelMazo() {
		cartasEnMano.add(mazo.tomarUnaCarta());
	}

	public void mandarMonstruoAlCementerio(int nroDeCarta) {
		zonaMonstruos.remove(nroDeCarta).mandarAlCementerio();
	}
	
	public void mandarMagicaOTrampaAlCementerio(int nroDeCarta) {
		zonaMagicasYTrampas.remove(nroDeCarta).mandarAlCementerio();
	}
	
	public void mandarMagicaOTrampaAlCementerio(String nombreDeLaCarta) {
		mandarMagicaOTrampaAlCementerio(buscarUnaCartaPorNombre(zonaMagicasYTrampas, nombreDeLaCarta));
	}
	
	private int buscarUnaCartaPorNombre(List<Carta> zonaARecorrer, String nombreDeLaCarta) {
		for (int i = 0; i < zonaARecorrer.size(); i++) {
			if (zonaARecorrer.get(i).seLlama(nombreDeLaCarta)) {
				return i;
			}
		}
		
		throw new Error();
	}
	
	public int obtenerCantidadDeCartasEnLaMano() {
		return (cartasEnMano.size());
	}
	
	public Iterator<Monstruo> iterarMonstruos() 
	{
		return zonaMonstruos.iterator();
	}
	
	public Iterator<Carta> iterarMagicasYTrampas() 
	{
		return zonaMagicasYTrampas.iterator();
	}

	public void agregarDeCampo(DeCampo cartaCampo) {
		zonaDeCampo = cartaCampo;
	}
}





