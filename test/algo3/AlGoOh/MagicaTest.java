package algo3.AlGoOh;

import org.junit.Test;
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
	public void test05ActivarAgujeroOscuro() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador jugador= new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		
		Carta agujeroOscuro = new Carta("Agujero Oscuro", new EfectoAgujeroOscuro());
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarCartaMagica(agujeroOscuro);
		jugador.activarMagica(0);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(monoAcrobata.estaEnElCementerio());
		assertTrue(agujeroOscuro.estaEnElCementerio());
	}
	
	@Test
	public void test06ActivarFisuraYOponenteSoloUnMonstruo() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador jugador = new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		
		Carta fisura = new Carta("Fisura", new EfectoFisura());
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarCartaMagica(fisura);
		jugador.activarMagica(0);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertTrue(fisura.estaEnElCementerio());
	}
	
	@Test
	public void test07ActivarFisuraYOponenteCon2MonstruosYSeDestruyeElDeMenorAtaque() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador jugador= new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
	
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		
		Carta fisura = new Carta("Fisura", new EfectoFisura());
		
		jugador = jugador.pasarTurno();

		jugador.agregarCartaMagica(fisura);
		jugador.activarMagica(0);
		
		assertTrue(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
		assertTrue(fisura.estaEnElCementerio());
	}
	
	@Test
	public void test07ActivarFisuraYOponenteConVariosMonstruosYSeDestruyeElDeMenorAtaque() throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		Jugador jugador= new Jugador();
		
		Monstruo huevoMonstruoso = new Monstruo("Huevo Monstruoso", new EfectoVacio(), new InvocacionNormal(), 600, 900);
		Monstruo monoAcrobata = new Monstruo("Mono Acrobata", new EfectoVacio(), new InvocacionNormal(), 1000, 1800);
		Monstruo brazoIzquierdoDelProhibido = new Monstruo ("Brazo Izquierdo Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		
		jugador = jugador.pasarTurno();
		
		jugador.agregarMonstruoEnAtaque(huevoMonstruoso);
		jugador.agregarMonstruoEnAtaque(monoAcrobata);
		jugador.agregarMonstruoEnDefensa(brazoIzquierdoDelProhibido);
		
		Carta fisura = new Carta("Fisura", new EfectoFisura());
		
		jugador = jugador.pasarTurno();

		jugador.agregarCartaMagica(fisura);
		jugador.activarMagica(0);
		
		assertTrue(brazoIzquierdoDelProhibido.estaEnElCementerio);
		assertFalse(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
		assertTrue(fisura.estaEnElCementerio());
	}
	
	@Test
	public void test08RealizarEfectoDeVolteoLevantaNoPuedeRealizarseException() throws InterrumpirAtaqueException, NoPuedeRealizarseEfectoDeVolteoException {
		Jugador jugador = new Jugador();
		Mazo mazo = new Mazo();
		Campo campo = new Campo(mazo);
		Campo campoOponente = new Campo(mazo);

		Carta magicaCualquiera = new Carta("Magica cualquiera", new EfectoVacio());
		
		magicaCualquiera.realizarEfectoDeVolteo(campo, campoOponente, jugador, jugador.pasarTurno());
		//realizarEfectoDeVolteo solo las ejecutan las de trampa
	}
	
	@Test
	public void test09ActivarFisuraYOponenteSinMonstruos() throws ZonaNoTieneMasEspacioException {
		Jugador jugador = new Jugador();
		
		Carta fisura = new Carta("Fisura", new EfectoFisura());
		
		jugador.agregarCartaMagica(fisura);
		jugador.activarMagica(0);
		
		assertTrue(fisura.estaEnElCementerio());
	}
}
