package algo3.AlGoOh;

public class EfectoAumentar500Ataque implements Efecto{

	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		campo.obtenerMonstruo().agregarPuntosDeAtaque(500);
	}
	
	public void realizarEfectoDeVolteo (Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		this.realizarse(campo, campoOponente, unJugador, oponente);
	}


}
