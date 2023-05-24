package org.java.bonus.obj;

import java.time.LocalDate;

import org.java.helper.Helper;

public class Employee {
	private String name;
	private String surname;
	private LocalDate birthDay;
	private String role;
	private static final String[] ROLES_LIST = {"employee" , "boss"};
	
	public Employee() {}
	
	public Employee(String name , String surname , LocalDate date , String role) throws Exception {
		setName(name);
		setSurname(surname);
		setBirthDay(date);
		setRole(role);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		Helper.isStrBlank(name);
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) throws Exception {
		Helper.isStrBlank(surname);
		this.surname = surname;
	}
	
	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) throws Exception {
		Helper.isDateTakedPlace(birthDay);
		this.birthDay = birthDay;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) throws Exception {
		Helper.isStrContainsWhiteSpaces(role);
		for(String roleName: ROLES_LIST) {
			if(roleName.equals(role.toLowerCase())) {
				this.role = role.toLowerCase();
				return;
			}
		}
		
		throw new Exception("Il ruolo inserito non è nella lista");
	}

	private String getInfo() {
		return "Nome completo: " + getName() + getSurname() + "\n" 
		+ "Data di nascità: " + getBirthDay() + "\n"
		+ "Ruolo: " + getRole();
	}

	@Override
	public String toString() {
		return getInfo();
	}
}
