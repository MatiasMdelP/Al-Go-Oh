package algo3.AlGoOh;

public class Jugador {
	
	private int puntosDeVida;
	private Campo campo;
	int VIDA = 8000;
	private Jugador oponente;	
	private boolean perdioElJuego = false;
	
	public Jugador() {
		campo = new Campo(new Mazo());
		puntosDeVida = VIDA;
	}
	
	public int obtenerPuntosDeVida() {
		return puntosDeVida;
	}

	public void inicializarMazo() {
		campo.inicializarMazo();
	}
	public void agregarCartaEnMano(Carta unaCarta) {
		campo.agregarCartaEnMano(unaCarta);
	}
	public void agregarMonstruoEnAtaque(Monstruo monstruo) throws MonstruosInsuficientesParaSacrificioException{
		monstruo.colocarEnPosicionAtaque();
		monstruo.agregarAlCampo(campo, oponente.campo);
		campo.agregarMonstruo(monstruo);
	}

	public void agregarMonstruoEnDefensa(Monstruo monstruo) throws MonstruosInsuficientesParaSacrificioException{
		monstruo.colocarEnPosicionDefensa();
		campo.agregarMonstruo(monstruo);
	}
	
	public void agregarCartaMagica(Carta cartaMagica) {
		cartaMagica.agregarAlCampo(campo, oponente.campo);
		campo.agregarMagicaOTrampa(cartaMagica);
	}
	
	public void agregarCartaCampo(DeCampo cartaCampo) {
		cartaCampo.agregarAlCampo(campo, oponente.campo);
		cartaCampo.realizarEfecto(this, oponente);
		campo.agregarDeCampo(cartaCampo);
	}

	public void activarMagica(int nroDeCarta) {
		campo.obtenerMagicaOTrampa(nroDeCarta).realizarEfecto(this, oponente);
	}
	
	public boolean activarTrampa() {
		int nroDeCarta = campo.obtenerNroCartaTrampa();
		if (nroDeCarta >= 0) {
			
			campo.obtenerMagicaOTrampa(nroDeCarta).realizarEfecto(this, oponente);
			return false;
		}
		return true;
		
	}
	
	public void activarMonstruo(int nroDeCarta) {
		campo.obtenerMonstruo(nroDeCarta).realizarEfecto(this, oponente);
	}
	
	public void atacarA(int nroMonstruoAtacante, int nroMonstruoAtacado) throws MonstruoNoPuedeAtacarException {
		campo.definirMonstruo(nroMonstruoAtacante);
		oponente.recibirAtaque(campo.obtenerMonstruo(nroMonstruoAtacante), nroMonstruoAtacado, this);
	}
	
	private void recibirAtaque(Monstruo monstruoAtacante, int nroMonstruoAtacado, Jugador jugadorAtacante) throws MonstruoNoPuedeAtacarException {
		campo.definirMonstruo(nroMonstruoAtacado);
		if(activarTrampa()) {
			monstruoAtacante.atacarA(campo.obtenerMonstruo(nroMonstruoAtacado),jugadorAtacante, this);
		}
		
	}
	
	public int cantidadDeCartasEnMano() {
		return campo.obtenerCantidadDeCartasEnLaMano();
	}

	public void fijarOponente(Jugador oponente) {
		this.oponente = oponente;
	}

	public void reducirVida(int danio) {
		puntosDeVida -= danio;
	}
	
	public void tomarUnaCartaDelMazo(){
		try {
			campo.tomarUnaCartaDelMazo();
		} catch (ElMazoNoTieneCartasException exception) {
			perdioElJuego = true;
		}
	}
	
	public boolean perdioElJuego(){
		return perdioElJuego;
	}

}