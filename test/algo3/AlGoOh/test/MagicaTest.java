package algo3.AlGoOh.test;

import org.junit.Test;

import algo3.AlGoOh.Campo;
import algo3.AlGoOh.Carta;
import algo3.AlGoOh.InvocacionNormal;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Mazo;
import algo3.AlGoOh.Monstruo;
import algo3.AlGoOh.Efectos.EfectoAgujeroOscuro;
import algo3.AlGoOh.Efectos.EfectoFisura;
import algo3.AlGoOh.Efectos.EfectoVacio;
import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.InterrumpirAtaqueException;
import algo3.AlGoOh.Exceptions.MonstruosInsuficientesParaSacrificioException;
import algo3.AlGoOh.Exceptions.NoPuedeRealizarseEfectoDeVolteoException;
import algo3.AlGoOh.Exceptions.ZonaNoTieneMasEspacioException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MagicaTest {

	@Test
	public void test01CrearCartaMagicaYVerificarQueEstaBocaArriba() {
		Carta agujeroOscuro = new Carta("Agujero Oscuro", new EfectoAgujeroOscuro());
		
		assertFalse(agujeroOscuro.estaBocaAbajo());
	}
	
	@Test
	public void test02PonerCartaMagicaBocaAbajo() {
		Carta agujeroOscuro = new Carta("Agujero Oscuro", new EfectoAgujeroOscuro());
		
		agujeroOscuro.darVuelta();
		
		assertTrue(agujeroOscuro.estaBocaAbajo());
	}
	
	@Test
	public void test03PonerCartaMagicaBocaAbajoLaVolvemosADarVueltaYQuedaBocaArriba() {
		Carta agujeroOscuro = new Carta("Agujero Oscuro", new EfectoAgujeroOscuro());
		
		agujeroOscuro.darVuelta();
		agujeroOscuro.darVuelta();
		
		assertFalse(agujeroOscuro.estaBocaAbajo());
	}
	
	@Test
	public void test04CartaMagicaBocaAbajoNoRealizaEfecto() {
		Carta agujeroOscuro = new Carta("Agujero Oscuro", new EfectoAgujeroOscuro());
		
		Mazo unMazo = new Mazo();
		Mazo mazoOponente = new Mazo();
		
		agujeroOscuro.darVuelta();
		agujeroOscuro.agregarAlCampo(new Campo(unMazo), new Campo(mazoOponente));
		agujeroOscuro.realizarEfecto(null,null);
		assertFalse(agujeroOscuro.estaBocaAbajo());
	}
	
	@Test
	public void test05ActivarAgujeroOscuro() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		Jugador jugador= new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		
		Carta agujeroOscuro = new Carta("Agujero Oscuro", new EfectoAgujeroOscuro());
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarCartaMagicaBocaArriba(agujeroOscuro);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
		assertTrue(agujeroOscuro.estaEnElCementerio());
	}
	
	@Test
	public void test06ActivarFisuraYOponenteSoloUnMonstruo() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		Jugador jugador = new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		Carta fisura = new Carta("Fisura", new EfectoFisura());
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarCartaMagicaBocaArriba(fisura);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(fisura.estaEnElCementerio());
	}
	
	@Test
	public void test07ActivarFisuraYOponenteCon2MonstruosYSeDestruyeElDeMenorAtaque() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		Jugador jugador= new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
	
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		
		Carta fisura = new Carta("Fisura", new EfectoFisura());
		
		jugador = jugador.pasarTurno();

		jugador.agregarCartaMagicaBocaArriba(fisura);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
		assertTrue(fisura.estaEnElCementerio());
	}
	
	@Test
	public void test08ActivarFisuraYOponenteConVariosMonstruosYSeDestruyeElDeMenorAtaque() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		Jugador jugador= new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		Monstruo brazoIzquierdoDelProhibido = new Monstruo ("Brazo Izquierdo Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		jugador = jugador.pasarTurno();
		jugador = jugador.pasarTurno();
		jugador.agregarMonstruoEnDefensa(brazoIzquierdoDelProhibido);
		
		Carta fisura = new Carta("Fisura", new EfectoFisura());
		
		jugador = jugador.pasarTurno();

		jugador.agregarCartaMagicaBocaArriba(fisura);
		
		assertTrue(brazoIzquierdoDelProhibido.estaEnElCementerio());
		assertFalse(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
		assertTrue(fisura.estaEnElCementerio());
	}
	
	@Test
	public void test09RealizarEfectoDeVolteoLevantaNoPuedeRealizarseException() throws InterrumpirAtaqueException, NoPuedeRealizarseEfectoDeVolteoException {
		Jugador jugador = new Jugador();
		Mazo mazo = new Mazo();
		Campo campo = new Campo(mazo);
		Campo campoOponente = new Campo(mazo);

		Carta magicaCualquiera = new Carta("Magica cualquiera", new EfectoVacio());
		
		magicaCualquiera.realizarEfectoDeVolteo(campo, campoOponente, jugador, jugador.pasarTurno());
	}
	
	@Test
	public void test10ActivarFisuraYOponenteSinMonstruos() throws ZonaNoTieneMasEspacioException, AccionInvalidaEnEstaFaseException {
		Jugador jugador = new Jugador();
		
		Carta fisura = new Carta("Fisura", new EfectoFisura());
		
		jugador.agregarCartaMagicaBocaArriba(fisura);
		
		assertTrue(fisura.estaEnElCementerio());
	}
}
