package algo3.AlGoOh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class CampoTest {

	@Test
	public void test01AgregarMonstruoYDefinirloYObtenerlo() throws MonstruosInsuficientesParaSacrificioException {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900);
		Campo campo = new Campo(new Mazo());
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		campo.agregarMonstruo(huevoMonstruoso);
		campo.definirMonstruo(0);
		
		assertEquals(600,campo.calcularDanio());
		assertEquals(huevoMonstruoso,campo.obtenerMonstruo());
	}
	
	@Test
	public void test02AgregarMonstruoYDefinirloYMandarloAlCemneterio() throws MonstruosInsuficientesParaSacrificioException {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900);
		Campo campo = new Campo(new Mazo());
		
		huevoMonstruoso.colocarEnPosicionAtaque();
		campo.agregarMonstruo(huevoMonstruoso);
		campo.definirMonstruo(0);
		
		campo.mandarMonstruoDefinidoAlCementerio();
		assertTrue(huevoMonstruoso.estaEnElCementerio());
	}
	
	@Test
	public void test03AgregarMonstruosYMandarlosAlCementerio() throws MonstruosInsuficientesParaSacrificioException {
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
	public void test04AgregarCeroCartaTrampaYObtenerNroMenosUno() {
		Campo campo = new Campo(new Mazo());
		
		assertEquals(-1,campo.obtenerNroCartaTrampa());
	}

	@Test
	public void test05AgregarTresCartasTrampaYNroDeCartaDos() {
		Trampa reinforcements1 = new Trampa("Reinforcements", new EfectoAumentar500Ataque());
		Trampa reinforcements2 = new Trampa("Reinforcements", new EfectoAumentar500Ataque());
		Trampa reinforcements3 = new Trampa("Reinforcements", new EfectoAumentar500Ataque());
		Campo campo = new Campo(new Mazo());
		
		campo.agregarMagicaOTrampa(reinforcements1);
		campo.agregarMagicaOTrampa(reinforcements2);
		campo.agregarMagicaOTrampa(reinforcements3);
		
		assertEquals(2,campo.obtenerNroCartaTrampa());
	}
	
	@Test
	public void test06AgregarCartasTrampaOMagicasYMandarlasAlCementerio() {
		Trampa reinforcements1 = new Trampa("Reinforcements", new EfectoAumentar500Ataque());
		Campo campo = new Campo(new Mazo());
		
		campo.agregarMagicaOTrampa(reinforcements1);
		campo.mandarMagicaOTrampaAlCementerio(0);
		
		assertTrue(reinforcements1.estaEnElCementerio());
	}

	
	@Test(expected = CartaNoEncontradaException.class)
	public void test07MandarMonstruoNoAgregadoAlCementerioYobtenerExcepcion() {
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900);
		Campo campo = new Campo(new Mazo());
		huevoMonstruoso.colocarEnPosicionAtaque();
			
		campo.mandarMonstruoAlCementerio(huevoMonstruoso);
	}
	
	@Test
	public void test08TomarCartaDelMazo() {
		Campo campo = new Campo(new Mazo());
		Carta carta = campo.tomarUnaCartaDelMazo();
		
		assertTrue(carta != null);
	}
	
	@Test 
	public void test09ActivarUnTrampa() throws InterrumpirAtaqueException {
		Trampa vacio = new Trampa("Vacio", new EfectoVacio());
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Campo campo = new Campo(new Mazo());
		Campo campoOponente = new Campo(new Mazo());
		
		assertFalse(vacio.estaEnElCementerio());
		assertTrue(vacio.estaBocaAbajo());
		campo.agregarMagicaOTrampa(vacio);
		campo.activarTrampa(campo, campoOponente, unJugador, oponente);
		assertFalse(vacio.estaEnElCementerio());
		assertFalse(vacio.estaBocaAbajo());
	}
	
	@Test 
	public void test10ActivarUnTrampaYMandarEsaCartaAlCementerio() throws InterrumpirAtaqueException {
		Trampa vacio = new Trampa("Vacio", new EfectoVacio());
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Campo campo = new Campo(new Mazo());
		Campo campoOponente = new Campo(new Mazo());
		
		assertFalse(vacio.estaEnElCementerio());
		assertTrue(vacio.estaBocaAbajo());
		campo.agregarMagicaOTrampa(vacio);
		campo.activarTrampa(campo, campoOponente, unJugador, oponente);
		assertFalse(vacio.estaEnElCementerio());
		assertFalse(vacio.estaBocaAbajo());
		campo.mandarMagicaOTrampaAlCementerio(0);
		assertTrue(vacio.estaEnElCementerio());
		assertFalse(vacio.estaBocaAbajo());
		
	}
	
	@Test 
	public void test11ActivarUnTrampaHabiendoDosOmasCartasAgregadas() throws InterrumpirAtaqueException {
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
		campo.agregarMagicaOTrampa(vacio1);
		campo.agregarMagicaOTrampa(vacio2);
		campo.activarTrampa(campo, campoOponente, unJugador, oponente);
		assertFalse(vacio1.estaEnElCementerio());
		assertFalse(vacio1.estaBocaAbajo());
		assertFalse(vacio2.estaEnElCementerio());
		assertTrue(vacio2.estaBocaAbajo());
	}
	
	@Test
	public void test12ActivarWasteland() throws MonstruosInsuficientesParaSacrificioException {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);// 900 + 300 = 1200
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);	//1000+200 = 1200
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		oponente.agregarMonstruoEnDefensa(huevoMonstruoso);
		
		DeCampo wasteland = new DeCampo("Wasteland", new EfectoWasteland());
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
	public void test13ActivarSogen() {
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
		
		DeCampo sogen = new DeCampo("Sogen", new EfectoSogen());
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
