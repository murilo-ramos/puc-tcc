package br.com.murilo.ecommercepuc.configuration;

/**
 * Enum contendo as chaves de internacionalização para rótulos de login
 * @author murilocosta
 */
public enum LoginI18n implements ItemI18n {
	LOGIN_CANNOT_BE_EMPTY("login.message.loginCannotBeEmpty"),
	PASSWORD_CANNOT_BE_EMPTY("login.message.passwordCannotBeEmpty"),
	INVALID_LOGIN_AND_PASSWORD("login.message.invalidLoginAndPassword"),
	ERROR_WHEN_PROCESSING_REQUEST("login.message.errorWhenProcessingRequest")
	;
	
	private final String key;
	
	private LoginI18n(String key) {
		this.key = key;
	}
	
	@Override
	public String getKey() {
		return this.key;
	}
	
}
