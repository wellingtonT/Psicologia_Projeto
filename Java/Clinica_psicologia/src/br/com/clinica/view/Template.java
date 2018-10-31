package br.com.clinica.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Template extends JPanel {
	
	private GridBagConstraints gbc = new GridBagConstraints();
	private JButton exitButton;
	private JLabel userName;
	
	public Template(int opt) {
		this.setPreferredSize(new Dimension(0,125));
		addNorthComponents(opt);
	}
	
	private  void addNorthComponents(int opt) {
		this.setLayout(new GridBagLayout());
		
		
		
		ImageIcon img = new ImageIcon(getClass().getResource("Logo.png"));
		JLabel imagem = new JLabel(img);

		imagem.setIcon(new ImageIcon(img.getImage().getScaledInstance(300,105, Image.SCALE_DEFAULT)));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(imagem, gbc);	
		
		exitButton = new JButton("Sair");
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// IMPLEMENTAR!!
				
			}
		});
		
		switch(opt) {
			case 1: this.remove(exitButton);
					this.validate();
					this.repaint();
					break;
					
			case 2: addExitButton();
					addUserName();
					break;
					
			default: System.out.println("Erro ao iniciar bot�o!");
		}
		
	}

	public JPanel getNorthPanel() {
		return this;
	}
	
	private void addExitButton() {
		gbc.weighty = 1.0;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		
		this.add(exitButton, gbc);
	}
	
	private void addUserName() {
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		
		userName = new JLabel();
		userName.setText("[Nome do usu�rio]");
		this.add(userName, gbc);
	}
	
}