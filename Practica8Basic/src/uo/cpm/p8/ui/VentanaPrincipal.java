package uo.cpm.p8.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author UO202549
 * @name German Iglesias Ramos
 * @date 14 nov 2023
 */
public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelNorte;
	private JPanel panelCentro;
	private JLabel lblLogo;
	private JSlider slVolumen;
	private JPanel panelVolumen;
	private JLabel lblVol;
	private JLabel lblTextVolumen;
	private JPanel panelLibrary;
	private JPanel panelPlay;
	private JLabel lblLibrary;
	private JScrollPane scListLibrary;
	private JList<File> listLibrary;
	private JPanel panelBtLibrary;
	private JButton btnAdd;
	private JButton btnDelLib;
	private JLabel lblReproducir;
	private JPanel panelBtPlay;
	private JButton btnRew;
	private JButton btnPlay;
	private JScrollPane scPlay;
	private JList<File> listPlay;
	private JButton btnStop;
	private JButton btnForward;
	private JButton btnDel;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnPlay;
	private JMenu mnOptions;
	private JMenu mnHelp;
	private JMenuItem mnOpen;
	private JMenuItem mnExit;
	private JMenuItem mnRandom;
	private JMenuItem mnNext;
	private JMenuItem mnContents;
	private JMenuItem mnAbout;
	private JSeparator separator;
	private JSeparator separator_1;
	private JFileChooser selector;

	// 1.Declaramos los dos modelos para las listas
	private DefaultListModel<File> modeloListLibrary;
	private DefaultListModel<File> modeloListPlay;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logoTitulo.png")));
		setTitle("EII MusicPlayer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 565);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelNorte(), BorderLayout.NORTH);
		contentPane.add(getPanel_1());
		setLocationRelativeTo(null);

		habilitarPanelBoton(false);

	}

	/**
	 * Metodo para habilitar o no los botones de los paneles libreria y play
	 * 
	 * @param bool
	 */
	private void habilitarPanelBoton(boolean bool) {
		for (int i = 0; i < panelBtLibrary.getComponents().length; i++) {
			panelBtLibrary.getComponent(i).setEnabled(bool);
		}
		for (int i = 0; i < panelBtPlay.getComponents().length; i++) {
			panelBtPlay.getComponent(i).setEnabled(bool);
		}
	}

	private JPanel getPanelNorte() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setBackground(Color.BLACK);
			panelNorte.setLayout(new GridLayout(1, 3, 0, 0));
			panelNorte.add(getLblLogo());
			panelNorte.add(getSlVolumen());
			panelNorte.add(getPanel_2());
		}
		return panelNorte;
	}

	private JPanel getPanel_1() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			panelCentro.setBackground(Color.BLACK);
			panelCentro.setLayout(new GridLayout(1, 2, 3, 0));
			panelCentro.add(getPanel_3());
			panelCentro.add(getPanelPlay());
		}
		return panelCentro;
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setFont(new Font("Dialog", Font.BOLD, 14));
			lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
		}
		return lblLogo;
	}

	private JSlider getSlVolumen() {
		if (slVolumen == null) {
			slVolumen = new JSlider();
			slVolumen.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					pintarYCambiarVolumen();
				}
			});
			slVolumen.setFocusable(false);
			slVolumen.setPaintTicks(true);
			slVolumen.setPaintLabels(true);
			slVolumen.setMinorTickSpacing(5);
			slVolumen.setMajorTickSpacing(20);
			slVolumen.setFont(new Font("Dialog", Font.BOLD, 14));
			slVolumen.setForeground(Color.WHITE);
			slVolumen.setBackground(Color.BLACK);
		}
		return slVolumen;
	}

	/**
	 * Metodo que permite a la vez que cambia el slider del volumen, cambia la label
	 * del volumen
	 */
	protected void pintarYCambiarVolumen() {
		getLblTextVolumen().setText(String.valueOf(getSlVolumen().getValue()));

	}

	private JPanel getPanel_2() {
		if (panelVolumen == null) {
			panelVolumen = new JPanel();
			panelVolumen.setBackground(Color.BLACK);
			panelVolumen.add(getLblVol());
			panelVolumen.add(getLblTextVolumen());
		}
		return panelVolumen;
	}

	private JLabel getLblVol() {
		if (lblVol == null) {
			lblVol = new JLabel("Vol:");
			lblVol.setHorizontalAlignment(SwingConstants.CENTER);
			lblVol.setForeground(Color.ORANGE);
			lblVol.setFont(new Font("Dialog", Font.BOLD, 32));
			lblVol.setBackground(Color.BLACK);
		}
		return lblVol;
	}

	private JLabel getLblTextVolumen() {
		if (lblTextVolumen == null) {
			lblTextVolumen = new JLabel("40");
			lblTextVolumen.setHorizontalAlignment(SwingConstants.CENTER);
			lblTextVolumen.setForeground(Color.WHITE);
			lblTextVolumen.setFont(new Font("Dialog", Font.BOLD, 40));
			lblTextVolumen.setBackground(Color.BLACK);
			lblTextVolumen.setText(String.valueOf(slVolumen.getValue()));
		}
		return lblTextVolumen;
	}

	private JPanel getPanel_3() {
		if (panelLibrary == null) {
			panelLibrary = new JPanel();
			panelLibrary.setBackground(Color.BLACK);
			panelLibrary.setLayout(new BorderLayout(0, 0));
			panelLibrary.add(getLblLibrary(), BorderLayout.NORTH);
			panelLibrary.add(getScListLibrary(), BorderLayout.CENTER);
			panelLibrary.add(getPanel_4(), BorderLayout.SOUTH);
		}
		return panelLibrary;
	}

	private JPanel getPanelPlay() {
		if (panelPlay == null) {
			panelPlay = new JPanel();
			panelPlay.setBackground(Color.BLACK);
			panelPlay.setLayout(new BorderLayout(0, 0));
			panelPlay.add(getLblReproducir(), BorderLayout.NORTH);
			panelPlay.add(getPanelBtPlay(), BorderLayout.SOUTH);
			panelPlay.add(getScPlay());
		}
		return panelPlay;
	}

	private JLabel getLblLibrary() {
		if (lblLibrary == null) {
			lblLibrary = new JLabel("Library:");
			lblLibrary.setLabelFor(getListLibrary());
			lblLibrary.setDisplayedMnemonic('l');
			lblLibrary.setForeground(Color.ORANGE);
			lblLibrary.setFont(new Font("Dialog", Font.BOLD, 18));
			lblLibrary.setText(" \u266A" + "Libray:");
		}
		return lblLibrary;
	}

	private JScrollPane getScListLibrary() {
		if (scListLibrary == null) {
			scListLibrary = new JScrollPane();
			scListLibrary.setBorder(new LineBorder(Color.ORANGE, 3, true));
			scListLibrary.setViewportView(getListLibrary());
		}
		return scListLibrary;
	}

	private JList<File> getListLibrary() {
		if (listLibrary == null) {
//			2.Instanciar el modlelo
			modeloListLibrary = new DefaultListModel<File>();
//			3.Asociar wel modelo con la lista. Modo1: parametro del contrictos
			listLibrary = new JList<File>(modeloListLibrary);
			listLibrary.setFont(new Font("Dialog", Font.PLAIN, 14));
			listLibrary.setForeground(Color.ORANGE);
			listLibrary.setBackground(Color.BLACK);
		}
		return listLibrary;
	}

	private JPanel getPanel_4() {
		if (panelBtLibrary == null) {
			panelBtLibrary = new JPanel();
			panelBtLibrary.setBackground(Color.BLACK);
			panelBtLibrary.setLayout(new GridLayout(1, 2, 0, 0));
			panelBtLibrary.add(getBtnAdd());
			panelBtLibrary.add(getBtnDelLib());
		}
		return panelBtLibrary;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add to PlayList");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirAPlayList();
				}
			});
			btnAdd.setMnemonic('a');
			btnAdd.setFont(new Font("Dialog", Font.BOLD, 14));
			btnAdd.setForeground(Color.WHITE);
			btnAdd.setBackground(Color.BLACK);
		}
		return btnAdd;
	}

	protected void añadirAPlayList() {
		for (int i = 0; i < getListLibrary().getSelectedValuesList().size(); i++) {
			modeloListPlay.addElement(getListLibrary().getSelectedValuesList().get(i));
		}

	}

	private JButton getBtnDelLib() {
		if (btnDelLib == null) {
			btnDelLib = new JButton("Delete");
			btnDelLib.setMnemonic('d');
			btnDelLib.setForeground(Color.WHITE);
			btnDelLib.setFont(new Font("Dialog", Font.BOLD, 14));
			btnDelLib.setBackground(Color.BLACK);
		}
		return btnDelLib;
	}

	private JLabel getLblReproducir() {
		if (lblReproducir == null) {
			lblReproducir = new JLabel("PlayList:");
			lblReproducir.setLabelFor(getListPlay());
			lblReproducir.setDisplayedMnemonic('y');
			lblReproducir.setForeground(Color.ORANGE);
			lblReproducir.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return lblReproducir;
	}

	private JPanel getPanelBtPlay() {
		if (panelBtPlay == null) {
			panelBtPlay = new JPanel();
			panelBtPlay.setBackground(Color.BLACK);
			panelBtPlay.setLayout(new GridLayout(1, 5, 0, 0));
			panelBtPlay.add(getBtnRew());
			panelBtPlay.add(getBtnPlay());
			panelBtPlay.add(getBtnStop());
			panelBtPlay.add(getBtnForward());
			panelBtPlay.add(getBtnDel());
		}
		return panelBtPlay;
	}

	private JButton getBtnRew() {
		if (btnRew == null) {
			btnRew = new JButton("◄◄");
			btnRew.setToolTipText("Rewind");
			btnRew.setForeground(Color.WHITE);
			btnRew.setFont(new Font("Dialog", Font.BOLD, 14));
			btnRew.setBackground(Color.BLACK);
		}
		return btnRew;
	}

	private JButton getBtnPlay() {
		if (btnPlay == null) {
			btnPlay = new JButton("►");
			btnPlay.setToolTipText("Play");
			btnPlay.setForeground(Color.WHITE);
			btnPlay.setFont(new Font("Dialog", Font.BOLD, 14));
			btnPlay.setBackground(Color.BLACK);
		}
		return btnPlay;
	}

	private JScrollPane getScPlay() {
		if (scPlay == null) {
			scPlay = new JScrollPane();
			scPlay.setBorder(new LineBorder(Color.ORANGE, 3, true));
			scPlay.setViewportView(getListPlay());
		}
		return scPlay;
	}

	private JList<File> getListPlay() {
		if (listPlay == null) {
			// 2.creamos el modelo
			modeloListPlay = new DefaultListModel<File>();
			listPlay = new JList<File>();
			// 3.Asociar el modelo con la lista. Modo 2 = uso del medoto setModel()
			listPlay.setModel(modeloListPlay);
			listPlay.setForeground(Color.ORANGE);
			listPlay.setFont(new Font("Dialog", Font.PLAIN, 14));
			listPlay.setBackground(Color.BLACK);
		}
		return listPlay;
	}

	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("■");
			btnStop.setToolTipText("Stop");
			btnStop.setForeground(Color.WHITE);
			btnStop.setFont(new Font("Dialog", Font.BOLD, 14));
			btnStop.setBackground(Color.BLACK);
		}
		return btnStop;
	}

	private JButton getBtnForward() {
		if (btnForward == null) {
			btnForward = new JButton("►►");
			btnForward.setToolTipText("Forward");
			btnForward.setForeground(Color.WHITE);
			btnForward.setFont(new Font("Dialog", Font.BOLD, 14));
			btnForward.setBackground(Color.BLACK);
		}
		return btnForward;
	}

	private JButton getBtnDel() {
		if (btnDel == null) {
			btnDel = new JButton("Del");
			btnDel.setToolTipText("delete");
			btnDel.setForeground(Color.WHITE);
			btnDel.setFont(new Font("Dialog", Font.BOLD, 14));
			btnDel.setBackground(Color.BLACK);
		}
		return btnDel;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnPlay());
			menuBar.add(getMnOptions());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.setMnemonic('f');
			mnFile.add(getMnOpen());
			mnFile.add(getSeparator());
			mnFile.add(getMnExit());
		}
		return mnFile;
	}

	private JMenu getMnPlay() {
		if (mnPlay == null) {
			mnPlay = new JMenu("Play");
			mnPlay.setEnabled(false);
			mnPlay.setMnemonic('a');
			mnPlay.add(getMnNext());
		}
		return mnPlay;
	}

	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Options");
			mnOptions.setEnabled(false);
			mnOptions.setMnemonic('o');
			mnOptions.add(getMnRandom());
		}
		return mnOptions;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('h');
			mnHelp.add(getMnContents());
			mnHelp.add(getSeparator_1());
			mnHelp.add(getMnAbout());
		}
		return mnHelp;
	}

	private JMenuItem getMnOpen() {
		if (mnOpen == null) {
			mnOpen = new JMenuItem("Open");
			mnOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirFicheros();
					habilitarPanelBoton(true);
					getMnPlay().setEnabled(true);
					getMnOptions().setEnabled(true);

				}
			});
			mnOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
			mnOpen.setMnemonic('o');
		}
		return mnOpen;
	}

	/**
	 * Metodo para abrir la ventana de añadir ficheros
	 */
	protected void abrirFicheros() {
		int resp = getSelector().showOpenDialog(this);
		if (resp == JFileChooser.APPROVE_OPTION) {
			// carga ficheros de canciones en listLibrary

			for (int i = 0; i < getSelector().getSelectedFiles().length; i++) {
				modeloListLibrary.addElement(getSelector().getSelectedFiles()[i]);
			}
//				if (!modeloListLib.contains(getSelector().getSelectedFiles()[i])) {
//					modeloListLib.addElement(getSelector().getSelectedFiles()[i]);
//				}				
//			}
		}

	}

	private JMenuItem getMnExit() {
		if (mnExit == null) {
			mnExit = new JMenuItem("Exit");
			mnExit.setMnemonic('e');
		}
		return mnExit;
	}

	private JMenuItem getMnRandom() {
		if (mnRandom == null) {
			mnRandom = new JMenuItem("Random");
			mnRandom.setMnemonic('r');
		}
		return mnRandom;
	}

	private JMenuItem getMnNext() {
		if (mnNext == null) {
			mnNext = new JMenuItem("Next");
			mnNext.setMnemonic('n');
		}
		return mnNext;
	}

	private JMenuItem getMnContents() {
		if (mnContents == null) {
			mnContents = new JMenuItem("Contents");
			mnContents.setMnemonic('t');
		}
		return mnContents;
	}

	private JMenuItem getMnAbout() {
		if (mnAbout == null) {
			mnAbout = new JMenuItem("About");
			mnAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			mnAbout.setMnemonic('b');
		}
		return mnAbout;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}

	private JFileChooser getSelector() {
		if (selector == null) {
			selector = new JFileChooser();
			// si solo quieres uno quita o comenta la siguiente linea
			// permite seleccionar varios ficheros a la vez
			selector.setMultiSelectionEnabled(true);

			// Para que cuando se nos abra la ventana aparexca en un determindao direcotrio
			// fijar el directorio de despliegue del JFilechooser en mi carpeta de mi
			// proyecto music
			String path = System.getProperty("user.dir") + "/music/";
			// fijar el direcotrio de despliegue del JFilechooser e el escritorio
			String path1 = System.getProperty("user.home") + "/desktop/";

			selector.setCurrentDirectory(new File(path));

		}
		return selector;
	}
}
