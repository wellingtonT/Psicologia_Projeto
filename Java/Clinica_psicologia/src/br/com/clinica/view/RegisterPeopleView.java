package br.com.clinica.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.clinica.listener.RegisterPeopleButtonsListener;
import br.com.clinica.listener.SearchButtonListener;
import br.com.clinica.listener.SelectButtonsListener;

public class RegisterPeopleView extends JPanel{
	private int registerType;
	private int modelo;
	
	private SelectButtonsListener listener;
	private SearchButtonListener listenerSearch;
	
	private String caminho = "/br/com/clinica/imagens/";
	
	private GridBagConstraints gbc;
	
	private JLabel breadcrumb = new JLabel();
	
	private JLabel nameText = new JLabel("Nome: ");
	private JTextField nameField = new JTextField(20);
	
	private JLabel cpfText = new JLabel("CPF: ");
	private JTextField cpfField = new JTextField(10);
	
	private JLabel streetText = new JLabel("Rua: ");
	private JTextField streetField = new JTextField(20);
	
	private JLabel cityText = new JLabel("Cidade: ");
	private JTextField cityField = new JTextField(20);
	
	private JLabel phoneText = new JLabel("Telefone: ");
	private JTextField phoneField = new JTextField(10);
	
	private JLabel locationCpfText = new JLabel("Digite o CPF: ");
	private JTextField locationField = new JTextField(10);
	private JButton locationButton = new JButton("Pesquisar");
	
	private JLabel medicationText1 = new JLabel("Medicamento: ");
	private JLabel medicationText2 = new JLabel("Medicamento: ");
	
	private JLabel dosageText1 = new JLabel("Dose: ");
	private JLabel dosageText2 = new JLabel("Dose: ");
	
	private JTextField medicationField1 = new JTextField(10);
	private JTextField medicationField2 = new JTextField(10);
	
	private JTextField dosageField1 = new JTextField(10);
	private JTextField dosageField2 = new JTextField(10);
	
	private JLabel salaryText = new JLabel("Salário: ");
	private JTextField salaryField = new JTextField(6);
	
	private JLabel crpText = new JLabel("CRP: ");
	private JTextField crpField = new JTextField(5);

	private ImageIcon imgClear = new ImageIcon(getClass().getResource(caminho + "Limpar.png"));
	private JButton clearButton = new JButton(imgClear);
	
	private ImageIcon imgCancel = new ImageIcon(getClass().getResource(caminho + "Cancelar.png"));
	private JButton cancelButton = new JButton(imgCancel);
	
	private ImageIcon imgSave = new ImageIcon(getClass().getResource(caminho + "Salvar.png"));
	private JButton saveButton = new JButton(imgSave);

	
	public RegisterPeopleView(int tipo, int modelo) {
		this.registerType = tipo;
		this.modelo = modelo;
		addComponents();
	}
	
	public JPanel getView() {
		return this;
	}
	
	public void setListener(SelectButtonsListener listener) {
		this.listener = listener;
	}
	
	public void setListenerSearch(SearchButtonListener listener) {
		this.listenerSearch = listener;
	}
	
	public void addComponents() {
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		if(modelo == 1) {
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 1.0;
			gbc.insets = new Insets(1,10,1,1);
			gbc.fill = GridBagConstraints.NONE;
			gbc.anchor = GridBagConstraints.LINE_END;
	
			this.add(locationCpfText, gbc);
			
			gbc.gridx = 1;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			this.add(locationField, gbc);
			
			gbc.gridx = 2;
			gbc.anchor = GridBagConstraints.LINE_START;
			gbc.fill = GridBagConstraints.NONE;
			
			addActionSearchButton(locationButton);
			this.add(locationButton, gbc);
		}
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(1,1,1,1);
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.weighty = 0.9;
		
		JPanel personalData = new JPanel();
		addComponentsPersonalData(personalData);
		this.add(personalData,gbc);
		
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridy = 2;
		
		JPanel addressData = new JPanel();
		addComponentsAddressData(addressData);
		this.add(addressData, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.PAGE_END;
		
		JPanel contactData = new JPanel();
		addComponentsContactData(contactData);
		this.add(contactData, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.PAGE_START;
		
		switch(registerType) {
			case 1:	
				gbc.gridwidth = 2;
				JPanel medicationData = new JPanel();
				addComponentsMedicationData(medicationData);
				this.add(medicationData, gbc);
				break;
				
			default:
				JPanel secretaryData = new JPanel();
				addComponentsSecretaryData(secretaryData);
				this.add(secretaryData, gbc);
				break;
		}
		
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		
		JPanel buttonsData = new JPanel();
		addComponentsDataButtons(buttonsData);
		this.add(buttonsData,gbc);		
	}
	
	public void addComponentsPersonalData(JPanel panel) {
		panel.setBorder(BorderFactory.createTitledBorder("Dados pessoais"));
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10,15,10,15);
		gbc.weightx = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(nameText, gbc);
		
		gbc.gridy = 1;
		
		panel.add(cpfText,gbc);
	
		gbc.weightx = 0.9;
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		panel.add(nameField, gbc);
		
		gbc.gridy = 1;
		
		gbc.gridx = 1;
		
		panel.add(cpfField,gbc);
	}
	
	public void addComponentsAddressData(JPanel panel) {
		panel.setBorder(BorderFactory.createTitledBorder("Endereço"));
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10,15,10,15);
		gbc.weightx = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(streetText, gbc);
		
		gbc.gridy = 1;
		
		panel.add(cityText,gbc);
	
		gbc.weightx = 0.9;
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		panel.add(streetField, gbc);
		
		gbc.gridy = 1;

		panel.add(cityField,gbc);
	}
	
	public void addComponentsContactData(JPanel panel) {
		panel.setBorder(BorderFactory.createTitledBorder("Contato"));
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.insets = new Insets(30,15,30,15);
		gbc.weightx = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(phoneText, gbc);
		
		gbc.weightx = 0.9;
		gbc.gridx = 1;
		
		panel.add(phoneField, gbc);
	}
	
	public void addComponentsMedicationData(JPanel panel) {
		panel.setBorder(BorderFactory.createTitledBorder("Medicamento"));
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10,15,10,15);
		gbc.weightx = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(medicationText1, gbc);
		
		gbc.gridy = 1;
		
		panel.add(medicationText2,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.9;
		
		panel.add(medicationField1, gbc);
		
		gbc.gridy = 1;
		
		panel.add(medicationField2,gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.weightx = 0.1;
		
		panel.add(dosageText1,gbc);
		
		gbc.gridy = 1;
		
		panel.add(dosageText2,gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.weightx = 0.9;
		
		panel.add(dosageField1,gbc);
		
		gbc.gridy = 1;
		
		panel.add(dosageField2,gbc);
		
	}
	
	public void addComponentsSecretaryData(JPanel panel) {
		panel.setBorder(BorderFactory.createTitledBorder("Profissional"));
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.insets = new Insets(30,15,30,15);

		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(salaryText, gbc);
		
		gbc.gridx = 1;
		
		panel.add(salaryField, gbc);
		
		if(registerType == 3) {
			gbc.insets = new Insets(0,15,5,15);

			gbc.gridx = 0;
			gbc.gridy = 1;
			
			panel.add(crpText,gbc);

			gbc.gridx = 1;
				
			panel.add(crpField,gbc);
		}
	}
	
	public void addComponentsDataButtons(JPanel panel) {
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(1,1,1,10);
		
		redimensionarImagem(clearButton,imgClear);
		addActionClearButton();
		panel.add(clearButton, gbc);
		
		gbc.gridx = 1;
		
		redimensionarImagem(cancelButton, imgCancel);
		addActionCancelButton();
		panel.add(cancelButton,gbc);
		
		gbc.gridx = 2;
		
		redimensionarImagem(saveButton, imgSave);
		addActionSaveButton();
		panel.add(saveButton, gbc);
		
	}

	private void redimensionarImagem(JButton img1, ImageIcon img2) {
		img1.setIcon(new ImageIcon(img2.getImage().getScaledInstance(166, 150, Image.SCALE_DEFAULT)));
		img1.setPreferredSize(new Dimension(100,70));
		img1.setMinimumSize(new Dimension(85,55));
	}

	public void addActionClearButton() {
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.clean();
			}
		});
	}
	
	public void addActionCancelButton() {
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.cancel();
			}
		});
	}
	
	public void addActionSaveButton() {
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.save();
			}
		});
	}
	
	public void addActionSearchButton(JButton button) {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listenerSearch.search();				
			}
		});
	}

	public JTextField getNameField() {
		return nameField;
	}

	public JTextField getCpfField() {
		return cpfField;
	}

	public JTextField getStreetField() {
		return streetField;
	}

	public JTextField getCityField() {
		return cityField;
	}

	public JTextField getPhoneField() {
		return phoneField;
	}

	public JTextField getLocationField() {
		return locationField;
	}

	public JTextField getMedicationField1() {
		return medicationField1;
	}

	public JTextField getMedicationField2() {
		return medicationField2;
	}

	public JTextField getDosageField1() {
		return dosageField1;
	}

	public JTextField getDosageField2() {
		return dosageField2;
	}

	public JTextField getSalaryField() {
		return salaryField;
	}

	public JTextField getCrpField() {
		return crpField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public void setCpfField(JTextField cpfField) {
		this.cpfField = cpfField;
	}

	public void setStreetField(JTextField streetField) {
		this.streetField = streetField;
	}

	public void setCityField(JTextField cityField) {
		this.cityField = cityField;
	}

	public void setPhoneField(JTextField phoneField) {
		this.phoneField = phoneField;
	}

	public void setLocationField(JTextField locationField) {
		this.locationField = locationField;
	}

	public void setMedicationField1(JTextField medicationField1) {
		this.medicationField1 = medicationField1;
	}

	public void setMedicationField2(JTextField medicationField2) {
		this.medicationField2 = medicationField2;
	}

	public void setDosageField1(JTextField dosageField1) {
		this.dosageField1 = dosageField1;
	}

	public void setDosageField2(JTextField dosageField2) {
		this.dosageField2 = dosageField2;
	}

	public void setSalaryField(JTextField salaryField) {
		this.salaryField = salaryField;
	}

	public void setCrpField(JTextField crpField) {
		this.crpField = crpField;
	}

	
	
}
