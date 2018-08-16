package br.com.murilo.ecommercepuc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.ecommercepuc.configuration.I18nProvider;
import br.com.murilo.ecommercepuc.entity.Customer;
import br.com.murilo.ecommercepuc.entity.Employee;
import br.com.murilo.ecommercepuc.entity.User;
import br.com.murilo.ecommercepuc.model.Login;
import br.com.murilo.ecommercepuc.model.LoginResult;
import br.com.murilo.ecommercepuc.repository.CustomerRepository;
import br.com.murilo.ecommercepuc.repository.EmployeeRepository;

@Service
public class LoginService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private I18nProvider i18nProvider;
	
	public LoginResult login(Login login) {
		LoginResult result = new LoginResult();
				
		Employee employee = this.employeeRepository.getEmployee();
		
		if (this.matchLogin(login, employee)) {
			this.processSuccessfulLogin(result, employee);
			return result;
		}
		
		Optional<Customer> customer = this.customerRepository.findByEmail(login.getLogin());
		
		if (customer.isPresent()) {
			if (this.matchLogin(login, customer.get())) {
				this.processSuccessfulLogin(result, customer.get());
				return result;
			}
		}
		
		result.setLoginSuccessful(false);
		result.setMessage(i18nProvider.get("login.message.invalidLoginAndPassword"));
		
		return result;
	}
	
	private boolean matchLogin(Login login, User user) {
		if (!login.getLogin().equals(user.getLogin())) {
			return false;
		}
		
		if (!login.getPassword().equals(user.getPassword())) {
			return false;
		}
		
		return true;
	}
	
	private void processSuccessfulLogin(LoginResult loginResult, User user) {
		loginResult.setLoginSuccessful(true);
		loginResult.setUser(user);
		
		//TODO: Should create session?;
	}
}
