package uo.cpm.p8;

import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

import uo.cpm.p8.player.MusicPlayer;
import uo.cpm.p8.ui.VentanaPrincipal;

/**
 * 
 * @user German Iglesias Ramos
 * @UO 202549
 * @date 14 nov 2023
 */

public class Main {
	public static void main(String[] args) {
		MusicPlayer mP = new MusicPlayer();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					// Cambia el look and feel
					Properties props = new Properties();
					// Para quitar la imagen del agua
					props.put("logoString", "");
					// Para quitar el recuadro del slider que era amarillo y no poinga nada
					props.put("focusColor", "0 0 0");
					McWinLookAndFeel.setCurrentTheme(props);
					UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");

					// Crea la ventana
					VentanaPrincipal v = new VentanaPrincipal(mP);
					v.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error: " + e);
				}
			}
		});

	}

}