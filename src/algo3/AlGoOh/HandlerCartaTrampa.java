package algo3.AlGoOh;

import algo3.AlGoOh.handlers.BotonCarta;
import algo3.AlGoOh.handlers.BotonTrampaEnManoEventHandler;

public class HandlerCartaTrampa implements HandlerCarta {

	@Override
	public BotonCarta getHandler(Carta carta) {
		return new BotonTrampaEnManoEventHandler(carta);
	}

}
