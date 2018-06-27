package algo3.AlGoOh;

import algo3.AlgoOh.Exceptions.MonstruosInsuficientesParaSacrificioException;

public class Invocacion1Sacrificio implements Invocacion{

	public void efectuarSacrificios(Campo campo) throws MonstruosInsuficientesParaSacrificioException{
		campo.sacrificarMonstruos(1);
	}
}
