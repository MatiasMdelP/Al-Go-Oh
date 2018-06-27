package algo3.AlGoOh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

class EstadoTest {

	@Test
	void test01EstadoVacioConJugadorSinNadaDaFalso() {
		Estado estado = new Estado();
		Jugador jugador = new Jugador();
		assertFalse(Estado.ganoElJuego(jugador));
	}

}
