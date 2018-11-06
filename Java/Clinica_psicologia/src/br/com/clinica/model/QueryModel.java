package br.com.clinica.model;

public class QueryModel {
	private String cpfPatient;
	private String cpfPsycologist;
	private String date;
	private String hour;
	
	public String getCpfPatient() {
		return cpfPatient;
	}
	
	public void setCpfPatient(String cpfPatient) {
		this.cpfPatient = cpfPatient;
	}
	
	public String getCpfPsycologist() {
		return cpfPsycologist;
	}
	
	public void setCpfPsycologist(String cpfPsycologist) {
		this.cpfPsycologist = cpfPsycologist;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getHour() {
		return hour;
	}
	
	public void setHour(String hour) {
		this.hour = hour;
	}
	
}
