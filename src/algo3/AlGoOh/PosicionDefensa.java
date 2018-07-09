package algo3.AlGoOh;

import algo3.AlGoOh.Exceptions.MonstruoNoPuedeAtacarException;
import javafx.scene.control.Button;

public class PosicionDefensa implements Posicion {
	
	private int puntosDeAtaque;
	private int puntosDeDefensa;

	public PosicionDefensa(int puntosDeAtaque, int puntosDeDefensa) {
		this.puntosDeAtaque = puntosDeAtaque;
		this.puntosDeDefensa = puntosDeDefensa;
	}
		
	public Posicion ponerEnPosicionAtaque() {
		return new PosicionAtaque(puntosDeAtaque,puntosDeDefensa);
	}
	
	public Posicion ponerEnPosicionDefensa() {
		return this;
	}
	
	public int devolverDanio(int diferenciaDelEnfrentamiento) {
		if (diferenciaDelEnfrentamiento < 0)
			return 0;
		return diferenciaDelEnfrentamiento;
	}
	
	public void efectuarDanio(int diferenciaDelEnfrentamiento, Jugador jugador, Monstruo monstruo ) {
		monstruo.mandarAlCementerio();
		jugador.reducirVida(0);
		jugador.mandarAlCementerioAlMonstruoDefinido();
	}
	
	public int calcularDiferenciaDeDanio(Posicion posicion){
		return posicion.calcularDanio(puntosDeDefensa);
	}
	
	public int calcularDanio(int puntos) {
		return puntosDeDefensa - puntos;
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
		throw new MonstruoNoPuedeAtacarException();
	}

	public void rotarBoton(Button unBoton) {
		unBoton.setRotate(90);
	}
	
	public void pasarTurno() {}
}
