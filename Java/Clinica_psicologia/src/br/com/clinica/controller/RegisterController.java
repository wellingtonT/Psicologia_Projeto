package br.com.clinica.controller;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import br.com.clinica.listener.InitialButtonsListener;
import br.com.clinica.listener.RegisterPeopleButtonsListener;
import br.com.clinica.view.Frame;
import br.com.clinica.view.RegisterView;

public class RegisterController {
	
	private Frame frame;
	private int opt;
	
	private RegisterView registerView;
	
	private RegisterPeopleController registerPeopleController;
	private InitialController initialController;
		
	public RegisterController(Frame frame, int opt) {
		registerView = new RegisterView(opt);

		this.frame = frame;
		
		mudarConteudo(registerView);
		buttonDefinition(this.frame);
	}
	
	public void mudarConteudo(Component conteudo) {
		frame.getConteudo().removeAll();
		frame.getConteudo().add(conteudo);
		frame.getConteudo().revalidate();

		SwingUtilities.updateComponentTreeUI(frame);
	}

	public void buttonDefinition(Frame frame) {
		registerView.setListener(new RegisterPeopleButtonsListener() {
			
			@Override
			public void registerSecretary() throws SQLException {
				registerPeopleController = new RegisterPeopleController(frame, 2,2);
			}
			
			@Override
			public void registerPsycologist() throws SQLException {
				registerPeopleController = new RegisterPeopleController(frame, 3,2);
			}
			
			@Override
			public void registerPatient() throws SQLException {
				registerPeopleController = new RegisterPeopleController(frame, 1,2);
			}

			@Override
			public void back() {
				initialController = new InitialController(frame);	
			}
		});
	}
}
