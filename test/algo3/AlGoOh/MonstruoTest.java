package algo3.AlGoOh;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class MonstruoTest {
	
	@Test
	public void test01ColocarMonstruoEnAtaque() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", null, 3, new InvocacionNormal(), 600, 900);
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		
		assertTrue(huevoMonstruoso.estaEnPosicionDeAtaque());
	}
	
	@Test
	public void test02ColocarMonstruoEnDefensa() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", null, 3, new InvocacionNormal(), 600, 900);
		
		huevoMonstruoso.colocarEnPosicionDefensa();
		
		assertFalse(huevoMonstruoso.estaEnPosicionDeAtaque());
	}
	
	@Test
	public void test03CrearCartaMontruoYVerificarQueNoEstaEnElCementerio(){
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", null, 3, new InvocacionNormal(), 600, 900);
		
		assertFalse(huevoMonstruoso.estaEnElCementerio());
	}
	
	@Test
	public void test04MandarCartaMontruoAlCementerioYVerificarQueEstaAhi(){
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", null, 3, new InvocacionNormal() ,600, 900);
		
		huevoMonstruoso.mandarAlCementerio();
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
	}

	@Test
	public void test05AtacarConMonstruoConMayorAtaqueYMatarYVerificarQueEstaEnElCementerio() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", null, 3,new InvocacionNormal() ,600, 900); //Monstruo Atacado
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", null, 3,new InvocacionNormal() ,1000, 1800);	  //Monstruo Atacante
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionAtaque();
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		assertEquals(400, monoAcrobata.atacarA(huevoMonstruoso,unJugador,oponente));
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test06AtacarConMonstruoConMenorAtaqueSeDestruyeAtacanteYVerificarQueEstaEnElCementerio() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", null, 3,new InvocacionNormal() ,600, 900); //Monstruo Atacante
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", null, 3,new InvocacionNormal() ,1000, 1800);     //Monstruo Atacado
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionAtaque();

		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		assertEquals(400, huevoMonstruoso.atacarA(monoAcrobata,unJugador,oponente));
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
		
	}
	
	@Test
	public void test07AtacarAMonstruoEnModoDefensaConMayorAtaqueYSeDestruyeAtacado() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", null, 3,new InvocacionNormal() ,600, 900); //Monstruo Atacado
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", null, 3,new InvocacionNormal() ,1000, 1800);	  //Monstruo Atacante
		
		huevoMonstruoso.colocarEnPosicionDefensa();
		monoAcrobata.colocarEnPosicionAtaque();
		
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		assertEquals(0, monoAcrobata.atacarA(huevoMonstruoso,unJugador,oponente));
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test08ActivarJinzo7() {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo jinzo7 = new Monstruo("Jinzo #7", new EfectoJinzo7(), 2, new InvocacionNormal(), 500, 400);
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", null, 3,new InvocacionNormal() ,600, 900); //Monstruo Atacado
		
		try {
			unJugador.agregarMonstruoEnAtaque(jinzo7);
			oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		} catch (MonstruosInsuficientesParaSacrificioException e) {
			assertTrue(false);
		}
		
		
		unJugador.activarMonstruo(0);
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(7500, oponente.obtenerPuntosDeVida());
		assertFalse(huevoMonstruoso.estaEnElCementerio);
	}
}