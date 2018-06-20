package algo3.AlGoOh;

public class EfectoDestruirMonstruoAtacante implements Efecto{
	
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente, int nroMonstruoAtacante) throws InterrumpirAtaqueException{
		Monstruo monstruoAtacante = campoOponente.obtenerMonstruo(nroMonstruoAtacante);
		campo.mandarMonstruoAlCementerio(nroMonstruoAtacante);
		oponente.reducirVida(monstruoAtacante.getDanio());
		throw new InterrumpirAtaqueException();
	}
	
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente, int nroMonstruoAtacante) throws InterrumpirAtaqueException {
		this.realizarse(campo, campoOponente, unJugador, oponente, nroMonstruoAtacante);
	}

}
