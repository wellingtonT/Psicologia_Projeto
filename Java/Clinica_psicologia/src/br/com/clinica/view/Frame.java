package br.com.clinica.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	private JPanel conteudo;
	
	private JPanel content;
    private JPanel template;

	
	public Frame() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Abrir na tela cheia
		this.setMinimumSize(new Dimension(900,500));
		this.setTitle("Clínica Amaranto");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		setPane();
	}
	
	private void setPane() {
		content = new JPanel();
		content.setLayout(new BorderLayout());
		this.setContentPane(content);
	}
	
	public void addComponent() {
		content.add(template, BorderLayout.NORTH);
		content.add(conteudo, BorderLayout.CENTER);
	}
	
	public void setTemplate(JPanel t) {
		this.template = new JPanel();
		this.template = t;
	}
	
	public void setConteudo(JPanel conteudo) {
		this.conteudo = new JPanel();
		this.conteudo = conteudo;
	}
	
	public JPanel getTemplate() {
		return this.template;
	}
	
	public JPanel getConteudo() {
		return this.conteudo;
	}
	
	
	
	
	
	
}
