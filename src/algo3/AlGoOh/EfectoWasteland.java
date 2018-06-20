package algo3.AlGoOh;

import java.util.Iterator;

public class EfectoWasteland implements Efecto {

	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente, int nroMonstruoAtacante) {
		Iterator<Monstruo> iterador = campo.iterarMonstruos();
		
		while(iterador.hasNext())
		{
			iterador.next().agregarPuntosDeAtaque(200);
		}
		
		iterador = campoOponente.iterarMonstruos();
		
		while(iterador.hasNext())
		{
			iterador.next().agregarPuntosDeDefensa(300);
		}
	}
	
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente, int nroMonstruoAtacante) throws InterrumpirAtaqueException{}
}
