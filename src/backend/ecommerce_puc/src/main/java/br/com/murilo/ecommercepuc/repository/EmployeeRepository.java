package br.com.murilo.ecommercepuc.repository;

import br.com.murilo.ecommercepuc.entity.Employee;

/**
 * Interface contendo a representação do repositório de dados para funcionário
 * @author murilocosta
 */
public interface EmployeeRepository {
	
	Employee getEmployee();
	
}
