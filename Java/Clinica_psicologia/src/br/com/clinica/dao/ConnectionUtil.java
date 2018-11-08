package br.com.clinica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static final String USER = "postgres";
	private static final String PASSWORD = "123456";
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost/Psicologia";
		
		Properties properties = new Properties();
		properties.setProperty("user", USER);
		properties.setProperty("password", PASSWORD);
		
		return DriverManager.getConnection(url, properties);
	}
	
}
