package algo3.AlGoOh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class MonstruoTest {
	
	@Test
	public void test01CrecarMonstruoYVerificarQueEstaBocaArriba() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		
		assertTrue(huevoMonstruoso.estaBocaArriba());
		huevoMonstruoso.darVuelta();
		assertFalse(huevoMonstruoso.estaBocaArriba());
	}
	
	@Test
	public void test01ColocarMonstruoEnAtaque() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		
		assertTrue(huevoMonstruoso.estaEnPosicionDeAtaque());
	}
	
	@Test
	public void test02ColocarMonstruoEnDefensa() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		
		huevoMonstruoso.colocarEnPosicionDefensa();
		
		assertFalse(huevoMonstruoso.estaEnPosicionDeAtaque());
	}
	
	@Test
	public void test03CrearCartaMontruoYVerificarQueNoEstaEnElCementerio(){
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		
		assertFalse(huevoMonstruoso.estaEnElCementerio());
	}
	
	@Test
	public void test04MandarCartaMontruoAlCementerioYVerificarQueEstaAhi(){
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900);
		
		huevoMonstruoso.mandarAlCementerio();
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
	}

	@Test
	public void test05AtacarConMonstruoConMayorAtaqueYMatarYVerificarQueEstaEnElCementerio() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900); //Monstruo Atacado
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal() ,1000, 1800);	  //Monstruo Atacante
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionAtaque();
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		try {
			monoAcrobata.atacarA(huevoMonstruoso,unJugador,oponente);
			assertEquals(7600,oponente.obtenerPuntosDeVida());
		} catch (MonstruoNoPuedeAtacarException e) {
			assertTrue(false);
		}
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test06AtacarConMonstruoConMenorAtaqueSeDestruyeAtacanteYVerificarQueEstaEnElCementerio() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900); //Monstruo Atacante
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal() ,1000, 1800);     //Monstruo Atacado
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionAtaque();

		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		try {
			huevoMonstruoso.atacarA(monoAcrobata,unJugador,oponente);
			assertEquals(7600,unJugador.obtenerPuntosDeVida());
		} catch (MonstruoNoPuedeAtacarException e) {
			assertTrue(false);
		}
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
		
	}
	
	@Test
	public void test07AtacarAMonstruoEnModoDefensaConMayorAtaqueYSeDestruyeAtacado() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900); //Monstruo Atacado
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal() ,1000, 1800);	  //Monstruo Atacante
		
		huevoMonstruoso.colocarEnPosicionDefensa();
		monoAcrobata.colocarEnPosicionAtaque();
		
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		try {
			monoAcrobata.atacarA(huevoMonstruoso,unJugador,oponente);
			assertEquals(8000,unJugador.obtenerPuntosDeVida());
			assertEquals(8000,oponente.obtenerPuntosDeVida());
		} catch (MonstruoNoPuedeAtacarException e) {
			assertTrue(false);
		}
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test08ActivarJinzo7() {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo jinzo7 = new Monstruo("Jinzo #7", new EfectoJinzo7(), new InvocacionNormal(), 500, 400);
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900); //Monstruo Atacado
		
		try {
			unJugador.agregarMonstruoEnAtaque(jinzo7);
			oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		} catch (MonstruosInsuficientesParaSacrificioException e) {
			assertTrue(false);
		}
		
		
		unJugador.activarMonstruo(0);
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(7500, oponente.obtenerPuntosDeVida());
		assertFalse(huevoMonstruoso.estaEnElCementerio());
	}
	
	@Test
	public void test09VoltearInsectoComeHombres() throws MonstruoNoPuedeAtacarException {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo insectoComeHombres = new Monstruo("Insecto come hombres", new EfectoDestruirMonstruoAtacante(), new InvocacionNormal(), 450, 600);
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900);
		
		insectoComeHombres.darVuelta();
		
		try {
			oponente.agregarMonstruoEnDefensa(insectoComeHombres);
			unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		} catch (MonstruosInsuficientesParaSacrificioException e) {
			assertTrue(false);
		}
		
		unJugador.atacarA(0, 0);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(insectoComeHombres.estaEnElCementerio());
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
	}
	
	@Test
	public void test10MonstruoEnPosicionDefensaNoPuedeAtacarYNadieSufroDanio() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900); //Monstruo Atacado
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal() ,1000, 1800);	  //Monstruo Atacante
		
		huevoMonstruoso.colocarEnPosicionDefensa();
		monoAcrobata.colocarEnPosicionAtaque();
		
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		
		boolean seLanzoLaExcepcion = false; 
		
		try {
			huevoMonstruoso.atacarA(monoAcrobata,unJugador,oponente);
			assertEquals(8000,unJugador.obtenerPuntosDeVida());
			assertEquals(8000,oponente.obtenerPuntosDeVida());
		} catch (MonstruoNoPuedeAtacarException e) {
			seLanzoLaExcepcion = true;
		}
		
		assertTrue(seLanzoLaExcepcion);
		assertFalse(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test11MonstruoBocaAbajoNoPuedeAtacarYNadieSufroDanio() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900); //Monstruo Atacado
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal() ,1000, 1800);	  //Monstruo Atacante
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionAtaque();
		
		huevoMonstruoso.darVuelta();
		
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		
		boolean seLanzoLaExcepcion = false; 
		
		try {
			huevoMonstruoso.atacarA(monoAcrobata,unJugador,oponente);
			assertEquals(8000,unJugador.obtenerPuntosDeVida());
			assertEquals(8000,oponente.obtenerPuntosDeVida());
		} catch (MonstruoNoPuedeAtacarException e) {
			seLanzoLaExcepcion = true;
		}
		
		assertTrue(seLanzoLaExcepcion);
		assertFalse(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
}