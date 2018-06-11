package algo3.AlGoOh;

import java.util.List;

public class Campo {

	private List<Monstruo> monstruos;
	private List<Carta> magicaYTrampas;//Habria que poner un tipo que abarque a ambas pero no a Monstruo
	private List<Carta> cementerio;
	
	
	public Campo() {
		monstruos = new ArrayList<Monstruo>();
		magicaYTrampas = new ArrayList<Carta>();
		cementerio = new ArrayList<Carta>();
	}
	
	public void agregarMonstruoEnAtaque(Monstruo monstruo) {
		//Excepcion si la cantidad de cartas supera 5
		monstruo.colocarEnPosicionAtaque();
		monstruos.add(monstruo);
	}
	
	public void agregarMonstruoEnDefensa(Monstruo monstruo) {
		//Idem agregarEnAtaque
		monstruo.colocarEnPosicionDefensa();
		monstruos.add(monstruo);
	}

	public int atacarMonstruo(int i, Monstruo atacante) {
		Monstruo atacado = monstruos.get(i);
		return atacante.atacar(atacado);
	}

	public Monstruo getMonstruo(int i) {
		return monstruos.get(i);
	}
}
