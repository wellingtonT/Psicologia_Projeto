package br.com.clinica.dao;

import java.util.ArrayList;

import br.com.clinica.model.PsycologistModel;
import br.com.clinica.model.QueryModel;


public class QueryDAO {
	
	private ArrayList<QueryModel> queryData = new ArrayList<>();
	
	public void save(QueryModel query) {
		queryData.add(query);
	}
	
	public ArrayList<QueryModel> getAll(){
		return queryData;
	}
	
	public ArrayList<QueryModel> getSecretary(String cpfPatient) {
		
		ArrayList<QueryModel> queryPatient = new ArrayList<>();
		
		for (QueryModel query : queryData) {
			if(query.getCpfPatient() == cpfPatient) {
				queryPatient.add(query);
			}
		}
		
		return queryPatient;
	}
}
