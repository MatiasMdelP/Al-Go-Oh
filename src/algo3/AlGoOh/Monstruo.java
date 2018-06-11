package algo3.AlGoOh;

import javax.xml.stream.events.ProcessingInstruction;

import org.junit.validator.PublicClassValidator;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class Monstruo extends Carta {
	
	private int estrellas;
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private String nombre;
	private boolean posicionAtaque;
	private Posicion posicion;
	
	
	public Monstruo(String unNombre, int cantidadDeEstrellas, int ataque, int defensa) {
		super();
		nombre = unNombre;
		estrellas = cantidadDeEstrellas;
		puntosDeAtaque = ataque;
		puntosDeDefensa = defensa;
		estaEnElCementerio = false;
	}

	public void colocarEnPosicionAtaque() {
		posicion = new PosicionAtaque();
		posicionAtaque = true;
	}
	
	public void colocarEnPosicionDefensa() {
		posicion = new PosicionDefensa();
		posicionAtaque = false;
	}

	public boolean estaEnPosicionDeAtaque() {
		return posicionAtaque;
	}
	
	public int atacar(Monstruo atacado) {
		int diferenciaDelEnfrentamiento = atacado.posicion.esAtacado(atacado, puntosDeAtaque);
		if (diferenciaDelEnfrentamiento > 0) {
			this.mandarAlCementerio();
		} else if (diferenciaDelEnfrentamiento < 0) {
			atacado.mandarAlCementerio();
			return Math.abs(diferenciaDelEnfrentamiento);
		} else {
			this.mandarAlCementerio();
			atacado.mandarAlCementerio();
		}
		return 0;
	}
		
	public int esAtacadoEnPosicionDeDefensa(int puntosDelAtacante) {
		return (puntosDeDefensa - puntosDelAtacante);
	}
	
	public int esAtacadoEnPosicionDeAtaque(int puntosDelAtacante){
		return (puntosDeAtaque - puntosDelAtacante);
	}
	
	//De aca para abajo es una posible "solucion" sin Posicion.
	/*
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
	}*/
}
