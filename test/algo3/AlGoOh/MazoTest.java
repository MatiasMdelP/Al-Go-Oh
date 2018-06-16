package algo3.AlGoOh;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import jdk.nashorn.internal.ir.ThrowNode;


public class MazoTest {

	@Test (expected=ElMazoNoTieneCartasException.class)
	public void test01AlIniciarNoPuedoSacarUnaCartaPorqueEstaVacio() {
		Mazo unMazo = new Mazo();
		unMazo.tomarUnaCarta();
	}
	
	@Test
	public void test02AlPonerUnaCartaLuegoPuedoSacarla() {
		Mazo unMazo = new Mazo();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		unMazo.agregarUnaCartaAlMazo(huevoMonstruoso);
		
		assertEquals(huevoMonstruoso, unMazo.tomarUnaCarta());
	}
	
	@Test(expected=ElMazoNoTieneCartasException.class)
	public void test03AlPonerUnaCartaPuedoSacarUnaPeroNoDos() {
		Mazo unMazo = new Mazo();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		unMazo.agregarUnaCartaAlMazo(huevoMonstruoso);
		Carta primeraCarta = unMazo.tomarUnaCarta();
		
		unMazo.tomarUnaCarta();
	}
}
