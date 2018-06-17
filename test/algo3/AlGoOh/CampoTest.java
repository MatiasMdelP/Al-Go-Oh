package algo3.AlGoOh;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class CampoTest {

	@Test
	public void test01AlIniciarNoTengoCartasEnMano() {
		Mazo unMazo = new Mazo();
		unMazo.inicializarMazo();
		Campo unCampo = new Campo(unMazo);
		
		assertEquals(0, unCampo.obtenerCantidadDeCartasEnLaMano());
	}
	
	@Test
	public void test02AlTomarUnaCartaTengoUnaEnMano() {
		Mazo unMazo = new Mazo();
		unMazo.inicializarMazo();
		Campo unCampo = new Campo(unMazo);
		unCampo.tomarUnaCartaDelMazo();
		
		assertEquals(1, unCampo.obtenerCantidadDeCartasEnLaMano());
	}
}
