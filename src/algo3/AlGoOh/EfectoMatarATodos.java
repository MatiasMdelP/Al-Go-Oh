package algo3.AlGoOh;

public class EfectoMatarATodos implements Efecto {

	private Campo campo;
	public EfectoMatarATodos(Campo campo) {
		this.campo = campo;
	}
	@Override
	public void realizarse() {
		
		for(Monstruo m : campo.getMonstruos()) {
			m.mandarAlCementerio();
		}

	}

}
