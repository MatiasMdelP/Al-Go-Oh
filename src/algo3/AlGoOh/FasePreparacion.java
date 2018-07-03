package algo3.AlGoOh;

import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;

public class FasePreparacion implements Fase {

	private boolean monstruoAgregado = false;

	public Fase pasarFase() {
		return new FaseAtaque();
	}

	public void sacrificar() throws AccionInvalidaEnEstaFaseException {
	}

	public void agregarMonstruo() throws AccionInvalidaEnEstaFaseException {
		if(monstruoAgregado) throw new AccionInvalidaEnEstaFaseException();
		monstruoAgregado = true;
	}

	public void agregarMagica() throws AccionInvalidaEnEstaFaseException {
		
	}

	public void agregarTrampa() throws AccionInvalidaEnEstaFaseException {
		
	}

	public void agregarCampo() throws AccionInvalidaEnEstaFaseException {
		
	}
	
	public void atacar() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();
	}

	public void activarMagica() throws AccionInvalidaEnEstaFaseException {
		throw new AccionInvalidaEnEstaFaseException();
	}

	@Override
	public String getNombreDeFase() {
		return "Fase de Preparacion";
	}

}
