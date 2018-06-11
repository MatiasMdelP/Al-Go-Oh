package algo3.AlGoOh;

public class Monstruo extends Carta {
	
	private int estrellas;
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private String nombre;
	private boolean posicionAtaque;
	
	
	public Monstruo(String unNombre, int cantidadDeEstrellas, int ataque, int defensa) {
		super();
		nombre = unNombre;
		estrellas = cantidadDeEstrellas;
		puntosDeAtaque = ataque;
		puntosDeDefensa = defensa;
		estaEnElCementerio = false;
	}

	public void colocarEnPosicionAtaque() {
		posicionAtaque = true;
	}
	
	public boolean estaEnPosicionDeAtaque() {
		return posicionAtaque;
	}

	public void colocarEnPosicionDefensa() {
		posicionAtaque = false;
	}

	public void atacar(Monstruo atacado) {
		if(!atacado.loMato(puntosDeAtaque))
			this.mandarAlCementerio();
			
	}
	
	public boolean loMato(int puntosAtacante) {
		if (puntosAtacante > puntosDeAtaque) {
			this.mandarAlCementerio();
			return true;
		}
		else
			return false;
	}

	public int diferenciaDeAtaque(Monstruo monstruo) {
		return monstruo.diferenciaDeAtaque(puntosDeAtaque);
	}

	private int diferenciaDeAtaque(int puntosDeAtaque2) {
		return Math.abs(puntosDeAtaque2 - puntosDeAtaque);
	}
}
