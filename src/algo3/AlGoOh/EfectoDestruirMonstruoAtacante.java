package algo3.AlGoOh;

public class EfectoDestruirMonstruoAtacante implements Efecto{
	
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException{
		campoOponente.mandarMonstruoDefinidoAlCementerio();
		throw new InterrumpirAtaqueException();
	}
	
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException {
		this.realizarse(campo, campoOponente, unJugador, oponente);
	}

}
