package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	
	private List<Monstruo> monstruos = new ArrayList<Monstruo>();
	
	private List<Carta> magicasYTrampas = new ArrayList<Carta>();
	
	public Monstruo obtenerMonstruo(int nroDeMonstruo) {
		return monstruos.get(nroDeMonstruo);
	}
	
	public Carta obtenerMagicaOTrampa(int nroDeCarta) {
		return magicasYTrampas.get(nroDeCarta);
	}
	
	public void agregarMonstruo(Monstruo monstruo) {
		monstruos.add(monstruo);
	}
	
	public void agregarMagicaOTrampa(Carta carta) {
		magicasYTrampas.add(carta);
	}

	public void MatarATodos() {
		for(Monstruo m: monstruos) {
			m.mandarAlCementerio();
		}
	}
}
