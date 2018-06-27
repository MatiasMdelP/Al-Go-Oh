package algo3.AlGoOh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algo3.AlGoOh.Efectos.EfectoAgujeroOscuro;
import algo3.AlGoOh.Efectos.EfectoAumentar500Ataque;
import algo3.AlGoOh.Efectos.EfectoCilindroMagico;
import algo3.AlGoOh.Efectos.EfectoDestruirMonstruoAtacante;
import algo3.AlGoOh.Efectos.EfectoFisura;
import algo3.AlGoOh.Efectos.EfectoJinzo7;
import algo3.AlGoOh.Efectos.EfectoOllaDeLaCodicia;
import algo3.AlGoOh.Efectos.EfectoSogen;
import algo3.AlGoOh.Efectos.EfectoVacio;
import algo3.AlGoOh.Efectos.EfectoWasteland;
import algo3.AlGoOh.Exceptions.ElMazoNoTieneCartasException;
import algo3.AlGoOh.Exceptions.InvocacionDragonDefinitivoDeOjosAzules;

public class Mazo {

	private List<Carta> baraja = new ArrayList<Carta>();
	
	public Carta tomarUnaCarta() {
		if (seQuedoSinCartas()) {
			throw new ElMazoNoTieneCartasException();
		}
		
		Random eleccionDeCarta = new Random();
		
		return (baraja.remove(eleccionDeCarta.nextInt(baraja.size())));
	}
	
	public void agregarUnaCartaAlMazo(Carta unaCarta) {
		baraja.add(unaCarta);
	}
	
	public boolean seQuedoSinCartas() {
		return baraja.isEmpty();
	}

	public void inicializarMazo() {
		//Huevo Monstruoso
		Monstruo huevoMonstruoso1 = new Monstruo("Huevo Monstruoso", null,new InvocacionNormal(), 600, 900);
		Monstruo huevoMonstruoso2 = new Monstruo("Huevo Monstruoso", null,new InvocacionNormal(), 600, 900);
		agregarUnaCartaAlMazo(huevoMonstruoso1);
		agregarUnaCartaAlMazo(huevoMonstruoso2);
		
		//Digitron
		Monstruo digitron1 = new Monstruo("Digitron", null,new InvocacionNormal(), 1500, 0);
		Monstruo digitron2 = new Monstruo("Digitron", null,new InvocacionNormal(), 1500, 0);
		agregarUnaCartaAlMazo(digitron1);
		agregarUnaCartaAlMazo(digitron2);
		
		//Bruja Oscura
		Monstruo brujaOscura = new Monstruo("Bruja Oscura", null, new Invocacion1Sacrificio(), 1800, 1700);
		agregarUnaCartaAlMazo(brujaOscura);
		
		//Ara�a Lanzadora
		Monstruo arania = new Monstruo("Ara�a Lanzadora", null, new Invocacion2Sacrificios(), 2200, 2500);
		agregarUnaCartaAlMazo(arania);
		
		//Frostosaurus
		Monstruo frostosaurus1 = new Monstruo("Frostosaurus", null, new Invocacion1Sacrificio(), 2600, 1700);
		Monstruo frostosaurus2 = new Monstruo("Frostosaurus", null, new Invocacion1Sacrificio(), 2600, 1700);
		agregarUnaCartaAlMazo(frostosaurus1);	
		agregarUnaCartaAlMazo(frostosaurus2);
		
		//Rata De La Prevencion
		Monstruo rata1 = new Monstruo("Rata De La Prevencion", null, new InvocacionNormal(), 500, 2000);
		Monstruo rata2 = new Monstruo("Rata De La Prevencion", null, new InvocacionNormal(), 500, 2000);
		agregarUnaCartaAlMazo(rata1);
		agregarUnaCartaAlMazo(rata2);
		
		//Serpiente Espiral
		Monstruo serpiente1 = new Monstruo("Serpiente Espiral", null, new Invocacion2Sacrificios(), 2900, 2900);
		Monstruo serpiente2 = new Monstruo("Serpiente Espiral", null, new Invocacion2Sacrificios(), 2900, 2900);
		agregarUnaCartaAlMazo(serpiente1);
		agregarUnaCartaAlMazo(serpiente2);
		
		//Mono Acrobata
		Monstruo monoAcrobata1 = new Monstruo("Mono Acrobata", null, new InvocacionNormal(), 1000, 1800);
		Monstruo monoAcrobata2 = new Monstruo("Mono Acrobata", null, new InvocacionNormal(), 1000, 1800);
		agregarUnaCartaAlMazo(monoAcrobata1);
		agregarUnaCartaAlMazo(monoAcrobata2);
		
		//Dragon Blanco
		Monstruo dragonBlanco1 = new Monstruo("Dragon Blanco De Ojos Azules", null, new Invocacion2Sacrificios(), 3000, 2500);
		Monstruo dragonBlanco2 = new Monstruo("Dragon Blanco De Ojos Azules", null, new Invocacion2Sacrificios(), 3000, 2500);
		Monstruo dragonBlanco3 = new Monstruo("Dragon Blanco De Ojos Azules", null, new Invocacion2Sacrificios(), 3000, 2500);
		Monstruo dragonBlanco4 = new Monstruo("Dragon Blanco De Ojos Azules", null, new Invocacion2Sacrificios(), 3000, 2500);
		agregarUnaCartaAlMazo(dragonBlanco1);
		agregarUnaCartaAlMazo(dragonBlanco2);
		agregarUnaCartaAlMazo(dragonBlanco3);
		agregarUnaCartaAlMazo(dragonBlanco4);
		
		//Dragon Meteoro
		Monstruo dragonMeteoro = new Monstruo("Dragon Meteoro", null, new Invocacion1Sacrificio(), 1800, 2000);
		agregarUnaCartaAlMazo(dragonMeteoro);
		
		//Dragon Definitivo
		Monstruo dragonDefinitivo = new Monstruo("Dragon Definitivo De Ojos Azules", null,
				new InvocacionDragonDefinitivoDeOjosAzules(), 4500, 3800);
		agregarUnaCartaAlMazo(dragonDefinitivo);
		
		//Exodia
		Monstruo exodiaElProhibido = new Monstruo("Exodia El Prohibido", new EfectoVacio(), new InvocacionNormal(), 1000, 1000);
		Monstruo brazoIzquierdoDelProhibido = new Monstruo("Brazo Izquierdo Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		Monstruo piernaIzquierdaDelProhibido = new Monstruo("Pierna Izquierda Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		Monstruo brazoDerechoDelProhibido = new Monstruo("Brazo Derecho Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		Monstruo piernaDerechaDelProhibido = new Monstruo("Pierna Derecha Del Prohibido", new EfectoVacio(), new InvocacionNormal(), 200, 300);
		agregarUnaCartaAlMazo(exodiaElProhibido);
		agregarUnaCartaAlMazo(brazoIzquierdoDelProhibido);
		agregarUnaCartaAlMazo(piernaIzquierdaDelProhibido);
		agregarUnaCartaAlMazo(brazoDerechoDelProhibido);
		agregarUnaCartaAlMazo(piernaDerechaDelProhibido);
		
		//Jinzo7
		Monstruo jinzo7 = new Monstruo("Jinzo #7", new EfectoJinzo7(), new InvocacionNormal(), 500, 400);
		agregarUnaCartaAlMazo(jinzo7);
		
		//Insecto come hombres
		Monstruo insectoComeHombres1 = new Monstruo("Insecto come hombres", new EfectoDestruirMonstruoAtacante(), new InvocacionNormal(), 450, 600);
		Monstruo insectoComeHombres2 = new Monstruo("Insecto come hombres", new EfectoDestruirMonstruoAtacante(), new InvocacionNormal(), 450, 600);
		agregarUnaCartaAlMazo(insectoComeHombres1);
		agregarUnaCartaAlMazo(insectoComeHombres2);
		
		//Agujero Oscuro
		Carta agujeroOscuro1 = new Carta("Agujero Oscuro", new EfectoAgujeroOscuro());
		Carta agujeroOscuro2 = new Carta("Agujero Oscuro", new EfectoAgujeroOscuro());
		agregarUnaCartaAlMazo(agujeroOscuro1);
		agregarUnaCartaAlMazo(agujeroOscuro2);
		
		//Cilindro Magico
		Carta cilindroMagico1 = new Carta("Cilindro Magico", new EfectoCilindroMagico());
		Carta cilindroMagico2 = new Carta("Cilindro Magico", new EfectoCilindroMagico());
		agregarUnaCartaAlMazo(cilindroMagico1);
		agregarUnaCartaAlMazo(cilindroMagico2);
		
		//Olla de la Codicia
		Carta ollaDeLaCodicia1 = new Carta("Olla De La Codicia", new EfectoOllaDeLaCodicia());
		Carta ollaDeLaCodicia2 = new Carta("Olla De La Codicia", new EfectoOllaDeLaCodicia());
		agregarUnaCartaAlMazo(ollaDeLaCodicia1);
		agregarUnaCartaAlMazo(ollaDeLaCodicia2);
		
		//Fisura
		Carta fisura1 = new Carta("Fisura", new EfectoFisura());
		Carta fisura2 = new Carta("Fisura", new EfectoFisura());
		agregarUnaCartaAlMazo(fisura1);
		agregarUnaCartaAlMazo(fisura2);
		
		//Reinforcements
		Carta reinforcements = new Carta("Reinforcements", new EfectoAumentar500Ataque());
		agregarUnaCartaAlMazo(reinforcements);
		
		//Sogen
		Carta sogen1 = new Carta("Sogen", new EfectoSogen());
		Carta sogen2 = new Carta("Sogen", new EfectoSogen());
		agregarUnaCartaAlMazo(sogen1);
		agregarUnaCartaAlMazo(sogen2);
		
		//Wasteland
		Carta wasteland = new Carta("Wasteland", new EfectoWasteland());
		agregarUnaCartaAlMazo(wasteland);
		
	}
}
