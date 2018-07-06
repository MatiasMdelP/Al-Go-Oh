package algo3.AlGoOh;

import java.util.List;

public class Estado {

	private Jugador jugador;
	private int contador;
	private boolean estado;
	
	public Estado(Jugador jugador) {
		this.jugador = jugador;
		contador = 0;
		estado = false;
	}
	
	private void actualizarEstadoCartas() {
		contador = 0;
		List<Carta> cartasEnMano = jugador.getListaDeCartasEnMano();
		for(Carta carta: cartasEnMano) {
			carta.modificarEstado(this);
		}
	}
	
	public boolean ganoElJuego() {
		return estado;
	}

	public void agregarComponenteCartaCompuesta() {
		contador++;
		if(contador == 5) {
			declararComoGanador();
		}
	}
	
	public void declararComoGanador() {
		estado = true;		
	}
	
	public void actualizarEstado() {
		actualizarEstadoCartas();
	}

}