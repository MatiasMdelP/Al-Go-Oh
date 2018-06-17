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
		Mazo unMazo = new Mazo();
		Campo unCampo = new Campo(unMazo);
		Mazo mazoOponente = new Mazo();
		Campo campoOponente = new Campo(mazoOponente);
		Jugador unJugador= new Jugador(unCampo);
		Jugador oponente = new Jugador(campoOponente);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		oponente.agregarMonstruoEnDefensa(huevoMonstruoso);
		
		DeCampo wasteland = new DeCampo("Wasteland", new EfectoWasteland());
		wasteland.agregarAlCampo(unCampo, campoOponente);
		wasteland.realizarEfecto();
		
		unJugador.atacarA(oponente, 0, 0);
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
	}
}
