package algo3.AlGoOh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class MonstruoTest {
	
	@Test
	public void test01CrecarMonstruoYVerificarQueEstaBocaArriba() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3, new InvocacionNormal(), 600, 900);
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		
		assertFalse(huevoMonstruoso.estaBocaAbajo());
		huevoMonstruoso.darVuelta();
		assertTrue(huevoMonstruoso.estaBocaAbajo());
	}
	
	@Test
	public void test01ColocarMonstruoEnAtaque() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3, new InvocacionNormal(), 600, 900);
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		
		assertTrue(huevoMonstruoso.estaEnPosicionDeAtaque());
	}
	
	@Test
	public void test02ColocarMonstruoEnDefensa() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3, new InvocacionNormal(), 600, 900);
		
		huevoMonstruoso.colocarEnPosicionDefensa();
		
		assertFalse(huevoMonstruoso.estaEnPosicionDeAtaque());
	}
	
	@Test
	public void test03CrearCartaMontruoYVerificarQueNoEstaEnElCementerio(){
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3, new InvocacionNormal(), 600, 900);
		
		assertFalse(huevoMonstruoso.estaEnElCementerio());
	}
	
	@Test
	public void test04MandarCartaMontruoAlCementerioYVerificarQueEstaAhi(){
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3, new InvocacionNormal() ,600, 900);
		
		huevoMonstruoso.mandarAlCementerio();
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
	}

	@Test
	public void test05AtacarConMonstruoConMayorAtaqueYMatarYVerificarQueEstaEnElCementerio() throws MonstruoNoPuedeAtacarException {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal() ,600, 900); //Monstruo Atacado
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), 3,new InvocacionNormal() ,1000, 1800);	  //Monstruo Atacante
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionAtaque();
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		
		monoAcrobata.atacarA(huevoMonstruoso,unJugador,oponente);
		assertEquals(7600,oponente.obtenerPuntosDeVida());
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test06AtacarConMonstruoConMenorAtaqueSeDestruyeAtacanteYVerificarQueEstaEnElCementerio() throws MonstruoNoPuedeAtacarException {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal() ,600, 900); //Monstruo Atacante
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), 3,new InvocacionNormal() ,1000, 1800);     //Monstruo Atacado
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionAtaque();

		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		
		huevoMonstruoso.atacarA(monoAcrobata, unJugador, oponente);
		
		assertEquals(7600,unJugador.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
		
	}
	
	@Test
	public void test07AtacarAMonstruoEnModoDefensaConMayorAtaqueYSeDestruyeAtacado() throws MonstruoNoPuedeAtacarException {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal() ,600, 900); //Monstruo Atacado
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), 3,new InvocacionNormal() ,1000, 1800);	  //Monstruo Atacante
		
		huevoMonstruoso.colocarEnPosicionDefensa();
		monoAcrobata.colocarEnPosicionAtaque();
		
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		
		monoAcrobata.atacarA(huevoMonstruoso,unJugador,oponente);
		assertEquals(8000,unJugador.obtenerPuntosDeVida());
		assertEquals(8000,oponente.obtenerPuntosDeVida());
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test08ActivarJinzo7() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo jinzo7 = new Monstruo("Jinzo #7", new EfectoJinzo7(), 2, new InvocacionNormal(), 500, 400);
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal() ,600, 900); //Monstruo Atacado
		
		unJugador.agregarMonstruoEnAtaque(jinzo7);
		oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		unJugador.activarMonstruo(0);
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(7500, oponente.obtenerPuntosDeVida());
		assertFalse(huevoMonstruoso.estaEnElCementerio());
	}
	
	@Test
	public void test09VoltearInsectoComeHombres() throws MonstruoNoPuedeAtacarException, MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo insectoComeHombres = new Monstruo("Insecto come hombres", new EfectoDestruirMonstruoAtacante(), 2, new InvocacionNormal(), 450, 600);
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal() ,600, 900);
		
		insectoComeHombres.darVuelta();
		
		oponente.agregarMonstruoEnDefensa(insectoComeHombres);
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		unJugador.atacarA(0, 0);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(insectoComeHombres.estaEnElCementerio());
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
	}	
}