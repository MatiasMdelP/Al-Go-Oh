package algo3.AlGoOh.Efectos;

import java.util.List;

import algo3.AlGoOh.Campo;
import algo3.AlGoOh.Estado;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Monstruo;
import algo3.AlGoOh.Exceptions.InterrumpirAtaqueException;

public interface Efecto {

	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente);
	
	public void realizarEfectoDeVolteo (Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException;

	public void modificarEstado(Estado estado);
	
	public void sacrificar(List<Monstruo>  monstruosASacrificar, Monstruo monstruo);
}
