package br.com.clinica.controller;

import java.awt.Component;

import javax.swing.SwingUtilities;

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

		mudarConteudo(initialView, template);
		
	}
	
	public void mudarConteudo(Component conteudo, Component template) {
		frame.getConteudo().removeAll();
		frame.getTemplate().removeAll();
		
		frame.getConteudo().add(conteudo);
		frame.getTemplate().add(template); //<-- AQUI É O PROBLEMA
		
		frame.getConteudo().revalidate();
		frame.getTemplate().revalidate();
		
		SwingUtilities.updateComponentTreeUI(frame);
	}

}
