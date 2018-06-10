package algo3.AlGoOh;

public class Jugador {
	
	private int puntosDeVida;
	
	public Jugador() {
		puntosDeVida = 8000;
	}

	public int obtenerPuntosDeVida() {
		return puntosDeVida;
	}

	public void descontarPuntosDeVida(int puntosPerdidos) {
		puntosDeVida = puntosDeVida - puntosPerdidos; // Despues hay que chequear como hacer si (puntosPerdidos > puntosDeVida)
	}
}
