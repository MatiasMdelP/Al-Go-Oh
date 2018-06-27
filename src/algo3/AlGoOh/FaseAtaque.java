package algo3.AlGoOh;

import algo3.AlgoOh.Exceptions.AccionInvalidaEnEstaFaseException;

public class FaseAtaque implements Fase {

	@Override
	public Fase pasarFase() {
		return new FaseFinal();
	}

	@Override
	public void sacrificar() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();
	}

	@Override
	public void agregarMonstruo() throws AccionInvalidaEnEstaFaseException {
		 throw new AccionInvalidaEnEstaFaseException();
	}

	@Override
	public void agregarMagica() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();		
	}

	@Override
	public void agregarTrampa() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();		
	}
	
	@Override
	public void agregarCampo() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();
	}

	@Override
	public void atacar() throws AccionInvalidaEnEstaFaseException {

	}

	@Override
	public void activarMagica() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();
	}
}
