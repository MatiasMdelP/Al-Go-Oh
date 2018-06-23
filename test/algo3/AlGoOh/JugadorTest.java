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
	public void test02AlIniciarNoTengoCartasEnMano() {
		Jugador unJugador = new Jugador();
		
		assertEquals(0, unJugador.cantidadDeCartasEnMano());
	}
	
	@Test
	public void test03AlTomarUnaCartaTengoUnaEnMano() {
		Jugador unJugador = new Jugador();
		unJugador.tomarUnaCartaDelMazo();
		
		assertEquals(1, unJugador.cantidadDeCartasEnMano());
	}
	
	@Test
	public void test04ActivarMonstruo() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		unJugador.activarMonstruo(0);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
	}
	
	@Test
	public void test05AtacoAMonstruoEnPosicionAtaqueConMenorAtaqueYSeReduceLaVidaDelJugadorAtacado() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, MonstruoNoPuedeAtacarException {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		unJugador.atacarA(0, 0);
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(7600, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test06AtacoAMonstruoEnPosicionAtaqueConMayorAtaqueYSufroDanio() throws ZonaNoTieneMasEspacioException, MonstruosInsuficientesParaSacrificioException, MonstruoNoPuedeAtacarException {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal() ,1000, 1800);

		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		oponente.agregarMonstruoEnAtaque(monoAcrobata);
		
		unJugador.atacarA( 0, 0);
		
		assertEquals(7600, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	
	@Test
	public void test07AtacoAMonstruoEnPosicionAtaqueConIgualAtaqueYNaDieSufreDanioYAmbosMontruosVanAlCementerio() throws MonstruoNoPuedeAtacarException, MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso1 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo huevoMonstruoso2 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
	
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso1);
		oponente.agregarMonstruoEnAtaque(huevoMonstruoso2);
		unJugador.atacarA(0, 0);
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso1.estaEnElCementerio());
		assertTrue(huevoMonstruoso2.estaEnElCementerio());
	}
	
	
	@Test
	public void test08AtacoAMonstruoEnPosicionDefensaConMenorAtaqueYOponenteNoSufreDanio() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, MonstruoNoPuedeAtacarException {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
	
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		oponente.agregarMonstruoEnDefensa(huevoMonstruoso);
	
		unJugador.atacarA(0, 0);

		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test09AtacoAMonstruoEnPosicionDefensaConMayorAtaqueYSufroDanioIgualALaDiferenciaEntrePuntosDeAtaqueYDefensa() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, MonstruoNoPuedeAtacarException {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(),1000, 1800);

		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		oponente.agregarMonstruoEnDefensa(monoAcrobata);
		
		unJugador.atacarA(0,0);

		
		assertEquals(6800, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test09AtacoAMonstruoEnPosicionDefensaConIgualAtaqueYNadieSufreDanio() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, MonstruoNoPuedeAtacarException {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso1 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo huevoMonstruoso2 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);

		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso1);
		oponente.agregarMonstruoEnDefensa(huevoMonstruoso2);
		
		unJugador.atacarA(0,0);
		
		assertEquals(7700, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso1.estaEnElCementerio());
		assertFalse(huevoMonstruoso2.estaEnElCementerio());
	}

	@Test 
	public void test11InvocacionDeMonstruoDe5Estrellas() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(),new InvocacionNormal() ,600, 900);
		Monstruo unMonstruoDe5Estrellas = new Monstruo("Monstruo", new EfectoVacio(), new Invocacion1Sacrificio() ,1800, 1800);
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		unJugador.agregarMonstruoASacrificar(0);
		unJugador.agregarMonstruoEnAtaque(unMonstruoDe5Estrellas);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
	
	}

	@Test 
	public void test12InvocacionDeMonstruoDe7Estrellas() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		Monstruo dragonBlanco = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), new Invocacion2Sacrificios(), 3000, 2500);
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		unJugador.agregarMonstruoASacrificar(1);
		unJugador.agregarMonstruoASacrificar(0);
		unJugador.agregarMonstruoEnAtaque(dragonBlanco);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
	}
	
	@Test(expected=MonstruosInsuficientesParaSacrificioException.class)
	public void test13InvocacionDeMonstruoDe7EstrellasConMonstruosInsuficientesYElMonstruoExistenteSigueVivo() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo dragonBlanco = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), new Invocacion2Sacrificios(), 3000, 2500);
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		unJugador.agregarMonstruoASacrificar(0);
		unJugador.agregarMonstruoEnAtaque(dragonBlanco);

		assertFalse(huevoMonstruoso.estaEnElCementerio());
	}
	
	@Test(expected=MonstruosInsuficientesParaSacrificioException.class)
	public void test14NoPuedoInvocarAlDragonDefinitivoSoloConUnDragonBlancoEnCampo() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		Monstruo dragonBlanco = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), new Invocacion2Sacrificios(), 3000, 2500);
		Monstruo dragonDefinitivo = new Monstruo("Dragon Definitivo De Ojos Azules", new EfectoVacio(), 
									new InvocacionDragonDefinitivoDeOjosAzules(), 4500, 3800);
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		unJugador.agregarMonstruoEnAtaque(dragonBlanco);
		
		unJugador.agregarMonstruoEnDefensa(dragonDefinitivo);
		
		assertFalse(dragonBlanco.estaEnElCementerio());
	}
	
	@Test(expected=MonstruosInsuficientesParaSacrificioException.class)
	public void test15NoPuedoInvocarAlDragonDefinitivoSoloConDosDragonBlancoEnCampo() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso1 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata1 = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		Monstruo huevoMonstruoso2 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata2 = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		
		Monstruo dragonBlanco1 = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), new Invocacion2Sacrificios(), 3000, 2500);
		Monstruo dragonBlanco2 = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), new Invocacion2Sacrificios(), 3000, 2500);
		
		Monstruo dragonDefinitivo = new Monstruo("Dragon Definitivo De Ojos Azules", new EfectoVacio(), 
									new InvocacionDragonDefinitivoDeOjosAzules(), 4500, 3800);
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso1);
		unJugador.agregarMonstruoEnAtaque(monoAcrobata1);
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso2);
		unJugador.agregarMonstruoEnAtaque(monoAcrobata2);
		unJugador.agregarMonstruoEnAtaque(dragonBlanco1);
		unJugador.agregarMonstruoEnAtaque(dragonBlanco2);
		
		unJugador.agregarMonstruoEnDefensa(dragonDefinitivo);
		
		
		assertFalse(dragonBlanco1.estaEnElCementerio());
		assertFalse(dragonBlanco2.estaEnElCementerio());
	}

	@Test
	public void test16InvocarAlDragonDefinitivoSacrificandoLosTresDragonesBlancosEnCampo() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
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
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso1);
		unJugador.agregarMonstruoEnAtaque(monoAcrobata1);
		unJugador.agregarMonstruoASacrificar(0);
		unJugador.agregarMonstruoASacrificar(1);
		unJugador.agregarMonstruoEnAtaque(dragonBlanco1);
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso2);
		unJugador.agregarMonstruoEnAtaque(monoAcrobata2);
		unJugador.agregarMonstruoASacrificar(1);
		unJugador.agregarMonstruoASacrificar(2);
		unJugador.agregarMonstruoEnAtaque(dragonBlanco2);
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso3);
		unJugador.agregarMonstruoEnAtaque(monoAcrobata3);
		unJugador.agregarMonstruoASacrificar(2);
		unJugador.agregarMonstruoASacrificar(3);
		unJugador.agregarMonstruoEnAtaque(dragonBlanco3);
		
		unJugador.agregarMonstruoEnDefensa(dragonDefinitivo);

		assertTrue(dragonBlanco1.estaEnElCementerio());
		assertTrue(dragonBlanco2.estaEnElCementerio());
		assertTrue(dragonBlanco3.estaEnElCementerio());
		assertFalse(dragonDefinitivo.estaEnElCementerio());
	}
	
	@Test
	public void test17Habiendo5CartasEnElMazoPuedoSacarTodasYNoPierdo() {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		for (int i = 0; i < 5; i++) {
				unJugador.tomarUnaCartaDelMazo();
		}

		assertFalse(unJugador.ganoElJuego());
		assertFalse(oponente.ganoElJuego());
	}

	@Test
	public void test18Habiendo5CartasEnElMazoSacoTodasYCuandoQuieroSacarUnaMasPierdo() {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		for (int i = 0; i < 5; i++) {
			unJugador.tomarUnaCartaDelMazo();
		}
		
		unJugador.tomarUnaCartaDelMazo();
		
		assertFalse(unJugador.ganoElJuego());
		assertTrue(oponente.ganoElJuego());
	}
	
	@Test
	public void test19Con4PartesDelExodiaEnManoElJugadorNoGana() {
		Jugador unJugador = new Jugador();
		
		Monstruo exodiaElProhibido = new Monstruo("Exodia El Prohibido", new EfectoVacio(), new InvocacionNormal(), 1000, 1000);
		Monstruo brazoIzquierdoDelProhibido = new Monstruo("Brazo Izquierdo Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		Monstruo piernaIzquierdaDelProhibido = new Monstruo("Pierna Izquierda Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		Monstruo brazoDerechoDelProhibido = new Monstruo("Brazo Derecho Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		
		unJugador.agregarCartaEnMano(exodiaElProhibido);
		unJugador.agregarCartaEnMano(brazoIzquierdoDelProhibido);
		unJugador.agregarCartaEnMano(piernaIzquierdaDelProhibido);
		unJugador.agregarCartaEnMano(brazoDerechoDelProhibido);
		
		assertFalse(unJugador.ganoElJuego());
	}
	
	@Test
	public void test20ElJugadorGanaCuandoTieneLas5PartesDeExodiaEnLaMano() {
		Jugador unJugador = new Jugador();
		
		Monstruo exodiaElProhibido = new Monstruo("Exodia El Prohibido", new EfectoVacio(), new InvocacionNormal(), 1000, 1000);
		Monstruo brazoIzquierdoDelProhibido = new Monstruo("Brazo Izquierdo Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		Monstruo piernaIzquierdaDelProhibido = new Monstruo("Pierna Izquierda Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		Monstruo brazoDerechoDelProhibido = new Monstruo("Brazo Derecho Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		Monstruo piernaDerechaDelProhibido = new Monstruo("Pierna Derecha Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
	
		unJugador.agregarCartaEnMano(exodiaElProhibido);
		unJugador.agregarCartaEnMano(brazoIzquierdoDelProhibido);
		unJugador.agregarCartaEnMano(piernaIzquierdaDelProhibido);
		unJugador.agregarCartaEnMano(brazoDerechoDelProhibido);
		unJugador.agregarCartaEnMano(piernaDerechaDelProhibido);
		
		assertTrue(unJugador.ganoElJuego());
	}
	
	@Test 
	public void test21InvocacionDeMonstruoDe5EstrellasSacrificoSegundoMonstruo() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(),new InvocacionNormal() ,600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		
		Monstruo unMonstruoDe5Estrellas = new Monstruo("Monstruo", new EfectoVacio(), new Invocacion1Sacrificio() ,1800, 1800);
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		unJugador.agregarMonstruoASacrificar(1);
		unJugador.agregarMonstruoEnAtaque(unMonstruoDe5Estrellas);
		
		assertFalse(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio);
	
	}
}
