package algo3.AlGoOh;


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

	public boolean estaEnPosicionDeAtaque() {
		return posicion.estaEnAtaque();
	}
	
	public void atacarA(Monstruo atacado, Jugador jugadorAtacante, Jugador jugadorAtacado) throws MonstruoNoPuedeAtacarException {

		if (bocaAbajo || !posicion.estaEnAtaque()) throw new MonstruoNoPuedeAtacarException();
		
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
		posicion.agregarPuntos(puntos);
	}
	
	public void agregarPuntosDeDefensa(int puntos) {
		posicion.agregarPuntos(puntos);
	}
	
	public boolean tieneMenorAtaqueQue(Monstruo otroMonstruo) {
		return (otroMonstruo.tieneMayorAtaqueQue(getDanio()));
	}
	
	private boolean tieneMayorAtaqueQue(int puntosDelMonstruoRival) {
		return (getDanio() > puntosDelMonstruoRival);
	}
	
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException {
		if (bocaAbajo) 
			this.darVuelta();
			efecto.realizarEfectoDeVolteo(campo, campoOponente, unJugador, oponente);
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
