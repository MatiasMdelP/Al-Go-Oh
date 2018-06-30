package algo3.AlGoOh.Efectos;

import algo3.AlGoOh.Campo;
import algo3.AlGoOh.Estado;
import algo3.AlGoOh.Jugador;

public class EfectoAumentar500Ataque implements Efecto{

	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		campo.obtenerMonstruo().agregarPuntosDeAtaque(500);
	}
	
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		this.realizarse(campo, campoOponente, unJugador, oponente);
	}
	
	@Override
	public void modificarEstado(Estado estado) {
	}
}