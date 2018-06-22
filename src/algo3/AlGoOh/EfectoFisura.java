package algo3.AlGoOh;

import java.util.Iterator;

public class EfectoFisura implements Efecto{

	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		Iterator<Monstruo> iterador1 = campoOponente.iterarMonstruos();
		
		Monstruo monstruoConMenorAtaque = null;
		Monstruo monstruoActual = null;
		
		if (iterador1.hasNext()) {
			monstruoConMenorAtaque = iterador1.next();
		}
	
		while (iterador1.hasNext()) {
			monstruoActual = iterador1.next();
			if (monstruoActual.tieneMenorAtaqueQue(monstruoConMenorAtaque)) {
				monstruoConMenorAtaque = monstruoActual;
			}
		}
		
		campoOponente.mandarMonstruoAlCementerio(monstruoConMenorAtaque);
	}

	public void realizarEfectoDeVolteo (Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente){}
}
