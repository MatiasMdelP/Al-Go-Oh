package algo3.AlGoOh;

public class EfectoAgujeroOscuro implements Efecto{
	
	public void realizarse(Campo campo, Campo campoOponente) {
		campo.mandarTodasLasCartasAlCementerio();
		campoOponente.mandarTodasLasCartasAlCementerio();
	}
}
