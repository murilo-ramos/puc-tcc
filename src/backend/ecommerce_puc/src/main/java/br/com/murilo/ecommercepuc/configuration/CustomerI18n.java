package br.com.murilo.ecommercepuc.configuration;

/**
 * Enum contendo as chaves de internacionalização para rótulos de cliente
 * @author murilocosta
 */

public enum CustomerI18n implements ItemI18n {
	CPF_CANNOT_BE_EMPTY("customer.message.customerCpfCannotBeEmpty"),
	NAME_CANNOT_BE_EMPTY("customer.message.customerNameCannotBeEmpty"),
	EMAIL_CANNOT_BE_EMPTY("customer.message.customerEmailCannotBeEmpty"),
	PASSWORD_CANNOT_BE_EMPTY("customer.message.customerPasswordCannotBeEmpty"),
	
	CPF_ALREADY_EXISTS("customer.message.cpfAlreadyExists"),
	EMAIL_ALREADY_EXISTS("customer.message.emailAlreadyExists"),
	
	CUSTOMER_WITH_CPF_NOT_EXISTS("customer.message.customerWithCpfNotExists"),
	
	ENROLLED_WITH_SUCCESS("customer.message.customerEnrolledWithSuccess"),
	UPDATED_WITH_SUCESS("customer.message.customerUpdatedWithSuccess"),
	DELETED_WITH_SUCCESS("customer.message.customerDeletedWithSuccess"),
	
	ERROR_WHEN_PROCESSING_CUSTOMER_ENROLLMENT("customer.message.errorWhenProcessingCustomerEnrollment"),
	ERROR_WHEN_PROCESSING_CUSTOMER_UPDATE("customer.message.errorWhenProcessingCustomerUpdate"),
	ERROR_WHEN_PROCESSING_CUSTOMER_DELETE("customer.message.errorWhenProcessingCustomerDelete")
	;
	
	private final String key;
	
	private CustomerI18n(String key) {
		this.key = key;
	}
	
	@Override
	public String getKey() {
		return this.key;
	}
}
