package player;

import java.io.File;

import javazoom.jlgui.basicplayer.*;

/**
 * Titulo: Clase MusicPlayer
 * 
 * @author German Iglesias Ramos
 * @version 07/11/2023
 */
public class MusicPlayer {
	/**
	 * Atributo basicPlayer
	 */
	private BasicPlayer basicPlayer = null;
	
	/**
	 * Constructor
	 */
	public MusicPlayer(){
		basicPlayer = new BasicPlayer();
	}
	
	/**
	 * M�todo que reproduce
	 * @param file, archivo
	 */
	public void play (File file){
		try {
			basicPlayer.open(file);
			basicPlayer.play();
		}
		catch (Exception e){}
	}
	
	/**
	 * M�todo que para
	 */
	public void stop(){
		try {
			basicPlayer.stop();
		}
		catch (BasicPlayerException e){
		}
	}
	
	/**
	 * M�todo que setea el volumen
	 * @param vol, volumen
	 * @param volMax, volumen m�ximo
	 */
	public void setVolume(double vol, double volMax){
		try{
			
			basicPlayer.setGain(vol/volMax);
		}
		catch (BasicPlayerException e){
		}
	}
}
