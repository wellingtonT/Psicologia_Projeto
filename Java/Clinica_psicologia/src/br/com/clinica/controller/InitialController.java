package br.com.clinica.controller;

import java.awt.Component;

import javax.swing.JPanel;

import br.com.clinica.view.Frame;
import br.com.clinica.view.InitialView;
import br.com.clinica.view.Template;

public class InitialController {
	
	private InitialView initialView;
	private Template template;
	private Frame frame;
	
	public InitialController(Frame frame) {
		initialView = new InitialView();
		
		template = new Template(2);
		
		
		this.frame = frame;
	
		mudarTemplate(template);
		mudarConteudo(initialView);
		
	}
	
	public void mudarConteudo(Component conteudo) {
		frame.getConteudo().removeAll();
		frame.getConteudo().add(conteudo);
		frame.getConteudo().revalidate();
	}
	
	public void mudarTemplate(Component template) {
		frame.getTemplate().removeAll();
		frame.getTemplate().add(template);
//		frame.setTemplate(this.template);
		frame.getTemplate().revalidate();
	}
	
	
	
}
