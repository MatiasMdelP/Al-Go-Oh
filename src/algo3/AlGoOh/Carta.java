package algo3.AlGoOh;

public abstract class Carta {
	
	protected boolean bocaAbajo;
	protected boolean estaEnElCementerio;
	protected String nombre;
	protected Efecto efecto;
	protected Campo campo;
	protected Campo campoOponente;

	public Carta(String nombreDeLaCarta, Efecto unEfecto) {
		nombre = nombreDeLaCarta;
		efecto = unEfecto;
		bocaAbajo = false;
		estaEnElCementerio = false;
	}
		
	public void mandarAlCementerio(){
		estaEnElCementerio = true;
	}

	public boolean estaEnElCementerio() {
		return estaEnElCementerio;
	}

	public boolean estaBocaAbajo() {
		return bocaAbajo;
	}
	
	public void darVuelta() {
		bocaAbajo = !bocaAbajo;
	}
	
	public void realizarEfecto(Jugador unJugador, Jugador oponente){
		efecto.realizarse(campo, campoOponente, unJugador, oponente);
		this.mandarAlCementerio();
		darVuelta();
	}
	
	public abstract boolean esParteDelExodia();
	
	public abstract void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws NoPuedeRealizarseEfectoDeVolteoException, InterrumpirAtaqueException;
	
	public void agregarAlCampo(Campo unCampo, Campo unCampoOponente) {
		campo = unCampo;
		campoOponente = unCampoOponente;
	}
}
