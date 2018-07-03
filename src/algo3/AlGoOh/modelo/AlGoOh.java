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
		try {
			jugadorActual.atacarA(numeroAtacante, numeroAtacado);
		} catch (AccionInvalidaEnEstaFaseException e) {
			alertaAccionInvalidaEnFase();
		}
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
	
	public void agregarMonstruoASacrificar(int posicionDelMonstruo) {
		try {
			jugadorActual.agregarMonstruoASacrificar(posicionDelMonstruo);
		} catch (AccionInvalidaEnEstaFaseException e) {
			alertaAccionInvalidaEnFase();
		}
		contenedorJugadores.actualizarDatosDeJugadores();
	}
	
	public boolean noHayGanador() {
		return (!jugadorActual.ganoElJuego());
	}
	
	public void agregarCartaAlCampo(Carta carta) throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		
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
	}
	
	private void alertaSacrificiosInsuficientes() {
		Alert alert = new Alert(AlertType.WARNING,""
				+ "Antes de invocar al monstruo debe hacer los sacrificios necesarios. \n"
				);
        alert.setTitle("Sacrificion insuficientes...");

        alert.showAndWait();
	}
	
	private void alertaNoHayMasEspacioEnLaZona() {
		Alert alert = new Alert(AlertType.WARNING,""
				+ "No se puede invocar mas invocar esta carta porque no \n"
				+ "hay mas espacio en el campo. \n"
				);
        alert.setTitle("Zona sin lugar...");

        alert.showAndWait();
	}
	
	private void alertaAccionInvalidaEnFase() {
		Alert alert = new Alert(AlertType.WARNING,""
				+ "No se pueden invocar monstruos en esta fase. \n"
				);
        alert.setTitle("Accion en fase invalida...");

        alert.showAndWait();
	}
	
	public String getNombreDeFase() {
		return jugadorActual.getNombreDeFase();
	}
}
