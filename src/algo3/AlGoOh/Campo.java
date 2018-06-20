package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Campo {
	
	private List<Monstruo> zonaMonstruos = new ArrayList<Monstruo>();
	private List<Carta> zonaMagicasYTrampas = new ArrayList<Carta>();
	private List<Carta> cartasEnMano = new ArrayList<Carta>();
	private Mazo mazo;
	private DeCampo zonaDeCampo;
	private Monstruo monstruo;
	private int nroMonstruoDefinido;
	
	public Campo(Mazo unMazoDeCartas) {
		mazo = unMazoDeCartas;
		mazo.inicializarMazo();
	}
	
	public Monstruo obtenerMonstruo() {
		return monstruo;
	}
	
	public Carta obtenerMagicaOTrampa(int nroDeCarta) {
		return zonaMagicasYTrampas.get(nroDeCarta);
	}
	
	
	public int obtenerCantidadDeCartasEnLaMano() {
		return (cartasEnMano.size());
	}
	
	public int obtenerNroCartaTrampa() {
		return zonaMagicasYTrampas.size()-1;
	}
	
	public void agregarMonstruo(Monstruo monstruo) throws MonstruosInsuficientesParaSacrificioException {
		monstruo.efectuarSacrificios(zonaMonstruos);
		zonaMonstruos.add(monstruo);
	}
	
	public void agregarMagicaOTrampa(Carta carta) {
		zonaMagicasYTrampas.add(carta);
	}
	
	public void agregarDeCampo(DeCampo cartaCampo) {
		zonaDeCampo = cartaCampo;
	}

	public void agregarCartaEnMano(Carta unaCarta) {
		cartasEnMano.add(unaCarta);
	}
	
	public void tomarUnaCartaDelMazo() {
		cartasEnMano.add(mazo.tomarUnaCarta());
	}

	public void mandarMonstruoAlCementerio(int nroDeCarta) {
		zonaMonstruos.remove(nroDeCarta).mandarAlCementerio();
	}
	
	public void mandarMonstruoAlCementerio(String nombreDeLaCarta) {
		mandarMonstruoAlCementerio(buscarUnaCartaPorNombre(zonaMonstruos, nombreDeLaCarta));
	}
	
	public void mandarMagicaOTrampaAlCementerio(int nroDeCarta) {
		zonaMagicasYTrampas.remove(nroDeCarta).mandarAlCementerio();
	}
	
	private int buscarUnaCartaPorNombre(List zonaARecorrer, String nombreDeLaCarta) {
		for (int i = 0; i < zonaARecorrer.size(); i++) {
			if (((Carta) zonaARecorrer.get(i)).seLlama(nombreDeLaCarta))
				return i;
		}
		throw new Error();
	}

	public int calcularDanio() {
		return monstruo.getDanio();
	}

	public void atacarA(Jugador jugadorAtacante, Jugador jugadorAtacado) throws MonstruoNoPuedeAtacarException {
		jugadorAtacado.recibirAtaque(monstruo,jugadorAtacante);
	}

	public void recibirAtaque(Monstruo monstruoAtacante, Jugador jugadorAtacante, Jugador jugadorAtacado) throws MonstruoNoPuedeAtacarException {
		monstruoAtacante.atacarA(monstruo, jugadorAtacante, jugadorAtacado);
	}
	
	public void definirMonstruo(int nroDeMonstruo) {
		nroMonstruoDefinido = nroDeMonstruo;
		monstruo = zonaMonstruos.get(nroDeMonstruo);
	}
	
	public void activarEfectoDeVolteoMonstruoDefinido(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException {
		monstruo.realizarEfectoDeVolteo(campo, campoOponente, unJugador, oponente);
	}

	public void mandarMonstruoDefinidoAlCementerio() {
		zonaMonstruos.remove(nroMonstruoDefinido);
		monstruo.mandarAlCementerio();
	}
	
	public Iterator<Monstruo> iterarMonstruos() {
		return zonaMonstruos.iterator();
	}
	
	public Iterator<Carta> iterarMagicasYTrampas() {
		return zonaMagicasYTrampas.iterator();
	}
}





