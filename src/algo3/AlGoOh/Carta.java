package algo3.AlGoOh;

import algo3.AlGoOh.Efectos.Efecto;
import algo3.AlGoOh.Exceptions.InterrumpirAtaqueException;
import algo3.AlGoOh.handlers.BotonCarta;
import javafx.scene.control.Button;

public class Carta {
	
	protected Boca boca;
	protected boolean estaEnElCementerio;
	protected String nombre;
	protected Efecto efecto;
	protected Campo campo;
	protected Campo campoOponente;
	private HandlerCarta handler;

	public Carta(String nombreDeLaCarta, Efecto unEfecto, HandlerCarta unHandler) {
		nombre = nombreDeLaCarta;
		efecto = unEfecto;
		handler = unHandler;
		boca = new BocaArriba();
		estaEnElCementerio = false;
	}
	
	public String obtenerNombre() {
		return nombre;
	}
	
	public void rotarBoton(Button unBoton) {}
		
	public void mandarAlCementerio(){
		estaEnElCementerio = true;
	}

	public boolean estaEnElCementerio() {
		return estaEnElCementerio;
	}

	public boolean estaBocaAbajo() {
		return boca.getEstado();
	}
	
	//estos tres metodos no contribuyen a la funcionalidade de la cclase pero ayudan a las pruebass
	
	public void darVuelta() {
		boca = boca.darVuelta();
	}
	
	public void realizarEfecto(Jugador unJugador, Jugador oponente) {
		ponerBocaAbajo();
		efecto.realizarse(campo, campoOponente, unJugador, oponente);
		campo.mandarMagicaOTrampaAlCementerio(this);
	}
	
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException{
		efecto.realizarEfectoDeVolteo(campo, campoOponente, unJugador, oponente);
		this.darVuelta();
	}
	
	public void agregarAlCampo(Campo unCampo, Campo unCampoOponente) {
		campo = unCampo;
		campoOponente = unCampoOponente;
	}

	public void modificarEstado(Estado estado) {
		this.efecto.modificarEstado(estado);
	}

	public void ponerBocaAbajo() {
		boca = boca.ponerBocaAbajo();
	}

	public BotonCarta getHandler() {
		return handler.getHandler(this);
	}
}
