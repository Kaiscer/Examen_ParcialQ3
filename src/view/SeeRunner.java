package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControllerMadridRockRoll;
import model.DataBase;
import model.Runner;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class SeeRunner extends JPanel {
	public static final String BTN_SEE = "Consultar";
	private JScrollPane scrollTable;
	private JTable tableRunners;
	private JRadioButton rdbtnSeeMan;
	private JRadioButton rdbtnSeeWoman;
	private JRadioButton rdbtnSeeAll;
	private final ButtonGroup btnGSee = new ButtonGroup();
	private JButton btnSee;
	private DefaultTableModel tModel;
	
	DataBase data;
	
	public SeeRunner() {
		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		scrollTable = new JScrollPane();
		scrollTable.setVisible(false);
		scrollTable.setBounds(6, 88, 438, 162);
		add(scrollTable);
		
		tableRunners = new JTable();
		configTable();
		scrollTable.setViewportView(tableRunners);
		
		JLabel lblFiltrar = new JLabel("Filtrar por:");
		lblFiltrar.setBounds(6, 22, 76, 16);
		add(lblFiltrar);
		
		rdbtnSeeMan = new JRadioButton("Hombre");
		btnGSee.add(rdbtnSeeMan);
		rdbtnSeeMan.setBounds(6, 50, 89, 23);
		add(rdbtnSeeMan);
		
		rdbtnSeeWoman = new JRadioButton("Mujer");
		btnGSee.add(rdbtnSeeWoman);
		rdbtnSeeWoman.setBounds(98, 50, 76, 23);
		add(rdbtnSeeWoman);
		
		rdbtnSeeAll = new JRadioButton("Todos");
		btnGSee.add(rdbtnSeeAll);
		rdbtnSeeAll.setBounds(179, 53, 76, 23);
		add(rdbtnSeeAll);
		
		btnSee = new JButton(BTN_SEE);
		btnSee.setBounds(304, 47, 117, 29);
		add(btnSee);
	}
	private void configTable() {
		
		tModel = new DefaultTableModel() {
			
			public boolean isCellEditable(int row, int column) {
				
				return false;
			}
			
		};
		
		tableRunners.setModel(tModel);
		
		tModel.addColumn("Nombre");
		tModel.addColumn("Dorsal");
		tModel.addColumn("Sexo");
		tModel.addColumn("Edad");
		tModel.addColumn("Modalidad");
		
		tableRunners.getColumn("Nombre").setPreferredWidth(75);
		tableRunners.getColumn("Dorsal").setPreferredWidth(75);
		tableRunners.getColumn("Sexo").setPreferredWidth(75);
		tableRunners.getColumn("Edad").setPreferredWidth(50);
		tableRunners.getColumn("Modalidad").setPreferredWidth(80);
		
	}
	
	
	public void fillTable(ArrayList<Runner> listRunner ) {
		
		tModel.getDataVector().clear();
		
		Object[]row = new Object[5];
		
		for (Runner runner : listRunner) {
			
			row [0] = runner.getNombre();
			row [1] = runner.getDorsal();
			row [2] = runner.getSexo();
			row [3] = runner.getEdad();
			row [4] = runner.getModalidad();
			
			tModel.addRow(row);
		}
		
		
	}

	
	public void hacerVisible(boolean b) {
		
		scrollTable.setVisible(b);
	}
	public JRadioButton getRdbtnSeeMan() {
		return rdbtnSeeMan;
	}
	public JRadioButton getRdbtnSeeWoman() {
		return rdbtnSeeWoman;
	}
	public JRadioButton getRdbtnSeeAll() {
		return rdbtnSeeAll;
	}
	public JButton getBtnSee() {
		return btnSee;
	}
	public void setControl(ControllerMadridRockRoll c) {
		
		rdbtnSeeMan.addActionListener(c);
		rdbtnSeeWoman.addActionListener(c);
		rdbtnSeeAll.addActionListener(c);
		btnSee.addActionListener(c);
		
		
	}
	
	
	
	
	
	
	
}
