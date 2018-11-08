package br.com.clinica.listener;

import java.sql.SQLException;

public interface RegisterPeopleButtonsListener {
	void registerPatient() throws SQLException;
	void registerPsycologist() throws SQLException;
	void registerSecretary() throws SQLException;
	void back();
}
