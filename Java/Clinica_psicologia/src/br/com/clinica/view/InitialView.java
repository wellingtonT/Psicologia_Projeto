package br.com.clinica.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InitialView extends JPanel{
	
	private GridBagConstraints gbc = new GridBagConstraints();
	
	private ImageIcon imgPessoas = new ImageIcon(getClass().getResource("Pessoas.png"));
	private JLabel registerPeopleButton = new JLabel(imgPessoas);
	private JLabel registerPeopleText = new JLabel("Registrar Pessoas");
	
	private ImageIcon imgModificarPessoas = new ImageIcon(getClass().getResource("Modificar_Pessoas.png"));
	private JLabel modifyPeopleButton = new JLabel(imgModificarPessoas);
	private JLabel modifyPeopleText = new JLabel("Modificar Pessoas");
	
	private ImageIcon imgConsultas = new ImageIcon(getClass().getResource("Consultas.png"));
	private JLabel registerQueryButton = new JLabel(imgConsultas);
	private JLabel registerQueryText = new JLabel("Registrar Consultas");
	
	private ImageIcon imgModificarConsultas = new ImageIcon(getClass().getResource("Modificar_Consultas.png"));
	private JLabel modifyQueryButton = new JLabel(imgModificarConsultas);
	private JLabel modifyQueryText = new JLabel("Modificar Consultas");
	
	private JLabel rodape = new JLabel(" ");
	
	public InitialView() {
		addComponents();
//		this.setBackground(Color.WHITE);
	}
	
	private void addComponents() {
		this.setLayout(new GridBagLayout());
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.PAGE_END;
		
		redimensionarImagem(registerPeopleButton, imgPessoas);
		this.add(registerPeopleButton, gbc);
		setActionButton(registerPeopleButton, 1);
		
		gbc.gridx = 1;
		
		redimensionarImagem(modifyPeopleButton, imgModificarPessoas);
		this.add(modifyPeopleButton, gbc);
		setActionButton(modifyPeopleButton, 2);
		
		gbc.gridx = 2;
		
		redimensionarImagem(registerQueryButton, imgConsultas);
		this.add(registerQueryButton, gbc);
		setActionButton(registerQueryButton, 3);
		
		gbc.gridx = 3;
		
		redimensionarImagem(modifyQueryButton, imgModificarConsultas);
		this.add(modifyQueryButton, gbc);
		setActionButton(modifyQueryButton, 4);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.insets = new Insets(1, 1, 60, 1);
		gbc.anchor = GridBagConstraints.PAGE_END;
		
		setFont(registerPeopleText);
		this.add(registerPeopleText, gbc);
		
		gbc.gridx = 1;
		
		setFont(modifyPeopleText);
		this.add(modifyPeopleText, gbc);
		
		gbc.gridx = 2;
		
		setFont(registerQueryText);
		this.add(registerQueryText, gbc);
		
		gbc.gridx = 3;
		
		setFont(modifyQueryText);
		this.add(modifyQueryText, gbc);
		
		
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weighty = 0.9;
		gbc.gridwidth = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(rodape, gbc);
		
	}
	
	public JPanel getView() {
		return this;
	}
	
	private void redimensionarImagem(JLabel img1, ImageIcon img2) {
		img1.setIcon(new ImageIcon(img2.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT)));
	}
	
	private void setFont(JLabel text) {
		text.setFont(new Font("Georgia", Font.ROMAN_BASELINE, 20));
	}
	
	private void setActionButton(JLabel button, int opt) {
		switch(opt) {
			case 1: 
				setActionRegisterPeople(button);
				break;
			case 2:
				setActionModifyPeople(button);
				break;
			case 3: 
				setActionRegisterQuery(button);
				break;
			case 4:
				setActionModifyQuery(button);
				break;
			default:
				System.out.println("Valor ou botão inválido!");
		}
	}
	
	private void setActionRegisterPeople(JLabel button) {
		button.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				//IMPLEMENTAR
			}
			
		});
	}
	
	private void setActionModifyPeople(JLabel button) {
		button.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				//IMPLEMENTAR
			}
			
		});
	}
	
	private void setActionRegisterQuery(JLabel button) {
		button.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				//IMPLEMENTAR
			}
			
		});
	}
	
	private void setActionModifyQuery(JLabel button) {
		button.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				//IMPLEMENTAR
			}
			
		});
	}
}
