package algo3.AlGoOh;

import algo3.AlGoOh.Exceptions.AccionInvalidaEnEstaFaseException;

public class FasePreparacion implements Fase{

	private boolean monstruoAgregado = false;

	public Fase pasarFase(){
		return new FaseAtaque();
	}

	public void sacrificar(){
	}

	public void agregarMonstruo(){
		if(monstruoAgregado) throw new AccionInvalidaEnEstaFaseException();
		monstruoAgregado = true;
	}

	public void agregarMagica(){
		
	}

	public void agregarTrampa(){
		
	}

	public void agregarCampo(){
		
	}
	
	public void atacar(){
		throw new AccionInvalidaEnEstaFaseException();
	}

	public void activarMagica(){
		throw new AccionInvalidaEnEstaFaseException();
	}

	@Override
	public String getNombreDeFase(){
		return "Fase de Preparacion";
	}

}
