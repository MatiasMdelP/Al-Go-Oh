package algo3.AlGoOh.modelo;

import java.util.Random;

import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.vista.VentanaDeCartasEnMano;
import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.NoHayMasFasesException;

public class AlGoOh {

	private static AlGoOh INSTANCE = null;
	private Jugador jugadorActual;
	private Tablero tablero;
	private VentanaDeCartasEnMano vistaCartasEnMano;
	
	public AlGoOh(){}
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
	
	public void cargarJugadores(Jugador jugador1, Jugador jugador2 ) throws Exception {
		
		Random sorteo = new Random();
				
		if (sorteo.nextInt(2) == 0) {
			jugadorActual = jugador1;
		} else {
			jugadorActual = jugador2;
		}
		jugadorActual.tomarUnaCartaDelMazo();
		//vistaCartasEnMano = new VentanaDeCartasEnMano(jugadorActual);
	}
	
	public void cargarElTablero(Tablero unTablero) {
		tablero = unTablero;
	}
	
	public void finalizarTurno() {
		jugadorActual = jugadorActual.pasarTurno();
		jugadorActual.tomarUnaCartaDelMazo();
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
		vistaCartasEnMano.actualizarCartasEnMano(jugadorActual);
	}
	
	public void agregarMonstruoASacrificar(int posicionDelMonstruo) {
		try {
			jugadorActual.agregarMonstruoASacrificar(posicionDelMonstruo);
		} catch (AccionInvalidaEnEstaFaseException e) {
			//e.printStackTrace();
		}
	}
	
	public boolean noHayGanador() {
		return (! jugadorActual.ganoElJuego());
	}
}
