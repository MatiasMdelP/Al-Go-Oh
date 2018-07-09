package algo3.AlGoOh;

import java.util.List;
import algo3.AlGoOh.Efectos.Efecto;
import algo3.AlGoOh.handlers.BotonCarta;
import algo3.AlGoOh.handlers.BotonMonstruoEnManoEventHandler;
import javafx.scene.control.Button;

public class Monstruo extends Carta {
	
	private Posicion posicion;
	private Invocacion invocacion;
	private Turno turnoDeInvocacion;
	
	public Monstruo(String unNombre, Efecto unEfecto, Invocacion invocacionIngresada, int ataque, int defensa) {
		super(unNombre, unEfecto, null);
		invocacion = invocacionIngresada;
		estaEnElCementerio = false;
		posicion = new PosicionAtaque(ataque,defensa);
		turnoDeInvocacion= new TurnoActual();
	}
	
	public void invocarBocaAbajo() {
		super.darVuelta();
	}
	
	public void rotarBoton(Button unBoton) {
		posicion.rotarBoton(unBoton);
	}
	
	public void colocarEnPosicionAtaque() {
		turnoDeInvocacion.verificarAcciones();
		posicion = posicion.ponerEnPosicionAtaque();
	}
	
	public void colocarEnPosicionDefensa() {
		turnoDeInvocacion.verificarAcciones();
		posicion = posicion.ponerEnPosicionDefensa();
	}
	
	public void darVuelta() {
		turnoDeInvocacion.verificarAcciones();
		super.darVuelta();
	}
	
	public void pasarTurno() {
		turnoDeInvocacion = turnoDeInvocacion.pasarTurno();
		posicion.pasarTurno();
	}
	
	public void atacarA(Monstruo atacado, Jugador jugadorAtacante, Jugador jugadorAtacado) {
		boca.verificarEstado();
		posicion.verificarEstado();
		
		int diferenciaDelEnfrentamiento = atacado.recibirAtaque(posicion, jugadorAtacado);
		
		if (diferenciaDelEnfrentamiento >= 0) 
			this.posicion.efectuarDanio(diferenciaDelEnfrentamiento,jugadorAtacante,this);
	}
	
	private int recibirAtaque(Posicion posicionAtacante, Jugador jugadorAtacado) {
		int diferenciaDelEnfrentamiento = posicionAtacante.calcularDiferenciaDeDanio(posicion);
		
		if(diferenciaDelEnfrentamiento <= 0)
			this.posicion.efectuarDanio(diferenciaDelEnfrentamiento,jugadorAtacado,this);
		
		return diferenciaDelEnfrentamiento;
	}

	public void agregarPuntosDeAtaque(int puntos) {
		posicion.agregarPuntosDeAtaque(puntos);
	}
	
	public void agregarPuntosDeDefensa(int puntos) {
		posicion.agregarPuntosDeDefensa(puntos);
	}
	
	public boolean tieneMenorAtaqueQue(Monstruo otroMonstruo) {
		return (otroMonstruo.tieneMayorAtaqueQue(getDanio()));
	}
	
	private boolean tieneMayorAtaqueQue(int puntosDelMonstruoRival) {
		return (getDanio() > puntosDelMonstruoRival);
	}
	
	public void realizarEfectoDeVolteo(Campo campo, Campo campoOponente, Jugador unJugador, Jugador oponente) {
		boca.realizarEfectoDeVolteo(efecto, campo, campoOponente, unJugador, oponente);
	}
	
	public int getDanio() {
		return posicion.danioAtaque();
	}

	public void efectuarSacrificios(Campo campo) {
		invocacion.efectuarSacrificios(campo);
	}

	public void sacrificarse(List<Monstruo> monstruosASacrificar) {
		efecto.sacrificar(monstruosASacrificar, this);
	}
	public BotonCarta getHandler() {
		return new BotonMonstruoEnManoEventHandler(this);
	}
}
