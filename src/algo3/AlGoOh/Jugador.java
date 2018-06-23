package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	int VIDA = 8000;
	private int puntosDeVida;
	private Campo campo;
	private Jugador oponente;	
	private boolean ganoElJuego = false;
	private int partesDelExodiaEnMano = 0;
	private List<Carta> cartasEnMano = new ArrayList<Carta>();
	
	public Jugador() {
		campo = new Campo(new Mazo());
		puntosDeVida = VIDA;
		oponente = new Jugador(this);
	}
	
	public Jugador(Jugador jugador) {
		campo = new Campo(new Mazo());
		puntosDeVida = VIDA;
		oponente = jugador;
	}
	
	public int obtenerPuntosDeVida() {
		return puntosDeVida;
	}
	
	public void agregarMonstruoASacrificar(int posicionDelMonstruo) {
		campo.agregarMonstruoASacrificar(posicionDelMonstruo);
	}

	public void agregarCartaEnMano(Carta unaCarta) {
		cartasEnMano.add(unaCarta);
		if (cartasEnMano.get(cartasEnMano.size()-1).esParteDelExodia()) {
			partesDelExodiaEnMano++;
		}
	}
	public void agregarMonstruoEnAtaque(Monstruo monstruo) throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException{
		monstruo.colocarEnPosicionAtaque();
		monstruo.agregarAlCampo(campo, oponente.campo);
		campo.agregarMonstruo(monstruo);
	}

	public void agregarMonstruoEnDefensa(Monstruo monstruo) throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException{
		monstruo.colocarEnPosicionDefensa();
		campo.agregarMonstruo(monstruo);
	}
	
	public void agregarCartaMagica(Carta magica) throws ZonaNoTieneMasEspacioException {
		magica.agregarAlCampo(campo, oponente.campo);
		campo.agregarMagica(magica);
	}
	
	public void agregarCartaTrampa(Carta tramoa) throws ZonaNoTieneMasEspacioException {
		tramoa.agregarAlCampo(campo,  oponente.campo);
		campo.agregarTrampa(tramoa);
	}
	
	public void agregarCartaCampo(Carta cartaCampo) {
		cartaCampo.agregarAlCampo(campo, oponente.campo);
		cartaCampo.realizarEfecto(this, oponente);
	}

	public void activarMagica(int nroDeCarta) {
		campo.obtenerMagicaOTrampa(nroDeCarta).realizarEfecto(this, oponente);
	}
	
	public void activarMonstruo(int nroDeCarta) {
		campo.definirMonstruo(nroDeCarta);
		campo.obtenerMonstruo().realizarEfecto(this, oponente);
	}
	
	public void atacarA(int nroMonstruoAtacante, int nroMonstruoAtacado) throws MonstruoNoPuedeAtacarException {
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
	
	public void tomarUnaCartaDelMazo(){
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
		return oponente;
	}
}