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

import br.com.clinica.listener.ExitButtonListener;

public class Template extends JPanel {
	
	private ExitButtonListener listener;
	
	private int opt;
	
	private GridBagConstraints gbc;
	
	private String caminho = "/br/com/clinica/imagens/";
	
	private ImageIcon imgExit = new ImageIcon(getClass().getResource(caminho + "Sair.png"));
	private JButton exitButton = new JButton(imgExit);
	
	private JLabel userName = new JLabel();
	
	private ImageIcon imgLogo = new ImageIcon(getClass().getResource(caminho + "Logo.png"));
	private JLabel logo = new JLabel(imgLogo);
	
	public Template(int opt) {
		this.opt = opt;
		
		this.setPreferredSize(new Dimension(0,125));
		addNorthComponents();
	}
	
	public void setOpt(int opt) {
		this.opt = opt;
	}
	
	public int getOpt() {
		return this.opt;
	}
	
	public void setListener(ExitButtonListener listener) {
		this.listener = listener;
	}
	
	public void addNorthComponents() {
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		redimensionarImagem(logo, imgLogo);
		this.add(logo, gbc);	
		
		switch(opt) {
			case 1: this.remove(exitButton);
//					this.validate();
//					this.repaint();
					break;
					
			case 2: addExitButton();
					addUserName();
					break;
		}
		
	}

	public void setUserName(String userName) {
		this.userName.setText(userName);
	}
	
	public JPanel getView() {
		return this;
	}
	
	public void redimensionarImagem(JButton img1, ImageIcon img2) {
		img1.setIcon(new ImageIcon(img2.getImage().getScaledInstance(200, 190, Image.SCALE_DEFAULT)));
		img1.setPreferredSize(new Dimension(70,20));
	}
	
	public void redimensionarImagem(JLabel img1, ImageIcon img2) {
		img1.setIcon(new ImageIcon(img2.getImage().getScaledInstance(260, 100, Image.SCALE_DEFAULT)));
	}
	
	public void addExitButton() {
		gbc.weighty = 1.0;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		
		redimensionarImagem(exitButton,imgExit);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.exit();				
			}
		});
		this.add(exitButton, gbc);
	}
	
	public void addUserName() {
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;

		this.add(userName, gbc);
	}
	
}
