package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import control.ControllerMadridRockRoll;
import model.Runner;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class AddRunner extends JPanel {
	private static final String [] MODALIDAD = {" ","10000", "Medio Maratón", "Maratón"};
	public static final String BTN_ADD = "Añadir";
	public static final String BTN_CLEAN = "limpiar";
	public static final String RDBTN_MAN = "Hombre";
	public static final String RDBTN_WOMAN = "Mujer";
	
	private JTextField txtname;
	private JTextField txtDorsal;
	private JRadioButton rdbtnMan;
	private final ButtonGroup buttonGSexo = new ButtonGroup();
	private JRadioButton rdbtnWoman;
	private JSpinner spnEdad;
	private JComboBox<String> cmbModalidad;
	private JButton btnAdd;
	private JButton btnClean;
	public AddRunner() {
		initComponets();
	}
	private void initComponets() {
		
		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(6, 28, 59, 16);
		
		txtname = new JTextField();
		txtname.setBounds(75, 23, 197, 26);
		txtname.setColumns(10);
		
		JLabel lblDorsal = new JLabel("Dorsal:");
		lblDorsal.setBounds(6, 68, 61, 16);
		
		txtDorsal = new JTextField();
		txtDorsal.setBounds(75, 63, 165, 26);
		txtDorsal.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(6, 113, 40, 16);
		
		rdbtnMan = new JRadioButton(RDBTN_MAN);
		rdbtnMan.setBounds(74, 109, 87, 23);
		buttonGSexo.add(rdbtnMan);
		
		rdbtnWoman = new JRadioButton(RDBTN_WOMAN);
		rdbtnWoman.setBounds(160, 109, 87, 23);
		buttonGSexo.add(rdbtnWoman);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(6, 155, 61, 16);
		
		spnEdad = new JSpinner();
		spnEdad.setBounds(75, 150, 59, 26);
		spnEdad.setEditor(new JSpinner.DefaultEditor(spnEdad));
		spnEdad.setModel(new SpinnerNumberModel(16, 0, 100, 1));
		
		JLabel lblModalidad = new JLabel("Modalidad:");
		lblModalidad.setBounds(146, 155, 81, 16);
		
		cmbModalidad = new JComboBox<String>();
		cmbModalidad.setBounds(220, 151, 153, 27);
		cmbModalidad.setModel(new DefaultComboBoxModel<String>(MODALIDAD));
		
		btnAdd = new JButton(BTN_ADD);
		btnAdd.setBounds(220, 228, 117, 29);
		
		btnClean = new JButton(BTN_CLEAN);
		btnClean.setBounds(49, 228, 117, 29);
		setLayout(null);
		add(lblName);
		add(txtname);
		add(lblDorsal);
		add(txtDorsal);
		add(lblSexo);
		add(rdbtnWoman);
		add(rdbtnMan);
		add(lblEdad);
		add(spnEdad);
		add(cmbModalidad);
		add(lblModalidad);
		add(btnClean);
		add(btnAdd);
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public JButton getBtnClean() {
		return btnClean;
	}
	
	public void setControl(ControllerMadridRockRoll c) {
		
		btnAdd.addActionListener(c);
		btnClean.addActionListener(c);
		
	}
	public Runner requestData() {
		Runner rn = null;
		
		String name = txtname.getText().trim();
		
		if (name.isBlank()) {
			JOptionPane.showConfirmDialog(this, "Debes introducir el nombre del corredor", "Error de datos",JOptionPane.ERROR_MESSAGE);		
		}else {
			try {
				int dorsal = Integer.parseInt(txtDorsal.getText());
				
				if (dorsal <= 0) {
					
				}else if (String.valueOf(dorsal).length() > 5) {
					JOptionPane.showConfirmDialog(this, "El dorsal no puede superar los 5 dígitos", "Error de datos",JOptionPane.ERROR_MESSAGE);
				}else {
					String sexo = "";
					
					if (rdbtnMan.isSelected()) {
						sexo = "Hombre";
						
					}else {
						sexo = "Mujer";
					}
					
					int edad = (int)spnEdad.getValue();
					
					String mod = (String)cmbModalidad.getSelectedItem();
					
					if (mod.equals(" ")) {
						JOptionPane.showConfirmDialog(this, "Debes elegir la modalidad", "Error de difultad", JOptionPane.ERROR_MESSAGE);
					}else {
						
						rn = new Runner(name, dorsal, sexo, edad, mod);	
					}
					
					
					
				}
				
				
			}catch (NumberFormatException e){
				JOptionPane.showConfirmDialog(this, "El dorsal solo acepta dígitos numéricos", "Error de datos",JOptionPane.ERROR_MESSAGE);
			}

			
		}
		
		
		return rn;
	}
	public void cleanForm() {
		
		txtname.setText("");
		txtDorsal.setText("");
		rdbtnMan.setSelected(true);
		spnEdad.setValue(0);
		cmbModalidad.setSelectedItem(MODALIDAD[0]);
		
		
		
		
	}
}
