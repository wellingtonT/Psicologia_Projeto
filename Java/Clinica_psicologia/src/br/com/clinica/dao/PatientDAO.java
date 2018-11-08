package br.com.clinica.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.clinica.model.PatientModel;

public class PatientDAO {

	private Connection connection;
	
	public PatientDAO() throws SQLException {
		connection = ConnectionUtil.getConnection();
	}
	
	public void save(PatientModel patient) throws SQLException {

		String sql = "INSERT INTO paciente"
				+ " (CPF, NOME, RUA, CIDADE, TELEFONE)"
				+" VALUES (?, ?, ?, ?, ?);";
		
		PreparedStatement prep = connection.prepareStatement(sql);
		
		prep.setString(1, patient.getCpf());
		prep.setString(2, patient.getNome());
		prep.setString(3, patient.getRua());
		prep.setString(4, patient.getCidade());
		prep.setString(5, patient.getTelefone());
		
		prep.execute();
	}
	
	public boolean searchPatient(String cpf) throws SQLException {
		String sql = "SELECT NOME FROM paciente"
				+ "WHERE CPF = '" + cpf + "';";
		
		java.sql.Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		System.out.println("Linhas: " + resultSet.getRow());
		
		if(resultSet.getRow() > 0) return true;
		else return false;
		
	}
	
}
