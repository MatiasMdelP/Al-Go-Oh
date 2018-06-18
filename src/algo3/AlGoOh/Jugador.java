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

	public void agregarMonstruoEnAtaque(Monstruo monstruo) throws MonstruosInsuficientesParaSacrificioException{
		monstruo.colocarEnPosicionAtaque();
		campo.agregarMonstruo(monstruo);
	}

	public void agregarMonstruoEnDefensa(Monstruo monstruo) throws MonstruosInsuficientesParaSacrificioException{
		monstruo.colocarEnPosicionDefensa();
		campo.agregarMonstruo(monstruo);
	}
	
	public void agregarCartaMagicaOTrampa(Magica cartaMagica) {
		cartaMagica.agregarAlCampo(campo, oponente.campo);
		campo.agregarMagicaOTrampa(cartaMagica);
	}

	public void activarMagicaOTrampa(int nroDeCarta) {
		campo.obtenerMagicaOTrampa(nroDeCarta).realizarEfecto();
	}
	
	public void agregarCartaCampo(DeCampo cartaCampo) {
		cartaCampo.agregarAlCampo(campo, oponente.campo);
		cartaCampo.realizarEfecto();
		campo.agregarMagicaOTrampa(cartaCampo);
	}
	
	public void atacarA(Jugador oponente, int nroMonstruoAtacante, int nroMonstruoAtacado) {
		int diferenciaDePuntos = oponente.atacarse(campo.obtenerMonstruo(nroMonstruoAtacante), nroMonstruoAtacado);
		
		if (diferenciaDePuntos > 0) {
			puntosDeVida -= diferenciaDePuntos;
		}
	}
	
	public int atacarse(Monstruo atacante, int nroMonstruoAtacado) {
		int diferenciaDePuntos = atacante.atacarA(campo.obtenerMonstruo(nroMonstruoAtacado));
		
		if (diferenciaDePuntos < 0) {
			puntosDeVida += diferenciaDePuntos;
			return 0;
		}
		return diferenciaDePuntos;
	}
	
	public int cantidadDeCartasEnMano() {
		return campo.obtenerCantidadDeCartasEnLaMano();
	}

	public void fijarOponente(Jugador oponente) {
		this.oponente = oponente;
		
	}


}









