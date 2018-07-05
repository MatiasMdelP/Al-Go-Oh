package algo3.AlGoOh;

import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;
import algo3.AlGoOh.Exceptions.NoHayMasFasesException;

public class FaseFinal implements Fase {

	public Fase pasarFase(){
		throw new NoHayMasFasesException();
	}

	public void sacrificar(){
		throw new AccionInvalidaEnEstaFaseException();		
	}

	public void agregarMonstruo(){
		throw new AccionInvalidaEnEstaFaseException();		
	}

	public void agregarMagica(){
		throw new AccionInvalidaEnEstaFaseException();		
	}

	public void agregarTrampa(){
		throw new AccionInvalidaEnEstaFaseException();		
	}

	public void agregarCampo(){
		throw new AccionInvalidaEnEstaFaseException();
	}
	
	public void atacar(){
		throw new AccionInvalidaEnEstaFaseException();		
	}

	public void activarMagica(){
		
	}
	
	public String getNombreDeFase() {
		return "Fase Final";
	}
}
