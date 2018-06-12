package algo3.AlGoOh;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MagicaTest {

	@Test
	public void test01CrearCartaMagicaYVerificarQueEstaBocaAbajo() {
		Magica cartaMagica = new Magica(new EfectoNulo());
		
		assertTrue(cartaMagica.estaBocaAbajo());
	}
	
	@Test
	public void test02PonerCartaMagicaBocaArriba() {
		Magica cartaMagica = new Magica(new EfectoNulo());

		
		cartaMagica.darVuelta();
		
		assertFalse(cartaMagica.estaBocaAbajo());
	}
	
	@Test
	public void test03CartaMagicaBocaAbajoNoRealizaEfecto() {
		Magica cartaMagica = new Magica(new EfectoNulo());
		
		assertFalse(cartaMagica.realizarEfecto());
	}

}
