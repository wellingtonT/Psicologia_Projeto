package br.com.clinica.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClasseTeste extends JFrame {
	
	
	private JPanel content;
    private Template template;
    private LoginView conteudoLogin;
    private InitialView conteudoInicio;
    private RegisterView conteudoRegistro;
    private ModifyView conteudoModificar;
    private RegisterQueryView conteudoRegistroConsulta;
    private RegisterPeopleView conteudoRegistroPessoa;
	
	public ClasseTeste() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Abrir na tela cheia
		this.setMinimumSize(new Dimension(900,500));
		this.setTitle("Clínica Amaranto");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		template = new Template(2);
		conteudoLogin = new LoginView();
		conteudoInicio = new InitialView();
		conteudoRegistro = new RegisterView(3);
		conteudoModificar = new ModifyView(3);
		conteudoRegistroConsulta = new RegisterQueryView(1);
		conteudoRegistroPessoa = new RegisterPeopleView(1);
		
		setPane();
		addComponent();	
	}
	
	private void setPane() {
		content = new JPanel();
		content.setLayout(new BorderLayout());
		this.setContentPane(content);
	}
	
	private void addComponent() {
		content.add(template.getView(), BorderLayout.NORTH);
		content.add(conteudoRegistroPessoa.getView(), BorderLayout.CENTER);
	}
	
}
