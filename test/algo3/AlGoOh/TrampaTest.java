package algo3.AlGoOh;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TrampaTest {

	@Test
	public void test01CrearCartaTrampaYVerificarQueEstaArriba() {
		Trampa cartaTrampa = new Trampa("Un nombre", null);
		
		assertFalse(cartaTrampa.estaBocaAbajo());
	}

	@Test
	public void test02PonerCartaTrampaBocaAbajo() {
		Trampa cartaTrampa = new Trampa("Un nombre", null);
		
		cartaTrampa.darVuelta();
		
		assertTrue(cartaTrampa.estaBocaAbajo());
	}
}