package algo3.AlGoOh;

import java.util.Random;

import algo3.AlGoOh.vista.Tablero;
import javafx.scene.layout.Background;

public class AlGoOh {

	private static AlGoOh INSTANCE = null;
	private Jugador jugadorActual;
	private Tablero tablero;
	
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
	
	public void cargarJugadores(Jugador jugador1, Jugador jugador2 ) {
		
		Random sorteo = new Random();
				
		if (sorteo.nextInt(2) == 0) {
			jugadorActual = jugador1;
		} else {
			jugadorActual = jugador2;
		}
		jugadorActual.tomarUnaCartaDelMazo();
	}
	
	public void cargarElTablero(Tablero unTablero) {
		tablero = unTablero;
	}
	
	public void finalizarTurno() {
		jugadorActual = jugadorActual.pasarTurno();
		jugadorActual.tomarUnaCartaDelMazo();
		tablero.actualizarTablero();
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
		return (! jugadorActual.ganoElJuego());
	}
}
