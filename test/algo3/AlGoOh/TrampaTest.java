package algo3.AlGoOh;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TrampaTest {

	@Test
	public void test01CrearCartaTrampaYVerificarQueEstaArriba() {
		Trampa cartaTrampa = new Trampa();
		
		assertFalse(cartaTrampa.estaBocaAbajo());
	}
	
	@Test
	public void test02PonerCartaTrampaBocaAbajo() {
		Trampa cartaTrampa = new Trampa();
		
		cartaTrampa.darVuelta();
		
		assertTrue(cartaTrampa.estaBocaAbajo());
	}

}
