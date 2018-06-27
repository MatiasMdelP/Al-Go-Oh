package algo3.AlGoOh.vista;

import algo3.AlgoOh.handlers.OpcionComoAtacarEventHandler;
import algo3.AlgoOh.handlers.OpcionFasesJuegoEventHandler;
import algo3.AlgoOh.handlers.OpcionSalirEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");

    public BarraDeMenu(Stage stage) {

        Menu menuArchivo = new Menu("Archivo");
        //Menu menuVer = new Menu("Ver");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionComoAtacar = new MenuItem("Como atacar...");
        MenuItem opcionFasesJuego = new MenuItem("Sobre las Fases del Juego...");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");

        OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirHandler);

        OpcionFasesJuegoEventHandler opcionFasesJuegoHandler = new OpcionFasesJuegoEventHandler();
        opcionFasesJuego.setOnAction(opcionFasesJuegoHandler);
        
        OpcionComoAtacarEventHandler opcionComoAtacarHandler = new OpcionComoAtacarEventHandler();
        opcionComoAtacar.setOnAction(opcionComoAtacarHandler);

        //OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
        //opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);

        //opcionPantallaCompleta.setDisable(true);

        menuArchivo.getItems().addAll(/*opcionAbrir, new SeparatorMenuItem(),*/ opcionSalir);
        menuAyuda.getItems().addAll(opcionComoAtacar, opcionFasesJuego, new SeparatorMenuItem(), opcionAcercaDe);
        //menuVer.getItems().addAll(opcionPantallaCompleta);

        this.getMenus().addAll(menuArchivo, /*menuVer,*/ menuAyuda);
    }

    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);

    }
}
