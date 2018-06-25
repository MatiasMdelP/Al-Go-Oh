package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	private int puntosDeVida;
	private Campo campo;
	private Jugador oponente;	
	private boolean ganoElJuego = false;
	private int partesDelExodiaEnMano = 0;
	private List<Carta> cartasEnMano = new ArrayList<Carta>();
	private Fase fase;
	
	public Jugador() {
		campo = new Campo(new Mazo());
		puntosDeVida = 8000;
		oponente = new Jugador(this);
		tomarUnaCartaDelMazo();
		fase = new FasePreparacion();
	}
	
	public Jugador(Jugador jugador) {
		campo = new Campo(new Mazo());
		puntosDeVida = 8000;
		oponente = jugador;
		tomarUnaCartaDelMazo();
		fase = new FasePreparacion();
	}
	
	public int obtenerPuntosDeVida() {
		return puntosDeVida;
	}
	
	public void agregarMonstruoASacrificar(int posicionDelMonstruo) throws AccionInvalidaEnEstaFaseException {
		fase.sacrificar();
		campo.agregarMonstruoASacrificar(posicionDelMonstruo);
	}

	public void agregarCartaEnMano(Carta unaCarta) {
		cartasEnMano.add(unaCarta);
		if (unaCarta.esParteDelExodia()) {
			partesDelExodiaEnMano++;
		}
	}
	
	public void agregarMonstruoEnAtaque(Monstruo monstruo) throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException{
		fase.agregarMonstruo();
		monstruo.colocarEnPosicionAtaque();
		monstruo.agregarAlCampo(campo, oponente.campo);
		campo.agregarMonstruo(monstruo);
	}

	public void agregarMonstruoEnDefensa(Monstruo monstruo) throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException{
		fase.agregarMonstruo();
		monstruo.colocarEnPosicionDefensa();
		campo.agregarMonstruo(monstruo);
	}
	
	public void agregarCartaMagicaBocaArriba(Carta magica) throws ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		fase.agregarMagica();
		magica.agregarAlCampo(campo, oponente.campo);
		campo.agregarMagica(magica);
		magica.realizarEfecto(this, oponente);
	}
	
	public void agregarCartaMagicaBocaAbajo(Carta magica) throws ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		fase.agregarMagica();
		if(!magica.estaBocaAbajo()) magica.darVuelta();
		magica.agregarAlCampo(campo, oponente.campo);
		campo.agregarMagica(magica);
	}
	
	public void agregarCartaTrampa(Carta trampa) throws ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		fase.agregarTrampa();
		trampa.agregarAlCampo(campo, oponente.campo);
		campo.agregarTrampa(trampa);
	}
	
	public void agregarCartaCampo(Carta cartaCampo) throws AccionInvalidaEnEstaFaseException {
		fase.agregarCampo();
		cartaCampo.agregarAlCampo(campo, oponente.campo);
		cartaCampo.realizarEfecto(this, oponente);
	}

	public void activarMagica(int nroDeCarta) throws AccionInvalidaEnEstaFaseException {
		fase.activarMagica();
		campo.obtenerMagicaOTrampa(nroDeCarta).realizarEfecto(this, oponente);
	}
	
	public void activarMonstruo(int nroDeCarta) throws AccionInvalidaEnEstaFaseException {
		fase.atacar();
		campo.definirMonstruo(nroDeCarta);
		campo.obtenerMonstruo().realizarEfecto(this, oponente);
	}
	
	public void atacarA(int nroMonstruoAtacante, int nroMonstruoAtacado) throws MonstruoNoPuedeAtacarException, AccionInvalidaEnEstaFaseException {
		fase.atacar();
		campo.definirMonstruo(nroMonstruoAtacante);
		oponente.recibirAtaque(campo, nroMonstruoAtacado, this);
	}
	
	private void recibirAtaque(Campo campoAtacante, int nroMonstruoAtacado, Jugador jugadorAtacante) throws MonstruoNoPuedeAtacarException {
		campo.definirMonstruo(nroMonstruoAtacado);
		try {
			campo.activarTrampa(campo, campoAtacante, this, jugadorAtacante);
			campo.activarEfectoDeVolteoMonstruoDefinido(campo, campoAtacante, this, jugadorAtacante);
			campoAtacante.atacarA(jugadorAtacante,this);
		}catch(InterrumpirAtaqueException excepcion){
			
		}
	}
	
	public int cantidadDeCartasEnMano() {
		return (cartasEnMano.size());
	}

	public void reducirVida(int danio) {
		puntosDeVida -= danio;
	}
	
	public void tomarUnaCartaDelMazo() {
		try {
			cartasEnMano.add(campo.tomarUnaCartaDelMazo());
		} catch (ElMazoNoTieneCartasException exception) {
			oponente.declararComoGanador();
		}
	}
	
	private void tieneTodasLasPartesDelExodia() {
		if (partesDelExodiaEnMano == 5) {
			declararComoGanador();
		}
	}
	
	public boolean ganoElJuego(){
		tieneTodasLasPartesDelExodia();
		return ganoElJuego;
	}
	
	public void declararComoGanador() {
		ganoElJuego = true;
	}
	
	public void recibirAtaque(Monstruo monstruoAtacante, Jugador jugadorAtacante) throws MonstruoNoPuedeAtacarException {
		this.campo.recibirAtaque(monstruoAtacante, jugadorAtacante, this);
	}
	
	public Jugador pasarTurno() {
		oponente.FasePreparacion();
		oponente.tomarUnaCartaDelMazo();
		return oponente;
	}

	private void FasePreparacion() {
		fase = new FasePreparacion();
	}

	public void pasarFase() throws NoHayMasFasesException {
		fase = fase.pasarFase();
	}

	public List<Carta> getListaDeCartasEnMano() {
		return cartasEnMano;
	}
}