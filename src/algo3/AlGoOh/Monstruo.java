package algo3.AlGoOh;

import java.util.List;

public class Monstruo extends Carta {
	
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private boolean posicionAtaque;
	private Posicion posicion;
	private boolean bocaArriba;
	private int puntosRecibirAtaque;
	private Invocacion invocacion;
	
	public Monstruo(String unNombre, Efecto unEfecto, int cantidadDeEstrellas,Invocacion invocacionIngresada, int ataque, int defensa) {
		super(unNombre, unEfecto);
		invocacion = invocacionIngresada;
		puntosDeAtaque = ataque;
		puntosDeDefensa = defensa;
		estaEnElCementerio = false;
		bocaArriba = true;
	}
	
	public String obtenerNombre() {
		return nombre;
	}

	public void efectuarSacrificios(List<Monstruo> monstruos) throws MonstruosInsuficientesParaSacrificioException {
		invocacion.efectuarSacrificios(monstruos);
	}
	
	public void darVuelta() {
		bocaArriba = !bocaArriba;
	}
	
	public boolean estaBocaArriba() {
		return bocaArriba;
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
	
	public int atacarA(Monstruo atacado, Jugador jugadorAtacante, Jugador jugadorAtacado) throws MonstruoNoPuedeAtacarException {
		if (!bocaArriba && !posicionAtaque) throw new MonstruoNoPuedeAtacarException();
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
		puntosRecibirAtaque = posicion.obtenerResistencia(puntosDeAtaque, puntosDeDefensa);
	}
	
	public void agregarPuntosDeDefensa(int puntos) {
		puntosDeDefensa += puntos;
		puntosRecibirAtaque = posicion.obtenerResistencia(puntosDeAtaque, puntosDeDefensa);
	}
	
	public boolean tieneMenorAtaqueQue(Monstruo otroMonstruo) {
		return  (otroMonstruo.tieneMayorAtaqueQue(puntosDeAtaque));
	}
	
	private boolean tieneMayorAtaqueQue(int puntosDelMonstruoRival) {
		return (puntosDeAtaque > puntosDelMonstruoRival);
	}

	public int getDanio() {
		return puntosDeAtaque;
	}

}
