package algo3.AlGoOh.modelo;

import java.util.Random;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Monstruo;
import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.MonstruosInsuficientesParaSacrificioException;
import algo3.AlGoOh.Exceptions.NoHayMasFasesException;
import algo3.AlGoOh.Exceptions.ZonaNoTieneMasEspacioException;
import algo3.AlGoOh.vista.ContenedorPrincipal;

public class AlGoOh {

	private static AlGoOh INSTANCE = null;
	public Jugador jugadorActual;
	private Tablero tablero;
	private Jugador oponente;
	private ContenedorPrincipal contenedorJugadores;
	
	private AlGoOh(){}
	private synchronized static void createInstance() {
		if (INSTANCE == null) { 
	       INSTANCE = new AlGoOh();
	    }
	}

	public static AlGoOh getInstance() {
	    if (INSTANCE == null)
	    	createInstance();
	    return INSTANCE;
	}
	
	public void cargarJugadores(Jugador jugador1, Jugador jugador2, ContenedorPrincipal contenedor) throws Exception {
		jugador1.oponente(jugador2);
		jugador2.oponente(jugador1);
		contenedorJugadores = contenedor;
		
		Random sorteo = new Random();	
		
		if (sorteo.nextInt(2) == 0) {
			jugadorActual = jugador1;
			oponente = jugador2;
		} else {
			jugadorActual = jugador2;
			oponente = jugador1;
		}
		jugadorActual.tomarUnaCartaDelMazo();
		actualizarJuego();
	}
	
	public void cargarTablero(Tablero unTablero) {
		tablero = unTablero;
	}
	
	public void finalizarTurno() {
		oponente = jugadorActual;
		jugadorActual = jugadorActual.pasarTurno();
		actualizarJuego();
	}
	
	public void pasarALaSiguienteFase() {
		try {
			jugadorActual.pasarFase();
		} catch (NoHayMasFasesException exception) {
			this.finalizarTurno();
		}
		actualizarJuego();
	}
	
	public void atacar(int numeroAtacante, int numeroAtacado) {
		jugadorActual.atacarA(numeroAtacante, numeroAtacado);
		actualizarJuego();
	}
	
	public void ponerEnPosicionAtaque(int numeroDeMonstruo) {
		jugadorActual.ponerEnPosicionAtaque(numeroDeMonstruo);
	}
	
	public void ponerEnPosicionDefensa(int numeroDeMonstruo) {
		jugadorActual.ponerEnPosicionDefensa(numeroDeMonstruo);
	}
	
	public void darVueltaMonstruo(int numeroDeMonstruo) {
		jugadorActual.darVueltaMonstruo(numeroDeMonstruo);
		actualizarJuego();
	}
	
	public void darVueltaCartaMagica(int numeroDeMagica) {
		jugadorActual.activarMagica(numeroDeMagica);
		actualizarJuego();
	}
	
	public void agregarMonstruoASacrificar(int posicionDelMonstruo) {
		jugadorActual.agregarMonstruoASacrificar(posicionDelMonstruo);
		
		contenedorJugadores.actualizarDatosDeJugadores();
	}
	
	private void actualizarJuego() {
		if (!jugadorActual.ganoElJuego()) {
			tablero.actualizarTablero(jugadorActual);
			contenedorJugadores.actualizarDatosDeJugadores();
		} else {
			contenedorJugadores.ganadorDelJuego(jugadorActual);
		}
	}
	
	public boolean noHayGanador() {
		return (!jugadorActual.ganoElJuego());
	}
	
	public void agregarCartaTrampa(Carta cartaTrampa) throws ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		jugadorActual.agregarCartaTrampa(cartaTrampa);
		actualizarJuego();
	}
	
	public void agregarCartaMagicaBocaArriba(Carta cartaMagica) throws ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		jugadorActual.agregarCartaMagicaBocaArriba(cartaMagica);
		actualizarJuego();
	}
	
	public void agregarCartaMagicaBocaAbajo(Carta cartaMagica) throws ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		jugadorActual.agregarCartaMagicaBocaAbajo(cartaMagica);
		actualizarJuego();
	}
	
	public void agregarMonstruoAlCampo(Carta unMonstruo) throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		jugadorActual.agregarMonstruoEnAtaque((Monstruo)unMonstruo);
		actualizarJuego();
	}
	
	public void agregarCartaCampo(Carta cartaDeCampo) throws AccionInvalidaEnEstaFaseException {
		jugadorActual.agregarCartaCampo(cartaDeCampo);
		actualizarJuego();
	}
	
	public String getNombreDeFase() {
		return jugadorActual.getNombreDeFase();
	}
}
