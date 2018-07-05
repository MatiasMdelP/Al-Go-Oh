package algo3.AlGoOh;

public interface Fase {

	public Fase pasarFase();

	public void sacrificar();

	public void agregarMonstruo();

	public void agregarMagica();

	public void agregarTrampa();
	
	public void agregarCampo();

	public void atacar();

	public void activarMagica();
	
	public String getNombreDeFase();
}
