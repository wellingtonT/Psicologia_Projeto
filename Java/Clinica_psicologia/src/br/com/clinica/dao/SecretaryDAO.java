package br.com.clinica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.clinica.model.PsycologistModel;
import br.com.clinica.model.SecretaryModel;

public class SecretaryDAO {
	
	private Connection connection;
	
	public SecretaryDAO() throws SQLException {
		connection = ConnectionUtil.getConnection();
	}
	
	public void save(SecretaryModel secretary) throws SQLException {

		String sql = "INSERT INTO secretaria"
				+ " (CPF, NOME, RUA, CIDADE, TELEFONE, SALARIO)"
				+ " VALUES (?, ?, ?, ?, ?, ?);";
		
		PreparedStatement prep = connection.prepareStatement(sql);
		
		prep.setString(1, secretary.getCpf());
		prep.setString(2, secretary.getNome());
		prep.setString(3, secretary.getRua());
		prep.setString(4, secretary.getCidade());
		prep.setString(5, secretary.getTelefone());
		prep.setString(6, secretary.getSalario());
		
		prep.execute();
	}
	
}
