package algo3.AlGoOh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class MonstruoTests {
	
	@Test
	public void test01ColocarMonstruoEnAtaque() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 600, 900);
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		
		assertTrue(huevoMonstruoso.estaEnPosicionDeAtaque());
	}
	
	@Test
	public void test02ColocarMonstruoEnDefensa() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 600, 900);
		
		huevoMonstruoso.colocarEnPosicionDefensa();
		
		assertFalse(huevoMonstruoso.estaEnPosicionDeAtaque());
	}
	
}
