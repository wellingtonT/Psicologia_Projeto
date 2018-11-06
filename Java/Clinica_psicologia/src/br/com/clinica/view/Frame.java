package br.com.clinica.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	private JPanel conteudo;
	
	private JPanel content;
    private Template template;
//    private LoginView conteudoLogin;
//    private InitialView conteudoInicio;
//    private RegisterView conteudoRegistro;
//    private ModifyView conteudoModificar;
//    private RegisterQueryView conteudoRegistroConsulta;
//    private RegisterPeopleView conteudoPessoa;
	
	public Frame() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Abrir na tela cheia
		this.setMinimumSize(new Dimension(900,500));
		this.setTitle("Cl�nica Amaranto");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
//
//		conteudoLogin = new LoginView();
//		conteudoInicio = new InitialView();
//		conteudoRegistro = new RegisterView(3);
//		conteudoModificar = new ModifyView(3);
//		conteudoRegistroConsulta = new RegisterQueryView(1);
//		conteudoPessoa = new RegisterPeopleView(3,1);
//		
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
	
	public void setTemplate(Template t) {
		template = t;
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
