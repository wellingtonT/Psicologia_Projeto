package br.com.clinica.controller;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JOptionPane;
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
	
	public RegisterPeopleController(Frame frame,int p1, int p2) throws SQLException {
		registerPeopleView = new RegisterPeopleView(p1, p2);
		patientDao = new PatientDAO();
		psycologistDao = new PsycologistDAO();
		secretaryDao = new SecretaryDAO();
		
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
	
	public void buttonDefinition(Frame frame, int opt,int p1) { //P1 1-Paciente 3- Psic�logo 2- Secret�ria
		registerPeopleView.setListener(new SelectButtonsListener() {
			
			@Override
			public void save() {
				if(opt == 1) { //Se opt for 1 � MODIFICAR
					switch(p1) {
						case 1: modifyPatient();
								break;
						case 3: modifyPsycologist();
								break;
						case 2: modifySecretary();
					}
				}else { //se opt for 2 � CADASTRAR
					switch(p1) {
						case 1: registerPatient();
								break;
						case 3: registerPsycologist();
								break;
						case 2: registerSecretary();
					}
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

			@Override
			public void delete() {
				if(p1 == 3) deletePsycologist();
				else if(p1 == 2) deleteSecretary();
				
			}
		});
		
		registerPeopleView.setListenerSearch(new SearchButtonListener() {
			
			@Override
			public void search() {
				searchPeople(p1);
			}
		});
	}
	
	public void deletePsycologist() {
		getPsycologistFields();
		
		if(verificationPsycologist()) {
			psycologistDao.delete(psycologistModel);
		}
	}
	
	public void deleteSecretary() {
		getSecretaryFields();
		
		if(verificationSecretary()) {
			secretaryDao.delete(secretaryModel);
		}
	}
	
	public void clearFields() {
		registerPeopleView.getNameField().setText(null);
		registerPeopleView.getCpfField().setText(null);
		registerPeopleView.getStreetField().setText(null);
		registerPeopleView.getCityField().setText(null);
		registerPeopleView.getPhoneField().setText(null);
		registerPeopleView.getMedicationField1().setText(null);
		registerPeopleView.getMedicationField2().setText(null);
		registerPeopleView.getDosageField1().setText(null);
		registerPeopleView.getDosageField2().setText(null);
		registerPeopleView.getSalaryField().setText(null);
		registerPeopleView.getCrpField().setText(null);
		registerPeopleView.getLocationField().setText(null);
	}
	
	
	public void getPatientFields() {
		patientModel.setNome(registerPeopleView.getNameField().getText());
		patientModel.setCpf(registerPeopleView.getCpfField().getText());
		patientModel.setRua(registerPeopleView.getStreetField().getText());
		patientModel.setCidade(registerPeopleView.getCityField().getText());
		patientModel.setTelefone(registerPeopleView.getPhoneField().getText());
		patientModel.setMedicamento1(registerPeopleView.getMedicationField1().getText());
		patientModel.setDosagem1(registerPeopleView.getDosageField1().getText());
		patientModel.setMedicamento2(registerPeopleView.getMedicationField2().getText());
		patientModel.setDosagem2(registerPeopleView.getDosageField2().getText());
	}
	
	public boolean verificationPatient() {
		if(patientModel.getNome().equals("")) return false;
		if(patientModel.getCpf().equals("")) return false;
		if(patientModel.getRua().equals("")) return false;
		if(patientModel.getCidade().equals("")) return false;
		if(patientModel.getTelefone().equals("")) return false;
		return true;
	}
	
	public void registerPatient() {
		patientModel = new PatientModel();
		
		getPatientFields();
		
		if(verificationPatient()) {
			try {
				if(patientDao.save(patientModel)) clearFields();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Há algum campo em branco, favor preencher.");
		}
		
	}
	
	public void getPsycologistFields() {
		psycologistModel.setNome(registerPeopleView.getNameField().getText());
		psycologistModel.setCpf(registerPeopleView.getCpfField().getText());
		psycologistModel.setRua(registerPeopleView.getStreetField().getText());
		psycologistModel.setCidade(registerPeopleView.getCityField().getText());
		psycologistModel.setTelefone(registerPeopleView.getPhoneField().getText());
		psycologistModel.setSalario(registerPeopleView.getSalaryField().getText());
		psycologistModel.setCrp(registerPeopleView.getCrpField().getText());
	}
	
	public void registerPsycologist() {
		psycologistModel = new PsycologistModel();
		
		getPsycologistFields();
		if(verificationPsycologist()) {
			try {
				if(psycologistDao.save(psycologistModel)) clearFields();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Há algum campo em branco, favor preencher.");
		}
		
		
	}
	
	public boolean verificationPsycologist() {
		if(psycologistModel.getNome().equals("")) return false;
		if(psycologistModel.getCpf().equals("")) return false;
		if(psycologistModel.getRua().equals("")) return false;
		if(psycologistModel.getCidade().equals("")) return false;
		if(psycologistModel.getTelefone().equals("")) return false;
		if(psycologistModel.getSalario().equals("")) return false;
		if(psycologistModel.getCrp().equals("")) return false;
		return true;
	}
	
	public void getSecretaryFields() {
		secretaryModel.setNome(registerPeopleView.getNameField().getText());
		secretaryModel.setCpf(registerPeopleView.getCpfField().getText());
		secretaryModel.setRua(registerPeopleView.getStreetField().getText());
		secretaryModel.setCidade(registerPeopleView.getCityField().getText());
		secretaryModel.setTelefone(registerPeopleView.getPhoneField().getText());
		secretaryModel.setSalario(registerPeopleView.getSalaryField().getText());
	}
	
	public void registerSecretary() {
		secretaryModel = new SecretaryModel();
		
		getSecretaryFields();
		if(verificationSecretary()) {
			try {
				if(secretaryDao.save(secretaryModel)) clearFields();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Há algum campo em branco, favor preencher.");
		}
		
		
	}
	
	public boolean verificationSecretary() {
		if(secretaryModel.getNome().equals("")) return false;
		if(secretaryModel.getCpf().equals("")) return false;
		if(secretaryModel.getRua().equals("")) return false;
		if(secretaryModel.getCidade().equals("")) return false;
		if(secretaryModel.getTelefone().equals("")) return false;
		if(secretaryModel.getSalario().equals("")) return false;
		return true;
	}
	
	public void searchPeople(int p1) {
		String cpf = registerPeopleView.getLocationField().getText();
		
		if(p1 == 1) {
			patientModel = patientDao.getPeople(cpf);
			if(patientModel != null) insertFields(patientModel);
			else JOptionPane.showMessageDialog(null, "Paciente n�o encontrado.");
		}else {	
			if(p1 == 2 ) {
				secretaryModel = secretaryDao.getPeople(cpf);
				if(secretaryModel != null) insertFields(secretaryModel);
				else JOptionPane.showMessageDialog(null, "Secret�ria n�o encontrada.");
			}else {
				if(p1 == 3) {
					psycologistModel = psycologistDao.getPeople(cpf);
					if(psycologistModel != null) insertFields(psycologistModel);
					else JOptionPane.showMessageDialog(null, "Psic�logo n�o encontrado.");
				}
			}
		}
		
	}
	
	public void insertFields(PatientModel patientModel){
		registerPeopleView.getNameField().setText(patientModel.getNome());
		registerPeopleView.getCpfField().setText(patientModel.getCpf());
		registerPeopleView.getStreetField().setText(patientModel.getRua());
		registerPeopleView.getCityField().setText(patientModel.getCidade());
		registerPeopleView.getPhoneField().setText(patientModel.getTelefone());
		registerPeopleView.getMedicationField1().setText(patientModel.getMedicamento1());
		registerPeopleView.getDosageField1().setText(patientModel.getDosagem1());
		registerPeopleView.getMedicationField2().setText(patientModel.getMedicamento2());
		registerPeopleView.getDosageField2().setText(patientModel.getDosagem2());
	}
	
	public void insertFields(PsycologistModel psycologistModel){
		registerPeopleView.getNameField().setText(psycologistModel.getNome());
		registerPeopleView.getCpfField().setText(psycologistModel.getCpf());
		registerPeopleView.getStreetField().setText(psycologistModel.getRua());
		registerPeopleView.getCityField().setText(psycologistModel.getCidade());
		registerPeopleView.getPhoneField().setText(psycologistModel.getTelefone());
		registerPeopleView.getCrpField().setText(psycologistModel.getCrp());
		registerPeopleView.getSalaryField().setText(psycologistModel.getSalario());
	}
	
	public void insertFields(SecretaryModel secretaryModel){
		registerPeopleView.getNameField().setText(secretaryModel.getNome());
		registerPeopleView.getCpfField().setText(secretaryModel.getCpf());
		registerPeopleView.getStreetField().setText(secretaryModel.getRua());
		registerPeopleView.getCityField().setText(secretaryModel.getCidade());
		registerPeopleView.getPhoneField().setText(secretaryModel.getTelefone());
		registerPeopleView.getSalaryField().setText(secretaryModel.getSalario());
	}
	
	public void modifyPatient() {
		getPatientFields();	

		try{
			patientDao.update(patientModel);
			clearFields();
		}catch (Exception e) {
			
		}
	
	}
	
	public void modifyPsycologist() {
		getPsycologistFields();
		
		psycologistDao.update(psycologistModel);
	}
	
	public void modifySecretary() {
		getSecretaryFields();
		
		secretaryDao.update(secretaryModel);
	}
	
}
