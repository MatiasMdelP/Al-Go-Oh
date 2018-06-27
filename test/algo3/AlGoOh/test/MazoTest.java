package algo3.AlGoOh.test;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

import algo3.AlGoOh.InvocacionNormal;
import algo3.AlGoOh.Mazo;
import algo3.AlGoOh.Monstruo;
import algo3.AlgoOh.Exceptions.ElMazoNoTieneCartasException;


public class MazoTest {

	@Test (expected=ElMazoNoTieneCartasException.class)
	public void test01AlIniciarNoPuedoSacarUnaCartaPorqueEstaVacio() {
		Mazo unMazo = new Mazo();
		unMazo.tomarUnaCarta();
	}
	
	@Test
	public void test02AlPonerUnaCartaLuegoPuedoSacarla() {
		Mazo unMazo = new Mazo();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", null, new InvocacionNormal(), 600, 900);
		unMazo.agregarUnaCartaAlMazo(huevoMonstruoso);
		
		assertEquals(huevoMonstruoso, unMazo.tomarUnaCarta());
	}
	
	@Test(expected=ElMazoNoTieneCartasException.class)
	public void test03AlPonerUnaCartaPuedoSacarUnaPeroNoDos() {
		Mazo unMazo = new Mazo();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", null, new InvocacionNormal() ,600, 900);
		unMazo.agregarUnaCartaAlMazo(huevoMonstruoso);
		unMazo.tomarUnaCarta();
		unMazo.tomarUnaCarta();
	}
}
