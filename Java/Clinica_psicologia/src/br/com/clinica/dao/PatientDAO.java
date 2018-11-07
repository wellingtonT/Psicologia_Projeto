package br.com.clinica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.clinica.model.PatientModel;

public class PatientDAO {

	private ArrayList<PatientModel> patientData = new ArrayList<>(); 
	
	
	public void save(PatientModel patient) {
		patientData.add(patient);
	}
	
	
	public ArrayList<PatientModel> getAll(){
		return patientData;
	}
	
	public PatientModel getPatient(String cpf) {
		
		for (PatientModel patient : patientData) {
			if(patient.getCpf() == cpf) {
				return patient;
			}
		}
		
		return null;
		
	}
	
	
}
