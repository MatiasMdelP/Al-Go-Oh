package algo3.AlGoOh;

import algo3.AlGoOh.Efectos.Efecto;

public interface Boca {
	public Boca darVuelta();

	public boolean getEstado();

	public Boca ponerBocaAbajo();

	public void verificarEstado();
	
	public Boca realizarEfectoDeVolteo(Efecto efecto, Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente);

}
