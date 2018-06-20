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
	public void test04AtacoAMonstruoEnPosicionAtaqueConMenorAtaqueYSeReduceLaVidaDelJugadorAtacado() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3, new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), 3, new InvocacionNormal(), 1000, 1800);
		try {
			unJugador.agregarMonstruoEnAtaque(monoAcrobata);
			oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion) {
			assertTrue(false);
		}
		
		try {
			unJugador.atacarA(0, 0);
		} catch (MonstruoNoPuedeAtacarException e) {
			assertTrue(false);
		}
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(7600, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test05AtacoAMonstruoEnPosicionAtaqueConMayorAtaqueYSufroDanio() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), 3,new InvocacionNormal() ,1000, 1800);
		try {
			unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
			oponente.agregarMonstruoEnAtaque(monoAcrobata);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion) {
			assertTrue(false);
		}
		
		try {
			unJugador.atacarA( 0, 0);
		} catch (MonstruoNoPuedeAtacarException e) {
			assertTrue(false);
		}

		
		assertEquals(7600, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	
	@Test
	public void test06AtacoAMonstruoEnPosicionAtaqueConIgualAtaqueYNaDieSufreDanioYAmbosMontruosVanAlCementerio() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso1 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal(), 600, 900);
		Monstruo huevoMonstruoso2 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal(), 600, 900);
		try {
			unJugador.agregarMonstruoEnAtaque(huevoMonstruoso1);
			oponente.agregarMonstruoEnAtaque(huevoMonstruoso2);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion) {
			assertTrue(false);
		}
		
		try {
			unJugador.atacarA(0, 0);
		} catch (MonstruoNoPuedeAtacarException e) {
			assertTrue(false);
		}
		
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso1.estaEnElCementerio());
		assertTrue(huevoMonstruoso2.estaEnElCementerio());
	}
	
	
	@Test
	public void test07AtacoAMonstruoEnPosicionDefensaConMenorAtaqueYOponenteNoSufreDanio() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
	
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), 3,new InvocacionNormal(), 1000, 1800);
		
		try {
			unJugador.agregarMonstruoEnAtaque(monoAcrobata);
			oponente.agregarMonstruoEnDefensa(huevoMonstruoso);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion) {
			assertTrue(false);
		}
	
		try {
			unJugador.atacarA(0, 0);
		} catch (MonstruoNoPuedeAtacarException e) {
			assertTrue(false);
		}

	
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertEquals(8000, unJugador.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test08AtacoAMonstruoEnPosicionDefensaConMayorAtaqueYSufroDanioIgualALaDiferenciaEntrePuntosDeAtaqueYDefensa() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), 3, new InvocacionNormal(),1000, 1800);

		try {
			unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
			oponente.agregarMonstruoEnDefensa(monoAcrobata);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion) {
			assertTrue(false);
		}
		
		try {
			unJugador.atacarA(0,0);
		} catch (MonstruoNoPuedeAtacarException e) {
			assertTrue(false);
		}

		
		assertEquals(6800, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
	}
	
	@Test
	public void test09AtacoAMonstruoEnPosicionDefensaConIgualAtaqueYNadieSufreDanio() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso1 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal(), 600, 900);
		Monstruo huevoMonstruoso2 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal(), 600, 900);

		try {
			unJugador.agregarMonstruoEnAtaque(huevoMonstruoso1);
			oponente.agregarMonstruoEnDefensa(huevoMonstruoso2);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion) {
			assertTrue(false);
		}
		
		try {
			unJugador.atacarA(0,0);
		} catch (MonstruoNoPuedeAtacarException e) {
			assertTrue(false);
		}

		
		assertEquals(7700, unJugador.obtenerPuntosDeVida());
		assertEquals(8000, oponente.obtenerPuntosDeVida());
		assertTrue(huevoMonstruoso1.estaEnElCementerio());
		assertFalse(huevoMonstruoso2.estaEnElCementerio());
	}

	@Test 
	public void test10InvocacionDeMonstruoDe5Estrellas() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal() ,600, 900);
		Monstruo unMonstruoDe5Estrellas = new Monstruo("Monstruo", new EfectoVacio(), 5,new Invocacion1Sacrificio() ,1800, 1800);
		try {
			unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
			unJugador.agregarMonstruoEnAtaque(unMonstruoDe5Estrellas);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion){
			assertTrue(false);
		}
		assertTrue(huevoMonstruoso.estaEnElCementerio());
	
	}

	@Test 
	public void test11InvocacionDeMonstruoDe7Estrellas() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3, new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), 3, new InvocacionNormal(), 1000, 1800);
		Monstruo dragonBlanco = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), 8, new Invocacion2Sacrificios(), 3000, 2500);
		try {
			unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
			unJugador.agregarMonstruoEnAtaque(monoAcrobata);
			unJugador.agregarMonstruoEnAtaque(dragonBlanco);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion){
			assertTrue(false);
		}
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
	}
	
	@Test 
	public void test12InvocacionDeMonstruoDe7EstrellasConMonstruosInsuficientesYElMonstruoExistenteSigueVivo() {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3, new InvocacionNormal(), 600, 900);
		Monstruo dragonBlanco = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), 8, new Invocacion2Sacrificios(), 3000, 2500);
		try {
			unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
			unJugador.agregarMonstruoEnAtaque(dragonBlanco);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion){
			assertTrue(true);
		}
		assertFalse(huevoMonstruoso.estaEnElCementerio());
	}
	
	@Test 
	public void test13NoPuedoInvocarAlDragonDefinitivoSoloConUnDragonBlancoEnCampo() {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3, new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), 3, new InvocacionNormal(), 1000, 1800);
		Monstruo dragonBlanco = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), 8, new Invocacion2Sacrificios(), 3000, 2500);
		Monstruo dragonDefinitivo = new Monstruo("Dragon Definitivo De Ojos Azules", new EfectoVacio(), 12, 
									new InvocacionDragonDefinitivoDeOjosAzules(), 4500, 3800);
		
		try {
			unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
			unJugador.agregarMonstruoEnAtaque(monoAcrobata);
			unJugador.agregarMonstruoEnAtaque(dragonBlanco);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion){
			assertTrue(false);
		}
		
		try {
			unJugador.agregarMonstruoEnDefensa(dragonDefinitivo);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion){
			assertTrue(true);
		}
		
		assertFalse(dragonBlanco.estaEnElCementerio());
	}
	
	@Test 
	public void test14NoPuedoInvocarAlDragonDefinitivoSoloConDosDragonBlancoEnCampo() {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso1 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3, new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata1 = new Monstruo("Mono Acrobata", new EfectoVacio(), 3, new InvocacionNormal(), 1000, 1800);
		Monstruo huevoMonstruoso2 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3, new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata2 = new Monstruo("Mono Acrobata", new EfectoVacio(), 3, new InvocacionNormal(), 1000, 1800);
		
		Monstruo dragonBlanco1 = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), 8, new Invocacion2Sacrificios(), 3000, 2500);
		Monstruo dragonBlanco2 = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), 8, new Invocacion2Sacrificios(), 3000, 2500);
		
		Monstruo dragonDefinitivo = new Monstruo("Dragon Definitivo De Ojos Azules", new EfectoVacio(), 12, 
									new InvocacionDragonDefinitivoDeOjosAzules(), 4500, 3800);
		
		try {
			unJugador.agregarMonstruoEnAtaque(huevoMonstruoso1);
			unJugador.agregarMonstruoEnAtaque(monoAcrobata1);
			unJugador.agregarMonstruoEnAtaque(huevoMonstruoso2);
			unJugador.agregarMonstruoEnAtaque(monoAcrobata2);
			unJugador.agregarMonstruoEnAtaque(dragonBlanco1);
			unJugador.agregarMonstruoEnAtaque(dragonBlanco2);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion){
			assertTrue(false);
		}
		
		try {
			unJugador.agregarMonstruoEnDefensa(dragonDefinitivo);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion){
			assertTrue(true);
		}
		
		assertFalse(dragonBlanco1.estaEnElCementerio());
		assertFalse(dragonBlanco2.estaEnElCementerio());
	}

	@Test 
	public void test15InvocarAlDragonDefinitivoSacrificandoLosTresDragonesBlancosEnCampo() {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso1 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3, new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata1 = new Monstruo("Mono Acrobata", new EfectoVacio(), 3, new InvocacionNormal(), 1000, 1800);
		Monstruo huevoMonstruoso2 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3, new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata2 = new Monstruo("Mono Acrobata", new EfectoVacio(), 3, new InvocacionNormal(), 1000, 1800);
		Monstruo huevoMonstruoso3 = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3, new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata3 = new Monstruo("Mono Acrobata", new EfectoVacio(), 3, new InvocacionNormal(), 1000, 1800);
		
		Monstruo dragonBlanco1 = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), 8, new Invocacion2Sacrificios(), 3000, 2500);
		Monstruo dragonBlanco2 = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), 8, new Invocacion2Sacrificios(), 3000, 2500);
		Monstruo dragonBlanco3 = new Monstruo("Dragon Blanco De Ojos Azules", new EfectoVacio(), 8, new Invocacion2Sacrificios(), 3000, 2500);
		
		Monstruo dragonDefinitivo = new Monstruo("Dragon Definitivo De Ojos Azules", new EfectoVacio(), 12, 
									new InvocacionDragonDefinitivoDeOjosAzules(), 4500, 3800);
		
		try {
			unJugador.agregarMonstruoEnAtaque(huevoMonstruoso1);
			unJugador.agregarMonstruoEnAtaque(monoAcrobata1);
			unJugador.agregarMonstruoEnAtaque(huevoMonstruoso2);
			unJugador.agregarMonstruoEnAtaque(monoAcrobata2);
			unJugador.agregarMonstruoEnAtaque(huevoMonstruoso3);
			unJugador.agregarMonstruoEnAtaque(monoAcrobata3);
			unJugador.agregarMonstruoEnAtaque(dragonBlanco1);
			unJugador.agregarMonstruoEnAtaque(dragonBlanco2);
			unJugador.agregarMonstruoEnAtaque(dragonBlanco3);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion){
			assertTrue(false);
		}
		
		try {
			unJugador.agregarMonstruoEnDefensa(dragonDefinitivo);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion){
			assertTrue(false);
		}

		assertTrue(dragonBlanco1.estaEnElCementerio());
		assertTrue(dragonBlanco2.estaEnElCementerio());
		assertTrue(dragonBlanco3.estaEnElCementerio());
	}
	
	@Test
	public void test16Habiendo5CartasEnElMazoPuedoSacarTodasYNoPierdo() {
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
	public void test17Habiendo5CartasEnElMazoSacoTodasYCuandoQuieroSacarUnaMasPierdo() {
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
	public void test18ElJugadorGanaCuandoTieneLas5PartesDeExodiaEnLaMano() {
		Jugador unJugador = new Jugador();
		
		Monstruo exodiaElProhibido = new Monstruo("Exodia El Prohibido", new EfectoVacio(), 3, new InvocacionNormal(), 1000, 1000);
		Monstruo brazoIzquierdoDelProhibido = new Monstruo("Brazo Izquierdo Del Prohibido", new EfectoVacio(), 1, new InvocacionNormal(), 200, 300);
		Monstruo piernaIzquierdaDelProhibido = new Monstruo("Pierna Izquierda Del Prohibido", new EfectoVacio(), 1, new InvocacionNormal(), 200, 300);
		Monstruo brazoDerechoDelProhibido = new Monstruo("Brazo Derecho Del Prohibido", new EfectoVacio(), 1, new InvocacionNormal(), 200, 300);
		Monstruo piernaDerechaDelProhibido = new Monstruo("Pierna Derecha Del Prohibido", new EfectoVacio(), 1, new InvocacionNormal(), 200, 300);
	
		unJugador.agregarCartaEnMano(exodiaElProhibido);
		unJugador.agregarCartaEnMano(brazoIzquierdoDelProhibido);
		unJugador.agregarCartaEnMano(piernaIzquierdaDelProhibido);
		unJugador.agregarCartaEnMano(brazoDerechoDelProhibido);
		unJugador.agregarCartaEnMano(piernaDerechaDelProhibido);
		
		//assertTrue(unJugador.ganoElJuego());
	}
	
}
