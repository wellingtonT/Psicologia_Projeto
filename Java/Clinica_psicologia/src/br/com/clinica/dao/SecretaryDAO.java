package br.com.clinica.dao;

import java.util.ArrayList;

import br.com.clinica.model.SecretaryModel;
import br.com.clinica.model.UserModel;

public class SecretaryDAO {
	
	private ArrayList<SecretaryModel> secretaryData = new ArrayList<>();
	
	public void save(SecretaryModel secretary) {
		secretaryData.add(secretary);
	}
	
	public ArrayList<SecretaryModel> getAll(){
		return secretaryData;
	}
	
	public SecretaryModel getSecretary(String cpf) {
		
		for (SecretaryModel secretary : secretaryData) {
			if(secretary.getCpf() == cpf) {
				return secretary;
			}
		}
		
		return null;
	}
	
}
