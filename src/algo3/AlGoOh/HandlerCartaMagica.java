package algo3.AlGoOh;

import algo3.AlGoOh.handlers.BotonCarta;
import algo3.AlGoOh.handlers.cartasEnMano.BotonMagicaEnManoEventHandler;

public class HandlerCartaMagica implements HandlerCarta {

	@Override
	public BotonCarta getHandler(Carta carta) {
		return new BotonMagicaEnManoEventHandler(carta);
	}

}
