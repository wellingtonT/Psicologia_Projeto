package br.com.clinica.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	private JPanel conteudo;
	
	private JPanel content;
    private JPanel template;
    
	public Frame() {
		this.setSize(new Dimension(901,501));
		this.setMinimumSize(new Dimension(900,500));
		this.setTitle("Clínica Amaranto");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		setPane();
	}
	
	public void setPane() {
		content = new JPanel();
		content.setLayout(new BorderLayout());
		
		this.setContentPane(content);
	}
	
	public void addComponent() {
		template.setLayout(new BorderLayout());
		
		content.add(template, BorderLayout.NORTH);
		content.add(conteudo, BorderLayout.CENTER);
	}
	
	public void setTemplate(JPanel t) {
		this.template = t;
	}
	
	public void setConteudo(JPanel conteudo) {
		this.conteudo = conteudo;
	}
	
	public JPanel getTemplate() {
		return this.template;
	}
	
	public JPanel getConteudo() {
		return this.conteudo;
	}
	
	
}
