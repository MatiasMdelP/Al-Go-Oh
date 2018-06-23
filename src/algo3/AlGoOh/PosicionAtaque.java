package algo3.AlGoOh;

public class PosicionAtaque implements Posicion{
	

	private int puntosDeAtaque;
	private int puntosDeDefensa;

	public PosicionAtaque(int puntosDeAtaque, int puntosDeDefensa) {
		this.puntosDeAtaque = puntosDeAtaque;
		this.puntosDeDefensa = puntosDeDefensa;
	}

	@Override
	public Posicion ponerEnPosicionAtaque() {
		return this;
	}
	
	@Override
	public Posicion ponerEnPosicionDefensa() {
		return new PosicionDefensa(puntosDeAtaque,puntosDeDefensa);
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
	public boolean estaEnAtaque() {

		return true;
	}

	@Override
	public int calcularDiferenciaDeDanio(Posicion posicion){
		return posicion.calcularDanio(puntosDeAtaque);
	}
	
	@Override
	public int calcularDanio(int puntos) {
		return puntosDeAtaque - puntos;
	}
	
	@Override
	public void agregarPuntos(int puntos) {
		puntosDeAtaque += puntos;
		
	}
	
	@Override
	public int danioAtaque() {
		return puntosDeAtaque;
	}


}
