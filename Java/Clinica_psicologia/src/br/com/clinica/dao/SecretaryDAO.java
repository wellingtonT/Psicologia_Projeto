package br.com.clinica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.clinica.model.PsycologistModel;
import br.com.clinica.model.SecretaryModel;

public class SecretaryDAO {
	
	private Connection connection;
	
	public SecretaryDAO() throws SQLException {
		connection = ConnectionUtil.getConnection();
	}
	
	public void save(SecretaryModel secretary) throws SQLException {

		try {
			String sql = "INSERT INTO secretaria "
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
			
			createUser(secretary);
			JOptionPane.showMessageDialog(null, "Secretária cadastrada com sucesso! Senha: 123456");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar secretária.");
		}
		
		
		
	}
	
	public void createUser(SecretaryModel secretary) {
		try {
			String sql = "INSERT INTO usuario "
					+ " (perfil, senha, cpf_secretaria) "
					+ " VALUES ('" + 1 +"', '" + 123456 + "', '" + secretary.getCpf() + "');";
			
			PreparedStatement prep = connection.prepareStatement(sql);
			
			System.out.println(sql);
			System.out.println(secretary.getCpf());
			
			prep.execute();
		}catch(SQLException e) {
		}
	}
	
	public SecretaryModel getPeople(String cpf) {
		SecretaryModel secretaryModel = new SecretaryModel();
		
		String sql = "SELECT * FROM secretaria "
				+ "WHERE cpf LIKE '" + cpf + "';";
		
		
		
		try {
			java.sql.Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			resultSet.next();
			
			if(resultSet.getRow() > 0) {
				secretaryModel.setNome(resultSet.getString("nome"));
				secretaryModel.setCpf(resultSet.getString("cpf"));
				secretaryModel.setRua(resultSet.getString("rua"));
				secretaryModel.setCidade(resultSet.getString("cidade"));
				secretaryModel.setTelefone(resultSet.getString("telefone"));
				secretaryModel.setSalario(resultSet.getString("salario"));
				
				return secretaryModel;
				
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public void update(SecretaryModel secretary) {
		String sql = "UPDATE secretaria "
				+ "SET nome = '" + secretary.getNome() + "', "
				+ "rua = '" + secretary.getRua() + "', "
				+ "cidade = '" + secretary.getCidade() + "', "
				+ "telefone = '" + secretary.getTelefone() + "',"
				+ "salario = '" + secretary.getSalario() + "' "
				+ "WHERE cpf = '" + secretary.getCpf() + "';";
		
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.execute();
			
			JOptionPane.showMessageDialog(null, "Secretária atualizada com sucesso!");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar a secretária.");
		}
	}
	
}
