package algo3.AlGoOh;

import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.NoHayMasFasesException;

public class FaseFinal implements Fase {

	public Fase pasarFase() throws NoHayMasFasesException {
		throw new NoHayMasFasesException();
	}

	public void sacrificar() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();		
	}

	public void agregarMonstruo() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();		
	}

	public void agregarMagica() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();		
	}

	public void agregarTrampa() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();		
	}

	public void agregarCampo() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();
	}
	
	public void atacar() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();		
	}

	public void activarMagica() throws AccionInvalidaEnEstaFaseException {
		
	}
}
