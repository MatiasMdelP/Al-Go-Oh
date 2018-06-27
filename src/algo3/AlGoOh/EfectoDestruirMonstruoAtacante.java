package algo3.AlGoOh;

public class EfectoDestruirMonstruoAtacante implements Efecto{
	
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente){
		campoOponente.mandarMonstruoDefinidoAlCementerio();
	}
	
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException {
		this.realizarse(campo, campoOponente, unJugador, oponente);
		throw new InterrumpirAtaqueException();
	}

	@Override
	public void modificarEstado(Estado estado) {
	}
}
