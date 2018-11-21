package br.com.clinica.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.clinica.listener.RegisterPeopleButtonsListener;

public class ModifyView extends JPanel{
	
	private int opt;
	
	private RegisterPeopleButtonsListener listener;
	
	private GridBagConstraints gbc = new GridBagConstraints();
	
	private String caminho = "/br/com/clinica/imagens/";
	
	private ImageIcon imgPessoas = new ImageIcon(getClass().getResource(caminho + "Modificar_Pessoas.png"));

	private JButton registerPatient = new JButton(imgPessoas);
	private JLabel registerPatientText = new JLabel("Modificar Paciente");
	
	private JButton registerPsycologist = new JButton(imgPessoas);
	private JLabel registerPsycologistText = new JLabel("Modificar Psicólogo");
	
	private JButton registerSecretary = new JButton(imgPessoas);
	private JLabel registerSecretaryText = new JLabel("Modificar Secretária");
	
	private JButton backButton = new JButton("Voltar");
	
	private JLabel rodape = new JLabel(" ");
//	private JLabel breadcrumb = new JLabel("Início > Moficiar Pessoas");
	
	public ModifyView(int opt) {
		this.opt = opt;
		addComponents();
	}
	
	public void addComponents() {
		this.setLayout(new GridBagLayout());
		
		gbc.insets = new Insets(1,10,1,1);		
		gbc.gridwidth = 1;
		gbc.gridy = 1;
		gbc.gridx = 0;		
		gbc.anchor = GridBagConstraints.CENTER;
		
		redimensionarImagem(registerPatient, imgPessoas);
		addButtonsAction(registerPatient,1);
		this.add(registerPatient, gbc);
		
		if(opt == 3) {
			gbc.gridx = 1;
			
			redimensionarImagem(registerPsycologist, imgPessoas);
			addButtonsAction(registerPsycologist,2);
			this.add(registerPsycologist, gbc);
			
			gbc.gridx = 2;
			
			redimensionarImagem(registerSecretary, imgPessoas);
			addButtonsAction(registerSecretary,3);
			this.add(registerSecretary, gbc);
		}
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 2;
		gbc.insets = new Insets(1,15,0,1);
		
		setFont(registerPatientText);
		this.add(registerPatientText, gbc);
		
		if(opt == 3) {
			gbc.gridx = 1;
			
			setFont(registerPsycologistText);
			this.add(registerPsycologistText, gbc);
			
			gbc.gridx = 2;
			
			setFont(registerSecretaryText);
			this.add(registerSecretaryText, gbc);
		}
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(50,0,0,0);
		addButtonsAction(backButton, 4);
		this.add(backButton, gbc);
	}
	
	public void setListener(RegisterPeopleButtonsListener listener) {
		this.listener = listener;
	}
	
	private void redimensionarImagem(JButton img1, ImageIcon img2) {
		img1.setIcon(new ImageIcon(img2.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
		img1.setPreferredSize(new Dimension(180,130));
	}
	
	private void setFont(JLabel text) {
		text.setFont(new Font("Georgia", Font.ROMAN_BASELINE, 20));
	}
	
	public JPanel getView() {
		return this;
	}
	
	public void addButtonsAction(JButton button, int opt){
		switch (opt) {
			case 1:
				modifyPatient(button);
				break;
			case 2:
				modifyPsycologist(button);
				break;
			case 3:
				modifySecretary(button);
				break;
			case 4:
				backButton(button);
				break;
		}
	}	
	
	public void modifyPatient(JButton button) {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					listener.registerPatient();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void modifyPsycologist(JButton button) {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					listener.registerPsycologist();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void modifySecretary(JButton button) {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					listener.registerSecretary();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void backButton(JButton button) {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.back();
			}
		});
	}
}
