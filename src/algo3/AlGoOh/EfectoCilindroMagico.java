package algo3.AlGoOh;

public class EfectoCilindroMagico implements Efecto {

	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		int danio = campoOponente.calcularDanio();
		oponente.reducirVida(danio);
	}


}
