package br.com.clinica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.clinica.model.PatientModel;
import br.com.clinica.model.PsycologistModel;
import br.com.clinica.model.SecretaryModel;


public class PsycologistDAO {
	
	private Connection connection;
	
	public PsycologistDAO() throws SQLException {
		connection = ConnectionUtil.getConnection();
	}
	
	public void save(PsycologistModel psycologist) throws SQLException {
		try {
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
			
			createUser(psycologist);
			
			JOptionPane.showMessageDialog(null, "Psicólogo cadastrado com sucesso! Senha: 123456");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar psicólogo!");
		}
			
	}
	
	public void createUser(PsycologistModel psycologist) {
		try {
			String sql = "INSERT INTO usuario "
					+ " (perfil, senha, cpf_psicologo) "
					+ " VALUES ('" + 2 +"', '" + 123456 + "', '" + psycologist.getCpf() + "');";
			
			PreparedStatement prep = connection.prepareStatement(sql);
			
			prep.execute();
		}catch(SQLException e) {
			
		}
	}
	
	public void update(PsycologistModel psycologist) {
		String sql = "UPDATE psicologo "
				+ "SET nome = '" + psycologist.getNome() + "', "
				+ "rua = '" + psycologist.getRua() + "', "
				+ "cidade = '" + psycologist.getCidade() + "', "
				+ "telefone = '" + psycologist.getTelefone() + "',"
				+ "salario = '" + psycologist.getSalario() + "', "
				+ "crp = '" + psycologist.getCrp() + "' "
				+ "WHERE cpf = '" + psycologist.getCpf() + "';";
		
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.execute();
			
			JOptionPane.showMessageDialog(null, "Psicólogo atualizado com sucesso!");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar o psicólogo.");
		}
	
	}
	
	public String cpfPsycologist(String name) {
		String sql = "SELECT cpf FROM psicologo "
				+ "WHERE nome LIKE '" + name + "';";
		
		java.sql.Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				return resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public PsycologistModel getPeople(String cpf) {
		PsycologistModel psycologistModel = new PsycologistModel();
		
		String sql = "SELECT * FROM psicologo "
				+ "WHERE cpf LIKE '" + cpf + "';";
		
		
		
		try {
			java.sql.Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			resultSet.next();
			
			if(resultSet.getRow() > 0) {
				psycologistModel.setNome(resultSet.getString("nome"));
				psycologistModel.setCpf(resultSet.getString("cpf"));
				psycologistModel.setRua(resultSet.getString("rua"));
				psycologistModel.setCidade(resultSet.getString("cidade"));
				psycologistModel.setTelefone(resultSet.getString("telefone"));
				psycologistModel.setCrp(resultSet.getString("crp"));
				psycologistModel.setSalario(resultSet.getString("salario"));
				
				return psycologistModel;
				
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public String[] getAllPsycologistsName() {
		String names[] = null;
		ArrayList<String> list = new ArrayList<>();
		int i = 0;
		
		String sql = "SELECT * FROM psicologo WHERE nome <> 'Gerente'";
		
				
		try {
			java.sql.Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				list.add(resultSet.getString("nome"));
			}
			
			names = new String[list.size()];
			
			for (String string : list) {
				names[i] = string;
				i++;
			}
			
			
			return names;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
	

