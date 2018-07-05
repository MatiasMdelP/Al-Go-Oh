package algo3.AlGoOh.Efectos;

import algo3.AlGoOh.Campo;
import algo3.AlGoOh.Estado;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Exceptions.InterrumpirAtaqueException;
import algo3.AlGoOh.Monstruo;
import java.util.List;

public class EfectoDestruirMonstruoAtacante implements Efecto{
	
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente){
		campoOponente.mandarMonstruoDefinidoAlCementerio();
	}
	
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException {
		this.realizarse(campo, campoOponente, unJugador, oponente);
		throw new InterrumpirAtaqueException();
	}

	public void modificarEstado(Estado estado) {
	}

	public void sacrificar(List<Monstruo>  monstruosASacrificar, Monstruo monstruo) {
		
	}
}
