package algo3.AlGoOh.modelo;

import java.util.Random;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Monstruo;
import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.MonstruosInsuficientesParaSacrificioException;
import algo3.AlGoOh.Exceptions.NoHayMasFasesException;
import algo3.AlGoOh.Exceptions.ZonaNoTieneMasEspacioException;

public class AlGoOh {

	private static AlGoOh INSTANCE = null;
	public Jugador jugadorActual;
	private Tablero tablero;
	private Jugador oponente;
	
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
	
	public void cargarJugadores(Jugador jugador1, Jugador jugador2) throws Exception {
		
		Random sorteo = new Random();
				
		if (sorteo.nextInt(2) == 0) {
			jugadorActual = jugador1;
			oponente = jugador2;
		} else {
			jugadorActual = jugador2;
			oponente = jugador1;
		}
		jugador1.oponente(jugador2);
		jugador2.oponente(jugador1);
	}
	
	public void cargarTablero(Tablero unTablero) {
		tablero = unTablero;
	}
	
	public void finalizarTurno() {
		oponente = jugadorActual;
		jugadorActual = jugadorActual.pasarTurno();
		tablero.actualizarTablero();
		//vistaCartasEnMano.actualizarCartasEnMano(jugadorActual);
	}
	
	public void pasarALaSiguienteFase() {
		try {
			jugadorActual.pasarFase();
		} catch (NoHayMasFasesException exception) {
			this.finalizarTurno();
		}
		tablero.actualizarTablero();
	}
	
	public void atacar(int numeroAtacante, int numeroAtacado) {
		try {
			jugadorActual.atacarA(numeroAtacante, numeroAtacado);
		} catch (Exception e) {
			
		}
	}
	
	public void agregarMonstruoASacrificar(int posicionDelMonstruo) {
		try {
			jugadorActual.agregarMonstruoASacrificar(posicionDelMonstruo);
		} catch (AccionInvalidaEnEstaFaseException e) {
			//e.printStackTrace();
		}
	}
	
	public boolean noHayGanador() {
		return (!jugadorActual.ganoElJuego());
	}
	public void agregarCartaAlCampo(Carta carta) throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		if(carta.getClass() == Monstruo.class) {
			jugadorActual.agregarMonstruoEnAtaque((Monstruo)carta);
			tablero.actualizarTablero();
		}
	}
}
