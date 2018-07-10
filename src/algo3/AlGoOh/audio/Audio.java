package algo3.AlGoOh.audio;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Audio {
	private static MediaPlayer mediaPlayer;

	public static void reproducirClick() {
		reproducir("src/algo3/AlGoOh/audio/click.mp3");
	}
	public static void reproducirAlerta() {
		reproducir("src/algo3/AlGoOh/audio/alerta.mp3");
	}
	
	public static void reproducirIntro() {
        reproducir("src/algo3/AlGoOh/audio/intro.mp3");;
	}
	
	public static void reproducirBatalla() {
		mediaPlayer.pause();
        reproducir("src/algo3/AlGoOh/audio/Batalla.mp3");
	}
	
	public static void reproducirVictoria() {
		//mediaPlayer.pause();
        reproducir("src/algo3/AlGoOh/audio/victoria.mp3");
	}
	private static void reproducir (String path) {
		 Media media = new Media(new File(path).toURI().toString());
	     mediaPlayer = new MediaPlayer(media);
	     mediaPlayer.setAutoPlay(true);
	}
	
}
