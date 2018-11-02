package br.com.clinica.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JPanel {
	
	private JLabel texto;
	
	private String caminho = "/br/com/clinica/imagens/";
	
	private JLabel login = new JLabel("LOGIN");
	private JLabel cpfLabel = new JLabel("CPF: ");
	private JLabel passwordLabel = new JLabel("Senha: ");
	private JTextField cpfText = new JTextField();
	private JPasswordField passwordText = new JPasswordField();
	
	private ImageIcon imgEnter = new ImageIcon(getClass().getResource(caminho + "Entrar.png"));
	private JButton enterButton = new JButton(imgEnter);
	
	private JLabel theEnd = new JLabel(" ");
	
	private GridBagConstraints gbc;
	
	public LoginView() {
		addComponent();	
	}
	
	
	private void addComponent() {	
		this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        
        gbc.weighty = 0.4;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
    
        login.setFont(new Font("Georgia", Font.BOLD, 50));
        this.add(login,gbc);
        
        gbc.insets = new Insets(1,1,10,1);
        gbc.weighty = 0.2;
        gbc.weighty = 0;
        gbc.weightx = 0.5;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        
        this.add(cpfLabel,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        
        this.add(passwordLabel,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        gbc.anchor = GridBagConstraints.LINE_START;
        cpfText.setColumns(20);
        
        this.add(cpfText,gbc);
        
        gbc.gridy = 2;
        
        passwordText.setColumns(20);
        this.add(passwordText,gbc);
        
        gbc.gridy = 3;
        gbc.fill = new GridBagConstraints().NONE;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(50,35,1,1);
        
        redimensionarImagem(enterButton, imgEnter);
        this.add(enterButton,gbc);
        
        gbc.weighty = 0.4;
        gbc.gridy = 4;
        
        this.add(theEnd,gbc);
		
	}
	
	public JPanel getView() {
		return this;
	}
	
	private void redimensionarImagem(JButton img1, ImageIcon img2) {
		img1.setIcon(new ImageIcon(img2.getImage().getScaledInstance(335, 375, Image.SCALE_DEFAULT)));
		img1.setPreferredSize(new Dimension(149,45));
		img1.setBackground(Color.lightGray);
	}
}
