package algo3.AlGoOh.Efectos;

import algo3.AlGoOh.Campo;
import algo3.AlGoOh.Carta;
import algo3.AlGoOh.Estado;
import algo3.AlGoOh.Jugador;
import algo3.AlGoOh.Exceptions.InterrumpirAtaqueException;
import algo3.AlGoOh.Monstruo;
import java.util.List;

public class EfectoAgujeroOscuro implements Efecto{
	
	@Override
	public void realizarse(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		campo.vaciarMonstruosEnCampo();
		campoOponente.vaciarMonstruosEnCampo();
		/*Iterator<Carta> iterador1 = campo.iterarMagicasYTrampas();
		Iterator<Monstruo> iterador2 = campo.iterarMonstruos();
	
		iterador1.forEachRemaining(e -> e.mandarAlCementerio());
		iterador2.forEachRemaining(e -> campo.mandarMonstruoAlCementerio(e));
		
		iterador1 = campoOponente.iterarMagicasYTrampas();
		iterador2 = campoOponente.iterarMonstruos();
		
		iterador1.forEachRemaining(e -> e.mandarAlCementerio());
		iterador2.forEachRemaining(e -> campoOponente.mandarMonstruoAlCementerio(e));
		
		while (iterador1.hasNext()) {
			iterador1.next().mandarAlCementerio();
		}
		
		while (iterador2.hasNext()) {
			iterador2.next().mandarAlCementerio();
		}
		*/
	}

	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) throws InterrumpirAtaqueException{}

	@Override
	public void modificarEstado(Estado estado) {
	}

	@Override
	public void sacrificar(List<Monstruo>  monstruosASacrificar, Monstruo monstruo) {
		// TODO Auto-generated method stub
		
	}


}
