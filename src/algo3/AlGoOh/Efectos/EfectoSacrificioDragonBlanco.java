package algo3.AlGoOh.Efectos;

import algo3.AlGoOh.Campo;
import algo3.AlGoOh.Estado;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Exceptions.InterrumpirAtaqueException;
import algo3.AlGoOh.Monstruo;
import java.util.List;


public class EfectoSacrificioDragonBlanco implements Efecto {

	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente)
			throws InterrumpirAtaqueException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarEstado(Estado estado) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sacrificar(List<Monstruo>  monstruosASacrificar, Monstruo monstruo) {
		monstruosASacrificar.add(monstruo);		
	}

}
