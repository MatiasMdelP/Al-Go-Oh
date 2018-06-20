package algo3.AlGoOh;

import java.util.Iterator;

public class EfectoWasteland implements Efecto {

	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		Iterator<Monstruo> iterador = campo.iterarMonstruos();
		
		iterador.forEachRemaining(e -> e.agregarPuntosDeAtaque(200));
		iterador = campoOponente.iterarMonstruos();
		iterador.forEachRemaining(e -> e.agregarPuntosDeDefensa(300));

	}
	
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente){}
}
