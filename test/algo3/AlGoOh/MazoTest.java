package algo3.AlGoOh;


import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class MazoTest {

	@Test (expected=ElMazoNoTieneCartasException.class)
	public void test01AlIniciarNoPuedoSacarUnaCartaPorqueEstaVacio() {
		Mazo unMazo = new Mazo();
		unMazo.tomarUnaCarta();
	}
	
	@Test
	public void test02AlPonerUnaCartaLuegoPuedoSacarla() {
		Mazo unMazo = new Mazo();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", null, 3,new InvocacionNormal(), 600, 900);
		unMazo.agregarUnaCartaAlMazo(huevoMonstruoso);
		
		assertEquals(huevoMonstruoso, unMazo.tomarUnaCarta());
	}
	
	@Test(expected=ElMazoNoTieneCartasException.class)
	public void test03AlPonerUnaCartaPuedoSacarUnaPeroNoDos() {
		Mazo unMazo = new Mazo();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", null, 3,new InvocacionNormal() ,600, 900);
		unMazo.agregarUnaCartaAlMazo(huevoMonstruoso);
		unMazo.tomarUnaCarta();
		unMazo.tomarUnaCarta();
	}
}
