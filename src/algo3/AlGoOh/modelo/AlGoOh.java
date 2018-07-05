package algo3.AlGoOh.modelo;

import java.util.List;
import java.util.Random;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Monstruo;
import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.MonstruosInsuficientesParaSacrificioException;
import algo3.AlGoOh.Exceptions.NoHayMasFasesException;
import algo3.AlGoOh.Exceptions.ZonaNoTieneMasEspacioException;
import algo3.AlGoOh.vista.ContenedorPrincipal;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
	}
	
	public void cargarTablero(Tablero unTablero) {
		tablero = unTablero;
	}
	
	public void finalizarTurno() {
		oponente = jugadorActual;
		jugadorActual = jugadorActual.pasarTurno();
		tablero.actualizarTablero(jugadorActual);
		contenedorJugadores.actualizarDatosDeJugadores();
		//vistaCartasEnMano.actualizarCartasEnMano(jugadorActual);
	}
	
	public void pasarALaSiguienteFase() {
		try {
			jugadorActual.pasarFase();
		} catch (NoHayMasFasesException exception) {
			this.finalizarTurno();
		}
		tablero.actualizarTablero(jugadorActual);
		contenedorJugadores.actualizarDatosDeJugadores();
	}
	
	public void atacar(int numeroAtacante, int numeroAtacado) {
		jugadorActual.atacarA(numeroAtacante, numeroAtacado);
		tablero.actualizarTablero(jugadorActual);
		contenedorJugadores.actualizarDatosDeJugadores();
	}
	
	public void ponerEnPosicionAtaque(int numeroDeMonstruo) {
		jugadorActual.ponerEnPosicionAtaque(numeroDeMonstruo);
	}
	
	public void ponerEnPosicionDefensa(int numeroDeMonstruo) {
		jugadorActual.ponerEnPosicionDefensa(numeroDeMonstruo);
	}
	
	public void darVueltaMonstruo(int numeroDeMonstruo) {
		jugadorActual.darVueltaMonstruo(numeroDeMonstruo);
		tablero.actualizarTablero(jugadorActual);
	}
	
	public void darVueltaCartaMagica(int numeroDeMagica) {
		jugadorActual.activarMagica(numeroDeMagica);
		tablero.actualizarTablero(jugadorActual);
	}
	
	public void agregarMonstruoASacrificar(int posicionDelMonstruo) {
		jugadorActual.agregarMonstruoASacrificar(posicionDelMonstruo);
		
		contenedorJugadores.actualizarDatosDeJugadores();
	}
	
	public boolean noHayGanador() {
		return (!jugadorActual.ganoElJuego());
	}
	
	public void agregarCartaTrampa(Carta cartaTrampa) throws ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		jugadorActual.agregarCartaTrampa(cartaTrampa);
		tablero.actualizarTablero(jugadorActual);
	}
	
	public void agregarCartaMagicaBocaArriba(Carta cartaMagica) throws ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		jugadorActual.agregarCartaMagicaBocaArriba(cartaMagica);
		tablero.actualizarTablero(jugadorActual);
	}
	
	public void agregarCartaMagicaBocaAbajo(Carta cartaMagica) throws ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		jugadorActual.agregarCartaMagicaBocaAbajo(cartaMagica);
		tablero.actualizarTablero(jugadorActual);
	}
	
	public void agregarMonstruoAlCampo(Carta unMonstruo) throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		jugadorActual.agregarMonstruoEnAtaque((Monstruo)unMonstruo);
		tablero.actualizarTablero(jugadorActual);
	}
	
	public void agregarCartaCampo(Carta cartaDeCampo) throws AccionInvalidaEnEstaFaseException {
		jugadorActual.agregarCartaCampo(cartaDeCampo);
		tablero.agregarCartaCampo(jugadorActual);
	}
	
	/*public void agregarCartaAlCampo(Carta carta) throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		
		if(carta.getClass() == Monstruo.class) {
			try {
				jugadorActual.agregarMonstruoEnAtaque((Monstruo)carta);
				tablero.actualizarTablero(jugadorActual);
			} catch (MonstruosInsuficientesParaSacrificioException e) {
				alertaSacrificiosInsuficientes();
			} catch (ZonaNoTieneMasEspacioException e) {
				alertaNoHayMasEspacioEnLaZona();
			} catch (AccionInvalidaEnEstaFaseException e) {
				alertaAccionInvalidaEnFase();
			}
		} else {
			jugadorActual.agregarCartaMagicaBocaArriba(carta);
			tablero.actualizarTablero(jugadorActual);
		}
		contenedorJugadores.actualizarDatosDeJugadores();
	}*/
	
	public String getNombreDeFase() {
		return jugadorActual.getNombreDeFase();
	}
}
