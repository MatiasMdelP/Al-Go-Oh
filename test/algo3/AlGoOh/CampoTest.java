package algo3.AlGoOh;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CampoTest {

	@Test
	void testAgregarMonstruoEnAtaque() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Campo campo = new Campo();
		
		campo.agregarMonstruoEnAtaque(huevoMonstruoso);
		assertTrue(huevoMonstruoso.estaEnPosicionDeAtaque());
	}

	@Test
	void testAgregarMonstruoEnDefensa() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Campo campo = new Campo();
		
		campo.agregarMonstruoEnDefensa(huevoMonstruoso);
		assertFalse(huevoMonstruoso.estaEnPosicionDeAtaque());
	}

	@Test
	void testEnviarAlCementerio() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Campo campo = new Campo();
		
		campo.enviarAlCementerio(huevoMonstruoso);
		assertTrue(huevoMonstruoso.estaEnElCementerio());
	}

	@Test
	void testCombatirEnAtaque() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900); 
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		Campo campo = new Campo();
		
		campo.agregarMonstruoEnAtaque(huevoMonstruoso);
		campo.agregarMonstruoEnAtaque(monoAcrobata);
		assertEquals(-400,campo.combatir(1, 0));
		assertEquals(400,campo.combatir(0, 1));
		assertEquals(0,campo.combatir(0, 0));
	
	}
	
	@Test
	void testCombatirEnDefensa() {
		//modificar
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900); 
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		Campo campo = new Campo();
		
		campo.agregarMonstruoEnAtaque(huevoMonstruoso);
		campo.agregarMonstruoEnAtaque(monoAcrobata);
		assertEquals(-400,campo.combatir(1, 0));
		assertEquals(400,campo.combatir(0, 1));
		assertEquals(0,campo.combatir(0, 0));
	
	}
	
	@Test
	void testUsarCartaMagica() {
		//modificar
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900); 
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		Campo campo = new Campo();
		Efecto efecto = new EfectoMatarATodos(campo);
		Carta agujeroNegro = new Magica(efecto);
		
		campo.agregarMonstruoEnAtaque(huevoMonstruoso);
		campo.agregarMonstruoEnAtaque(monoAcrobata);
		campo.agregarMagicaBocaArriba(agujeroNegro);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
		assertTrue(agujeroNegro.estaEnElCementerio());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
