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
	public void test03CrearCartaMontruoYVerificarQueNoEstaEnElCementerio(){
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
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900); //Monstruo Atacado
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);	  //Monstruo Atacante
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionAtaque();
		
		assertEquals(-400, monoAcrobata.atacarA(huevoMonstruoso));
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test06AtacarConMonstruoConMenorAtaqueSeDestruyeAtacanteYVerificarQueEstaEnElCementerio() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900); //Monstruo Atacante
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);     //Monstruo Atacado
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionAtaque();

		assertEquals(400, huevoMonstruoso.atacarA(monoAcrobata));
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
		
	}
	
	@Test
	public void test07AtacarAMonstruoEnModoDefensaConMayorAtaqueYSeDestruyeAtacado() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900); //Monstruo Atacado
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);	  //Monstruo Atacante
		
		huevoMonstruoso.colocarEnPosicionDefensa();
		monoAcrobata.colocarEnPosicionAtaque();
		
		assertEquals(0, monoAcrobata.atacarA(huevoMonstruoso));
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
}