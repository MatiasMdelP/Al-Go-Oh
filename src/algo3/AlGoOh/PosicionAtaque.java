package algo3.AlGoOh;

public class PosicionAtaque implements Posicion{
	
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

}
