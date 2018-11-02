package br.com.clinica.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RegisterView extends JPanel{
	
	private GridBagConstraints gbc = new GridBagConstraints();
	
	private String caminho = "/br/com/clinica/imagens/";
	
	private ImageIcon imgPessoas = new ImageIcon(getClass().getResource(caminho + "Pessoas.png"));

	private JButton registerPatient = new JButton(imgPessoas);
	private JLabel registerPatientText = new JLabel("Registrar Paciente");
	
	private JButton registerPsycologist = new JButton(imgPessoas);
	private JLabel registerPsycologistText = new JLabel("Registar Psicólogo");
	
	private JButton registerSecretary = new JButton(imgPessoas);
	private JLabel registerSecretaryText = new JLabel("Registrar Secretária");
	
	private JLabel rodape = new JLabel(" ");
	private JLabel breadcrumb = new JLabel("Início > Cadastro de Pessoas");
	
	public RegisterView(int opt) {
		addComponents(opt);
	}
	
	public void addComponents(int opt) {
		this.setLayout(new GridBagLayout());
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 0.1;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(1,10,1,1);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		this.add(breadcrumb,gbc);
		
		gbc.gridwidth = 1;
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		
		redimensionarImagem(registerPatient, imgPessoas);
		this.add(registerPatient, gbc);
		
		if(opt == 3) {
			gbc.gridx = 1;
			
			redimensionarImagem(registerPsycologist, imgPessoas);
			this.add(registerPsycologist, gbc);
			
			gbc.gridx = 2;
			
			redimensionarImagem(registerSecretary, imgPessoas);
			this.add(registerSecretary, gbc);
		}
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.insets = new Insets(1,15,-155,1);
		
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
		
		gbc.weighty = 0.9;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		this.add(rodape, gbc);
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
}
