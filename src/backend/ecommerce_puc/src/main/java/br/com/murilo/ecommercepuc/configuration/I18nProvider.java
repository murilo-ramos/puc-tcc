package br.com.murilo.ecommercepuc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class I18nProvider {
	
	@Autowired
	private MessageSource messageSource;
	
	public String get(String key) {
		return this.messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
	}
	
	public String get(String key, String...params) {
		return this.messageSource.getMessage(key, params, LocaleContextHolder.getLocale());
	}

}
