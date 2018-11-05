package br.com.clinica.dao;

import java.util.ArrayList;

import br.com.clinica.model.PsycologistModel;


public class PsycologistDAO {
	
	private ArrayList<PsycologistModel> psycologistData = new ArrayList<>();
	
	public void save(PsycologistModel psycologist) {
		psycologistData.add(psycologist);
	}
	
	public ArrayList<PsycologistModel> getAll(){
		return psycologistData;
	}
	
	public PsycologistModel getSecretary(String cpf) {
		
		for (PsycologistModel psycologist : psycologistData) {
			if(psycologist.getCpf() == cpf) {
				return psycologist;
			}
		}
		
		return null;
	}
}
