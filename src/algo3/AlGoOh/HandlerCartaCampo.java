package algo3.AlGoOh;

import algo3.AlGoOh.handlers.BotonCampoEnManoEventHandler;
import algo3.AlGoOh.handlers.BotonCarta;

public class HandlerCartaCampo implements HandlerCarta {

	@Override
	public BotonCarta getHandler(Carta carta) {
		return new BotonCampoEnManoEventHandler(carta);
	}

}
