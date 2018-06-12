package algo3.AlGoOh;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MagicaTest {

	@Test
	public void test01CrearCartaMagicaYVerificarQueEstaBocaArriba() {
		Efecto efecto = new EfectoAgujeroOscuro();
		Magica cartaMagica = new Magica(efecto);
		
		assertFalse(cartaMagica.estaBocaAbajo());
	}
	
	@Test
	public void test02PonerCartaMagicaBocaAbajo() {
		Efecto efecto = new EfectoAgujeroOscuro();
		Magica cartaMagica = new Magica(efecto);
		
		cartaMagica.darVuelta();
		
		assertTrue(cartaMagica.estaBocaAbajo());
	}
	
	@Test
	public void test03CartaMagicaBocaAbajoNoRealizaEfecto() {
		Efecto efecto = new EfectoAgujeroOscuro();
		Magica cartaMagica = new Magica(efecto);
		
		cartaMagica.darVuelta();
		cartaMagica.agregarAlCampo(new Campo(), new Campo());
		
		assertFalse(cartaMagica.realizarEfecto());
	}
	
	@Test
	public void test03ActivarAgujeroOscuro() {
		Campo unCampo = new Campo();
		Campo campoOponente = new Campo();
		Jugador unJugador= new Jugador(unCampo);
		Jugador oponente = new Jugador(campoOponente);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", 3, 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", 3, 1000, 1800);

		unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		oponente.agregarMonstruoEnAtaque(monoAcrobata);
		
		Magica agujeroOscuro = new Magica(new EfectoAgujeroOscuro());
		agujeroOscuro.agregarAlCampo(unCampo, campoOponente);
		unJugador.agregarCartaMagicaOTrampa(agujeroOscuro);
		
		unJugador.activarMagicaOTrampa(0);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
		assertTrue(agujeroOscuro.estaEnElCementerio());
	}
}
