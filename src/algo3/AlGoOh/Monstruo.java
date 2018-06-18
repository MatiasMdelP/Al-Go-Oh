package algo3.AlGoOh;

import java.util.List;

public class Monstruo extends Carta {
	
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private boolean posicionAtaque;
	private Posicion posicion;
	private int puntosRecibirAtaque;
	private Invocacion invocacion;
	
	public Monstruo(String unNombre, int cantidadDeEstrellas,Invocacion invocacionIngresada, int ataque, int defensa) {
		super(unNombre);
		invocacion = invocacionIngresada;
		puntosDeAtaque = ataque;
		puntosDeDefensa = defensa;
		estaEnElCementerio = false;
	}

	public void efectuarSacrificios(List<Monstruo> monstruos) throws MonstruosInsuficientesParaSacrificioException {
		invocacion.efectuarSacrificios(monstruos);
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
	
	public int atacarA(Monstruo atacado) {
		int diferenciaDelEnfrentamiento = atacado.recibirAtaque(puntosDeAtaque);
		if (diferenciaDelEnfrentamiento >= 0) {
			this.mandarAlCementerio();
		}
		return atacado.posicion.devolverDanio(diferenciaDelEnfrentamiento);
		//Cero si ambos mueren o si el atacado esta en posicion de defensa
		//Negativo si el atacado muere
		//positivo si el atacante muere
	}
	
	
	private int recibirAtaque(int puntosDelAtacante) {
		int dif = puntosRecibirAtaque - puntosDelAtacante;
		if(dif <= 0) {
			this.mandarAlCementerio();
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
