package algo3.AlGoOh;

public class Magica extends Carta {
	
	public Magica(String unNombre, Efecto unEfecto) {
		super(unNombre, unEfecto);
	}

	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException, NoPuedeRealizarseEfectoDeVolteoException{
		throw new NoPuedeRealizarseEfectoDeVolteoException();
	}
	
}