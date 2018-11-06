package br.com.clinica.controller;

import java.awt.Component;

import javax.swing.SwingUtilities;

import br.com.clinica.listener.SearchButtonListener;
import br.com.clinica.listener.SelectButtonsListener;
import br.com.clinica.view.Frame;
import br.com.clinica.view.RegisterQueryView;

public class RegisterQueryController {
	
	private Frame frame;
	
	private RegisterQueryView registerQueryView;
	
	private InitialController initialController;
	
	public RegisterQueryController(Frame frame, int opt) {
		registerQueryView = new RegisterQueryView(opt);
		
		this.frame = frame;
		
		mudarConteudo(registerQueryView);
		
		buttonDefinition(this.frame,opt);
	}
	
	public void mudarConteudo(Component conteudo) {
		frame.getConteudo().removeAll();
		frame.getConteudo().add(conteudo);
		frame.getConteudo().revalidate();
		
		SwingUtilities.updateComponentTreeUI(frame);
	}
	
	public void buttonDefinition(Frame frame,int opt) {
		registerQueryView.setListener(new SelectButtonsListener() {
			
			@Override
			public void save() {
				if(opt == 1) { //Se opt for 1 é MODIFICAR
					
				}else { //se opt for 2 é CADASTRAR
					
				}
				System.out.println("Salvo!");
			}
			
			@Override
			public void clean() {
				//IMPLEMENTAR
				System.out.println("Limpo!");
			}
			
			@Override
			public void cancel() {
				initialController = new InitialController(frame);
			}
		});
		
		registerQueryView.setListenerSearch(new SearchButtonListener() {
			
			@Override
			public void search() {
				System.out.println("Entrei!");
			}
		});
		
	}
	
}
