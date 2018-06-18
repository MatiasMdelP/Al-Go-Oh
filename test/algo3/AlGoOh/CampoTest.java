package algo3.AlGoOh;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class CampoTest {

	@Test
	public void test01AlIniciarNoTengoCartasEnMano() {
		Mazo unMazo = new Mazo();
		unMazo.inicializarMazo();
		Campo unCampo = new Campo(unMazo);
		
		assertEquals(0, unCampo.obtenerCantidadDeCartasEnLaMano());
	}
	
	@Test
	public void test02AlTomarUnaCartaTengoUnaEnMano() {
		Mazo unMazo = new Mazo();
		unMazo.inicializarMazo();
		Campo unCampo = new Campo(unMazo);
		unCampo.tomarUnaCartaDelMazo();
		
		assertEquals(1, unCampo.obtenerCantidadDeCartasEnLaMano());
	}
	
	@Test
	public void test03ActivarWasteland() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		oponente.agregarMonstruoEnDefensa(huevoMonstruoso);
		
		
		DeCampo wasteland = new DeCampo("Wasteland", new EfectoWasteland());
		unJugador.agregarCartaCampo(wasteland);
		unJugador.atacarA(0, 0);
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test04ActivarSogen() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		oponente.agregarMonstruoEnDefensa(huevoMonstruoso);
		
		
		DeCampo sogen = new DeCampo("Sogen", new EfectoSogen());
		oponente.agregarCartaCampo(sogen);
		unJugador.atacarA(oponente, 0, 0);
		
		assertEquals(7800, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
}
