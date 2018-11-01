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

public class RegisterQueryView extends JPanel {
	
	private int opt;
	
	private GridBagConstraints gbc;
	
	private JLabel breadcrumb = new JLabel();
	
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
	
	private String[] columnsNames;
	private Object[][] rowData;
	private JTable tableQuery;
	private JScrollPane tableScroll;
	
	private JButton clearButton = new JButton("Limpar");
	private JButton cancelButton = new JButton("Cancelar");
	private JButton saveButton = new JButton("Salvar");
	
	public RegisterQueryView(int opt) {
		this.opt = opt;
		addComponents();
	}
	
	private void addComponents() {
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 0.05;
		gbc.insets = new Insets(1,10,1,1);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.PAGE_START;
		
		switch(opt) {
			case 1: breadcrumb.setText("Início > Cadastrar Consulta");
					break;
			case 2: breadcrumb.setText("Início > Modificar Consulta");
					break;
			default: System.out.println("Erro ao mudar breadcrumb");
		}
		
		this.add(breadcrumb,gbc);
		
		gbc.insets = new Insets(1,1,1,1);
		gbc.gridy = 1;
		gbc.weighty = 0.95;
		
		JPanel personalData = new JPanel();
		addComponentsPersonalData(personalData);
		this.add(personalData,gbc);
		
		gbc.gridx = 1;
		
		JPanel dateData = new JPanel();
		addComponentsDateData(dateData);
		this.add(dateData, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.VERTICAL;
		
		JPanel tableData = new JPanel();
		addComponentsDataTable(tableData);
		this.add(tableData,gbc);
		
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		
		JPanel buttonsData = new JPanel();
		addComponentsDataButtons(buttonsData);
		this.add(buttonsData,gbc);
		
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
		
		yearField.setMinimumSize(new Dimension(50,20));
		panel.add(yearField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		panel.add(hourText, gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		
		hourBox.setPreferredSize(new Dimension(150,20));
		panel.add(hourBox, gbc);
		
	}
	
	public void addComponentsDataTable(JPanel panel) {
		panel.setBorder(BorderFactory.createTitledBorder("Relação de data"));
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.insets = new Insets(5,20,1,20);
		
		tableDataConfig();
		
		tableQuery = new JTable(rowData, columnsNames);
		
		tableScroll = new JScrollPane(tableQuery);
		tableScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tableScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tableScroll.setMinimumSize(new Dimension(300,200));
		panel.add(tableScroll,gbc);
		
	}
	
	public void addComponentsDataButtons(JPanel panel) {
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(1,1,10,10);
		
		if(opt == 1) {
			buttonConfig(clearButton);
			panel.add(clearButton, gbc);
		}
		
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
	
	public void tableDataConfig() {
		columnsNames = new String[]{"Data", "Hora", "Psicólogo"};
		rowData = new Object[][] {
			{"10/10/2010", "14:30", "Wellington"}
		};
	}
}
