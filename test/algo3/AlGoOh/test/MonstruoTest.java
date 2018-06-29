package algo3.AlGoOh.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import algo3.AlGoOh.InvocacionNormal;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Monstruo;
import algo3.AlGoOh.Efectos.EfectoDestruirMonstruoAtacante;
import algo3.AlGoOh.Efectos.EfectoJinzo7;
import algo3.AlGoOh.Efectos.EfectoVacio;
import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.MonstruoNoPuedeAtacarException;
import algo3.AlGoOh.Exceptions.MonstruosInsuficientesParaSacrificioException;
import algo3.AlGoOh.Exceptions.NoHayMasFasesException;
import algo3.AlGoOh.Exceptions.ZonaNoTieneMasEspacioException;

public class MonstruoTest {
	
	@Test
	public void test01CrecarMonstruoYVerificarQueEstaBocaArriba() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		
		assertFalse(huevoMonstruoso.estaBocaAbajo());
		huevoMonstruoso.darVuelta();
		assertTrue(huevoMonstruoso.estaBocaAbajo());
	}
	
	@Test
	public void test01ColocarMonstruoEnAtaque() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal() ,1000, 1800);
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		huevoMonstruoso.atacarA(monoAcrobata, unJugador, oponente);
		
	}
	
	@Test(expected=MonstruoNoPuedeAtacarException.class)
	public void test02ColocarMonstruoEnDefensa() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal() ,1000, 1800);
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		
		huevoMonstruoso.colocarEnPosicionDefensa();
		
		huevoMonstruoso.atacarA(monoAcrobata, unJugador, oponente);
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
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		try {
			monoAcrobata.atacarA(huevoMonstruoso, unJugador, oponente);
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
	public void test08ActivarJinzo7() throws ZonaNoTieneMasEspacioException, MonstruosInsuficientesParaSacrificioException, AccionInvalidaEnEstaFaseException, NoHayMasFasesException {
		Jugador jugador = new Jugador();
		
		Monstruo jinzo7 = new Monstruo("Jinzo #7", new EfectoJinzo7(), new InvocacionNormal(), 500, 400);
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900); //Monstruo Atacado
		
		jugador.agregarMonstruoEnAtaque(jinzo7);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		jugador = jugador.pasarTurno();
		jugador.pasarFase();
		jugador.activarMonstruo(0);
		
		assertEquals(8000, jugador.obtenerPuntosDeVida());
		assertEquals(7500, jugador.pasarTurno().obtenerPuntosDeVida());
		assertFalse(huevoMonstruoso.estaEnElCementerio());
	}
	
	@Test
	public void test09VoltearInsectoComeHombres() throws MonstruoNoPuedeAtacarException, ZonaNoTieneMasEspacioException, MonstruosInsuficientesParaSacrificioException, AccionInvalidaEnEstaFaseException, NoHayMasFasesException {
		Jugador jugador = new Jugador();
		
		Monstruo insectoComeHombres = new Monstruo("Insecto come hombres", new EfectoDestruirMonstruoAtacante(), new InvocacionNormal(), 450, 600);
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900);
		
		insectoComeHombres.darVuelta();
		
		jugador.agregarMonstruoEnDefensa(insectoComeHombres);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		jugador.pasarFase();
		
		jugador.atacarA(0, 0);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(insectoComeHombres.estaEnElCementerio());
		assertEquals(8000, jugador.obtenerPuntosDeVida());
		assertEquals(8000, jugador.pasarTurno().obtenerPuntosDeVida());
	}
	
	@Test(expected=MonstruoNoPuedeAtacarException.class)
	public void test10MonstruoEnPosicionDefensaNoPuedeAtacarYNadieSufroDanio() throws MonstruoNoPuedeAtacarException {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900); //Monstruo Atacado
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal() ,1000, 1800);	  //Monstruo Atacante
		
		huevoMonstruoso.colocarEnPosicionDefensa();
		monoAcrobata.colocarEnPosicionAtaque();
		
		Jugador jugador = new Jugador();
		
		huevoMonstruoso.atacarA(monoAcrobata, jugador, jugador.pasarTurno());
		
		assertEquals(8000, jugador.obtenerPuntosDeVida());
		assertEquals(8000,jugador.pasarTurno().obtenerPuntosDeVida());
		assertFalse(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test(expected=MonstruoNoPuedeAtacarException.class)
	public void test11MonstruoBocaAbajoNoPuedeAtacarYNadieSufroDanio() throws MonstruoNoPuedeAtacarException {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900); //Monstruo Atacado
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal() ,1000, 1800);	  //Monstruo Atacante
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionAtaque();
		
		huevoMonstruoso.darVuelta();
		
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		
		huevoMonstruoso.atacarA(monoAcrobata,unJugador,oponente);
	}
}