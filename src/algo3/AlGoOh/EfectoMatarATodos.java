package algo3.AlGoOh;

public class EfectoMatarATodos implements Efecto {

	private Campo campo;
	public EfectoMatarATodos(Campo campo) {
		this.campo = campo;
	}

	public void realizarse(Campo campo, Campo campoOponente) {
		campo.MatarATodos();
		campoOponente.MatarATodos();
	}

}
