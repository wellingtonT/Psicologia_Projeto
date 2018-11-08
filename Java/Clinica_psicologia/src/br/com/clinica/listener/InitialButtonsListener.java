package br.com.clinica.listener;

import java.sql.SQLException;

public interface InitialButtonsListener {
	void registerPeopleButton();
	void modifyPeopleButton();
	
	void registerQueryButton() throws SQLException;
	void modifyQueryButton() throws SQLException;
}
