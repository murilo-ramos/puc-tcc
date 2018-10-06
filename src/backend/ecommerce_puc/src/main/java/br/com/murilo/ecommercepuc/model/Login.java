package br.com.murilo.ecommercepuc.model;

/**
 * Classe utilizado como modelo de login para troca de mensagens entre cliente e servidor
 * @author murilocosta
 */
public class Login {
	
	private String login;
	private String password;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
