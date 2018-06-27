package algo3.AlGoOh;

import java.util.List;

public class Estado {

	private Jugador jugador;
	private int contador;
	
	public Estado(Jugador jugador) {
		this.jugador = jugador;
		contador = 0;
		
	}
	public boolean ganoElJuego() {
		return (contador == 5);
	}

	public void actualizarEstado() {
		List<Carta> cartasEnMano =jugador.getListaDeCartasEnMano();
		for(Carta carta: cartasEnMano) {
			carta.modificarEstado(this);
		}
	}
	public void agregarComponente() {
		contador++;
		
	}

}