package br.com.clinica.controller;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import br.com.clinica.dao.QueryDAO;
import br.com.clinica.listener.SearchButtonListener;
import br.com.clinica.listener.SelectButtonsListener;
import br.com.clinica.model.QueryModel;
import br.com.clinica.view.Frame;
import br.com.clinica.view.RegisterQueryView;

public class RegisterQueryController {
	
	private Frame frame;
	
	private RegisterQueryView registerQueryView;

	private QueryDAO queryDao;
	private QueryModel queryModel;
	
	private InitialController initialController;
	
	public RegisterQueryController(Frame frame, int opt) throws SQLException {
		registerQueryView = new RegisterQueryView(opt);
		queryDao = new QueryDAO();
		
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
				
				if(opt == 2) { //Se opt for 2 é MODIFICAR
					modifyQuery();
				}else { //se opt for 1 é CADASTRAR
					registerQuery();
				}
				System.out.println("Salvo!");
			}
			
			@Override
			public void clean() {
				clearFields();
			}
			
			@Override
			public void cancel() {
				initialController = new InitialController(frame);
			}
		});
		
		registerQueryView.setListenerSearch(new SearchButtonListener() {
			
			@Override
			public void search() {
				searchQuery();
			}
		});
	}
	
	public void clearFields() {
		registerQueryView.getCpfField().setText(null);
		registerQueryView.getDayField().setText(null);
		registerQueryView.getYearField().setText(null);
		registerQueryView.getLocationField().setText(null);
	}
	
	public void getFields() {
		queryModel.setCpfPatient(registerQueryView.getCpfField().getText());
		queryModel.setCpfPsycologist(registerQueryView.getPsycologistBox().getSelectedItem().toString());
		queryModel.setDay(registerQueryView.getDayField().getText());
		queryModel.setMonth(registerQueryView.getMonthBox().getSelectedItem().toString());
		queryModel.setYear(registerQueryView.getYearField().getText());
		queryModel.setHour(registerQueryView.getHourBox().getSelectedItem().toString());
		
	}
	
	public void registerQuery() {
		queryModel = new QueryModel();
		
		getFields();
		
//		System.out.println(queryModel.getCpfPatient());
//		System.out.println(queryModel.getCpfPsycologist());
//		System.out.println(queryModel.getCpfSecretary());
//		System.out.println(queryModel.getDay());
//		System.out.println(queryModel.getMonth());
//		System.out.println(queryModel.getYear());		
//		System.out.println(queryModel.getHour());
		try {
			queryDao.save(queryModel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clearFields();
	}
	
	public void modifyQuery() {
		queryModel = new QueryModel();
		
		getFields();
		
		clearFields();		
	}
	
	public void searchQuery() {
		queryModel = new QueryModel();
		
//		registerQueryView.getPsycologistBox().setSelectedItem("Teste3");
	}
}
