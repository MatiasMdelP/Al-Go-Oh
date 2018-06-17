package algo3.AlGoOh;

public class EfectoOllaDeLaCodicia implements Efecto{
	
	public void realizarse(Campo campo, Campo campoOponente) {
		campo.tomarUnaCartaDelMazo();
		campo.tomarUnaCartaDelMazo();
		campo.mandarMagicaOTrampaAlCementerio("Olla De La Codicia");
	}
}
