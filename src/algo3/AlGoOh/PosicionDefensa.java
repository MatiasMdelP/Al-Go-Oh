package algo3.AlGoOh;

public class PosicionDefensa implements Posicion {

	@Override
	public int esAtacado(Monstruo monstruoAtacado, int puntosDelAtacante) {
		return monstruoAtacado.esAtacadoEnPosicionDeDefensa(puntosDelAtacante);
	}
	

}
