package algo3.AlGoOh;

public class EfectoCilindroMAgico implements Efecto {

	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		int danio = campoOponente.calcularDanio();
		oponente.reducirVida(danio);
	}


}
