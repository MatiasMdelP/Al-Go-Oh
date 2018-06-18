package algo3.AlGoOh;

public class Jugador {
	
	private int puntosDeVida;
	private Campo campo;
	int VIDA = 8000;
	private Jugador oponente;	
	
	public Jugador() {
		campo = new Campo(new Mazo());
		puntosDeVida = VIDA;
	}
	
	public int obtenerPuntosDeVida() {
		return puntosDeVida;
	}

	public void agregarMonstruoEnAtaque(Monstruo monstruo) {
		monstruo.colocarEnPosicionAtaque();
		campo.agregarMonstruo(monstruo);
	}

	public void agregarMonstruoEnDefensa(Monstruo monstruo) {
		monstruo.colocarEnPosicionDefensa();
		campo.agregarMonstruo(monstruo);
	}
	
	public void agregarCartaMagicaOTrampa(Magica cartaMagica) {
		cartaMagica.agregarAlCampo(campo, oponente.campo);
		campo.agregarMagicaOTrampa(cartaMagica);
	}
	
	public void agregarCartaCampo(DeCampo cartaCampo) {
		cartaCampo.agregarAlCampo(campo, oponente.campo);
		cartaCampo.realizarEfecto();
		campo.agregarDeCampo(cartaCampo);
	}

	public void activarMagicaOTrampa(int nroDeCarta) {
		campo.obtenerMagicaOTrampa(nroDeCarta).realizarEfecto();
	}
	
	public void atacarA(int nroMonstruoAtacante, int nroMonstruoAtacado) {
		 oponente.recibirAtaque(campo.obtenerMonstruo(nroMonstruoAtacante), nroMonstruoAtacado, this);
	}
	
	private void recibirAtaque(Monstruo atacante, int nroMonstruoAtacado, Jugador jugadorAtacante) {
		atacante.atacarA(campo.obtenerMonstruo(nroMonstruoAtacado),jugadorAtacante, this);
	}
	
	public int cantidadDeCartasEnMano() {
		return campo.obtenerCantidadDeCartasEnLaMano();
	}

	public void fijarOponente(Jugador oponente) {
		this.oponente = oponente;
		
	}

	public void reducirVida(int daño) {
		puntosDeVida -= daño;
		
	}

}









