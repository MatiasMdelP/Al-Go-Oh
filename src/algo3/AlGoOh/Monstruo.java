package algo3.AlGoOh;

import algo3.AlGoOh.Efectos.Efecto;
import algo3.AlGoOh.Exceptions.InterrumpirAtaqueException;
import algo3.AlGoOh.Exceptions.MonstruoNoPuedeAtacarException;
import algo3.AlGoOh.Exceptions.MonstruosInsuficientesParaSacrificioException;

public class Monstruo extends Carta {
	
	private Posicion posicion;
	private Invocacion invocacion;
	
	public Monstruo(String unNombre, Efecto unEfecto, Invocacion invocacionIngresada, int ataque, int defensa) {
		super(unNombre, unEfecto);
		invocacion = invocacionIngresada;
		estaEnElCementerio = false;
		posicion = new PosicionAtaque(ataque,defensa);
	}
	
	public void colocarEnPosicionAtaque() {
		posicion = posicion.ponerEnPosicionAtaque();
	}
	
	public void colocarEnPosicionDefensa() {
		posicion = posicion.ponerEnPosicionDefensa();
	}
	
	public void atacarA(Monstruo atacado, Jugador jugadorAtacante, Jugador jugadorAtacado) {
		boca.verificarEstado();
		posicion.verificarEstado();
		
		int diferenciaDelEnfrentamiento = atacado.recibirAtaque(posicion, jugadorAtacado);
		
		if (diferenciaDelEnfrentamiento >= 0) 
			this.posicion.efectuarDanio(diferenciaDelEnfrentamiento,jugadorAtacante,this);
	}
	
	private int recibirAtaque(Posicion posicionAtacante, Jugador jugadorAtacado) {
		int diferenciaDelEnfrentamiento = posicionAtacante.calcularDiferenciaDeDanio(posicion);
		
		if(diferenciaDelEnfrentamiento <= 0)
			this.posicion.efectuarDanio(diferenciaDelEnfrentamiento,jugadorAtacado,this);
		
		return diferenciaDelEnfrentamiento;
	}

	public void agregarPuntosDeAtaque(int puntos) {
		posicion.agregarPuntosDeAtaque(puntos);
	}
	
	public void agregarPuntosDeDefensa(int puntos) {
		posicion.agregarPuntosDeDefensa(puntos);
	}
	
	public boolean tieneMenorAtaqueQue(Monstruo otroMonstruo) {
		return (otroMonstruo.tieneMayorAtaqueQue(getDanio()));
	}
	
	private boolean tieneMayorAtaqueQue(int puntosDelMonstruoRival) {
		return (getDanio() > puntosDelMonstruoRival);
	}
	
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException {
		if (boca.getEstado()) {
			this.darVuelta();
			efecto.realizarEfectoDeVolteo(campo, campoOponente, unJugador, oponente);
		}
	}
	
	public int getDanio() {
		return posicion.danioAtaque();
	}


	public void efectuarSacrificios(Campo campo) throws MonstruosInsuficientesParaSacrificioException {
		invocacion.efectuarSacrificios(campo);
	}

	public boolean esDragonBlancoDeOjosAzules() {
		return nombre == "Dragon Blanco De Ojos Azules";
	}
	
}
