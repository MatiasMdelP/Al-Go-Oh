package algo3.AlGoOh.Efectos;

import java.util.Iterator;

import algo3.AlGoOh.Campo;
import algo3.AlGoOh.Estado;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Monstruo;

public class EfectoSogen implements Efecto {

	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		Iterator<Monstruo> iterador = campo.iterarMonstruos();
		
		iterador.forEachRemaining(e -> e.agregarPuntosDeDefensa(500));
		iterador = campoOponente.iterarMonstruos();
		iterador.forEachRemaining(e -> e.agregarPuntosDeAtaque(200));
		
		/*while(iterador.hasNext()) {
			iterador.next().agregarPuntosDeDefensa(500);
		}
		while(iterador.hasNext()) {
			iterador.next().agregarPuntosDeAtaque(200);
		}
		*/
		
		

	}

	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente){}
	
	@Override
	public void modificarEstado(Estado estado) {
	}
}
