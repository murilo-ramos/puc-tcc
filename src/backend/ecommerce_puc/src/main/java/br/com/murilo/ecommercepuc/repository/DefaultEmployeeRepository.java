package br.com.murilo.ecommercepuc.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.com.murilo.ecommercepuc.entity.Employee;

@Repository
@Qualifier("employeeRepository")
public class DefaultEmployeeRepository implements EmployeeRepository {

	private static final String DEFAULT_EMPLOYEE_LOGIN    = "funcionario";
	private static final String DEFAULT_EMPLOYEE_PASSWORD = "admin";
	
	@Override
	public Employee getEmployee() {
		return new Employee(DEFAULT_EMPLOYEE_LOGIN, DEFAULT_EMPLOYEE_PASSWORD);
	}

}
