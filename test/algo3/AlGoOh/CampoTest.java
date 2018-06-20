package algo3.AlGoOh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class CampoTest {

		
	@Test
	public void test01ActivarWasteland() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal(), 600, 900);// 900 + 300 = 1200
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), 3,new InvocacionNormal(), 1000, 1800);	//1000+200 = 1200
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		try {
			unJugador.agregarMonstruoEnAtaque(monoAcrobata);
			oponente.agregarMonstruoEnDefensa(huevoMonstruoso);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion){
			assertTrue(false);
		}
		
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
	public void test02ActivarSogen() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3, new InvocacionNormal(), 600, 900); // 900 + 500 = 1400
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), 3, new InvocacionNormal(), 1000, 1800); 	  // 1000 + 200 = 1200
		
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
