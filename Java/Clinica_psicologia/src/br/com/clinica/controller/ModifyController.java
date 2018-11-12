package br.com.clinica.controller;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import br.com.clinica.listener.RegisterPeopleButtonsListener;
import br.com.clinica.view.Frame;
import br.com.clinica.view.ModifyView;

public class ModifyController {
	
	private Frame frame;
	private int opt;
	
	private ModifyView modifyView;
	
	private InitialController initialController;
	private RegisterPeopleController registerPeopleController;
	
	
	public ModifyController(Frame frame, int opt) {
		modifyView = new ModifyView(opt);
		this.opt = opt;
		
		this.frame = frame;
		
		mudarConteudo(modifyView);
		
		buttonDefinition(this.frame, this.opt);
	}
	
	public void mudarConteudo(Component conteudo) {
		frame.getConteudo().removeAll();
		frame.getConteudo().add(conteudo);
		frame.getConteudo().revalidate();
		
		SwingUtilities.updateComponentTreeUI(frame);
	}
	
	public void buttonDefinition(Frame frame, int opt) {
		modifyView.setListener(new RegisterPeopleButtonsListener() {
			
			@Override
			public void registerSecretary() throws SQLException {
				registerPeopleController = new RegisterPeopleController(frame, 2,1);
			}
			
			@Override
			public void registerPsycologist() throws SQLException {
				registerPeopleController = new RegisterPeopleController(frame, 3,1);
			}
			
			@Override
			public void registerPatient() throws SQLException {
				registerPeopleController = new RegisterPeopleController(frame, 1,1);
			}

			@Override
			public void back() {
				initialController = new InitialController(frame);					
			}
		});
	}
}
