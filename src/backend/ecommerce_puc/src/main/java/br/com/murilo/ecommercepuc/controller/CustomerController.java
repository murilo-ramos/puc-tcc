package br.com.murilo.ecommercepuc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.murilo.ecommercepuc.configuration.I18nProvider;
import br.com.murilo.ecommercepuc.entity.Customer;
import br.com.murilo.ecommercepuc.model.RequestResult;
import br.com.murilo.ecommercepuc.service.CustomerService;
import br.com.murilo.ecommercepuc.service.CustomerServiceException;

@RestController
public class CustomerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private I18nProvider i18nProvider;
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public List<Customer> list() {
		return this.customerService.listAll();
	}
	
	@RequestMapping(value = "/customer/{name}", method = RequestMethod.GET)
	public List<Customer> listByName(@PathVariable String name) {
		return this.customerService.listByName(name);
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public RequestResult<Customer> add(@RequestBody Customer customer) {
		RequestResult<Customer> result = new RequestResult<>();
		
		if (!this.checkCustomerFields(customer, result)) {
			return result;
		}
		
		try {
			this.customerService.add(customer);
			result.setRequestSuccessful(true);
			result.setEntity(customer);
			result.setMessage(i18nProvider.get("customer.message.customerEnrolledWithSuccess"));
		} catch (CustomerServiceException ex) {
			LOGGER.error(ex.getMessage());
			result.setMessage(ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			result.setMessage(i18nProvider.get("customer.message.errorWhenProcessingCustomerEnrollment"));
		}
		
		return result;
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.PUT)
	public RequestResult<Customer> update(@RequestBody Customer customer) {
		RequestResult<Customer> result = new RequestResult<>();
		
		if (!this.checkCustomerFields(customer, result)) {
			return result;
		}
		
		try {
			this.customerService.update(customer);
			result.setRequestSuccessful(true);
			result.setEntity(customer);
			result.setMessage(i18nProvider.get("customer.message.customerUpdatedWithSuccess"));
		} catch (CustomerServiceException ex) {
			LOGGER.error(ex.getMessage());
			result.setMessage(ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			result.setMessage(i18nProvider.get("customer.message.errorWhenProcessingCustomerUpdate"));
		}
		
		return result;
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.DELETE)
	public RequestResult<Customer> delete(@RequestBody Customer customer) {
		RequestResult<Customer> result = new RequestResult<>();
		
		if (customer.getCpf().trim().isEmpty()) {
			result.setMessage(i18nProvider.get("customer.message.customerCpfCannotBeEmpty"));
			return result;
		}
		
		try {
			this.customerService.delete(customer);
			result.setRequestSuccessful(true);
			result.setEntity(customer);
			result.setMessage(i18nProvider.get("customer.message.customerDeletedWithSuccess"));
		} catch (CustomerServiceException ex) {
			LOGGER.error(ex.getMessage());
			result.setMessage(ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			result.setMessage(i18nProvider.get("customer.message.errorWhenProcessingCustomerDelete"));
		}
		
		return result;
	}
	
	private boolean checkCustomerFields(Customer customer, RequestResult<Customer> result) {
		if (customer.getCpf().trim().isEmpty()) {
			result.setMessage(i18nProvider.get("customer.message.customerCpfCannotBeEmpty"));
			return false;
		}
		
		if (customer.getName().trim().isEmpty()) {
			result.setMessage(i18nProvider.get("customer.message.customerNameCannotBeEmpty"));
			return false;
		}
		
		if (customer.getEmail().trim().isEmpty()) {			
			result.setMessage(i18nProvider.get("customer.message.customerEmailCannotBeEmpty"));
			return false;
		}
		
		if (customer.getPassword().trim().isEmpty()) {
			result.setMessage(i18nProvider.get("customer.message.customerPasswordCannotBeEmpty"));
			return false;
		}
		
		return true;
	}
}
