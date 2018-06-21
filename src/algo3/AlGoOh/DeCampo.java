package algo3.AlGoOh;

public class DeCampo extends Carta {
	
	public DeCampo(String unNombre, Efecto unEfecto) {
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
}
