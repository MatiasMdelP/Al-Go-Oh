package algo3.AlGoOh;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JugadorTest {
	
	@Test
	public void test01JugadorRecienCreadoTiene8000PuntosDeVida() {
		Jugador unJugador = new Jugador();
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
	}
	
	@Test
	public void test02PerdidaDe500PuntosDeVida() {
		Jugador unJugador = new Jugador();
		unJugador.descontarPuntosDeVida(500);
		
		assertEquals(7500, unJugador.obtenerPuntosDeVida());
	}
	
	@Test
	public void test03AtacoAMonstruoEnPosicionAtaqueConMayorAtaqueYSeReduceMiVida() {
		Jugador unJugador = new Jugador();
		unJugador.descontarPuntosDeVida(500);
		
		assertEquals(7500, unJugador.obtenerPuntosDeVida());
	}
}
