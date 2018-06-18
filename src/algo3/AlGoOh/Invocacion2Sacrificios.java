package algo3.AlGoOh;

import java.util.List;

public class Invocacion2Sacrificios implements Invocacion{
	
	public void efectuarSacrificios(List<Monstruo> monstruos) throws MonstruosInsuficientesParaSacrificioException{
		if (monstruos.size() >= 2) {
			monstruos.remove(0).mandarAlCementerio();
			monstruos.remove(0).mandarAlCementerio();
		} else {
			throw new MonstruosInsuficientesParaSacrificioException();
		}
		/*try {
		monstruos.remove(0).mandarAlCementerio();
		monstruos.remove(0).mandarAlCementerio();
		}catch(IndexOutOfBoundsException excepcion) {
			throw new MonstruosInsuficientesParaSacrificioException();
		}*/
	}
}

