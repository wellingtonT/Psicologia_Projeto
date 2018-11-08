package br.com.clinica.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import br.com.clinica.model.QueryModel;


public class QueryDAO {
	
	private Connection connection;
	
	public QueryDAO() throws SQLException{
		connection = ConnectionUtil.getConnection();
	}
	
	public void save(QueryModel query) throws SQLException {
		PatientDAO patientDao = new PatientDAO();
		
		boolean a = patientDao.searchPatient(query.getCpfPatient());
		
		System.out.println("A = " + a);
		
		int mes = 0;
		String dateQuery;
		
		switch(query.getMonth()) {
			case "Janeiro": mes = 1; break;
			case "Fevereiro": mes = 2; break;
			case "Março": mes = 3; break;
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
		
		String sql = "INSERT INTO consulta"
				+ " (DATA_AGENDADA, HORA_AGENDADA, CPF_PACIENTE, CPF_PSICOLOGO, CPF_SECRETARIA)"
				+ " VALUES (?, ?, ?, ?, ?);";
		
		PreparedStatement prep = connection.prepareStatement(sql);
		
		prep.setDate(1, date);
		prep.setTime(2, time);
		prep.setString(3, query.getCpfPatient());
		prep.setString(4, query.getCpfPsycologist());
		prep.setString(5, "5241");

		prep.execute();
	}

}
