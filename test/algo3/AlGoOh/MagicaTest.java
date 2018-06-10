package algo3.AlGoOh;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MagicaTest {

	@Test
	void test01CrearCartaMagicaYVerificarQueEstaBocaAbajo() {
		Magica cartaMagica = new Magica();
		
		assertFalse(cartaMagica.estaBocaAbajo());
	}
	
	@Test
	void test02CrearCartaMagicaYVerificarQueEstaBocaAbajo() {
		Magica cartaMagica = new Magica();
		
		cartaMagica.darVuelta();
		
		assertTrue(cartaMagica.estaBocaAbajo());
	}

}
