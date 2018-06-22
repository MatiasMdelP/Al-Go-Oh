package algo3.AlGoOh;


public class Monstruo extends Carta {
	
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private Posicion posicion;
	private int puntosRecibirAtaque;
	private Invocacion invocacion;
	private boolean esParteDelExodia;
	
	public Monstruo(String unNombre, Efecto unEfecto, int cantidadDeEstrellas,Invocacion invocacionIngresada, int ataque, int defensa) {
		super(unNombre, unEfecto);
		invocacion = invocacionIngresada;
		puntosDeAtaque = ataque;
		puntosDeDefensa = defensa;
		estaEnElCementerio = false;
		esParteDelExodia = verificarSiEsParteDelExodia();
	}
	
	public String obtenerNombre() {
		return nombre;
	}
	
	public void colocarEnPosicionAtaque() {
		posicion = new PosicionAtaque();
		puntosRecibirAtaque = puntosDeAtaque;
	}
	
	public void colocarEnPosicionDefensa() {
		posicion = new PosicionDefensa();
		puntosRecibirAtaque = puntosDeDefensa;
	}

	public boolean estaEnPosicionDeAtaque() {
		return posicion.estaEnAtaque();
	}
	
	public void atacarA(Monstruo atacado, Jugador jugadorAtacante, Jugador jugadorAtacado) throws MonstruoNoPuedeAtacarException {
		if (bocaAbajo && !posicion.estaEnAtaque()) throw new MonstruoNoPuedeAtacarException();
		
		int diferenciaDelEnfrentamiento = atacado.recibirAtaque(puntosDeAtaque, jugadorAtacado);
		
		if (diferenciaDelEnfrentamiento >= 0) {
			this.posicion.efectuarDanio(diferenciaDelEnfrentamiento,jugadorAtacante,this);
		}
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
		return (otroMonstruo.tieneMayorAtaqueQue(puntosDeAtaque));
	}
	
	private boolean tieneMayorAtaqueQue(int puntosDelMonstruoRival) {
		return (puntosDeAtaque > puntosDelMonstruoRival);
	}
	
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException {
		if (bocaAbajo) 
			this.darVuelta();
			efecto.realizarEfectoDeVolteo(campo, campoOponente, unJugador, oponente);
	}
	
	public int getDanio() {
		return puntosDeAtaque;
	}
	
	public boolean esParteDelExodia() {
		return esParteDelExodia;
	}
	
	private boolean verificarSiEsParteDelExodia() {
		return ((nombre == "Exodia El Prohibido") || (nombre == "Brazo Izquierdo Del Prohibido") || (nombre == "Pierna Izquierda Del Prohibido") || 
				(nombre == "Brazo Derecho Del Prohibido") || (nombre == "Pierna Derecha Del Prohibido"));
	}

	public void efectuarSacrificios(Campo campo) throws MonstruosInsuficientesParaSacrificioException {
		invocacion.efectuarSacrificios(campo);
	}

	public boolean esDragonBlancoDeOjosAzules() {
		return nombre == "Dragon Blanco De Ojos Azules";
	}
}
