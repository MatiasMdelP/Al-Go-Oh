package algo3.AlGoOh;

public class Carta {
	
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
	
	public void realizarEfecto(Jugador unJugador, Jugador oponente) {
		if(bocaAbajo) darVuelta();
		efecto.realizarse(campo, campoOponente, unJugador, oponente);
		campo.mandarMagicaOTrampaAlCementerio(this);
	}
	
	public boolean esParteDelExodia() {
		return false;
	}
	
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws NoPuedeRealizarseEfectoDeVolteoException, InterrumpirAtaqueException{
		efecto.realizarEfectoDeVolteo(campo, campoOponente, unJugador, oponente);
		this.darVuelta();
	}
	
	public void agregarAlCampo(Campo unCampo, Campo unCampoOponente) {
		campo = unCampo;
		campoOponente = unCampoOponente;
	}
}
