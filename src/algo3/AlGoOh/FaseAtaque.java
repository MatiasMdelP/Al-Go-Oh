package algo3.AlGoOh;

import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;

public class FaseAtaque implements Fase {

	public Fase pasarFase() {
		return new FaseFinal();
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

	}

	public void activarMagica() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();
	}

	public String getNombreDeFase() {
		return "Fase de Ataque";
	}
}
