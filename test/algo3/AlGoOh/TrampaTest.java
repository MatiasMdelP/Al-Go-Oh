package algo3.AlGoOh;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
