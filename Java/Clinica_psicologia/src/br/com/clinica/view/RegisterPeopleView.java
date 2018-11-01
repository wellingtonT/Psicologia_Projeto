package br.com.clinica.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterPeopleView extends JPanel{
	
	private int registerType;
	private int modelo;
	private String caminho;
	
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
	
	private JButton clearButton = new JButton("Limpar");
	private JButton cancelButton = new JButton("Cancelar");
	private JButton saveButton = new JButton("Salvar");
	
	public RegisterPeopleView(int tipo, int modelo) {
		this.registerType = tipo;
		this.modelo = modelo;
		addComponents();
	}
	
	public JPanel getView() {
		return this;
	}
	
	public void addComponents() {
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(1,10,1,1);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.PAGE_START;
		
		switch(modelo) {
			case 1: caminho = "Modificar";
					break;
			default: caminho = "Cadastrar";
		}
		
		switch(registerType) {
			case 1: breadcrumb.setText("Início > " + caminho + " Pessoa > " + caminho + " Paciente");
					break;
			case 2: breadcrumb.setText("Início > " + caminho + " Pessoa > " + caminho + " Psicólogo");
					break;
			case 3: breadcrumb.setText("Início > " + caminho + " Pessoa > " + caminho + " Secretária");
					break;
			default: System.out.println("Erro ao mudar breadcrumb");
		}
		
		this.add(breadcrumb,gbc);
		
		gbc.insets = new Insets(1,1,1,1);
		gbc.anchor = GridBagConstraints.PAGE_END;
		gbc.gridy = 1;
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
		gbc.anchor = GridBagConstraints.PAGE_END;
		
		JPanel contactData = new JPanel();
		addComponentsContactData(contactData);
		this.add(contactData, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
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
		gbc.insets = new Insets(25,15,25,15);
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
		gbc.insets = new Insets(5,15,5,15);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(salaryText, gbc);
		
		gbc.gridx = 1;
		
		panel.add(salaryField, gbc);
		
		if(registerType == 3) {
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
		
		buttonConfig(clearButton);
		panel.add(clearButton, gbc);
		
		gbc.gridy = 1;
		
		buttonConfig(cancelButton);
		panel.add(cancelButton,gbc);
		
		gbc.gridy = 2;
		
		buttonConfig(saveButton);
		panel.add(saveButton, gbc);
		
	}

	public void buttonConfig(JButton button) {
		button.setPreferredSize(new Dimension(100,60));
		button.setMinimumSize(new Dimension(85,40));
	}

}
