package algo3.AlGoOh;

public class PosicionDefensa implements Posicion {
	
	private int puntosDeAtaque;
	private int puntosDeDefensa;

	public PosicionDefensa(int puntosDeAtaque, int puntosDeDefensa) {
		this.puntosDeAtaque = puntosDeAtaque;
		this.puntosDeDefensa = puntosDeDefensa;
	}
		
	@Override
	public Posicion ponerEnPosicionAtaque() {
		return new PosicionAtaque(puntosDeAtaque,puntosDeDefensa);
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
	
	@Override
	public int calcularDiferenciaDeDanio(Posicion posicion){
		return posicion.calcularDanio(puntosDeDefensa);
	}
	
	@Override
	public int calcularDanio(int puntos) {
		return puntosDeDefensa - puntos;
	}

	@Override
	public void agregarPuntos(int puntos) {
		puntosDeDefensa += puntos;
		
	}

	@Override
	public int danioAtaque() {
		return puntosDeAtaque;
	}


}
