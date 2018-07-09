package algo3.AlGoOh;

import javafx.scene.control.Button;

public interface Posicion {

	Posicion ponerEnPosicionAtaque();
	
	Posicion ponerEnPosicionDefensa();
	
	int devolverDanio(int diferenciaDelEnfrentamiento);

	void efectuarDanio(int dif, Jugador jugadorAtacado, Monstruo monstruo);

	int calcularDiferenciaDeDanio(Posicion posicion);

	void agregarPuntosDeAtaque(int puntos);
	
	void agregarPuntosDeDefensa(int puntos);

	int calcularDanio(int puntosDeDefensa);

	int danioAtaque();

	void verificarEstado();

	void rotarBoton(Button unBoton);
	
	void pasarTurno();
}
