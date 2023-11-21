package uo.cpm.p8.player;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.tritonus.share.sampled.file.TAudioFileFormat;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class MusicPlayer {

	private BasicPlayer basicPlayer = null;
	public boolean isPaused = false;

	public MusicPlayer() {
		basicPlayer = new BasicPlayer();
		
	}
	public void play(File file) {
		try {
			basicPlayer.open(file);
			basicPlayer.play();
		} catch (Exception e) {

		}
	}

	public void stop() {
		try {
			basicPlayer.stop();
		} catch (BasicPlayerException e) {
		}
	}

	public void pause() {
		try {
			basicPlayer.pause();
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	public void resume() {
		try {
			basicPlayer.resume();
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	public void setVolume(double vol, double volMax) {
		try {
			basicPlayer.setGain(vol / volMax);

		} catch (BasicPlayerException e) {
		}
	}
	
	
	
	public String obtenerDuracionEnMinutosYSegundos(File file) throws UnsupportedAudioFileException, IOException {
	    // Obtener el formato del archivo de audio
	    AudioFileFormat audioFileFormat = AudioSystem.getAudioFileFormat(file);
	    
	    // Obtener las propiedades del archivo de audio
	    Map<String, Object> properties = ((TAudioFileFormat) audioFileFormat).properties();

	    // Obtener la duración en microsegundos
	    Long microsegundos = (Long) properties.get("duration");

	    // Convertir la duración a segundos
	    int duracionEnSegundos = (int) (microsegundos / 1000000);

	    // Calcular minutos y segundos
	    int minutos = duracionEnSegundos / 60;
	    int segundos = duracionEnSegundos % 60;

	    // Formatear el resultado como "mm:ss"
	    String duracionFormateada = String.format("%02d:%02d", minutos, segundos);

	    return duracionFormateada;
	}

}
