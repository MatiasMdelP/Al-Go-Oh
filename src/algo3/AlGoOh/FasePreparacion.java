package algo3.AlGoOh;

import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;

public class FasePreparacion implements Fase {

	private boolean monstruoAgregado = false;

	@Override
	public Fase pasarFase() {
		return new FaseAtaque();
	}

	@Override
	public void sacrificar() throws AccionInvalidaEnEstaFaseException {
	}

	@Override
	public void agregarMonstruo() throws AccionInvalidaEnEstaFaseException {
		if(monstruoAgregado) throw new AccionInvalidaEnEstaFaseException();
		monstruoAgregado = true;
	}

	@Override
	public void agregarMagica() throws AccionInvalidaEnEstaFaseException {
		
	}

	@Override
	public void agregarTrampa() throws AccionInvalidaEnEstaFaseException {
		
	}

	@Override
	public void agregarCampo() throws AccionInvalidaEnEstaFaseException {
		
	}
	
	@Override
	public void atacar() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();
	}

	@Override
	public void activarMagica() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();
	}

}
