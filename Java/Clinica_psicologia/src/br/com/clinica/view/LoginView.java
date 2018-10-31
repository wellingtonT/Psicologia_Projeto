package br.com.clinica.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JPanel {
	private JLabel texto;
	
	public LoginView() {
		addComponent();	
	}
	
	
	private void addComponent() {	
		this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel login = new JLabel("LOGIN");
        JLabel cpfLabel = new JLabel("CPF: ");
        JLabel passwordLabel = new JLabel("Senha: ");
        JTextField cpfText = new JTextField();
        JPasswordField passwordText = new JPasswordField();
        JButton enterButton = new JButton("Entrar");
        JLabel theEnd = new JLabel(" ");
        
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
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        passwordText.setColumns(20);
        this.add(passwordText,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = new GridBagConstraints().NONE;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(1,75,1,1);
        this.add(enterButton,gbc);
        
        gbc.weighty = 0.4;
        gbc.gridy = 4;
        this.add(theEnd,gbc);
		
	}
	
	public JPanel getView() {
		return this;
	}
}
