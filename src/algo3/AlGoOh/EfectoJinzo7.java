package algo3.AlGoOh;

public class EfectoJinzo7 implements Efecto {

	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		oponente.reducirVida(500);
	}

	public void realizarEfectoDeVolteo (Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {}
	
	@Override
	public void modificarEstado(Estado estado) {
	}
	
}
