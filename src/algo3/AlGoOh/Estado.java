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
	public boolean ganoElJuego() {
		return estado;
	}

	public void actualizarEstado() {
		List<Carta> cartasEnMano =jugador.getListaDeCartasEnMano();
		for(Carta carta: cartasEnMano) {
			carta.modificarEstado(this);
		}
	}
	public void agregarComponenteCartaCompuesta() {
		contador++;
		if(contador == 5) {
			estado = true;	
		}
	}
	public void declararComoGanador() {
		estado = true;		
	}

}