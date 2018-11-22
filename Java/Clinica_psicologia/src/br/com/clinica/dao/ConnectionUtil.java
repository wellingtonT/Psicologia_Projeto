package br.com.clinica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static final String USER = "postgres";
	private static final String PASSWORD = "23121996";
	
	public static Connection getConnection() throws SQLException {
		//PORTA LINUX 5433
		String url = "jdbc:postgresql://localhost:5433/Psicologia";
		
		Properties properties = new Properties();
		properties.setProperty("user", USER);
		properties.setProperty("password", PASSWORD);
		
		return DriverManager.getConnection(url, properties);
	}
	
}
