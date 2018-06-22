package algo3.AlGoOh;


public class Invocacion1Sacrificio implements Invocacion{

	public void efectuarSacrificios(Campo campo) throws MonstruosInsuficientesParaSacrificioException{
		campo.sacrificarMonstruos(1);
	}
}
