package algo3.AlGoOh.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import algo3.AlGoOh.*;
import algo3.AlGoOh.Efectos.EfectoCartaCompuesta;
class EstadoTest {

	@Test
	void test01EstadoConJugadorSinNadaDaFalso() {
		Jugador jugador = new Jugador();
		Estado estado = new Estado(jugador);
		assertFalse(estado.ganoElJuego());
	}
	
	@Test
	void test02EstadoConJugadorSinNadaActualizaEstadoDaFalso() {
		Jugador jugador = new Jugador();
		Estado estado = new Estado(jugador);
		
		assertFalse(estado.ganoElJuego());
		estado.actualizarEstado();
		assertFalse(estado.ganoElJuego());
	}
	
	
	@Test
	void test03EstadoConJugadorConCartasExodiaDaFalso() {
		Jugador jugador = new Jugador();
		Estado estado = new Estado(jugador);
		
		Monstruo exodiaElProhibido = new Monstruo("Exodia El Prohibido", new EfectoCartaCompuesta(), new InvocacionNormal(), 1000, 1000);
		Monstruo brazoIzquierdoDelProhibido = new Monstruo("Brazo Izquierdo Del Prohibido", new EfectoCartaCompuesta(), new InvocacionNormal(), 200, 300);
		Monstruo piernaIzquierdaDelProhibido = new Monstruo("Pierna Izquierda Del Prohibido", new EfectoCartaCompuesta(), new InvocacionNormal(), 200, 300);
		Monstruo brazoDerechoDelProhibido = new Monstruo("Brazo Derecho Del Prohibido", new EfectoCartaCompuesta(), new InvocacionNormal(), 200, 300);
		Monstruo piernaDerechaDelProhibido = new Monstruo("Pierna Derecha Del Prohibido", new EfectoCartaCompuesta(), new InvocacionNormal(), 200, 300);
	
		jugador.agregarCartaEnMano(exodiaElProhibido);
		jugador.agregarCartaEnMano(brazoIzquierdoDelProhibido);
		jugador.agregarCartaEnMano(piernaIzquierdaDelProhibido);
		jugador.agregarCartaEnMano(brazoDerechoDelProhibido);
		jugador.agregarCartaEnMano(piernaDerechaDelProhibido);
		
		assertFalse(estado.ganoElJuego());
	}
	
	@Test
	void test04EstadoConJugadorConCartasExodiaYActualizarDaTrue() {
		Jugador jugador = new Jugador();
		Estado estado = new Estado(jugador);
		
		
		Monstruo exodiaElProhibido = new Monstruo("Exodia El Prohibido", new EfectoCartaCompuesta(), new InvocacionNormal(), 1000, 1000);
		Monstruo brazoIzquierdoDelProhibido = new Monstruo("Brazo Izquierdo Del Prohibido", new EfectoCartaCompuesta(), new InvocacionNormal(), 200, 300);
		Monstruo piernaIzquierdaDelProhibido = new Monstruo("Pierna Izquierda Del Prohibido", new EfectoCartaCompuesta(), new InvocacionNormal(), 200, 300);
		Monstruo brazoDerechoDelProhibido = new Monstruo("Brazo Derecho Del Prohibido", new EfectoCartaCompuesta(), new InvocacionNormal(), 200, 300);
		Monstruo piernaDerechaDelProhibido = new Monstruo("Pierna Derecha Del Prohibido", new EfectoCartaCompuesta(), new InvocacionNormal(), 200, 300);
	
		jugador.agregarCartaEnMano(exodiaElProhibido);
		jugador.agregarCartaEnMano(brazoIzquierdoDelProhibido);
		jugador.agregarCartaEnMano(piernaIzquierdaDelProhibido);
		jugador.agregarCartaEnMano(brazoDerechoDelProhibido);
		jugador.agregarCartaEnMano(piernaDerechaDelProhibido);
		
		assertFalse(estado.ganoElJuego());
		estado.actualizarEstado();
		assertTrue(estado.ganoElJuego());
	}
	
	@Test
	void test05Habiendo40CartasEnElMazoSacoTodasYCuandoQuieroSacarUnaMasPierdo() {
		Jugador oponente = new Jugador();
		Jugador jugador = new Jugador();
		oponente.oponente(jugador);
		jugador.oponente(oponente);
		
		Estado estado = new Estado(jugador);
		
		for (int i = 0; i <= 34; i++) {
			jugador.tomarUnaCartaDelMazo();
		}
		
		assertFalse(estado.ganoElJuego());
		assertFalse(oponente.ganoElJuego());
		jugador.tomarUnaCartaDelMazo();
		assertFalse(estado.ganoElJuego());
		assertTrue(oponente.ganoElJuego());
	}
	
	
	
	
	
	
	
	
}
