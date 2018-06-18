package algo3.AlGoOh;

import java.util.List;

public class Monstruo extends Carta {
	
	private Estrellas estrellas;
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private boolean posicionAtaque;
	private Posicion posicion;
	private int puntosRecibirAtaque;
	
	public Monstruo(String unNombre, int cantidadDeEstrellas, int ataque, int defensa) {
		super(unNombre);
		estrellas = new Estrellas(cantidadDeEstrellas);
		puntosDeAtaque = ataque;
		puntosDeDefensa = defensa;
		estaEnElCementerio = false;
	}

	public void efectuarSacrificios(List<Monstruo> monstruos) {
		estrellas.efectuarSacrificios(monstruos);
	}
	
	public void colocarEnPosicionAtaque() {
		posicion = new PosicionAtaque();
		posicionAtaque = true;
		puntosRecibirAtaque = puntosDeAtaque;
	}
	
	public void colocarEnPosicionDefensa() {
		posicion = new PosicionDefensa();
		posicionAtaque = false;
		puntosRecibirAtaque = puntosDeDefensa;
	}

	public boolean estaEnPosicionDeAtaque() {
		return posicionAtaque;
	}
	
	public int atacarA(Monstruo atacado, Jugador jugadorAtacante, Jugador jugadorAtacado) {
		int diferenciaDelEnfrentamiento = atacado.recibirAtaque(puntosDeAtaque,jugadorAtacado);
		if (diferenciaDelEnfrentamiento >= 0) {
			this.posicion.efectuarDanio(diferenciaDelEnfrentamiento,jugadorAtacante,this);
		}
		return atacado.posicion.devolverDanio(diferenciaDelEnfrentamiento); //deberia sacarse pero los deje para que pase por el momento las pruebas de monstruo
	}
	
	
	private int recibirAtaque(int puntosDelAtacante, Jugador jugadorAtacado) {
		int dif = puntosRecibirAtaque - puntosDelAtacante;
		if(dif <= 0) {
			this.posicion.efectuarDanio(dif,jugadorAtacado,this);
		}
		return dif;
	}

	public void agregarPuntosDeAtaque(int puntos) {
		puntosDeAtaque += puntos;
	}
	
	public void agregarPuntosDeDefensa(int puntos) {
		puntosDeDefensa += puntos;
	}
}
