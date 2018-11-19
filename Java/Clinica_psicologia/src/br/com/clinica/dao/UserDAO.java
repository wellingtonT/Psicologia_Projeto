package br.com.clinica.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.clinica.model.UserModel;

public class UserDAO {
	
	private Connection connection;
	
	public UserDAO() throws SQLException{
		connection = ConnectionUtil.getConnection();
	}
	
	public UserModel authenticatUser(String cpf, String password) {
		String sql = "SELECT * FROM usuario " + 
				"WHERE (cpf_psicologo LIKE '" + cpf +"' OR cpf_secretaria LIKE '" + cpf + "') AND senha = '" + password + "';";

		
		java.sql.Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet= statement.executeQuery(sql);
			
			resultSet.next();
			
			if(resultSet.getRow() > 0) {
				UserModel userModel = new UserModel();
				userModel.setPerfil(resultSet.getString("perfil"));
				userModel.setCpf(resultSet.getString("cpf_secretaria"));
				if(userModel.getCpf() == null) userModel.setCpf(resultSet.getString("cpf_psicologo"));
				return userModel;
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public String getName(String perfil, String cpf) {
		String tabela;
		String userName = null;
		
		if(Integer.parseInt(perfil) == 1) tabela = "secretaria";
		else tabela = "psicologo";
		
		String sql = "SELECT * FROM " + tabela + " "
				+ "WHERE cpf LIKE '" + cpf + "';";
				
		java.sql.Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				userName = resultSet.getString("nome");
			}
			
			return userName;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	

}
