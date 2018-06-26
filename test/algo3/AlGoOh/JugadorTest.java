package algo3.AlGoOh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class JugadorTest {
	
	@Test
	public void test01JugadorRecienCreadoTiene8000PuntosDeVida() {
		Jugador unJugador = new Jugador();
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
	}
	
	@Test
	public void test02AlIniciarTengoUnaCartaEnLaMano() {
		Jugador unJugador = new Jugador();
		
		assertEquals(1, unJugador.cantidadDeCartasEnMano());
	}
	
	@Test
	public void test04ActivarMonstruo() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException, NoHayMasFasesException {
		Jugador unJugador = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		unJugador.pasarFase();
		
		unJugador.activarMonstruo(0);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
	}
	
	@Test
	public void test05AtacoAMonstruoEnPosicionAtaqueConMenorAtaqueYSeReduceLaVidaDelJugadorAtacado() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, MonstruoNoPuedeAtacarException, AccionInvalidaEnEstaFaseException, NoHayMasFasesException {
		Jugador jugador= new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		jugador = jugador.pasarTurno();
		jugador.pasarFase();
		
		jugador.atacarA(0, 0);
		
		assertEquals(8000, jugador.obtenerPuntosDeVida());
		jugador = jugador.pasarTurno();
		assertEquals(7600, jugador.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test06AtacoAMonstruoEnPosicionAtaqueConMayorAtaqueYSufroDanio() throws ZonaNoTieneMasEspacioException, MonstruosInsuficientesParaSacrificioException, MonstruoNoPuedeAtacarException, AccionInvalidaEnEstaFaseException, NoHayMasFasesException {
		Jugador jugador= new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal() ,1000, 1800);

		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		
		jugador = jugador.pasarTurno();
		jugador.pasarFase();
		
		jugador.atacarA(0, 0);
		
		assertEquals(7600, jugador.obtenerPuntosDeVida());
		jugador = jugador.pasarTurno();
		assertEquals(8000, jugador.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	
	@Test
	public void test07AtacoAMonstruoEnPosicionAtaqueConIgualAtaqueYNaDieSufreDanioYAmbosMontruosVanAlCementerio() throws MonstruoNoPuedeAtacarException, MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException, NoHayMasFasesException {
		Jugador jugador= new Jugador();
		
		Monstruo huevoMonstruoso1 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo huevoMonstruoso2 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
	
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso1);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso2);
		
		jugador = jugador.pasarTurno();
		jugador.pasarFase();
		
		jugador.atacarA(0, 0);
		
		assertEquals(8000, jugador.obtenerPuntosDeVida());
		jugador = jugador.pasarTurno();
		assertEquals(8000, jugador.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso1.estaEnElCementerio());
		assertTrue(huevoMonstruoso2.estaEnElCementerio());
	}
	
	
	@Test
	public void test08AtacoAMonstruoEnPosicionDefensaConMenorAtaqueYOponenteNoSufreDanio() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, MonstruoNoPuedeAtacarException, AccionInvalidaEnEstaFaseException, NoHayMasFasesException {
		Jugador jugador= new Jugador();
	
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnDefensa(huevoMonstruoso);
		
		jugador = jugador.pasarTurno();
		jugador.pasarFase();

		jugador.atacarA(0, 0);

		assertEquals(8000, jugador.obtenerPuntosDeVida());
		jugador = jugador.pasarTurno();
		assertEquals(8000, jugador.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test09AtacoAMonstruoEnPosicionDefensaConMayorAtaqueYSufroDanioIgualALaDiferenciaEntrePuntosDeAtaqueYDefensa() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, MonstruoNoPuedeAtacarException, AccionInvalidaEnEstaFaseException, NoHayMasFasesException {
		Jugador jugador= new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(),1000, 1800);

		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnDefensa(monoAcrobata);
		
		jugador = jugador.pasarTurno();
		jugador.pasarFase();
		
		jugador.atacarA(0, 0);
		
		assertEquals(6800, jugador.obtenerPuntosDeVida());
		jugador = jugador.pasarTurno();
		assertEquals(8000, jugador.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test09AtacoAMonstruoEnPosicionDefensaConIgualAtaqueYNadieSufreDanio() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, MonstruoNoPuedeAtacarException, AccionInvalidaEnEstaFaseException, NoHayMasFasesException {
		Jugador jugador= new Jugador();
		
		Monstruo huevoMonstruoso1 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo huevoMonstruoso2 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);

		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso1);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnDefensa(huevoMonstruoso2);
		
		jugador = jugador.pasarTurno();
		jugador.pasarFase();

		jugador.atacarA(0, 0);
		
		assertEquals(7700, jugador.obtenerPuntosDeVida());
		jugador = jugador.pasarTurno();
		assertEquals(8000, jugador.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso1.estaEnElCementerio());
		assertFalse(huevoMonstruoso2.estaEnElCementerio());
	}

	@Test 
	public void test11InvocacionDeMonstruoDe5Estrellas() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		Jugador jugador= new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(),new InvocacionNormal() ,600, 900);
		Monstruo unMonstruoDe5Estrellas = new Monstruo("Monstruo", new EfectoVacio(), new Invocacion1Sacrificio() ,1000, 1800);
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		jugador.agregarMonstruoASacrificar(0);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(unMonstruoDe5Estrellas);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
	}

	@Test 
	public void test12InvocacionDeMonstruoDe7Estrellas() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		Jugador jugador= new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		Monstruo dragonBlanco = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), new Invocacion2Sacrificios(), 3000, 2500);
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoASacrificar(0);
		jugador.agregarMonstruoASacrificar(1);
		jugador.agregarMonstruoEnAtaque(dragonBlanco);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
	}
	
	@Test(expected=MonstruosInsuficientesParaSacrificioException.class)
	public void test13InvocacionDeMonstruoDe7EstrellasConMonstruosInsuficientesYElMonstruoExistenteSigueVivo() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		Jugador jugador = new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo dragonBlanco = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), new Invocacion2Sacrificios(), 3000, 2500);
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoASacrificar(0);
		jugador.agregarMonstruoEnAtaque(dragonBlanco);

		assertFalse(huevoMonstruoso.estaEnElCementerio());
	}
	
	@Test(expected=MonstruosInsuficientesParaSacrificioException.class)
	public void test14NoPuedoInvocarAlDragonDefinitivoSoloConUnDragonBlancoEnCampo() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		Jugador jugador = new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		Monstruo dragonBlanco = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), new Invocacion2Sacrificios(), 3000, 2500);
		Monstruo dragonDefinitivo = new Monstruo("Dragon Definitivo De Ojos Azules", new EfectoVacio(), 
									new InvocacionDragonDefinitivoDeOjosAzules(), 4500, 3800);
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(dragonBlanco);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnDefensa(dragonDefinitivo);
		
		assertFalse(dragonBlanco.estaEnElCementerio());
	}
	
	@Test(expected=MonstruosInsuficientesParaSacrificioException.class)
	public void test15NoPuedoInvocarAlDragonDefinitivoSoloConDosDragonBlancoEnCampo() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		Jugador jugador = new Jugador();
		
		Monstruo huevoMonstruoso1 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata1 = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		Monstruo huevoMonstruoso2 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata2 = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		
		Monstruo dragonBlanco1 = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), new Invocacion2Sacrificios(), 3000, 2500);
		Monstruo dragonBlanco2 = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), new Invocacion2Sacrificios(), 3000, 2500);
		
		Monstruo dragonDefinitivo = new Monstruo("Dragon Definitivo De Ojos Azules", new EfectoVacio(), 
									new InvocacionDragonDefinitivoDeOjosAzules(), 4500, 3800);
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso1);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(monoAcrobata1);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso2);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(monoAcrobata2);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(dragonBlanco1);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(dragonBlanco2);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnDefensa(dragonDefinitivo);
		
		
		assertFalse(dragonBlanco1.estaEnElCementerio());
		assertFalse(dragonBlanco2.estaEnElCementerio());
	}

	@Test
	public void test16InvocarAlDragonDefinitivoSacrificandoLosTresDragonesBlancosEnCampo() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		Jugador jugador = new Jugador();
		
		Monstruo huevoMonstruoso1 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata1 = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		Monstruo huevoMonstruoso2 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata2 = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		Monstruo huevoMonstruoso3 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata3 = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		
		Monstruo dragonBlanco1 = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), new Invocacion2Sacrificios(), 3000, 2500);
		Monstruo dragonBlanco2 = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), new Invocacion2Sacrificios(), 3000, 2500);
		Monstruo dragonBlanco3 = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), new Invocacion2Sacrificios(), 3000, 2500);
		
		Monstruo dragonDefinitivo = new Monstruo("Dragon Definitivo De Ojos Azules", new EfectoVacio(), 
									new InvocacionDragonDefinitivoDeOjosAzules(), 4500, 3800);
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso1);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(monoAcrobata1);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoASacrificar(0);
		jugador.agregarMonstruoASacrificar(1);
		jugador.agregarMonstruoEnAtaque(dragonBlanco1);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso2);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(monoAcrobata2);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoASacrificar(1);
		jugador.agregarMonstruoASacrificar(2);
		jugador.agregarMonstruoEnAtaque(dragonBlanco2);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso3);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(monoAcrobata3);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoASacrificar(2);
		jugador.agregarMonstruoASacrificar(3);
		jugador.agregarMonstruoEnAtaque(dragonBlanco3);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnDefensa(dragonDefinitivo);

		assertTrue(dragonBlanco1.estaEnElCementerio());
		assertTrue(dragonBlanco2.estaEnElCementerio());
		assertTrue(dragonBlanco3.estaEnElCementerio());
		assertFalse(dragonDefinitivo.estaEnElCementerio());
	}
	
	@Test
	public void test17Habiendo5CartasEnElMazoPuedoSacarTodasYNoPierdo() {
		Jugador jugador = new Jugador();
		
		for (int i = 0; i < 5; i++) {
			jugador.tomarUnaCartaDelMazo();
		}

		assertFalse(jugador.ganoElJuego());
		
		jugador = jugador.pasarTurno();
		
		assertFalse(jugador.ganoElJuego());
	}

	@Test
	public void test18Habiendo5CartasEnElMazoSacoTodasYCuandoQuieroSacarUnaMasPierdo() {
		Jugador jugador = new Jugador();
		
		for (int i = 0; i < 5; i++) {
			jugador.tomarUnaCartaDelMazo();
		}
		
		jugador.tomarUnaCartaDelMazo();
		
		assertFalse(jugador.ganoElJuego());
		jugador = jugador.pasarTurno();
		assertTrue(jugador.ganoElJuego());
	}
	
	@Test
	public void test19Con4PartesDelExodiaEnManoElJugadorNoGana() {
		Jugador jugador = new Jugador();
		
		Monstruo exodiaElProhibido = new Monstruo("Exodia El Prohibido", new EfectoVacio(), new InvocacionNormal(), 1000, 1000);
		Monstruo brazoIzquierdoDelProhibido = new Monstruo("Brazo Izquierdo Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		Monstruo piernaIzquierdaDelProhibido = new Monstruo("Pierna Izquierda Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		Monstruo brazoDerechoDelProhibido = new Monstruo("Brazo Derecho Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		
		jugador.agregarCartaEnMano(exodiaElProhibido);
		jugador.agregarCartaEnMano(brazoIzquierdoDelProhibido);
		jugador.agregarCartaEnMano(piernaIzquierdaDelProhibido);
		jugador.agregarCartaEnMano(brazoDerechoDelProhibido);
		
		assertFalse(jugador.ganoElJuego());
	}
	
	@Test
	public void test20ElJugadorGanaCuandoTieneLas5PartesDeExodiaEnLaMano() {
		Jugador jugador = new Jugador();
		
		Monstruo exodiaElProhibido = new Monstruo("Exodia El Prohibido", new EfectoVacio(), new InvocacionNormal(), 1000, 1000);
		Monstruo brazoIzquierdoDelProhibido = new Monstruo("Brazo Izquierdo Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		Monstruo piernaIzquierdaDelProhibido = new Monstruo("Pierna Izquierda Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		Monstruo brazoDerechoDelProhibido = new Monstruo("Brazo Derecho Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		Monstruo piernaDerechaDelProhibido = new Monstruo("Pierna Derecha Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
	
		jugador.agregarCartaEnMano(exodiaElProhibido);
		jugador.agregarCartaEnMano(brazoIzquierdoDelProhibido);
		jugador.agregarCartaEnMano(piernaIzquierdaDelProhibido);
		jugador.agregarCartaEnMano(brazoDerechoDelProhibido);
		jugador.agregarCartaEnMano(piernaDerechaDelProhibido);
		
		assertTrue(jugador.ganoElJuego());
	}
	
	@Test 
	public void test21InvocacionDeMonstruoDe5EstrellasSacrificoSegundoMonstruo() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		Jugador jugador= new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(),new InvocacionNormal() ,600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		
		Monstruo unMonstruoDe5Estrellas = new Monstruo("Monstruo", new EfectoVacio(), new Invocacion1Sacrificio() ,1800, 1800);
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoASacrificar(1);
		jugador.agregarMonstruoEnAtaque(unMonstruoDe5Estrellas);
		
		assertFalse(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
	}
}
