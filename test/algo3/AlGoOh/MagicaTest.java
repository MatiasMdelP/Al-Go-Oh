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
		agujeroOscuro.realizarEfecto(null,null);
		assertFalse(agujeroOscuro.estaBocaAbajo());
	}
	
	@Test
	public void test05ActivarAgujeroOscuro() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		try {
			unJugador.agregarMonstruoEnAtaque(huevoMonstruoso);
			oponente.agregarMonstruoEnAtaque(monoAcrobata);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion){
			assertTrue(false);
		}
		
		Magica agujeroOscuro = new Magica("Agujero Oscuro", new EfectoAgujeroOscuro());
		
		unJugador.agregarCartaMagica(agujeroOscuro);
		unJugador.activarMagica(0);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
		assertTrue(agujeroOscuro.estaEnElCementerio());
	}
	
	@Test
	public void test06ActivarFisuraYOponenteSoloUnMonstruo() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		
		try {
			oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion){
			assertTrue(false);
		}
		
		Magica fisura = new Magica("Fisura", new EfectoFisura());
		
		unJugador.agregarCartaMagica(fisura);
		unJugador.activarMagica(0);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(fisura.estaEnElCementerio());
	}
	
	@Test
	public void test07ActivarFisuraYOponenteCon2MonstruosYSeDestruyeElDeMenorAtaque() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		
		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		try {
			oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
			oponente.agregarMonstruoEnAtaque(monoAcrobata);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion){
			assertTrue(false);
		}
		
		Magica fisura = new Magica("Fisura", new EfectoFisura());
		
		unJugador.agregarCartaMagica(fisura);
		unJugador.activarMagica(0);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
		assertTrue(fisura.estaEnElCementerio());
	}
	
	@Test
	public void test07ActivarFisuraYOponenteConVariosMonstruosYSeDestruyeElDeMenorAtaque() {
		Jugador unJugador= new Jugador();
		Jugador oponente = new Jugador();
		

		unJugador.fijarOponente(oponente);
		oponente.fijarOponente(unJugador);
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		Monstruo brazoIzquierdoDelProhibido = new Monstruo ("Brazo Izquierdo Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
				
		try {
			oponente.agregarMonstruoEnAtaque(huevoMonstruoso);
			oponente.agregarMonstruoEnAtaque(monoAcrobata);
			oponente.agregarMonstruoEnDefensa(brazoIzquierdoDelProhibido);
		}catch(MonstruosInsuficientesParaSacrificioException excepcion){
			assertTrue(false);
		}
		
		Magica fisura = new Magica("Fisura", new EfectoFisura());
		
		unJugador.agregarCartaMagica(fisura);
		unJugador.activarMagica(0);
		
		assertTrue(brazoIzquierdoDelProhibido.estaEnElCementerio);
		assertFalse(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
		assertTrue(fisura.estaEnElCementerio());
	}
	
	@Test
	public void test08RealizarEfectoDeVolteoLevantaNoPuedeRealizarseException() {
		Jugador unJugador = new Jugador();
		Jugador oponente = new Jugador();
		Mazo mazo = new Mazo();
		Campo campo = new Campo(mazo);
		Campo campoOponente = new Campo(mazo);

		Carta magicaCualquiera = new Magica("Magica cualquiera", new EfectoVacio());
		
		try {
			magicaCualquiera.realizarEfectoDeVolteo(campo, campoOponente, unJugador, oponente);
			assertTrue(false);
		} catch(NoPuedeRealizarseEfectoDeVolteoException e) {
			assertTrue(true);
		}catch(InterrumpirAtaqueException e) {
			assertTrue(false);
		}
	
	}
}
