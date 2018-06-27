package algo3.AlgoOh.Exceptions;

import algo3.AlGoOh.Campo;
import algo3.AlGoOh.Invocacion;

public class InvocacionDragonDefinitivoDeOjosAzules implements Invocacion{

	public void efectuarSacrificios(Campo campo) throws MonstruosInsuficientesParaSacrificioException{
		campo.sacrificarTresDragonesBlancosDeOjosAzules();
	}
}
