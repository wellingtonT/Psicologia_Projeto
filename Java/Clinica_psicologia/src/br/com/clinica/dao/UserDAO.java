package br.com.clinica.dao;

import java.util.ArrayList;

import br.com.clinica.model.UserModel;

public class UserDAO {
	
	private ArrayList<UserModel> usersData = new ArrayList<>();
	
	public void save(UserModel user) {
		usersData.add(user);
	}
	
	public ArrayList<UserModel> getAll() {
		return usersData;
	}
	
	public UserModel getUser(String cpf) {
		
		for (UserModel user : usersData) {
			if(user.getCpf() == cpf) {
				return user;
			}
		}
		
		return null;
		
	}
}
