package br.com.murilo.ecommercepuc.entity;

public class Employee implements User {

	private final String login;
	private final String password;
		
	public Employee(String login, String password) {
		this.login = login;
		this.password = password;
	}

	@Override
	public String getLogin() {
		return this.login;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public UserType getType() {
		return UserType.EMPLOYEE;
	}	
}
