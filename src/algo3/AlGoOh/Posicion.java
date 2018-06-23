package algo3.AlGoOh;

public interface Posicion {

	Posicion ponerEnPosicionAtaque();
	
	Posicion ponerEnPosicionDefensa();
	
	int devolverDanio(int diferenciaDelEnfrentamiento);

	void efectuarDanio(int dif, Jugador jugadorAtacado, Monstruo monstruo);

	boolean estaEnAtaque();

	int calcularDiferenciaDeDanio(Posicion posicion);

	void agregarPuntos(int puntos);

	int calcularDanio(int puntosDeDefensa);

	int danioAtaque();

}
