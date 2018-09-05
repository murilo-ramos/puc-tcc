package br.com.murilo.ecommercepuc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.ecommercepuc.configuration.CustomerI18n;
import br.com.murilo.ecommercepuc.configuration.I18nProvider;
import br.com.murilo.ecommercepuc.entity.Customer;
import br.com.murilo.ecommercepuc.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private I18nProvider i18nProvider;
	
	public List<Customer> listAll() {
		return this.customerRepository.findAll(); 
	}
	
	public List<Customer> listByName(String name) {
		return this.customerRepository.findAllByName(name); 
	}
	
	public void add(Customer customer) throws CustomerServiceException {
		this.checkUniqueFields(customer, false);		
		this.customerRepository.saveAndFlush(customer);		
	}
	
	public void update(Customer customer) throws CustomerServiceException {
		this.checkIfCustomerExists(customer);		
		this.checkUniqueFields(customer, true);		
		this.customerRepository.saveAndFlush(customer);		
	}
	
	public void delete(Customer customer) throws CustomerServiceException {
		this.checkIfCustomerExists(customer);
		this.customerRepository.delete(customer);
	}
	
	private void checkUniqueFields(Customer customer, boolean isUpdate) throws CustomerServiceException {
		if (!isUpdate) {
			Optional<Customer> customerEntry =  this.customerRepository.findById(customer.getCpf());
			
			if (customerEntry.isPresent()) {
				throw new CustomerServiceException(i18nProvider.get(CustomerI18n.CPF_ALREADY_EXISTS));
			}
		}
		
		Optional<Customer> customerEntry =  this.customerRepository.findByEmail(customer.getEmail());
		
		if (customerEntry.isPresent()) {
			if (isUpdate && customerEntry.get().getCpf().equals(customer.getCpf())) {
				return;
			}
			
			throw new CustomerServiceException(i18nProvider.get(CustomerI18n.EMAIL_ALREADY_EXISTS));
		}
	}
	
	private void checkIfCustomerExists(Customer customer) throws CustomerServiceException {
		Optional<Customer> customerEntry =  this.customerRepository.findById(customer.getCpf());
		
		if (!customerEntry.isPresent()) {			
			throw new CustomerServiceException(i18nProvider.get(CustomerI18n.CUSTOMER_WITH_CPF_NOT_EXISTS, customer.getCpf()));
		}
	}
}
