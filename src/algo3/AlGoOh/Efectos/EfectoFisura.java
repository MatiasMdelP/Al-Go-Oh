package algo3.AlGoOh.Efectos;

import java.util.Iterator;

import algo3.AlGoOh.Campo;
import algo3.AlGoOh.Estado;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Monstruo;
import algo3.AlGoOh.Exceptions.CartaNoEncontradaException;

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
		
		try {
			campoOponente.mandarMonstruoAlCementerio(monstruoConMenorAtaque);
		} catch (CartaNoEncontradaException e) {
			
		}
	}

	public void realizarEfectoDeVolteo (Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente){}
	
	@Override
	public void modificarEstado(Estado estado) {
	}
}
