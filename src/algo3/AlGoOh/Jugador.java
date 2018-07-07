package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.List;
import algo3.AlGoOh.Exceptions.*;

public class Jugador {
	
	private int puntosDeVida;
	private Campo campo;
	private Jugador oponente;	
	private List<Carta> cartasEnMano = new ArrayList<Carta>();
	private Fase fase;
	private Estado estadoGanador = new Estado(this);
	
	public Jugador() {
		campo = new Campo(new Mazo());
		puntosDeVida = 8000;
		fase = new FasePreparacion();
		for (int i = 0; i < 5; ++i) {
			tomarUnaCartaDelMazo();
		}
	}
	
	public int obtenerPuntosDeVida() {
		return puntosDeVida;
	}
	
	public void agregarMonstruoASacrificar(int posicionDelMonstruo) {
		fase.sacrificar();
		campo.agregarMonstruoASacrificar(posicionDelMonstruo);
	}

	public void agregarCartaEnMano(Carta unaCarta) {
		cartasEnMano.add(unaCarta);
	}
	
	public void agregarMonstruoEnAtaque(Monstruo monstruo){
		fase.agregarMonstruo();
		//monstruo.colocarEnPosicionAtaque();
		monstruo.agregarAlCampo(campo, oponente.campo);
		campo.agregarMonstruo(monstruo);
		cartasEnMano.remove(monstruo);
	}

	public void agregarMonstruoEnDefensa(Monstruo monstruo) {
		fase.agregarMonstruo();
		monstruo.colocarEnPosicionDefensa();
		campo.agregarMonstruo(monstruo);
		cartasEnMano.remove(monstruo);
	}
	
	public void agregarCartaMagicaBocaArriba(Carta magica) {
		fase.agregarMagica();
		magica.agregarAlCampo(campo, oponente.campo);
		campo.agregarMagica(magica);
		cartasEnMano.remove(magica);
		magica.realizarEfecto(this, oponente);
	}
	
	public void agregarCartaMagicaBocaAbajo(Carta magica) {
		fase.agregarMagica();
		magica.ponerBocaAbajo();
		magica.agregarAlCampo(campo, oponente.campo);
		campo.agregarMagica(magica);
		cartasEnMano.remove(magica);
	}
	
	public void agregarCartaTrampa(Carta trampa) {
		fase.agregarTrampa();
		trampa.agregarAlCampo(campo, oponente.campo);
		campo.agregarTrampa(trampa);
		cartasEnMano.remove(trampa);
	}
	
	public void agregarCartaCampo(Carta cartaCampo) {
		fase.agregarCampo();
		cartaCampo.agregarAlCampo(campo, oponente.campo);
		//cartaCampo.realizarEfecto(this, oponente); LO PASE AL CAMPO
		campo.agregarCartaDeCampo(cartaCampo, this, oponente); //Agregue
		cartasEnMano.remove(cartaCampo); //Agregue
	}

	public void activarMagica(int nroDeCarta) {
		fase.activarMagica();
		campo.obtenerMagicaOTrampa(nroDeCarta).realizarEfecto(this, oponente);
	}
	
	public void activarMonstruo(int nroDeCarta) {
		fase.atacar();
		campo.definirMonstruo(nroDeCarta);
		campo.obtenerMonstruo().realizarEfecto(this, oponente);
	}
	
	public void atacarA(int nroMonstruoAtacante, int nroMonstruoAtacado) {
		fase.atacar();
		campo.definirMonstruo(nroMonstruoAtacante);
		oponente.recibirAtaque(campo, nroMonstruoAtacado, this);
	}
	
	private void recibirAtaque(Campo campoAtacante, int nroMonstruoAtacado, Jugador jugadorAtacante) {
		campo.definirMonstruo(nroMonstruoAtacado);
		try {
			campo.activarTrampa(campo, campoAtacante, this, jugadorAtacante);
			campo.activarEfectoDeVolteoMonstruoDefinido(campo, campoAtacante, this, jugadorAtacante);
			campoAtacante.atacarA(jugadorAtacante,this);
		}catch(InterrumpirAtaqueException excepcion){
			
		}
	}
	
	public int cantidadDeCartasEnMano() {
		return (cartasEnMano.size());
	}

	public void reducirVida(int danio) {
		puntosDeVida -= danio;
		if(puntosDeVida <= 0) {
			oponente.declararComoGanador();
		}
	}
	
	public void tomarUnaCartaDelMazo() {
		try {
			cartasEnMano.add(campo.tomarUnaCartaDelMazo());
		} catch (ElMazoNoTieneCartasException exception) {
			oponente.declararComoGanador();
		}
	}
	

	public void ponerEnPosicionAtaque(int numeroDeMosntruo) {
		campo.ponerEnPosicionAtaque(numeroDeMosntruo);
		cartasEnMano.remove(numeroDeMosntruo);
	}
	
	public void ponerEnPosicionDefensa(int numeroDeMosntruo) {
		campo.ponerEnPosicionDefensa(numeroDeMosntruo);
	}
	
	public void darVueltaMonstruo(int numeroDeMonstruo) {
		campo.darVueltaMonstruo(numeroDeMonstruo);
	}

	public boolean ganoElJuego(){
		estadoGanador.actualizarEstado();
		return estadoGanador.ganoElJuego();
	}
	
	public void recibirAtaque(Monstruo monstruoAtacante, Jugador jugadorAtacante){
		this.campo.recibirAtaque(monstruoAtacante, jugadorAtacante, this);
	}
	
	public void mandarAlCementerioAlMonstruoDefinido() {
		campo.mandarAlCementerioAlMonstruoDefinido();
	}
	
	public Jugador pasarTurno() {
		oponente.FasePreparacion();
		oponente.tomarUnaCartaDelMazo();
		campo.pasarTurno();
		estadoGanador.actualizarEstado();
		return oponente;
	}


	public void pasarFase() throws NoHayMasFasesException {
		fase = fase.pasarFase();
	}

	public List<Carta> getListaDeCartasEnMano() {
		return cartasEnMano;
	}

	public List<Monstruo> getListaDeCartasEnZonaMonstruo() {
		return campo.getListaDeCartasEnZonaMonstruo();
	}
	
	public List<Carta> getListaDeCartasEnZonaMagicaTrampa() {
		return campo.getListaDeCartasEnZonaMagicaTrampa();
	}
	
	public Carta getCartaDeCampo() {
		return campo.getCartaDeCampo();
	}
	
	public void oponente(Jugador unJugador) {
		oponente = unJugador;
	}
	
	private void declararComoGanador() {
		estadoGanador.declararComoGanador();
	}
	

	private void FasePreparacion() {
		fase = new FasePreparacion();
	}

	public String getNombreDeFase() {
		return fase.getNombreDeFase();
	}
}