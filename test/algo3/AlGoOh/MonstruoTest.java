package algo3.AlGoOh;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class MonstruoTest {
	
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
	public void test05AtacarConMonstruoConMayorAtaqueYMatarYVerificarQueEstaEnElCementerio() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionAtaque();
		
		monoAcrobata.atacar(huevoMonstruoso);
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertEquals(huevoMonstruoso.getVida(),-400);
		
	}
	
	@Test
	public void test06AtacarConMonstruoConMenorAtaqueSeDestruyeAtacanteYVerificarQueEstaEnElCementerio() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionAtaque();

		huevoMonstruoso.atacar(monoAcrobata);
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertEquals(huevoMonstruoso.getVida(),-400);
		
	}
	
	@Test
	public void test07AtacarAMonstruoEnModoDefensaConMayorAtaqueYSeDestruyeAtacado() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		huevoMonstruoso.colocarEnPosicionDefensa();
		monoAcrobata.colocarEnPosicionAtaque();

		monoAcrobata.atacar(huevoMonstruoso);
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertEquals(huevoMonstruoso.getVida(),-100);
	}

	@Test
	public void test08AtacarAMonstruoEnModoDefensaConMenorAtaqueYNoPasaNada() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);
		
		huevoMonstruoso.colocarEnPosicionDefensa();
		monoAcrobata.colocarEnPosicionAtaque();

		huevoMonstruoso.atacar(monoAcrobata);
		assertFalse(monoAcrobata.estaEnElCementerio());
		//assertEquals(monoAcrobata.getVida(),0);
	}
}
