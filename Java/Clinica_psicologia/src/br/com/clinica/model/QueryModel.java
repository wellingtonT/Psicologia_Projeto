package br.com.clinica.model;

public class QueryModel {
	private String cpfPatient;
	private String cpfPsycologist;
	private String cpfSecretary;
	private String day;
	private String month;
	private String year;
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
	
	public String getHour() {
		return hour;
	}
	
	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCpfSecretary() {
		return cpfSecretary;
	}

	public void setCpfSecretary(String cpfSecretary) {
		this.cpfSecretary = cpfSecretary;
	}
	
	
	
}
