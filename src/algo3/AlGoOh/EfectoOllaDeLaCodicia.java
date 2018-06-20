package algo3.AlGoOh;

public class EfectoOllaDeLaCodicia implements Efecto{
	
	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente, int nroMonstruoAtacante) {
		campo.tomarUnaCartaDelMazo();
		campo.tomarUnaCartaDelMazo();
	}

	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente, int nroMonstruoAtacante) throws InterrumpirAtaqueException{}
}
