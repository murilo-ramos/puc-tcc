package br.com.murilo.ecommercepuc.entity;

/**
 * Interface para unificação de entidades Cliente e Funcionário, usados como Usuário no login
 * @author murilocosta
 */
public interface User {
	
	String getLogin();
	
	String getPassword();
	
	UserType getType();

}
