package br.com.clinica.controller;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import br.com.clinica.dao.PatientDAO;
import br.com.clinica.dao.PsycologistDAO;
import br.com.clinica.dao.SecretaryDAO;
import br.com.clinica.listener.SearchButtonListener;
import br.com.clinica.listener.SelectButtonsListener;
import br.com.clinica.model.PatientModel;
import br.com.clinica.model.PsycologistModel;
import br.com.clinica.model.SecretaryModel;
import br.com.clinica.view.Frame;
import br.com.clinica.view.RegisterPeopleView;

public class RegisterPeopleController {
	
	private Frame frame;	
	
	private RegisterPeopleView registerPeopleView;
	
	private InitialController initialController;

	private PatientDAO patientDao;
	private PatientModel patientModel;
	
	private PsycologistDAO psycologistDao;
	private PsycologistModel psycologistModel;
	
	private SecretaryDAO secretaryDao;
	private SecretaryModel secretaryModel;
	
	public RegisterPeopleController(Frame frame,int p1, int p2) {
		registerPeopleView = new RegisterPeopleView(p1, p2);
		
		this.frame = frame;
		
		mudarConteudo(registerPeopleView);
		buttonDefinition(this.frame,p2, p1);
	}
	
	public void mudarConteudo(Component conteudo) {
		frame.getConteudo().removeAll();
		frame.getConteudo().add(conteudo);
		frame.getConteudo().revalidate();

		SwingUtilities.updateComponentTreeUI(frame);
	}
	
	public void buttonDefinition(Frame frame, int opt,int p1) { //P1 1-Paciente 2- Psicólogo 3- Secretária
		registerPeopleView.setListener(new SelectButtonsListener() {
			
			@Override
			public void save() {
				if(opt == 1) { //Se opt for 1 é MODIFICAR
					switch(p1) {
						case 1:
						case 2:
						case 3:
					}
				}else { //se opt for 2 é CADASTRAR
					switch(p1) {
						case 1: registerPatient();
								break;
						case 2:
						case 3:
					}
				}
				
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
		
		registerPeopleView.setListenerSearch(new SearchButtonListener() {
			
			@Override
			public void search() {
				System.out.println("Entrei!");
			}
		});
	}
	
	public void registerPatient() {

	}
	
}
