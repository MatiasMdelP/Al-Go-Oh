package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Campo {
	
	private List<Monstruo> zonaMonstruos = new ArrayList<Monstruo>();
	private List<Carta> zonaMagicasYTrampas = new ArrayList<Carta>();
	private Mazo mazo;
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
	
	public int obtenerNroCartaTrampa() {
		return zonaMagicasYTrampas.size()-1;
	}
	
	public void agregarMonstruo(Monstruo monstruo) throws MonstruosInsuficientesParaSacrificioException {
		monstruo.efectuarSacrificios(this);
		zonaMonstruos.add(monstruo);
	}
	
	public void agregarMagicaOTrampa(Carta carta) {
		zonaMagicasYTrampas.add(carta);
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
		zonaMagicasYTrampas.remove(nroDeCarta).mandarAlCementerio();
	}

	public int calcularDanio() {
		return monstruo.getDanio();
	}

	public void activarTrampa(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException{
		Iterator<Carta> iterador = zonaMagicasYTrampas.iterator();
		
		while(iterador.hasNext()) {
			if(iterador.next().activarTrampa(campo, campoOponente, unJugador, oponente))
				break;
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
		
		try {
			Iterator<Monstruo> monstruosASacrificar = zonaMonstruos.subList(0, cantidad).iterator();
			while(monstruosASacrificar.hasNext()) {
				monstruosASacrificar.next().mandarAlCementerio();
				monstruosASacrificar.remove();
			}
		} catch (Exception e){
			throw new MonstruosInsuficientesParaSacrificioException();
		}
	}
	
	public void sacrificarTresDragonesBlancosDeOjosAzules() throws MonstruosInsuficientesParaSacrificioException{
		Iterator<Monstruo> iterador = zonaMonstruos.iterator();
		
		int cantDragones = 0;
		
		while(iterador.hasNext()) {
			if(iterador.next().esDragonBlancoDeOjosAzules()) {
				cantDragones++;
			}
		}
		
		if(cantDragones < 3) {
			throw new MonstruosInsuficientesParaSacrificioException();
		} else {
			iterador = zonaMonstruos.iterator();
			
			while(iterador.hasNext()) {
				Monstruo monstruo = iterador.next();
				if(monstruo.esDragonBlancoDeOjosAzules()) {
					monstruo.mandarAlCementerio();
					iterador.remove();
				}
			}
		}
	}
}





