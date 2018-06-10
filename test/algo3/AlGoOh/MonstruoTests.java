package algo3.AlGoOh;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class MonstruoTests {
	
	@Test
	public void test01ColocarMonstruoEnAtaque() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		
		assertTrue(huevoMonstruoso.estaEnPosicionDeAtaque());
	}
	
	@Test
	public void test02ColocarMonstruoEnDefensa() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		
		huevoMonstruoso.colocarEnPosicionDefensa();
		
		assertFalse(huevoMonstruoso.estaEnPosicionDeAtaque());
	}
	
	@Test
	public void test03CrearCartaMontruoYVerificarQueNoEstaEnElCementero(){
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		
		assertFalse(huevoMonstruoso.estaEnElCementerio());
	}
	
	@Test
	public void test04MandarCartaMontruoAlCementerioYVerificarQueEstaAhi(){
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		
		huevoMonstruoso.mandarAlCementerio();
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
	}

	@Test
	public void test05AtacarConMonstruoConMAyorAtaqueYMatarYVerificarQueEstaEnElCementerio() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobatico = new Monstruo("Huevo Monstruoso", 3, 1000, 1800);
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobatico.colocarEnPosicionAtaque();
		
		monoAcrobatico.atacar(huevoMonstruoso);
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertEquals(huevoMonstruoso.getVida(),-400);
		
	}
	
	
	
	
	
	
	
}
