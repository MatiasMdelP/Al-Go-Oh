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
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionAtaque();
	
		unJugador.agregarMounstro(huevoMonstruoso);
		
		unJugador.atacar(0, monoAcrobata);
		
		assertEquals(7600, unJugador.obtenerPuntosDeVida());
	}
	
}
