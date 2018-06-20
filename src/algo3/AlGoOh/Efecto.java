package algo3.AlGoOh;

public interface Efecto {

	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente, int nroMonstruoAtacante) throws InterrumpirAtaqueException;
	
	public void realizarEfectoDeVolteo (Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente, int nroMonstruoAtacante) throws InterrumpirAtaqueException;
}
