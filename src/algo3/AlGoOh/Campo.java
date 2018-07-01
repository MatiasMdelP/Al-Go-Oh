package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import algo3.AlGoOh.Exceptions.CartaNoEncontradaException;
import algo3.AlGoOh.Exceptions.InterrumpirAtaqueException;
import algo3.AlGoOh.Exceptions.MonstruoNoPuedeAtacarException;
import algo3.AlGoOh.Exceptions.MonstruosInsuficientesParaSacrificioException;
import algo3.AlGoOh.Exceptions.NoPuedeRealizarseEfectoDeVolteoException;
import algo3.AlGoOh.Exceptions.ZonaNoTieneMasEspacioException;

public class Campo {
	
	private List<Monstruo> zonaMonstruos = new ArrayList<Monstruo>();
	private List <Carta> zonaMagicasYTrampas = new ArrayList<Carta>();
	private List<Carta> zonaMagicas = new ArrayList<Carta>();
	private List<Carta> zonaTrampas = new ArrayList<Carta>();
	private Mazo mazo;
	private Monstruo monstruo;
	private int nroMonstruoDefinido;
	private List<Monstruo> monstruosASacrificar = new ArrayList<Monstruo>();
	
	public Campo(Mazo unMazoDeCartas) {
		mazo = unMazoDeCartas;
		mazo.inicializarMazo();
	}
	
	public Monstruo obtenerMonstruo() {
		return monstruo;
	}
	
	public List<Monstruo> getListaDeCartasEnZonaMonstruo() {
		return zonaMonstruos;
	}
	
	public List<Carta> getListaDeCartasEnZonaMagicaTrampa() {
		return zonaMagicasYTrampas;
	}
	
	public void ponerEnPosicionAtaque(int numeroDeMonstruo) {
		zonaMonstruos.get(numeroDeMonstruo).colocarEnPosicionAtaque();
	}
	
	public void ponerEnPosicionDefensa(int numeroDeMonstruo) {
		zonaMonstruos.get(numeroDeMonstruo).colocarEnPosicionDefensa();
	}
	
	public void darVueltaMonstruo(int numeroDeMonstruo) {
		zonaMonstruos.get(numeroDeMonstruo).darVuelta();
	}
	
	public void agregarMonstruoASacrificar(int posicionASacrificar) {
		monstruosASacrificar.add(zonaMonstruos.get(posicionASacrificar));
	}
	
	public Carta obtenerMagicaOTrampa(int nroDeCarta) {
		return zonaMagicasYTrampas.get(nroDeCarta);
	}

	public void agregarMonstruo(Monstruo monstruo) throws MonstruosInsuficientesParaSacrificioException, ZonaNoTieneMasEspacioException {
		verificarCapacidadDeZonas(zonaMonstruos);
		monstruo.efectuarSacrificios(this);
		zonaMonstruos.add(monstruo);
	}
	
	public void agregarMagica(Carta magica) throws ZonaNoTieneMasEspacioException {
		verificarCapacidadDeZonas(zonaMagicasYTrampas);
		zonaMagicasYTrampas.add(magica);
		zonaMagicas.add(magica);
	}
	
	public void agregarTrampa(Carta trampa) throws ZonaNoTieneMasEspacioException {
		verificarCapacidadDeZonas(zonaMagicasYTrampas);
		trampa.darVuelta();
		zonaMagicasYTrampas.add(trampa);
		zonaTrampas.add(trampa);
	}
	
	@SuppressWarnings("rawtypes")
	private void verificarCapacidadDeZonas(List unaZona) throws ZonaNoTieneMasEspacioException{
		if (unaZona.size() == 5) throw new ZonaNoTieneMasEspacioException();
	}
	
	public Carta tomarUnaCartaDelMazo() {
		return mazo.tomarUnaCarta();
	}

	public void mandarMonstruoAlCementerio(int nroDeCarta) {
		zonaMonstruos.remove(nroDeCarta).mandarAlCementerio();
	}
	
	public void mandarMonstruoAlCementerio(Monstruo monstruo) {
		if(!zonaMonstruos.contains(monstruo)) {
			throw new CartaNoEncontradaException();
		}
		zonaMonstruos.remove(monstruo);
		monstruo.mandarAlCementerio();
	}
	
	public void mandarMagicaOTrampaAlCementerio(int nroDeCarta) {
		Carta carta = zonaMagicasYTrampas.remove(nroDeCarta);
		zonaMagicas.remove(carta);
		zonaTrampas.remove(carta);
		carta.mandarAlCementerio();
	}

	public int calcularDanio() {
		return monstruo.getDanio();
	}

	public void activarTrampa(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException{
		try {
			Carta trampa = zonaTrampas.remove(0);
			zonaMagicasYTrampas.remove(trampa);
			trampa.mandarAlCementerio();
			trampa.realizarEfectoDeVolteo(campo, campoOponente, unJugador, oponente);
		} catch (IndexOutOfBoundsException e) {
			
		} catch (NoPuedeRealizarseEfectoDeVolteoException e) {
			
		}
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

	public void sacrificarMonstruos(int cantidad) throws MonstruosInsuficientesParaSacrificioException {
		Monstruo monstruoASacrificar;
		
		try {
			Iterator<Monstruo> iteradorSacrificios = monstruosASacrificar.subList(0, cantidad).iterator();
			while(iteradorSacrificios.hasNext()) {
				monstruoASacrificar = iteradorSacrificios.next();
				monstruoASacrificar.mandarAlCementerio();
				zonaMonstruos.remove(monstruoASacrificar);
				iteradorSacrificios.remove();
				
			}
		} catch (Exception e){
			throw new MonstruosInsuficientesParaSacrificioException();
		}
		monstruosASacrificar.clear();
	}
	
	public void sacrificarTresDragonesBlancosDeOjosAzules() throws MonstruosInsuficientesParaSacrificioException{
		Iterator<Monstruo> iterador = zonaMonstruos.iterator();
		monstruosASacrificar.clear();
		
		int cantDragones = 0;
		Monstruo monstruoConPosibleSacrificio;
		
		while(iterador.hasNext()) {
			monstruoConPosibleSacrificio = iterador.next();
			if(monstruoConPosibleSacrificio.esDragonBlancoDeOjosAzules()) {
				cantDragones++;
				monstruosASacrificar.add(monstruoConPosibleSacrificio);
			}
		}
		
		if(cantDragones < 3) {
			throw new MonstruosInsuficientesParaSacrificioException();
		} 
		sacrificarMonstruos(3);
	}

	public void mandarMagicaOTrampaAlCementerio(Carta carta) {
		zonaMagicasYTrampas.remove(carta);
		zonaMagicas.remove(carta);
		zonaTrampas.remove(carta);
		carta.mandarAlCementerio();
	}

}