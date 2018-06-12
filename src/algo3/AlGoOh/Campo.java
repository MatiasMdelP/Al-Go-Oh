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
		monstruo.colocarEnCampo(this);
		monstruos.add(monstruo);
	}
	
	public void agregarMonstruoEnDefensa(Monstruo monstruo) {
		//Idem agregarEnAtaque
		monstruo.colocarEnPosicionDefensa();
		monstruos.add(monstruo);
	}

	public Monstruo getMonstruo(int i) {
		return monstruos.get(i);
	}

	public void enviarAlCementerio(Carta carta) {
		//Monstruo sigue teniendo el atributo de "cementerio"? Como lo mando ahi?
		cementerio.add(carta);
		carta.mandarAlCementerio();
	}

	public int combatir(int nroMonstruoAtacante, int nroMonstruoAtacado) {
		Monstruo atacado = monstruos.get(nroMonstruoAtacado);
		Monstruo atacante = monstruos.get(nroMonstruoAtacante);
		int dif = atacante.atacar(atacado);
		return dif;
	}

	public void agregarMagica(Carta agujeroNegro) {
			
	}

	public void agregarMagicaBocaArriba(Carta agujeroNegro) {
		magicaYTrampas.add(agujeroNegro);
		agujeroNegro.darVuelta();
		enviarAlCementerio(agujeroNegro);
		
	}

	public List<Monstruo> getMonstruos() {
		return monstruos;
	}
}
