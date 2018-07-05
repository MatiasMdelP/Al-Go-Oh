package algo3.AlGoOh.Efectos;

import java.util.Iterator;

import algo3.AlGoOh.Campo;
import algo3.AlGoOh.Estado;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Monstruo;

import algo3.AlGoOh.Monstruo;
import java.util.List;

public class EfectoWasteland implements Efecto {

	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		Iterator<Monstruo> iterador = campo.iterarMonstruos();
		
		iterador.forEachRemaining(e -> e.agregarPuntosDeAtaque(200));
		iterador = campoOponente.iterarMonstruos();
		iterador.forEachRemaining(e -> e.agregarPuntosDeDefensa(300));

	}
	
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente){}
	
	@Override
	public void modificarEstado(Estado estado) {
	}

	@Override
	public void sacrificar(List<Monstruo>  monstruosASacrificar, Monstruo monstruo) {
		// TODO Auto-generated method stub
		
	}
}
