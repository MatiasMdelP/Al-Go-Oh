package algo3.AlGoOh;

import algo3.AlGoOh.Efectos.Efecto;
import algo3.AlgoOh.Exceptions.InterrumpirAtaqueException;

public class Trampa extends Carta{
	
	public Trampa(String unNombre, Efecto unEfecto) {
		super(unNombre, unEfecto);
	}
	
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException {
		
	}
}
