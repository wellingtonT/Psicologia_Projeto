package br.com.clinica.controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import br.com.clinica.dao.UserDAO;
import br.com.clinica.listener.EnterButtonListener;
import br.com.clinica.model.UserModel;
import br.com.clinica.view.Frame;
import br.com.clinica.view.LoginView;
import br.com.clinica.view.Template;

public class LoginController {
	
	private LoginView loginView;
	private Template template;
	private Frame frame;
	private InitialController initialController;
	
	private UserDAO userDao;
	private UserModel userModel;	
	
	public LoginController() {
		frame = new Frame();
		loginView = new LoginView();
		userModel = new UserModel();
		template = new Template(1);
				
		loginView.setListener(new EnterButtonListener() {
			
			@Override
			public void enter() {
				enterButton();
			}
		});
		
		initApp();
	}
	
	public LoginController(Frame frame) {
		loginView = new LoginView();
		userModel = new UserModel();
		this.frame = frame;
		
		loginView.setListener(new EnterButtonListener() {
			
			@Override
			public void enter() {
				enterButton();
			}
		});
		
		mudarConteudo(loginView);
	}
	
	public void mudarConteudo(Component conteudo) {
		frame.getConteudo().removeAll();
		frame.getTemplate().removeAll();
		frame.getConteudo().add(conteudo); 
		frame.getConteudo().revalidate();
		
		SwingUtilities.updateComponentTreeUI(frame);
	}
	
	public void initApp() {
		frame.setTemplate(template);
		frame.setConteudo(loginView);
		frame.addComponent();
		frame.setVisible(true);
	}
	
	public void enterButton() {
		if(authenticat()) {
			initialController = new InitialController(frame, userModel);
		}else {
			JOptionPane.showMessageDialog(null, "Cpf ou senha inválidos!");
		}
		
	}
	
	public boolean authenticat() {
		try {
			userDao = new UserDAO();
			
			String cpfUser = loginView.getCpfField().getText();
			
			char[] passwordChar = loginView.getPasswordField().getPassword();
			String passwordUser = "";
			for (char c : passwordChar)	passwordUser += c;
			
			userModel = userDao.authenticatUser(cpfUser, passwordUser);
			
			if(userModel == null) return false;
			else return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

}
