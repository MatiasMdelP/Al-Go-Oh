package algo3.AlGoOh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class CampoTest {

	@Test
	public void test01AgregarMonstruoYDefinirloYObtenerlo() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900);
		Campo campo = new Campo(new Mazo());
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		campo.agregarMonstruo(huevoMonstruoso);
		campo.definirMonstruo(0);
		
		assertEquals(600,campo.calcularDanio());
		assertEquals(huevoMonstruoso,campo.obtenerMonstruo());
	}
	
	@Test
	public void test02AgregarMonstruoYDefinirloYMandarloAlCemneterio() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900);
		Campo campo = new Campo(new Mazo());
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		campo.agregarMonstruo(huevoMonstruoso);
		campo.definirMonstruo(0);
		
		campo.mandarMonstruoDefinidoAlCementerio();
		assertTrue(huevoMonstruoso.estaEnElCementerio());
	}
	
	@Test
	public void test03AgregarMonstruosYMandarlosAlCementerio() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		Campo campo = new Campo(new Mazo());
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		monoAcrobata.colocarEnPosicionDefensa();
		campo.agregarMonstruo(huevoMonstruoso);
		campo.agregarMonstruo(monoAcrobata);
		
		campo.mandarMonstruoAlCementerio(1);
		campo.mandarMonstruoAlCementerio(0);
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test04AgregarCartasTrampaOMagicasYMandarlasAlCementerio() throws ZonaNoTieneMasEspacioException {
		Trampa reinforcements1 = new Trampa("Reinforcements", new EfectoAumentar500Ataque());
		Campo campo = new Campo(new Mazo());
		
		campo.agregarTrampa(reinforcements1);
		campo.mandarMagicaOTrampaAlCementerio(0);
		
		assertTrue(reinforcements1.estaEnElCementerio());
	}

	
	@Test(expected = CartaNoEncontradaException.class)
	public void test05MandarMonstruoNoAgregadoAlCementerioYobtenerExcepcion() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900);
		Campo campo = new Campo(new Mazo());
		huevoMonstruoso.colocarEnPosicionAtaque();
			
		campo.mandarMonstruoAlCementerio(huevoMonstruoso);
	}
	
	@Test
	public void test06TomarCartaDelMazo() {
		Campo campo = new Campo(new Mazo());
		Carta carta = campo.tomarUnaCartaDelMazo();
		
		assertTrue(carta != null);
	}
	
	@Test 
	public void test07ActivarUnTrampa() throws InterrumpirAtaqueException, ZonaNoTieneMasEspacioException {
		Trampa vacio = new Trampa("Vacio", new EfectoVacio());
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Campo campo = new Campo(new Mazo());
		Campo campoOponente = new Campo(new Mazo());
		
		assertFalse(vacio.estaEnElCementerio());
		assertTrue(vacio.estaBocaAbajo());
		campo.agregarTrampa(vacio);
		campo.activarTrampa(campo, campoOponente, unJugador, oponente);
		assertTrue(vacio.estaEnElCementerio());
	}
	
	@Test 
	public void test08ActivarUnTrampaHabiendoDosOmasCartasAgregadas() throws InterrumpirAtaqueException, ZonaNoTieneMasEspacioException {
		Trampa vacio1 = new Trampa("Vacio", new EfectoVacio());
		Trampa vacio2 = new Trampa("Vacio", new EfectoVacio());
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Campo campo = new Campo(new Mazo());
		Campo campoOponente = new Campo(new Mazo());
		
		assertFalse(vacio1.estaEnElCementerio());
		assertTrue(vacio1.estaBocaAbajo());
		assertFalse(vacio2.estaEnElCementerio());
		assertTrue(vacio2.estaBocaAbajo());
		campo.agregarTrampa(vacio1);
		campo.agregarTrampa(vacio2);
		campo.activarTrampa(campo, campoOponente, unJugador, oponente);
		assertTrue(vacio1.estaEnElCementerio());
		assertFalse(vacio2.estaEnElCementerio());
		assertTrue(vacio2.estaBocaAbajo());
	}
	
	@Test
	public void test09ActivarWasteland() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);// 900 + 300 = 1200
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);	//1000+200 = 1200
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		oponente.agregarMonstruoEnDefensa(huevoMonstruoso);
		
		Carta wasteland = new Carta("Wasteland", new EfectoWasteland());
		unJugador.agregarCartaCampo(wasteland);
		try {
			unJugador.atacarA(0, 0);
		} catch (MonstruoNoPuedeAtacarException e) {
			assertTrue(false);
		}
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test10ActivarSogen() throws ZonaNoTieneMasEspacioException {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900); // 900 + 500 = 1400
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800); 	  // 1000 + 200 = 1200
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		try {
			unJugador.agregarMonstruoEnAtaque(monoAcrobata);
			oponente.agregarMonstruoEnDefensa(huevoMonstruoso);
		}catch (MonstruosInsuficientesParaSacrificioException excepcion) {
			assertTrue(false);
		}
		
		Carta sogen = new Carta("Sogen", new EfectoSogen());
		oponente.agregarCartaCampo(sogen);
		try {
			unJugador.atacarA(0, 0);
		} catch (MonstruoNoPuedeAtacarException e) {
			assertTrue(false);
		}
		
		assertEquals(7800, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertFalse(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
	}
}
