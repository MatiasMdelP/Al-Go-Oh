package algo3.AlGoOh;

import java.util.Random;

public class AlGoOh {

	private static AlGoOh INSTANCE = null;
	private Jugador jugadorActual;
	
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
	
	public void cargarJugadores() {
		
		Random sorteo = new Random();
		jugadorActual = new Jugador();
		
		if (sorteo.nextInt(2) == 1) {
			jugadorActual = jugadorActual.pasarTurno();
		}
	}
	
	public void finalizarTurno() {
		jugadorActual = jugadorActual.pasarTurno();
	}
	
	public void pasarALaSiguienteFase() {
		try {
			jugadorActual.pasarFase();
		} catch (NoHayMasFasesException exception) {
			this.finalizarTurno();
		}
	}
}
