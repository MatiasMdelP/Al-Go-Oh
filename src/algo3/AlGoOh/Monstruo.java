package algo3.AlGoOh;

import org.junit.validator.PublicClassValidator;

import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;

public class Monstruo {
	
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private String nombre;
	private boolean posicionAtaque;
	
	
	public Monstruo(String unNombre, int ataque, int defensa) {
		nombre = unNombre;
		puntosDeAtaque = ataque;
		puntosDeDefensa = defensa;
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
	
}
