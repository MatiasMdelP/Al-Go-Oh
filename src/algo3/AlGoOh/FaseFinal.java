package algo3.AlGoOh;

public class FaseFinal implements Fase {

	@Override
	public Fase pasarFase() throws NoHayMasFasesException {
		throw new NoHayMasFasesException();
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
		throw new AccionInvalidaEnEstaFaseException();		
	}

	@Override
	public void activarMagica() throws AccionInvalidaEnEstaFaseException {
		
	}
}
