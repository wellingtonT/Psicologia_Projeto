package br.com.clinica.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class RegisterQuery extends JPanel {
	
	private GridBagConstraints gbc;
	
	private JLabel breadcrumb = new JLabel("Início > Cadastrar Consulta");
	
	private JLabel cpfText = new JLabel("CPF: ");
	private JTextField cpfField = new JTextField(20);	
	
	private JLabel psycologistText = new JLabel("Psicólogo: ");
	private String[] psycologists = {"Teste1", "Teste2", "Teste3"};
	private JComboBox psycologistBox = new JComboBox(psycologists);
	
	private JLabel dayText = new JLabel("Dia: ");
	private JTextField dayField = new JTextField(5);
	
	private JLabel monthText = new JLabel("Mês: ");
	private String[] months = {"Janeiro", "Fevereiro", "Março"};
	private JComboBox monthBox = new JComboBox(months);
	
	private JLabel yearText = new JLabel("Ano: ");
	private JTextField yearField = new JTextField(5);
	
	private JLabel hourText = new JLabel("Horário: ");
	private String[] hours = {"10:00","11:00","12:00","14:00","15:00"};
	private JComboBox hourBox = new JComboBox(hours);
	
	private String[] columnsNames = {"Data", "Hora", "Psicologo"};
	private Object[][] rowData = {
							{"Maria", "12", "maria@gmail.com"},
							{"José", "13", "jose@gmail.com"},
							{"João", "14", "joao@gmail.com"}
	};
	private JTable tableQuery = new JTable(rowData,columnsNames);
	private JScrollPane tableScroll = new JScrollPane(tableQuery);
	
	private JButton clearButton = new JButton("Limpar");
	private JButton cancelButton = new JButton("Cancelar");
	private JButton saveButton = new JButton("Salvar");
	
	
	
	public RegisterQuery() {
		addComponents();
	}
	
	private void addComponents() {
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		JPanel personalData = new JPanel();
		addComponentsPersonalData(personalData);
		this.add(personalData,gbc);
		
		gbc.gridx = 1;
		
		JPanel dateData = new JPanel();
		addComponentsDateData(dateData);
		this.add(dateData, gbc);
		
	}
	
	public JPanel getView() {
		return this;
	}
	
	public void addComponentsPersonalData(JPanel panel) {
		panel.setBorder(BorderFactory.createTitledBorder("Dados pessoais"));
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10,15,10,15);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(cpfText, gbc);
		
		gbc.gridx = 1;
		
		panel.add(cpfField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		panel.add(psycologistText,gbc);
		
		gbc.gridx = 1;
		
		psycologistBox.setPreferredSize(new Dimension(222,20));
		panel.add(psycologistBox,gbc);
		
		
	}
	
	public void addComponentsDateData(JPanel panel) {
		panel.setBorder(BorderFactory.createTitledBorder("Dados pessoais"));
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(9,20,9,20);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(dayText, gbc);
		
		gbc.gridx = 1;
		
		dayField.setMinimumSize(new Dimension(50,20));
		panel.add(dayField, gbc);
		
		gbc.gridx = 2;
		
		panel.add(monthText, gbc);
		
		gbc.gridx = 3;
		
		panel.add(monthBox, gbc);
		
		gbc.gridx = 4;
		
		panel.add(yearText, gbc);
		
		gbc.gridx = 5;
		
		panel.add(yearField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		panel.add(hourText, gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		
		hourBox.setPreferredSize(new Dimension(150,20));
		panel.add(hourBox, gbc);
		
	}
}
