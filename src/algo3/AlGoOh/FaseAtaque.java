package algo3.AlGoOh;

import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;

public class FaseAtaque implements Fase{

	public Fase pasarFase(){
		return new FaseFinal();
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

	}

	public void activarMagica(){
		throw new AccionInvalidaEnEstaFaseException();
	}

	public String getNombreDeFase(){
		return "Fase de Ataque";
	}
}
