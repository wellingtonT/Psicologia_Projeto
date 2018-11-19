package br.com.clinica.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.clinica.listener.EnterButtonListener;
import br.com.clinica.listener.InitialButtonsListener;
import br.com.clinica.model.UserModel;

public class InitialView extends JPanel{
	
	private GridBagConstraints gbc = new GridBagConstraints();
	
	private String caminho = "/br/com/clinica/imagens/";
	
	private InitialButtonsListener listener;
	
	private ImageIcon imgPessoas = new ImageIcon(getClass().getResource(caminho + "Pessoas.png"));
	private JButton registerPeopleButton = new JButton(imgPessoas);
	private JLabel registerPeopleText = new JLabel("Registrar Pessoas");
	
	private ImageIcon imgModificarPessoas = new ImageIcon(getClass().getResource(caminho + "Modificar_Pessoas.png"));
	private JButton modifyPeopleButton = new JButton(imgModificarPessoas);
	private JLabel modifyPeopleText = new JLabel("Modificar Pessoas");
	
	private ImageIcon imgConsultas = new ImageIcon(getClass().getResource(caminho + "Consultas.png"));
	private JButton registerQueryButton = new JButton(imgConsultas);
	private JLabel registerQueryText = new JLabel("Registrar Consultas");
	
	private ImageIcon imgModificarConsultas = new ImageIcon(getClass().getResource(caminho + "Modificar_Consultas.png"));
	private JButton modifyQueryButton = new JButton(imgModificarConsultas);
	private JLabel modifyQueryText = new JLabel("Modificar Consultas");
	
	private JLabel rodape = new JLabel(" ");
	
	public InitialView() {
		addComponents();
	}
	
	public void addComponents() {
		this.setLayout(new GridBagLayout());
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 0.3;
		gbc.anchor = GridBagConstraints.PAGE_END;
		gbc.insets = new Insets(0,15,0,15);
		
		redimensionarImagem(registerPeopleButton, imgPessoas);
		setActionButton(registerPeopleButton, 1);
		this.add(registerPeopleButton, gbc);
		
		
		gbc.gridx = 1;
		
		redimensionarImagem(modifyPeopleButton, imgModificarPessoas);
		setActionButton(modifyPeopleButton, 2);
		this.add(modifyPeopleButton, gbc);
		
		
		if(Integer.parseInt(UserModel.getPerfil()) == 1) {
			
			gbc.gridx = 2;
			
			redimensionarImagem(registerQueryButton, imgConsultas);
			setActionButton(registerQueryButton, 3);
			this.add(registerQueryButton, gbc);
			
			
			gbc.gridx = 3;
			
			redimensionarImagem(modifyQueryButton, imgModificarConsultas);
			setActionButton(modifyQueryButton, 4);
			this.add(modifyQueryButton, gbc);
		}
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(1, 1, 72, 1);
		gbc.anchor = GridBagConstraints.PAGE_START;
		
		setFont(registerPeopleText);
		this.add(registerPeopleText, gbc);
		
		gbc.gridx = 1;
		
		setFont(modifyPeopleText);
		this.add(modifyPeopleText, gbc);
		
		if(Integer.parseInt(UserModel.getPerfil()) == 1) {
			gbc.gridx = 2;
			
			setFont(registerQueryText);
			this.add(registerQueryText, gbc);
			
			gbc.gridx = 3;
			
			setFont(modifyQueryText);
			this.add(modifyQueryText, gbc);
		}
		
		
		
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weighty = 0.9;
		gbc.gridwidth = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(rodape, gbc);
		
	}
	
	public void setListener(InitialButtonsListener listener) {
		this.listener = listener;
	}
	
	public JPanel getView() {
		return this;
	}
	
	public void redimensionarImagem(JButton img1, ImageIcon img2) {
		img1.setIcon(new ImageIcon(img2.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
		img1.setPreferredSize(new Dimension(180,130));
	}
	
	public void setFont(JLabel text) {
		text.setFont(new Font("Georgia", Font.ROMAN_BASELINE, 20));
	}
	
	public void setActionButton(JButton button, int opt) {
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
		}
	}
	
	public void setActionRegisterPeople(JButton button) {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.registerPeopleButton();
			}
		});
	}
	
	public void setActionModifyPeople(JButton button) {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.modifyPeopleButton();				
			}
		});
	}
	
	public void setActionRegisterQuery(JButton button) {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					listener.registerQueryButton();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void setActionModifyQuery(JButton button) {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					listener.modifyQueryButton();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
