package br.com.clinica.controller;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import br.com.clinica.dao.PsycologistDAO;
import br.com.clinica.dao.QueryDAO;
import br.com.clinica.listener.SearchButtonListener;
import br.com.clinica.listener.SelectButtonsListener;
import br.com.clinica.model.PsycologistModel;
import br.com.clinica.model.QueryModel;
import br.com.clinica.model.UserModel;
import br.com.clinica.view.Frame;
import br.com.clinica.view.RegisterQueryView;

public class RegisterQueryController {
	
	private Frame frame;
	
	private RegisterQueryView registerQueryView;

	private QueryDAO queryDao;
	private QueryModel queryModel;
	private PsycologistModel psycologistModel;
	private PsycologistDAO psycologistDao;
	
	private InitialController initialController;
	
	public RegisterQueryController(Frame frame, int opt) throws SQLException {
		registerQueryView = new RegisterQueryView(opt);
		queryDao = new QueryDAO();
		psycologistDao = new PsycologistDAO();
				
		this.frame = frame;
		
		setPsycologists();
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
				
				if(opt == 2) { //Se opt for 2 � MODIFICAR
					modifyQuery();
				}else { //se opt for 1 � CADASTRAR
					registerQuery();
				}
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
		boolean save = false;
		getFields();
		
		try {
			save = queryDao.save(queryModel);
			clearFields();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void modifyQuery() {
		queryModel = new QueryModel();
		
		getFields();
		
		queryDao.update(queryModel);
		
		clearFields();		
	}
	
	public void searchQuery() {
		queryModel = new QueryModel();
		psycologistModel = new PsycologistModel();
		
		String cpf = registerQueryView.getLocationField().getText();
		
		queryModel = queryDao.getQuery(cpf);
		
		psycologistModel = psycologistDao.getPeople(queryModel.getNamePsycologist());		
		
		registerQueryView.getCpfField().setText(queryModel.getCpfPatient());
		registerQueryView.getDayField().setText(queryModel.getDay());
		registerQueryView.getYearField().setText(queryModel.getYear());
		registerQueryView.getPsycologistBox().setSelectedItem(psycologistModel.getNome());
		registerQueryView.getHourBox().setSelectedItem(queryModel.getHour());
		registerQueryView.getMonthBox().setSelectedItem(getMonth(queryModel.getMonth()));		
	}
	
	public String getMonth(String month) {
		String dateMonth = null;
		
		switch(month) {
			case "1": dateMonth = "Janeiro";
					break;
			case "2": dateMonth = "Fevereiro";
					break;
			case "3": dateMonth = "Mar�o";
					break;
			case "4": dateMonth = "Abril";
					break;
			case "5": dateMonth = "Maio";
					break;
			case "6": dateMonth = "Junho";
					break;
			case "7": dateMonth = "Julho";
					break;
			case "8": dateMonth = "Agosto";
					break;
			case "9": dateMonth = "Setembro";
					break;
			case "10": dateMonth = "Outubro";
					break;
			case "11": dateMonth = "Novembro";
					break;
			case "12": dateMonth = "Dezembro";
		}
		
		return dateMonth;
	}
	
	public void setPsycologists(){
		String names[] = null;
		names = psycologistDao.getAllPsycologistsName();
		
		registerQueryView.setPsycologists(names);
		
	}
}
