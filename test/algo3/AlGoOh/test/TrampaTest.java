package algo3.AlGoOh.test;

import org.junit.Test;

import algo3.AlGoOh.Carta;
import algo3.AlGoOh.InvocacionNormal;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Monstruo;
import algo3.AlGoOh.Efectos.EfectoAumentar500Ataque;
import algo3.AlGoOh.Efectos.EfectoCilindroMagico;
import algo3.AlGoOh.Efectos.EfectoVacio;
import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.MonstruoNoPuedeAtacarException;
import algo3.AlGoOh.Exceptions.MonstruosInsuficientesParaSacrificioException;
import algo3.AlGoOh.Exceptions.NoHayMasFasesException;
import algo3.AlGoOh.Exceptions.ZonaNoTieneMasEspacioException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class TrampaTest {

	@Test
	public void test01CrearCartaTrampaYVerificarQueEstaArriba() {
		Carta cartaTrampa = new Carta("Un nombre", new EfectoVacio());
		
		assertFalse(cartaTrampa.estaBocaAbajo());
	}

	@Test
	public void test02ActivarCartaCilindroMagico() throws MonstruosInsuficientesParaSacrificioException, MonstruoNoPuedeAtacarException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException, NoHayMasFasesException {
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		jugador.oponente(oponente);
		oponente.oponente(jugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal() ,1000, 1800);	
		Carta cilindroMagico = new Carta("Cilindro Magico", new EfectoCilindroMagico());
		
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		jugador.agregarCartaTrampa(cilindroMagico);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		jugador.pasarFase();
	
		jugador.atacarA(0, 0);
		
		assertEquals(7400,jugador.obtenerPuntosDeVida());
		assertEquals(8000,jugador.pasarTurno().obtenerPuntosDeVida());
		assertTrue(cilindroMagico.estaEnElCementerio());
	}

	@Test
	public void test03ActivarCartaReinforcements() throws MonstruosInsuficientesParaSacrificioException, MonstruoNoPuedeAtacarException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException, NoHayMasFasesException{
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		jugador.oponente(oponente);
		oponente.oponente(jugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal() ,600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal() ,1000, 1800);	
		Carta reinforcements = new Carta("Reinforcements", new EfectoAumentar500Ataque());
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		jugador.agregarCartaTrampa(reinforcements);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		
		jugador.pasarFase();
		
		jugador.atacarA(0, 0);
		
		assertEquals(7900,jugador.obtenerPuntosDeVida());
		assertEquals(8000,jugador.pasarTurno().obtenerPuntosDeVida());
		assertTrue(monoAcrobata.estaEnElCementerio());
		assertFalse(huevoMonstruoso.estaEnElCementerio());
	}
}