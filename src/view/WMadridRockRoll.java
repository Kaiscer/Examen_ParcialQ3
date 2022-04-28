package view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JScrollPane;

import control.ControllerMadridRockRoll;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class WMadridRockRoll extends JFrame {
	public static final String ITEM_ADD = "Añadir Corredor";
	public static final String ITEM_CONSULT = "Consultar Corredores";
	public static final String ITEM_SALIR = "Salir";
	
	private static final int ALTO = 600;
	private static final int ANCHO = 400;
	
	private JScrollPane scrollContainer;
	private JMenuItem mItemAdd;
	private JMenuItem mItemSee;
	private JMenuItem mItemExit;
	public WMadridRockRoll() {
		initComponents();
		
		createMenu();
	}
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mItemAdd = new JMenuItem(ITEM_ADD);
		menuBar.add(mItemAdd);
		
		mItemSee = new JMenuItem(ITEM_CONSULT);
		menuBar.add(mItemSee);
		
		mItemExit = new JMenuItem(ITEM_SALIR);
		menuBar.add(mItemExit);
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrollContainer = new JScrollPane();
		getContentPane().add(scrollContainer, BorderLayout.CENTER);
		
		setSize(ALTO,ANCHO);
		
		centerWindow();
	}
	private void centerWindow() {
		
		setPreferredSize(new Dimension(750, 450));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = this.getPreferredSize();
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
		
	}
	
	public void hacerVisible() {
		
		setVisible(true);
		
	}
	public void setControl(ControllerMadridRockRoll c) {
		mItemAdd.addActionListener(c);
		mItemSee.addActionListener(c);
		mItemExit.addActionListener(c);
		
	}
	public void uploadPanel(JPanel panel) {
		
		
		scrollContainer.setViewportView(panel);
		
	}
	
	

}
