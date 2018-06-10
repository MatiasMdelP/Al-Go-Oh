package algo3.AlGoOh;

public class Monstruo extends Carta {
	
	private int estrellas;
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private String nombre;
	private boolean posicionAtaque;
	private int vida;
	
	
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
		vida = puntosDeAtaque;
	}
	
	public boolean estaEnPosicionDeAtaque() {
		return posicionAtaque;
	}

	public void colocarEnPosicionDefensa() {
		posicionAtaque = false;
		vida = puntosDeDefensa;
	}

	public void atacar(Monstruo atacado) {
		if (posicionAtaque) {
			atacado.esAtacadoEnPosicionDeAtaque(this, puntosDeAtaque);
		} else {
			atacado.esAtacadoEnPosicionDeDefensa(this, puntosDeAtaque);
		}
	}

	public void reducirVidaJugador(Jugador jugador) {
		jugador.descontarPuntosDeVida(vida);
	}
	
	public int getVida() {
		return vida;
	}
	
	private void reducirVida(int puntosRecibidos) {
		vida -= puntosRecibidos;
		if(vida <= 0) {
			this.mandarAlCementerio();
		}
	}
	
	
	private void esAtacadoEnPosicionDeAtaque(Monstruo atacante, int puntosDelAtacante) {
		if (puntosDelAtacante > puntosDeAtaque) {
			this.reducirVida(puntosDelAtacante);
		} else {
			atacante.reducirVida(puntosDeAtaque);
		}
	}
	
	private void esAtacadoEnPosicionDeDefensa(Monstruo atacante, int puntosDelAtacante) {
		if (puntosDelAtacante > puntosDeDefensa) {
			this.reducirVida(puntosDelAtacante);
		} 
	}
}
