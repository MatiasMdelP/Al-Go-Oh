package algo3.AlGoOh;

import algo3.AlGoOh.Exceptions.MonstruosInsuficientesParaSacrificioException;

public interface Invocacion {
	
	public void efectuarSacrificios(Campo campo) throws MonstruosInsuficientesParaSacrificioException;
}
