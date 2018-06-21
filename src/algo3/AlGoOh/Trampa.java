package algo3.AlGoOh;

public class Trampa extends Carta{
	
	public Trampa(String unNombre, Efecto unEfecto) {
		super(unNombre, unEfecto);
		bocaAbajo = true;
	}
	
	public boolean esTrampa() {
		return true;
	}

	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException {
		this.darVuelta();
		efecto.realizarEfectoDeVolteo(campo, campoOponente, unJugador, oponente);
	}
	
	public boolean esParteDelExodia() {
		return false;
	}
}
