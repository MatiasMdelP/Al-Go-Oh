package algo3.AlGoOh;

import algo3.AlGoOh.handlers.BotonCarta;
import algo3.AlGoOh.handlers.cartasEnMano.BotonTrampaEnManoEventHandler;

public class HandlerCartaTrampa implements HandlerCarta {

	@Override
	public BotonCarta getHandler(Carta carta) {
		return new BotonTrampaEnManoEventHandler(carta);
	}

}
