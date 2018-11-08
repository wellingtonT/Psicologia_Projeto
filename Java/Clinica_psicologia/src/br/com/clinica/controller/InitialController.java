package br.com.clinica.controller;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import br.com.clinica.listener.InitialButtonsListener;
import br.com.clinica.view.Frame;
import br.com.clinica.view.InitialView;
import br.com.clinica.view.ModifyView;
import br.com.clinica.view.RegisterQueryView;
import br.com.clinica.view.RegisterView;
import br.com.clinica.view.Template;
import br.com.clinica.view.Template2;

public class InitialController {
	
	private InitialView initialView;
	private Template template;
	private Frame frame;
	
	private RegisterController registerController;
	private ModifyController modifyController;
	private RegisterQueryController registerQueryController;
	
	public InitialController(Frame frame) {
		initialView = new InitialView();	
		template = new Template(2);
		
//		Template2 s = new Template2();
		this.frame = frame;

		mudarConteudo(initialView, template);
		buttonDefinition(this.frame);
		
	}
	
	public void mudarConteudo(Component conteudo, Component template) {
		frame.getConteudo().removeAll();
//		frame.getTemplate().removeAll();
		
		frame.getConteudo().add(conteudo);
//		frame.getTemplate().add(template); 
		
		frame.getConteudo().revalidate();
//		frame.getTemplate().revalidate();
		
		SwingUtilities.updateComponentTreeUI(frame);
	}
	
	public void buttonDefinition(Frame frame) {
		initialView.setListener(new InitialButtonsListener() {
			
			@Override
			public void registerQueryButton() throws SQLException {
				registerQueryController = new RegisterQueryController(frame, 1);
			}
			
			@Override
			public void registerPeopleButton() {
				registerController = new RegisterController(frame,3);
			}
			
			@Override
			public void modifyQueryButton() throws SQLException {
				registerQueryController = new RegisterQueryController(frame,2);
			}
			
			@Override
			public void modifyPeopleButton() {
				modifyController = new ModifyController(frame,3);
			}
		});
	}

}
