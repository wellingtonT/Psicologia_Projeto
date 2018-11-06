package br.com.clinica.controller;

import br.com.clinica.listener.EnterButtonListener;
import br.com.clinica.view.Frame;
import br.com.clinica.view.LoginView;
import br.com.clinica.view.Template;

public class LoginController {
	
	private LoginView loginView;
	private Template template;
	private Frame frame;
	private InitialController initialController;
		
	public LoginController() {
		loginView = new LoginView();
		template = new Template(1);
				
		loginView.setListener(new EnterButtonListener() {
			
			@Override
			public void enter() {
				enterButton();
			}
		});
		
		initApp();
	}
	
	public void initApp() {
		frame = new Frame();
		frame.setTemplate(template);
		frame.setConteudo(loginView);
		frame.addComponent();
		frame.setVisible(true);
		
	}
	
	public void enterButton() {
		
		initialController = new InitialController(frame);
	}
	
}
