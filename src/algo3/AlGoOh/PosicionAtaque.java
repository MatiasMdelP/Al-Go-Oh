package algo3.AlGoOh;

public class PosicionAtaque implements Posicion{
	
	public int esAtacado(Monstruo monstruoAtacado, int puntosDelAtacante) {
		return monstruoAtacado.esAtacadoEnPosicionDeAtaque(puntosDelAtacante);
	}
}
