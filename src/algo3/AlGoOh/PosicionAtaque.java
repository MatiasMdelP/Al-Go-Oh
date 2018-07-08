package algo3.AlGoOh;

import algo3.AlGoOh.Exceptions.MonstruoNoPuedeAtacarException;
import javafx.scene.control.Button;

public class PosicionAtaque implements Posicion{
	

	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private boolean atacoEnEsteTurno;

	public PosicionAtaque(int puntosDeAtaque, int puntosDeDefensa) {
		this.puntosDeAtaque = puntosDeAtaque;
		this.puntosDeDefensa = puntosDeDefensa;
		atacoEnEsteTurno = false;
	}

	public Posicion ponerEnPosicionAtaque() {
		return this;
	}
	
	public Posicion ponerEnPosicionDefensa() {
		return new PosicionDefensa(puntosDeAtaque,puntosDeDefensa);
	}
	
	public int devolverDanio(int diferenciaDelEnfrentamiento) {
		return Math.abs(diferenciaDelEnfrentamiento);
	}

	public void efectuarDanio(int diferenciaDelEnfrentamiento, Jugador jugador, Monstruo monstruo ) {
		monstruo.mandarAlCementerio();
		jugador.reducirVida(Math.abs(diferenciaDelEnfrentamiento));
		jugador.mandarAlCementerioAlMonstruoDefinido();
	}

	public int calcularDiferenciaDeDanio(Posicion posicion){
		return posicion.calcularDanio(puntosDeAtaque);
	}
	
	public int calcularDanio(int puntos) {
		return puntosDeAtaque - puntos;
	}
	
	public void agregarPuntosDeAtaque(int puntos) {
		puntosDeAtaque += puntos;
	}
	
	public void agregarPuntosDeDefensa(int puntos) {
		puntosDeDefensa += puntos;
	}
	
	public int danioAtaque() {
		return puntosDeAtaque;
	}

	public void verificarEstado() {
		if (atacoEnEsteTurno) {
			throw new MonstruoNoPuedeAtacarException();
		}
		atacoEnEsteTurno = true;
	}

	public void rotarBoton(Button unBoton) {
		unBoton.setRotate(0);
	}
	
	public void pasarTurno() {
		atacoEnEsteTurno = false;
	}
}
