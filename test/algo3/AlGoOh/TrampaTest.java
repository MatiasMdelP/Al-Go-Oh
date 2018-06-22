package algo3.AlGoOh;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class TrampaTest {

	@Test
	public void test01CrearCartaTrampaYVerificarQueEstaAbajo() {
		Trampa cartaTrampa = new Trampa("Un nombre", new EfectoVacio());
		
		assertTrue(cartaTrampa.estaBocaAbajo());
	}

	@Test
	public void test02ActivarCartaCilindroMagico() throws MonstruosInsuficientesParaSacrificioException, MonstruoNoPuedeAtacarException, ZonaNoTieneMasEspacioException {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal() ,600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), 3,new InvocacionNormal() ,1000, 1800);	
		Trampa cilindroMagico = new Trampa("Cilindro Magico", new EfectoCilindroMagico());
		
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		unJugador.agregarCartaTrampa(cilindroMagico);
		oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		oponente.atacarA(0, 0);
		
		assertEquals(7400,oponente.obtenerPuntosDeVida());
		assertEquals(8000,unJugador.obtenerPuntosDeVida());
		assertTrue(cilindroMagico.estaEnElCementerio());
	}

	@Test
	public void test03ActivarCartaReinforcements() throws MonstruosInsuficientesParaSacrificioException, MonstruoNoPuedeAtacarException, ZonaNoTieneMasEspacioException{
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal() ,600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), 3,new InvocacionNormal() ,1000, 1800);	
		Trampa reinforcements = new Trampa("Reinforcements", new EfectoAumentar500Ataque());
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		unJugador.agregarCartaTrampa(reinforcements);
		oponente.agregarMonstruoEnAtaque(monoAcrobata);
		
		oponente.atacarA(0, 0);
		
		assertEquals(7900,oponente.obtenerPuntosDeVida());
		assertEquals(8000,unJugador.obtenerPuntosDeVida());
		assertTrue(monoAcrobata.estaEnElCementerio());
		assertFalse(huevoMonstruoso.estaEnElCementerio());
	}
}