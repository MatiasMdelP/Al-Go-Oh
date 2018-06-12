package algo3.AlGoOh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JugadorTest {
	
	@Test
	public void test01JugadorRecienCreadoTiene8000PuntosDeVida() {
		Jugador unJugador = new Jugador(new Campo());
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
	}
	
	@Test
	public void test02AtacoAMonstruoEnPosicionAtaqueConMenorAtaqueYSeReduceLaVidaDelJugadorAtacado() {
		Campo campo = new Campo();
		Jugador unJugador= new Jugador(campo);
		Jugador oponente = new Jugador(campo);
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		oponente.atacar(unJugador, 1, 0);
		
		assertEquals(7600, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test03AtacoAMonstruoEnPosicionAtaqueConMayorAtaqueYSufroDanio() {
		Campo campo = new Campo();
		Jugador unJugador = new Jugador(campo);
		Jugador oponente = new Jugador(campo);
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		oponente.atacar(unJugador, 1, 0);
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(7600, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	
	@Test
	public void test04AtacoAMonstruoEnPosicionAtaqueConIgualAtaqueYNaDieSufreDanioYAmbosMontruosVanAlCementerio() {
		Campo campo = new Campo();
		Jugador unJugador = new Jugador(campo);
		Jugador oponente = new Jugador(campo);
		Monstruo huevoMonstruoso1 = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo huevoMonstruoso2 = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso1);
		oponente.agregarMonstruoEnAtaque(huevoMonstruoso2);
		
		oponente.atacar(unJugador, 1, 0);
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso1.estaEnElCementerio());
		assertTrue(huevoMonstruoso2.estaEnElCementerio());
	}
	
	
	@Test
	public void test05AtacoAMonstruoEnPosicionDefensaConMayorAtaqueYNoSufroDanio() {
		Campo campo = new Campo();
		Jugador unJugador = new Jugador(campo);
		Jugador oponente = new Jugador(campo);
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		unJugador.agregarMonstruoEnDefensa(huevoMonstruoso);
		oponente.agregarMonstruoEnAtaque(monoAcrobata);
	
		oponente.atacar(unJugador, 1, 0);
	
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
	
	}
	
	@Test
	public void test06OponenteAtacaAMonstruoEnDefensaConMenorAtaqueYJugadorNoSufreDanioYSuMonstruoNoMuere() {
		Campo campo = new Campo();
		Jugador unJugador = new Jugador(campo);
		Jugador oponente = new Jugador(campo);
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionDefensa();

		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		oponente.atacar(unJugador, 1,0);
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test07OponenteUsaCartaMagicaMAtarATodosYLasCArtasMuerenYNadieSeDanio() {
		Campo campo = new Campo();
		Jugador unJugador = new Jugador(campo);
		Jugador oponente = new Jugador(campo);
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		Efecto efecto = new EfectoMatarATodos(campo);
		Carta agujeroNegro = new Magica(efecto);
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionDefensa();


		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		oponente.agregarMagicaBocaArriba(agujeroNegro);

		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
		assertTrue(agujeroNegro.estaEnElCementerio());
	}
}
