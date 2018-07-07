package algo3.AlGoOh;

import algo3.AlGoOh.Exceptions.MonstruoInvocadoEnTurnoActualException;

public class TurnoActual implements Turno {

	public void verificarAcciones() {
		throw new MonstruoInvocadoEnTurnoActualException();
	}
		
	public Turno pasarTurno() {
		return new TurnoAnterior();
	}
	
}
