package algo3.AlGoOh;

public class EfectoJinzo7 implements Efecto {

	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		oponente.reducirVida(500);
	}
}
