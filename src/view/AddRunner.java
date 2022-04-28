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

public class AddRunner extends JPanel {
	private static final String [] MODALIDAD = {"10000", "Medio Maratón", "Maratón"};
	public static final String BTN_ADD = "Añadir";
	public static final String BTN_CLEAN = "limpiar";
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
		setLayout(null);
		
		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(6, 28, 59, 16);
		add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(75, 23, 197, 26);
		add(txtname);
		txtname.setColumns(10);
		
		JLabel lblDorsal = new JLabel("Dorsal:");
		lblDorsal.setBounds(6, 68, 61, 16);
		add(lblDorsal);
		
		txtDorsal = new JTextField();
		txtDorsal.setBounds(75, 63, 165, 26);
		add(txtDorsal);
		txtDorsal.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(6, 113, 40, 16);
		add(lblSexo);
		
		rdbtnMan = new JRadioButton("Hombre");
		buttonGSexo.add(rdbtnMan);
		rdbtnMan.setBounds(74, 109, 87, 23);
		add(rdbtnMan);
		
		rdbtnWoman = new JRadioButton("Mujer");
		buttonGSexo.add(rdbtnWoman);
		rdbtnWoman.setBounds(160, 109, 87, 23);
		add(rdbtnWoman);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(6, 155, 61, 16);
		add(lblEdad);
		
		spnEdad = new JSpinner();
		spnEdad.setEditor(new JSpinner.DefaultEditor(spnEdad));
		spnEdad.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spnEdad.setBounds(75, 150, 59, 26);
		add(spnEdad);
		
		JLabel lblModalidad = new JLabel("Modalidad:");
		lblModalidad.setBounds(146, 155, 81, 16);
		add(lblModalidad);
		
		cmbModalidad = new JComboBox<String>();
		cmbModalidad.setModel(new DefaultComboBoxModel<String>(MODALIDAD));
		cmbModalidad.setBounds(220, 151, 153, 27);
		add(cmbModalidad);
		
		btnAdd = new JButton(BTN_ADD);
		btnAdd.setBounds(220, 228, 117, 29);
		add(btnAdd);
		
		btnClean = new JButton(BTN_CLEAN);
		btnClean.setBounds(49, 228, 117, 29);
		add(btnClean);
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
					
					
					rn = new Runner(name, dorsal, sexo, edad, mod);	
					
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
