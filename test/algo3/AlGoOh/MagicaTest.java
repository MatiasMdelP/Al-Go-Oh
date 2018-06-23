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
		
		Magica fisura = new Magica("Fisura", new EfectoFisura());
		
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
		
		Magica fisura = new Magica("Fisura", new EfectoFisura());
		
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
		
		Magica fisura = new Magica("Fisura", new EfectoFisura());
		
		jugador = jugador.pasarTurno();

		jugador.agregarCartaMagica(fisura);
		jugador.activarMagica(0);
		
		assertTrue(brazoIzquierdoDelProhibido.estaEnElCementerio);
		assertFalse(huevoMonstruoso.estaEnElCementerio());
		assertFalse(monoAcrobata.estaEnElCementerio());
		assertTrue(fisura.estaEnElCementerio());
	}
	
	@Test(expected=NoPuedeRealizarseEfectoDeVolteoException.class)
	public void test08RealizarEfectoDeVolteoLevantaNoPuedeRealizarseException() throws NoPuedeRealizarseEfectoDeVolteoException, InterrumpirAtaqueException {
		Jugador jugador = new Jugador();
		Mazo mazo = new Mazo();
		Campo campo = new Campo(mazo);
		Campo campoOponente = new Campo(mazo);

		Carta magicaCualquiera = new Magica("Magica cualquiera", new EfectoVacio());
		
		magicaCualquiera.realizarEfectoDeVolteo(campo, campoOponente, jugador, jugador.pasarTurno());
	}
	
	@Test
	public void test09ActivarFisuraYOponenteSinMonstruos() throws ZonaNoTieneMasEspacioException {
		Jugador jugador = new Jugador();
		
		Magica fisura = new Magica("Fisura", new EfectoFisura());
		
		jugador.agregarCartaMagica(fisura);
		jugador.activarMagica(0);
		
		assertTrue(fisura.estaEnElCementerio());
	}
}
