package uo.cpm.p8;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import uo.cpm.p8.ui.VentanaPrincipal;


public class Main {
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		      try {
		    	  // Cambia el look and feel
		    	  Properties props = new Properties();
		    	  props.put("logoString", "");
		    	  HiFiLookAndFeel.setCurrentTheme(props);
		    	  UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		    	  
		    	  // Crea la ventana
		    	  VentanaPrincipal v = new VentanaPrincipal();
		    	  v.setVisible(true);
		      } catch (Exception e) {
		        JOptionPane.showMessageDialog(null, "Error: "+e);
		      }
		    }
		  });

	}

}