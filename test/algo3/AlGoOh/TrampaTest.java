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
	public void test02PonerCartaTrampaBocaAbajo() {
		Trampa cartaTrampa = new Trampa("Un nombre", new EfectoVacio());
		
		assertTrue(cartaTrampa.estaBocaAbajo());
	}

	/*Colocar un monstruo del lado enemigo, luego coloco la carta trampa Cilindro mágico
	de mi lado del campo. Atacar con el monstruo y verificar que se activa la carta
	trampa, se niega el ataque y el oponente recibe el daño directamente en sus puntos
	de vida.
	*/

	@Test
	public void test03ActivarCartaCilindroMagico() throws MonstruosInsuficientesParaSacrificioException, MonstruoNoPuedeAtacarException {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal() ,600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), 3,new InvocacionNormal() ,1000, 1800);	
		Trampa cilindroMagico = new Trampa("Cilindro Magico", new EfectoCilindroMagico());
		
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		unJugador.agregarCartaMagica(cilindroMagico);
		oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		oponente.atacarA(0, 0);
		
		assertEquals(7400,oponente.obtenerPuntosDeVida());
		assertEquals(8000,unJugador.obtenerPuntosDeVida());
	}
	@Test
	public void test04ActivarCartaReinforcements() throws MonstruosInsuficientesParaSacrificioException, MonstruoNoPuedeAtacarException{
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), 3,new InvocacionNormal() ,600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), 3,new InvocacionNormal() ,1000, 1800);	
		Trampa reinforcements = new Trampa("Reinforcements", new EfectoAumentar500Ataque());
		
		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		unJugador.agregarCartaMagica(reinforcements);
		oponente.agregarMonstruoEnAtaque(monoAcrobata);
		
		oponente.atacarA(0, 0);
		
		assertEquals(7900,oponente.obtenerPuntosDeVida());
		assertEquals(8000,unJugador.obtenerPuntosDeVida());
		assertTrue(monoAcrobata.estaEnElCementerio());
		assertFalse(huevoMonstruoso.estaEnElCementerio());
	}
	
}