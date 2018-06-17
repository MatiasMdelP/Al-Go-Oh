package algo3.AlGoOh;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MagicaTest {

	@Test
	public void test01CrearCartaMagicaYVerificarQueEstaBocaArriba() {
		Magica agujeroOscuro = new Magica("Agujero Oscuro", new EfectoAgujeroOscuro());
		
		assertFalse(agujeroOscuro.estaBocaAbajo());
	}
	
	@Test
	public void test02PonerCartaMagicaBocaAbajo() {
		Magica agujeroOscuro = new Magica("Agujero Oscuro", new EfectoAgujeroOscuro());
		
		agujeroOscuro.darVuelta();
		
		assertTrue(agujeroOscuro.estaBocaAbajo());
	}
	
	@Test
	public void test03PonerCartaMagicaBocaAbajoLaVolvemosADarVueltaYQuedaBocaArriba() {
		Magica agujeroOscuro = new Magica("Agujero Oscuro", new EfectoAgujeroOscuro());
		
		agujeroOscuro.darVuelta();
		agujeroOscuro.darVuelta();
		
		assertFalse(agujeroOscuro.estaBocaAbajo());
	}
	
	@Test
	public void test04CartaMagicaBocaAbajoNoRealizaEfecto() {
		Magica agujeroOscuro = new Magica("Agujero Oscuro", new EfectoAgujeroOscuro());
		
		Mazo unMazo = new Mazo();
		Mazo mazoOponente = new Mazo();
		
		agujeroOscuro.darVuelta();
		agujeroOscuro.agregarAlCampo(new Campo(unMazo), new Campo(mazoOponente));
		
		assertFalse(agujeroOscuro.realizarEfecto());
	}
	
	@Test
	public void test05ActivarAgujeroOscuro() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);

		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		oponente.agregarMonstruoEnAtaque(monoAcrobata);
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Magica agujeroOscuro = new Magica("Agujero Oscuro", new EfectoAgujeroOscuro());
		
		unJugador.agregarCartaMagicaOTrampa(agujeroOscuro);
		unJugador.activarMagicaOTrampa(0);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
		assertTrue(agujeroOscuro.estaEnElCementerio());
	}
}
