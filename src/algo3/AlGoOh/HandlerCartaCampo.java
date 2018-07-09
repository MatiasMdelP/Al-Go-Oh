package algo3.AlGoOh;

import algo3.AlGoOh.handlers.BotonCarta;
import algo3.AlGoOh.handlers.cartasEnMano.BotonCampoEnManoEventHandler;

public class HandlerCartaCampo implements HandlerCarta {

	@Override
	public BotonCarta getHandler(Carta carta) {
		return new BotonCampoEnManoEventHandler(carta);
	}

}
