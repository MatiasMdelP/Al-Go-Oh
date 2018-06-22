package algo3.AlGoOh;

public class Magica extends Carta {
	
	public Magica(String unNombre, Efecto unEfecto) {
		super(unNombre, unEfecto);
	}

	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException{
		
	}
	
	public boolean esTrampa() {
		return false;
	}
	
	public boolean esParteDelExodia() {
		return false;
	}

	@Override
	public boolean activarTrampa(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente)
			throws InterrumpirAtaqueException {
		return false;
	}
}