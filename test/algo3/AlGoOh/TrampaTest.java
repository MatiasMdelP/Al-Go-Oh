package algo3.AlGoOh;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

class TrampaTest {

	@Test
	void test01CrearCartaTrampaYVerificarQueEstaArriba() {
		Trampa cartaTrampa = new Trampa();
		
		assertFalse(cartaTrampa.estaBocaAbajo());
	}
	
	@Test
	void test02PonerCartaTrampaBocaAbajo() {
		Trampa cartaTrampa = new Trampa();
		
		cartaTrampa.darVuelta();
		
		assertTrue(cartaTrampa.estaBocaAbajo());
	}

}
