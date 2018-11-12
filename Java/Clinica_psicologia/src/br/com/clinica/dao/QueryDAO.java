package br.com.clinica.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

import javax.swing.JOptionPane;

import br.com.clinica.model.QueryModel;


public class QueryDAO {
	
	private Connection connection;
	
	public QueryDAO() throws SQLException{
		connection = ConnectionUtil.getConnection();
	}
	
	public boolean save(QueryModel query) throws SQLException {
		PatientDAO patientDao = new PatientDAO();
		PsycologistDAO psycologistDao = new PsycologistDAO();
		
		boolean existPatient = patientDao.existPatient(query.getCpfPatient());
		
		if(existPatient) {
			
			int mes = 0;
			String dateQuery;
			
			switch(query.getMonth()) {
				case "Janeiro": mes = 1; break;
				case "Fevereiro": mes = 2; break;
				case "Marï¿½o": mes = 3; break;
				case "Abril": mes = 4; break;
				case "Maio": mes = 5; break;
				case "Junho": mes = 6; break;
				case "Julho": mes = 7; break;
				case "Agosto": mes = 8; break;
				case "Setembro": mes = 9; break;
				case "Outubro": mes = 10; break;
				case "Novembro": mes = 11; break;
				case "Dezembro": mes = 12; 
			}
			
			dateQuery = query.getYear() + "-" + mes + "-" + query.getDay(); 
			Date date = Date.valueOf(dateQuery);
			
			LocalTime localTime = LocalTime.parse(query.getHour());
			Time time = Time.valueOf(localTime);
			
			String cpfPsycologist = psycologistDao.cpfPsycologist(query.getNamePsycologist());
			
			boolean existQuery = existQuery(date, time, cpfPsycologist);
			
			if(!existQuery) {
				String sql = "INSERT INTO consulta"
						+ " (DATA_AGENDADA, HORA_AGENDADA, CPF_PACIENTE, CPF_PSICOLOGO, CPF_SECRETARIA)"
						+ " VALUES (?, ?, ?, ?, ?);";
				
				PreparedStatement prep = connection.prepareStatement(sql);
				
				prep.setDate(1, date);
				prep.setTime(2, time);
				prep.setString(3, query.getCpfPatient());
				prep.setString(4, cpfPsycologist);
				prep.setString(5, "5241");

				prep.execute();
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "O horário "+time+" , do psicólogo " +query.getNamePsycologist()+" não está disponível!");
				return false;
			}				
		}else {
			JOptionPane.showMessageDialog(null, "Paciente não existe!");
			return false;
		}
	}
	
	public boolean existQuery(Date date, Time time, String cpf) {
		String sql = "SELECT * FROM consulta "
				+ "WHERE data_agendada::date = '" + date + "' "
				+ "AND hora_agendada = '" + time + "' "
				+ "AND cpf_psicologo LIKE '" + cpf + "';";
				
		System.out.println("Data: " + date);
		System.out.println("Hora: " + time);
		System.out.println("cpf: " + cpf);
		
		java.sql.Statement statement;
		try {
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			resultSet.next();
			
			if(resultSet.getRow() > 0) return true;
			else return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
