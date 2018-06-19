package algo3.AlGoOh;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class TrampaTest {

	@Test
	public void test01CrearCartaTrampaYVerificarQueEstaArriba() {
		Trampa cartaTrampa = new Trampa("Un nombre", null);
		
		assertFalse(cartaTrampa.estaBocaAbajo());
	}

	@Test
	public void test02PonerCartaTrampaBocaAbajo() {
		Trampa cartaTrampa = new Trampa("Un nombre", null);
		
		cartaTrampa.darVuelta();
		
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
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", null, 3,new InvocacionNormal() ,600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", null, 3,new InvocacionNormal() ,1000, 1800);	
		Trampa cilindroMagico = new Trampa("Cilindro Magico", new EfectoCilindroMAgico());
		
		unJugador.agregarMonstruoEnAtaque(monoAcrobata);
		unJugador.agregarCartaMagica(cilindroMagico);
		oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		oponente.atacarA(0, 0);
		
		assertEquals(7400,oponente.obtenerPuntosDeVida());
		assertEquals(8000,unJugador.obtenerPuntosDeVida());
	}
	
}