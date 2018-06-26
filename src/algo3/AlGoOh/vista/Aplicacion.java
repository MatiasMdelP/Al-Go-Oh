package algo3.AlGoOh.vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Aplicacion extends Application {

	private Scene scene;
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(final Stage stage) throws Exception {
    	stage.setTitle("Al-Go-Oh !");
    	
    	ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage/*, robot*/);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);
        
        configurarPantallaInicial(stage, escenaJuego);
        
        stage.setScene(scene);
    	stage.setMaximized(true);
        stage.show();
    }
    
    public void configurarPantallaInicial(Stage stage, Scene proximaEscena) {
    	Label etiquetaJugador1 = new Label();
    	etiquetaJugador1.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

        etiquetaJugador1.setText("Jugador 1:");
        etiquetaJugador1.setTextFill(Color.web("#000000"));

    	Label etiquetaJugador2 = new Label();
    	etiquetaJugador2.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

        etiquetaJugador2.setText("Jugador 2:");
        etiquetaJugador2.setTextFill(Color.web("#000000"));
        
    	TextField textoJugador1 = new TextField();
    	textoJugador1.setPromptText("Nombre del Jugador 1...");

    	TextField textoJugador2 = new TextField();
    	textoJugador2.setPromptText("Nombre del Jugador 2...");
    	
    	Button botonJugar = new Button("Jugar");
    	
    	TextoEventHandler textoEventHandler = new TextoEventHandler(botonJugar);
        textoJugador1.setOnKeyPressed(textoEventHandler);
    	
        TextoEventHandler textoEventHandler2 = new TextoEventHandler(botonJugar);
        textoJugador2.setOnKeyPressed(textoEventHandler2);
        
    	Image imagen = new Image("file:src/algo3/AlGoOh/vista/fondo.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        GridPane gridPane = new GridPane();    
        
        //Setting size for the pane 
        gridPane.setMinSize(1100, 5000); 
        
        //Setting the padding  
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        
        //Setting the vertical and horizontal gaps between the columns 
        gridPane.setVgap(5); 
        gridPane.setHgap(5);       
        
        //Setting the Grid alignment 
        gridPane.setAlignment(Pos.CENTER); 
         
        //Arranging all the nodes in the grid 
        gridPane.add(etiquetaJugador1, 0, 115); 
        gridPane.add(textoJugador1, 1, 115); 
        gridPane.add(etiquetaJugador2, 0, 116);       
        gridPane.add(textoJugador2, 1, 116); 
        gridPane.add(botonJugar, 1, 118); 
        //gridPane.add(button2, 1, 2); 
         
        //Styling nodes  
        //botonJugar.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
        //button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
         
        etiquetaJugador1.setStyle("-fx-font: normal bold 20px 'serif' "); 
        etiquetaJugador2.setStyle("-fx-font: normal bold 20px 'serif' ");  
       
        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, proximaEscena, textoJugador1, textoJugador2);
        botonJugar.setOnAction(botonJugarEventHandler);
        gridPane.setBackground(new Background(imagenDeFondo));
        
        //Creating a scene object 
        scene = new Scene(gridPane);
    }
}
