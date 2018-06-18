package algo3.AlGoOh;

import java.util.List;

public class InvocacionDragonDefinitivoDeOjosAzules implements Invocacion{

	public void efectuarSacrificios(List<Monstruo> monstruos) throws MonstruosInsuficientesParaSacrificioException{
		int cantidadDeDragonesDeOjosAzules = 0;
		
		for (int i = 0; i < monstruos.size(); i++) {
			if (monstruos.get(i).seLlama("Dragon Blanco De Ojos Azules")) {
				cantidadDeDragonesDeOjosAzules++;
			}
		}

		if (cantidadDeDragonesDeOjosAzules >= 3) {
			sacrificarATresDragonesDeOjosAzules(monstruos);
		} else {
			throw new MonstruosInsuficientesParaSacrificioException();
		}
	}
	
	private void sacrificarATresDragonesDeOjosAzules(List<Monstruo> monstruos) {
		
		for (int i = 0; i < monstruos.size(); i++) {
			if ((monstruos.get(i)).seLlama("Dragon Blanco De Ojos Azules")) {
				monstruos.remove(i).mandarAlCementerio();
				i--;
			}
		}
	}

}
