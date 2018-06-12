package algo3.AlGoOh;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

class MagicaTest {

	@Test
	void test01CrearCartaMagicaYVerificarQueEstaBocaAbajo() {
		Magica cartaMagica = new Magica();
		
		assertFalse(cartaMagica.estaBocaAbajo());
	}
	
	@Test
	void test02PonerCartaMagicaBocaArriba() {
		Magica cartaMagica = new Magica();
		
		cartaMagica.darVuelta();
		
		assertTrue(cartaMagica.estaBocaAbajo());
	}
	
	@Test
	void test03CartaMagicaBocaAbajoNoRealizaEfecto() {
		Magica cartaMagica = new Magica();
		
		cartaMagica.darVuelta();
		
		assertFalse(cartaMagica.realizarEfecto());
	}

}
