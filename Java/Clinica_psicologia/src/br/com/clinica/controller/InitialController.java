package br.com.clinica.controller;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import br.com.clinica.dao.UserDAO;
import br.com.clinica.listener.ExitButtonListener;
import br.com.clinica.listener.InitialButtonsListener;
import br.com.clinica.model.UserModel;
import br.com.clinica.view.Frame;
import br.com.clinica.view.InitialView;
import br.com.clinica.view.Template;

public class InitialController {
	
	private InitialView initialView;
	private Template template;
	private Frame frame;
	private UserModel userModel;
	private UserDAO userDao;
	
	private RegisterController registerController;
	private ModifyController modifyController;
	private RegisterQueryController registerQueryController;
	
	public InitialController(Frame frame, UserModel user) {
		initialView = new InitialView();	
		template = new Template(2);
		userModel = user;
		
		try {
			userDao = new UserDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String nome = userDao.getName(UserModel.getPerfil(), UserModel.getCpf());
		
		template.setUserName(nome);
		
		this.frame = frame;
		
		mudarConteudo(initialView, template);
		buttonDefinition(this.frame);
	}
	
	public InitialController(Frame frame) {
		initialView = new InitialView();	
		template = new Template(2);
		this.frame = frame;

		try {
			userDao = new UserDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		String nome = userDao.getName(UserModel.getPerfil(), UserModel.getCpf());
		
		template.setUserName(nome);
				
		

		mudarConteudo(initialView, template);
		buttonDefinition(this.frame);
	}
	
	public void mudarConteudo(Component conteudo, Component template) {
		frame.getConteudo().removeAll();
		frame.getTemplate().removeAll();
		
		frame.getConteudo().add(conteudo);
		frame.getTemplate().add(template); 
		
		frame.getConteudo().revalidate();
		frame.getTemplate().revalidate();
		
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
				registerController = new RegisterController(frame,Integer.parseInt(userModel.getPerfil()));
			}
			
			@Override
			public void modifyQueryButton() throws SQLException {
				registerQueryController = new RegisterQueryController(frame,2);
			}
			
			@Override
			public void modifyPeopleButton() {
				modifyController = new ModifyController(frame,Integer.parseInt(userModel.getPerfil()));
			}
		});
		
		template.setListener(new ExitButtonListener() {
			
			@Override
			public void exit() {
				LoginController loginController = new LoginController(frame);				
			}
		});
	}

}
