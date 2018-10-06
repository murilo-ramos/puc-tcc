package br.com.murilo.ecommercepuc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entidade de Cliente
 * @author murilocosta
 */
@Entity
public class Customer implements User {
	
	@Id
	private String cpf;
	private String name;
	private String address;
	private String state;
	private String city;
	private String phone;
	@Column(unique=true)
	private String email;
	private String password;
	
	public Customer() {
	}

	@Override
	public String getLogin() {
		return this.getEmail();
	}

	@Override
	public UserType getType() {
		return UserType.CUSTOMER;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
