package algo3.AlGoOh;

public interface Fase {

	public Fase pasarFase() throws NoHayMasFasesException;

	public void sacrificar() throws AccionInvalidaEnEstaFaseException;

	public void agregarMonstruo() throws AccionInvalidaEnEstaFaseException;

	public void agregarMagica() throws AccionInvalidaEnEstaFaseException;

	public void agregarTrampa() throws AccionInvalidaEnEstaFaseException;
	
	public void agregarCampo() throws AccionInvalidaEnEstaFaseException;

	public void atacar() throws AccionInvalidaEnEstaFaseException;

	public void activarMagica() throws AccionInvalidaEnEstaFaseException;	
}
