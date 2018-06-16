package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	
	private List<Monstruo> zonaMonstruos = new ArrayList<Monstruo>();
	private List<Carta> zonaMagicasYTrampas = new ArrayList<Carta>();
	private List<Carta> cartasEnMano = new ArrayList<Carta>();
	private Mazo mazo = new Mazo();
	
	public Campo() {
		mazo.inicializarMazo();
	}
	
	public Monstruo obtenerMonstruo(int nroDeMonstruo) {
		return zonaMonstruos.get(nroDeMonstruo);
	}
	
	public Carta obtenerMagicaOTrampa(int nroDeCarta) {
		return zonaMagicasYTrampas.get(nroDeCarta);
	}
	
	public void agregarMonstruo(Monstruo monstruo) {
		monstruo.efectuarSacrificios(zonaMonstruos);
		zonaMonstruos.add(monstruo);
	}
	
	public void agregarMagicaOTrampa(Carta carta) {
		zonaMagicasYTrampas.add(carta);
	}
	
	public Carta tomarUnaCartaDelMazo() {
		return mazo.tomarUnaCarta();
	}

	public void MatarATodos() {
		for(Monstruo m: zonaMonstruos) {
			m.mandarAlCementerio();
		}
	}
}
