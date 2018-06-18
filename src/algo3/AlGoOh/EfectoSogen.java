package algo3.AlGoOh;

import java.util.Iterator;

public class EfectoSogen implements Efecto {

	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		Iterator<Monstruo> iterador = campo.iterarMonstruos();
		
		while(iterador.hasNext()) {
			iterador.next().agregarPuntosDeDefensa(500);
		}
		
		iterador = campoOponente.iterarMonstruos();
		
		while(iterador.hasNext()) {
			iterador.next().agregarPuntosDeAtaque(200);
		}
	}
}
