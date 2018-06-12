package algo3.AlGoOh;

public class Monstruo extends Carta {
	
	private int estrellas;
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private String nombre;
	private boolean posicionAtaque;
	private Posicion posicion;
	private int puntosRecibirAtaque;
	
	
	public Monstruo(String unNombre, int cantidadDeEstrellas, int ataque, int defensa) {
		super();
		nombre = unNombre;
		estrellas = cantidadDeEstrellas;
		puntosDeAtaque = ataque;
		puntosDeDefensa = defensa;
		estaEnElCementerio = false;
		campo = new Campo(); //para las pruebas
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
	
	public int atacar(Monstruo atacado) {
		int diferenciaDelEnfrentamiento = atacado.recibirAtaque(puntosDeAtaque);
		if (diferenciaDelEnfrentamiento >= 0) {
			this.mandarAlCementerio();
		}
		return atacado.posicion.devolverDaño(diferenciaDelEnfrentamiento);
		//Cero si ambos mueren
		//Negativo si el atacado muere
		//positivo si el atacante muere
	}
	
	
	private int recibirAtaque(int puntosDelAtacante) {
		int dif = puntosRecibirAtaque - puntosDelAtacante;
		if(dif<=0) {
			this.mandarAlCementerio();
		}
		return dif;
	}

	
	//De aca para abajo es una posible "solucion" sin Posicion.
	/*
	public void atacar(Monstruo atacado) {
		if(!atacado.loMato(puntosDeAtaque))
			this.mandarAlCementerio();		
	}
	
	public boolean loMato(int puntosAtacante) {
		if (modoAtaque)
			if (puntosAtacante > puntosDeAtaque) {
				this.mandarAlCementerio();
				return true;
			} else
				return false;
		else
			if (puntosAtacante > puntosDeDefensa) {
				this.mandarAlCementerio();
				return true;
			} else
				return false;
	}

	public int diferenciaDeAtaque(Monstruo monstruo) {
		return monstruo.diferenciaDeAtaque(puntosDeAtaque);
	}

	private int diferenciaDeAtaque(int puntosDeAtaque2) {
		return Math.abs(puntosDeAtaque2 - puntosDeAtaque);
	}*/
}
