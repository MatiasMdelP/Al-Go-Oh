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
	public void test09ActivarWasteland() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, MonstruoNoPuedeAtacarException, AccionInvalidaEnEstaFaseException, NoHayMasFasesException {
		Jugador jugador = new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);// 900 + 300 = 1200
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);	//1000+200 = 1200
		
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnDefensa(huevoMonstruoso);
		
		Carta wasteland = new Carta("Wasteland", new EfectoWasteland());
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarCartaCampo(wasteland);
		jugador.pasarFase();
		jugador.atacarA(0, 0);
		
		assertEquals(8000, jugador.obtenerPuntosDeVida());
		assertEquals(8000, jugador.pasarTurno().obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test10ActivarSogen() throws ZonaNoTieneMasEspacioException, MonstruosInsuficientesParaSacrificioException, MonstruoNoPuedeAtacarException, AccionInvalidaEnEstaFaseException, NoHayMasFasesException {
		Jugador jugador = new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900); // 900 + 500 = 1400
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800); 	  // 1000 + 200 = 1200
		
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnDefensa(huevoMonstruoso);
		
		Carta sogen = new Carta("Sogen", new EfectoSogen());
		jugador.agregarCartaCampo(sogen);
		
		jugador = jugador.pasarTurno();
		jugador.pasarFase();
		jugador.atacarA(0, 0);
		
		assertEquals(7800, jugador.obtenerPuntosDeVida());
		assertEquals(8000, jugador.pasarTurno().obtenerPuntosDeVida());
		assertFalse(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
	}
}
