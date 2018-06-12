package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.List;

public class Campo {

	private List<Monstruo> monstruos = new ArrayList<Monstruo>();
	private List<Carta> magicaYTrampas = new ArrayList<Carta>();//Habria que poner un tipo que abarque a ambas pero no a Monstruo
	private List<Carta> cementerio = new ArrayList<Carta>();
	
	
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
		int diferenciaDePuntos = atacante.atacar(atacado);
		if (diferenciaDePuntos > 0) {
			monstruos.remove(i);
			cementerio.add(atacado);
		}
		return diferenciaDePuntos;
	}

	public Monstruo getMonstruo(int i) {
		return monstruos.get(i);
	}

	public void enviarAlCementerio(int i) {
		//Monstruo sigue teniendo el atributo de "cementerio"? Como lo mando ahi?
		cementerio.add(monstruos.remove(i));
	}
}
