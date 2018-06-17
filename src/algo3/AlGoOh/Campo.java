package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	
	private List<Monstruo> zonaMonstruos = new ArrayList<Monstruo>();
	private List<Carta> zonaMagicasYTrampas = new ArrayList<Carta>();
	private List<Carta> cartasEnMano = new ArrayList<Carta>();
	private Mazo mazo = new Mazo();
	
	public Campo() {
		mazo.inicializarMazo();
	}
	
	public Monstruo obtenerMonstruo(int nroDeMonstruo) {
		return zonaMonstruos.get(nroDeMonstruo);
	}
	
	public Carta obtenerMagicaOTrampa(int nroDeCarta) {
		return zonaMagicasYTrampas.get(nroDeCarta);
	}
	
	public void agregarMonstruo(Monstruo monstruo) {
		monstruo.efectuarSacrificios(zonaMonstruos);
		zonaMonstruos.add(monstruo);
	}
	
	public void agregarMagicaOTrampa(Carta carta) {
		zonaMagicasYTrampas.add(carta);
	}
	
	public void tomarUnaCartaDelMazo() {
		cartasEnMano.add(mazo.tomarUnaCarta());
	}

	public void mandarMonstruoAlCementerio(int nroDeCarta) {
		zonaMonstruos.remove(nroDeCarta).mandarAlCementerio();
	}
	
	public void mandarMagicaOTrampaAlCementerio(int nroDeCarta) {
		zonaMagicasYTrampas.remove(nroDeCarta).mandarAlCementerio();
	}
	
	public void mandarMagicaOTrampaAlCementerio(String nombreDeLaCarta) {
		zonaMagicasYTrampas.remove(0).mandarAlCementerio();
	}
	public void mandarTodosLosMonstruosAlCementerio() {
		while (! zonaMonstruos.isEmpty()){
			mandarMonstruoAlCementerio(0);
		}
	}
	
	public void mandarTodosLasMagicasOTrampasAlCementerio() {
		while (! zonaMagicasYTrampas.isEmpty()){
			mandarMagicaOTrampaAlCementerio(0);
		}
	}
	
	public void mandarTodasLasCartasAlCementerio() {
		mandarTodosLosMonstruosAlCementerio();
		mandarTodosLasMagicasOTrampasAlCementerio();
	}
	
}





