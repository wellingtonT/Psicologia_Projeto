package br.com.clinica.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.clinica.listener.SearchButtonListener;
import br.com.clinica.listener.SelectButtonsListener;

public class RegisterQueryView extends JPanel {
	
	private int opt;
	
	private GridBagConstraints gbc;
	
	private SelectButtonsListener listener;
	private SearchButtonListener listenerSearch;
	
	private String caminho = "/br/com/clinica/imagens/";
	
	private JLabel breadcrumb = new JLabel();
	
	private JLabel cpfText = new JLabel("CPF: ");
	private JTextField cpfField = new JTextField(20);	
	
	private JLabel psycologistText = new JLabel("Psicólogo: ");
	private String[] psycologists = {};
	private JComboBox psycologistBox = new JComboBox();
	
	private JLabel dayText = new JLabel("Dia: ");
	private JTextField dayField = new JTextField(5);
	
	private JLabel monthText = new JLabel("Mês: ");
	private String[] months = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
	private JComboBox monthBox = new JComboBox(months);
	
	private JLabel yearText = new JLabel("Ano: ");
	private JTextField yearField = new JTextField(5);
	
	private JLabel hourText = new JLabel("Horário: ");
	private String[] hours = {"10:00:00","11:00:00","12:00:00","14:00:00","15:00:00","16:00:00","17:00:00","18:00:00"};
	private JComboBox hourBox = new JComboBox(hours);
	
	private ImageIcon imgClear = new ImageIcon(getClass().getResource(caminho + "Limpar.png"));
	private JButton clearButton = new JButton(imgClear);
	
	private ImageIcon imgCancel = new ImageIcon(getClass().getResource(caminho + "Cancelar.png"));
	private JButton cancelButton = new JButton(imgCancel);
	
	private ImageIcon imgSave = new ImageIcon(getClass().getResource(caminho + "Salvar.png"));
	private JButton saveButton = new JButton(imgSave);
	
	private JLabel locationCpfText = new JLabel("Digite o cpf do paciente: ");
	private JTextField locationField = new JTextField(10);
	private JButton locationButton = new JButton("Pesquisar");
	
	public RegisterQueryView(int opt) {
		this.opt = opt;
		addComponents();
	}
	
	private void addComponents() {
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		if(opt == 2) {			
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
			
			addActionSearchButton();
			this.add(locationButton, gbc);
		}
		
		gbc.insets = new Insets(1,1,1,1);
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.weighty = 0.95;
		
		JPanel personalData = new JPanel();
		addComponentsPersonalData(personalData);
		this.add(personalData,gbc);
		
		gbc.gridx = 1;
		
		JPanel dateData = new JPanel();
		addComponentsDateData(dateData);
		this.add(dateData, gbc);
		
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		gbc.insets = new Insets(1, 1, 1, 1);
		
		JPanel buttonsData = new JPanel();
		addComponentsDataButtons(buttonsData);
		this.add(buttonsData,gbc);
		
	}
	
	public void setListener(SelectButtonsListener listener) {
		this.listener = listener;
	}
	
	public void setListenerSearch(SearchButtonListener listener) {
		this.listenerSearch = listener;
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
		panel.setBorder(BorderFactory.createTitledBorder("Horários"));
		
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
	
	public String[] getPsycologists() {
		return psycologists;
	}

	public void setPsycologists(String[] psycologists) {
		this.psycologists = psycologists;
		psycologistBox.setModel(new DefaultComboBoxModel<>(this.psycologists));
	}

	public void addComponentsDataButtons(JPanel panel) {
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(1,1,10,1);
		
		if(opt == 1) {
			redimensionarImagem(clearButton, imgClear);
			addActionClearButton();
			panel.add(clearButton, gbc);
		}
		
		gbc.gridy = 1;
		
		redimensionarImagem(cancelButton, imgCancel);
		addActionCancelButton();
		panel.add(cancelButton,gbc);
		
		gbc.gridy = 2;
		
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
	
	public void addActionSearchButton() {
		locationButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listenerSearch.search();
			}
		});
	}

	public JTextField getCpfField() {
		return cpfField;
	}

	public JComboBox getPsycologistBox() {
		return psycologistBox;
	}

	public JTextField getDayField() {
		return dayField;
	}

	public JComboBox getMonthBox() {
		return monthBox;
	}

	public JTextField getYearField() {
		return yearField;
	}

	public JComboBox getHourBox() {
		return hourBox;
	}

	public JTextField getLocationField() {
		return locationField;
	}

	public void setCpfField(JTextField cpfField) {
		this.cpfField = cpfField;
	}

	public void setPsycologistBox(JComboBox psycologistBox) {
		this.psycologistBox = psycologistBox;
	}

	public void setDayField(JTextField dayField) {
		this.dayField = dayField;
	}

	public void setMonthBox(JComboBox monthBox) {
		this.monthBox = monthBox;
	}

	public void setYearField(JTextField yearField) {
		this.yearField = yearField;
	}

	public void setHourBox(JComboBox hourBox) {
		this.hourBox = hourBox;
	}

	public void setLocationField(JTextField locationField) {
		this.locationField = locationField;
	}
	
	
	
}
