package algo3.AlGoOh;

public class PosicionDefensa implements Posicion {

	@Override
	public int devolverDanio(int diferenciaDelEnfrentamiento) {
		if (diferenciaDelEnfrentamiento < 0)
			return 0;
		return diferenciaDelEnfrentamiento;
	}

}
