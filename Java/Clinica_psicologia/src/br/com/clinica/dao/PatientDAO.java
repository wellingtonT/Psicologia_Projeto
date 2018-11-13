package br.com.clinica.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.clinica.model.PatientModel;

public class PatientDAO {

	private Connection connection;
	
	public PatientDAO() throws SQLException {
		connection = ConnectionUtil.getConnection();
	}
	
	public void save(PatientModel patient) throws SQLException {

		try {
			String sql = "INSERT INTO paciente "
					+ " (CPF, NOME, RUA, CIDADE, TELEFONE)"
					+" VALUES (?, ?, ?, ?, ?);";
			
			PreparedStatement prep = connection.prepareStatement(sql);
			
			prep.setString(1, patient.getCpf());
			prep.setString(2, patient.getNome());
			prep.setString(3, patient.getRua());
			prep.setString(4, patient.getCidade());
			prep.setString(5, patient.getTelefone());
			
			prep.execute();
			saveMedication(patient);
			JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar paciente.");
		}
	}
	
	public void saveMedication(PatientModel patient) {
		String sql = "INSERT INTO medicamento "
				+ " (NOME, DOSE, CPF_PACIENTE)"
				+" VALUES (?, ?, ?);";
		
		
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			
			prep.setString(1, patient.getMedicamento1());
			prep.setString(2, patient.getDosagem1());
			prep.setString(3, patient.getCpf());
			
			prep.execute();
			
			prep.setString(1, patient.getMedicamento2());
			prep.setString(2, patient.getDosagem2());
			prep.setString(3, patient.getCpf());
			
			prep.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteMedication(PatientModel patient) {
		String sql = "DELETE FROM medicamento "
				+ "WHERE cpf_paciente = '" + patient.getCpf() + "';";
		
		
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			
			prep.execute();
			
		} catch (SQLException e) {
			System.out.println("Erro ao deletar o medicamento.");
			e.printStackTrace();
		}
	}
	
	public boolean existPatient(String cpf) throws SQLException {
		String sql = "SELECT * FROM paciente "
				+ "WHERE cpf LIKE '" + cpf + "';";
		
		java.sql.Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		resultSet.next();
		
		if(resultSet.getRow() > 0) return true;
		else return false;
		
	}
	
	public PatientModel getPeople(String cpf) {
		PatientModel patientModel = new PatientModel();
		
		String sql = "SELECT * FROM paciente "
				+ "WHERE cpf LIKE '" + cpf + "';";
		
		try {
			java.sql.Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			resultSet.next();
			
			if(resultSet.getRow() > 0) {
				patientModel.setNome(resultSet.getString("nome"));
				patientModel.setCpf(resultSet.getString("cpf"));
				patientModel.setRua(resultSet.getString("rua"));
				patientModel.setCidade(resultSet.getString("cidade"));
				patientModel.setTelefone(resultSet.getString("telefone"));
				
				sql = "SELECT * FROM medicamento "
						+ "WHERE cpf_paciente LIKE '" + patientModel.getCpf() +"';";
				
				resultSet = statement.executeQuery(sql);
				
				System.out.println("medicamento: " + medicationExist(cpf));
				
				if(medicationExist(cpf) == 1) {
					resultSet.next();
					
					patientModel.setMedicamento1(resultSet.getString("nome"));
					patientModel.setDosagem1(resultSet.getString("dose"));
					
					
				}else {
					if(medicationExist(cpf) == 2) {
						resultSet.next();
						
						patientModel.setMedicamento1(resultSet.getString("nome"));
						patientModel.setDosagem1(resultSet.getString("dose"));
						
						resultSet.next();
						
						patientModel.setMedicamento2(resultSet.getString("nome"));
						patientModel.setDosagem2(resultSet.getString("dose"));
						
					}
				}			
				
				return patientModel;
				
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	
	public void update(PatientModel patient){
		String sql = "UPDATE paciente "
				+ "SET nome = '" + patient.getNome() + "', "
				+ "rua = '" + patient.getRua() + "', "
				+ "cidade = '" + patient.getCidade() + "', "
				+ "telefone = '" + patient.getTelefone() + "' "
				+ "WHERE cpf = '" + patient.getCpf() + "';";
		
		
		
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.execute();			
			
//			deleteMedication(patient);
//			saveMedication(patient);
			
			sql = "UPDATE medicamento "
					+ "SET nome = '" + patient.getMedicamento1() + "', "
					+ "dose = '" + patient.getDosagem1() + "' "
					+ "WHERE cpf_paciente = '" + patient.getCpf() + "' AND id = ("
					+ "SELECT id FROM medicamento " 
					+ " WHERE cpf_paciente = '" + patient.getCpf() + "' " 
					+ "	ORDER BY id ASC LIMIT 1);";
			
			prep = connection.prepareStatement(sql);
			prep.execute();
			
			sql = "UPDATE medicamento "
					+ "SET nome = '" + patient.getMedicamento2() + "', "
					+ "dose = '" + patient.getDosagem2() + "' "
					+ "WHERE cpf_paciente = '" + patient.getCpf() + "' AND id = ("  
					+ "SELECT id FROM medicamento "  
					+ " WHERE cpf_paciente = '" + patient.getCpf() + "' "  
					+ "	ORDER BY id DESC LIMIT 1);";
			
			prep = connection.prepareStatement(sql);
			prep.execute();
			
			
			JOptionPane.showMessageDialog(null, "Paciente atualizado com sucesso!");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar o paciente.");
		}
		
	}
	
	public int medicationExist(String cpf) {
		int lines = 0;
		
		String sql = "SELECT * FROM medicamento "
				+ "WHERE cpf_paciente LIKE '" + cpf + "';";
		
		
		try {
			java.sql.Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				lines++;
			}
			
			return lines;
		} catch (SQLException e) {
			System.out.println("Erro ao verificar medicamentos");
			e.printStackTrace();
		}
		
		return lines;		
	}
	
}
