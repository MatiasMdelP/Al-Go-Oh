package algo3.AlGoOh;

public interface Posicion {

	Posicion ponerEnPosicionAtaque();
	
	Posicion ponerEnPosicionDefensa();
	
	int devolverDanio(int diferenciaDelEnfrentamiento);

	void efectuarDanio(int dif, Jugador jugadorAtacado, Monstruo monstruo);

	int obtenerResistencia(int puntosDeAtaque, int puntosDeDefensa);

	boolean estaEnAtaque();

	int calcularDiferenciaDeDaño(Posicion posicion);

	void agregarPuntos(int puntos);

	int calcularDaño(int puntosDeDefensa);

	int dañoAtaque();

}
