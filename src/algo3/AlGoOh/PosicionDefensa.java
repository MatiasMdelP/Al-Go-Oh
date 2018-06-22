package algo3.AlGoOh;

public class PosicionDefensa implements Posicion {
	
	@Override
	public Posicion ponerEnPosicionAtaque() {
		return new PosicionAtaque();
	}
	
	@Override
	public Posicion ponerEnPosicionDefensa() {
		return this;
	}
	
	@Override
	public int devolverDanio(int diferenciaDelEnfrentamiento) {
		if (diferenciaDelEnfrentamiento < 0)
			return 0;
		return diferenciaDelEnfrentamiento;
	}
	public void efectuarDanio(int diferenciaDelEnfrentamiento, Jugador jugador, Monstruo monstruo ) {
		monstruo.mandarAlCementerio();
		jugador.reducirVida(0);
		
	}
	@Override
	public int obtenerResistencia(int puntosDeAtaque, int puntosDeDefensa) {
		return puntosDeDefensa;
	}

	@Override
	public boolean estaEnAtaque() {
		return false;
	}
}
