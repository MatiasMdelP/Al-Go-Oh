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
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		unJugador.atacarA(oponente, 0, 0);
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(7600, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test03AtacoAMonstruoEnPosicionAtaqueConMayorAtaqueYSufroDanio() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		oponente.agregarMonstruoEnAtaque(monoAcrobata);
		
		unJugador.atacarA(oponente, 0, 0);
		
		assertEquals(7600, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	
	@Test
	public void test04AtacoAMonstruoEnPosicionAtaqueConIgualAtaqueYNaDieSufreDanioYAmbosMontruosVanAlCementerio() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso1 = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo huevoMonstruoso2 = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso1);
		oponente.agregarMonstruoEnAtaque(huevoMonstruoso2);
		
		unJugador.atacarA(oponente, 0, 0);
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso1.estaEnElCementerio());
		assertTrue(huevoMonstruoso2.estaEnElCementerio());
	}
	
	
	@Test
	public void test05AtacoAMonstruoEnPosicionDefensaConMenorAtaqueYOponenteNoSufreDanio() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		oponente.agregarMonstruoEnDefensa(huevoMonstruoso);
	
		unJugador.atacarA(oponente, 0, 0);
	
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test06AtacoAMonstruoEnPosicionDefensaConMayorAtaqueYSufroDanioIgualALaDiferenciaEntrePuntosDeAtaqueYDefensa() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);

		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		oponente.agregarMonstruoEnDefensa(monoAcrobata);
		
		unJugador.atacarA(oponente, 0,0);
		
		assertEquals(6800, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test07AtacoAMonstruoEnPosicionDefensaConIgualAtaqueYNadieSufreDanio() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso1 = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo huevoMonstruoso2 = new Monstruo("Huevo Monstruoso", 3, 600, 900);

		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso1);
		oponente.agregarMonstruoEnDefensa(huevoMonstruoso2);
		
		unJugador.atacarA(oponente, 0,0);
		
		assertEquals(7700, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso1.estaEnElCementerio());
		assertFalse(huevoMonstruoso2.estaEnElCementerio());
	}

	@Test 
	public void test08InvocacionDeMonstruoDe5Estrellas() {
		Jugador unJugador= new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo unMonstruoDe5Estrellas = new Monstruo("Monstruo", 5, 1800, 1800);
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		unJugador.agregarMonstruoEnAtaque(unMonstruoDe5Estrellas);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
	
	}

	@Test 
	public void test09InvocacionDeMonstruoDe7Estrellas() {
		Jugador unJugador= new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		Monstruo dragonBlanco = new Monstruo("Dragon Blanco De Ojos Azules", 8, 3000, 2500);
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		unJugador.agregarMonstruoEnAtaque(dragonBlanco);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
	}
}
