package algo3.AlGoOh;

import java.util.Iterator;

public class EfectoAgujeroOscuro implements Efecto{
	
	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		Iterator<Carta> iterador1 = campo.iterarMagicasYTrampas();
		Iterator<Monstruo> iterador2 = campo.iterarMonstruos();
		
		while (iterador1.hasNext()) {
			iterador1.next().mandarAlCementerio();
		}
		
		while (iterador2.hasNext()) {
			iterador2.next().mandarAlCementerio();
		}
		
		iterador1 = campoOponente.iterarMagicasYTrampas();
		iterador2 = campoOponente.iterarMonstruos();
		
		while (iterador1.hasNext()) {
			iterador1.next().mandarAlCementerio();
		}
		
		while (iterador2.hasNext()) {
			iterador2.next().mandarAlCementerio();
		}
	}

	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException{}


}
