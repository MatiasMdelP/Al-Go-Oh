package algo3.AlGoOh;

public class PosicionAtaque implements Posicion{
	
	private int puntosRecibirAtaque;

	public PosicionAtaque(int puntosDeAtaque) {
		puntosRecibirAtaque = puntosDeAtaque;
	}

	@Override
	public int devolverDanio(int diferenciaDelEnfrentamiento) {
		return Math.abs(diferenciaDelEnfrentamiento);
	}

	@Override
	public void efectuarDanio(int diferenciaDelEnfrentamiento, Jugador jugador, Monstruo monstruo ) {
		monstruo.mandarAlCementerio();
		jugador.reducirVida(Math.abs(diferenciaDelEnfrentamiento));
	}

	@Override
	public int obtenerResistencia(int puntosDeAtaque, int puntosDeDefensa) {
		return puntosDeAtaque;
	}

	@Override
	public boolean estaEnAtaque() {

		return true;
	}

}
