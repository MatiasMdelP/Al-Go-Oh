package algo3.AlGoOh.Efectos;

import algo3.AlGoOh.Campo;
import algo3.AlGoOh.Estado;
import algo3.AlGoOh.Jugador;

public class EfectoOllaDeLaCodicia implements Efecto{
	
	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		unJugador.tomarUnaCartaDelMazo();
		unJugador.tomarUnaCartaDelMazo();
	}

	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente){}
	
	@Override
	public void modificarEstado(Estado estado) {
	}
}
