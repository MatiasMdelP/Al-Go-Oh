package algo3.AlGoOh.Efectos;

import algo3.AlGoOh.Campo;
import algo3.AlGoOh.Estado;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Monstruo;
import java.util.List;

public class EfectoCartaCompuesta implements Efecto {

	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {

	}

	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente){
		
	}

	public void modificarEstado(Estado estado) {
		estado.agregarComponenteCartaCompuesta();
	}

	public void sacrificar(List<Monstruo>  monstruosASacrificar, Monstruo monstruo) {
		
	}

}
