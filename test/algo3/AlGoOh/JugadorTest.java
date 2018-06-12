package algo3.AlGoOh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JugadorTest {
	
	@Test
	public void test01JugadorRecienCreadoTiene8000PuntosDeVida() {
		Jugador unJugador = new Jugador();
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
	}
	
	@Test
	public void test02AtacoAMonstruoEnPosicionAtaqueConMenorAtaqueYSeReduceLaVidaDelJugadorAtacado() {
		Jugador jugadorUno= new Jugador();
		Jugador jugadorDos = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		jugadorUno.agregarMonstruoEnAtaque(huevoMonstruoso);
		jugadorDos.agregarMonstruoEnAtaque(monoAcrobata);
		
		jugadorUno.atacar(jugadorDos, 0, 0);
		
		assertEquals(7600, jugadorUno.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test03AtacoAMonstruoEnPosicionAtaqueConMayorAtaqueYSufroDanio() {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		oponente.atacar(unJugador, 0, 0);
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(7600, unJugador.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
		// Hay que ser boludo para hacer esto pero bueno, es una opcion por lo tanto tiene prueba
	}
	
	@Test
	public void test04AtacoAMonstruoEnPosicionDefensaConMayorAtaqueYNoSufroDanio() {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		huevoMonstruoso.colocarEnPosicionDefensa();
		monoAcrobata.colocarEnPosicionAtaque();
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		oponente.agregarMonstruoEnAtaque(monoAcrobata);
	
		oponente.atacar(unJugador, 0, 0);
	
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio);
	
	}
	
	@Test
	public void test05OponenteAtacaAMonstruoEnDefensaConMenorAtaqueYJugadorNoSufreDanioYSuMonstruoNoMuere() {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionDefensa();

		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		oponente.atacar(unJugador, 0,0);
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertFalse(monoAcrobata.estaEnElCementerio);
	}
}
