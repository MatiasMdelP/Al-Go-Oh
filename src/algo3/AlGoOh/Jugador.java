package algo3.AlGoOh;

public class Jugador {
	
	private int puntosDeVida;
	private Campo campo;
	int VIDA = 8000;
	private Jugador oponente;	
	
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
	
	public void activarTrampa() {
		//campo.obtenerMagicaOTrampa(0).realizarEfecto(this, oponente);
	}
	
	public void activarMonstruo(int nroDeCarta) {
		campo.obtenerMonstruo(nroDeCarta).realizarEfecto(this, oponente);
	}
	
	public void atacarA(int nroMonstruoAtacante, int nroMonstruoAtacado) throws MonstruoNoPuedeAtacarException {

		oponente.recibirAtaque(campo.obtenerMonstruo(nroMonstruoAtacante), nroMonstruoAtacado, this);
	}
	
	private void recibirAtaque(Monstruo monstruoAtacante, int nroMonstruoAtacado, Jugador jugadorAtacante) throws MonstruoNoPuedeAtacarException {
		activarTrampa();
		monstruoAtacante.atacarA(campo.obtenerMonstruo(nroMonstruoAtacado),jugadorAtacante, this);
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

}