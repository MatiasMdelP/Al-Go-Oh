package algo3.AlGoOh;

public interface Efecto {

	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente);
	
	public void realizarEfectoDeVolteo (Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException;

	public void modificarEstado(Estado estado);
}
