package br.com.clinica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.clinica.model.PsycologistModel;


public class PsycologistDAO {
	
	private Connection connection;
	
	public PsycologistDAO() throws SQLException {
		connection = ConnectionUtil.getConnection();
	}
	
	public void save(PsycologistModel psycologist) throws SQLException {

		String sql = "INSERT INTO psicologo"
				+ " (CPF, NOME, RUA, CIDADE, TELEFONE, SALARIO, CRP)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?);";
		
		PreparedStatement prep = connection.prepareStatement(sql);
		
		prep.setString(1, psycologist.getCpf());
		prep.setString(2, psycologist.getNome());
		prep.setString(3, psycologist.getRua());
		prep.setString(4, psycologist.getCidade());
		prep.setString(5, psycologist.getTelefone());
		prep.setString(6, psycologist.getSalario());
		prep.setString(7, psycologist.getCrp());
		
		prep.execute();
	}
	
	public String cpfPsycologist(String name) {
		String sql = "SELECT cpf FROM psicologo "
				+ "WHERE nome LIKE '" + name + "';";
		
		java.sql.Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			resultSet.next();
			return resultSet.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
