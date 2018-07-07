package algo3.AlGoOh.vista;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Audio {
	private static MediaPlayer mediaPlayer;

	public static void reproducirAlerta() {
		String path = "src/algo3/AlGoOh/audio/alerta.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayerAlerta = new MediaPlayer(media);
        mediaPlayerAlerta.play();
	}
	
	public static void reproducirIntro() {
        String path = "src/algo3/AlGoOh/audio/intro.mp3";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
	}
	
	public static void reproducirBatalla() {
		mediaPlayer.pause();
        String path = "src/algo3/AlGoOh/audio/Batalla.mp3";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setOnRepeat(null);
	}
	
	public static void reproducirVictoria() {
		mediaPlayer.pause();
        String path = "src/algo3/AlGoOh/audio/victoria.mp3";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
	}
	
}
