package br.com.murilo.ecommercepuc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por invocar os textos de internacionalização
 * @author murilocosta
 */

@Component
public class I18nProvider {
	
	@Autowired
	private MessageSource messageSource;
	
	public String get(ItemI18n item) {
		return this.get(item.getKey());
	}
	
	public String get(ItemI18n item, String...params) {
		return this.get(item.getKey(), params);
	}
	
	public String get(String key) {
		return this.messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
	}
	
	public String get(String key, String...params) {
		return this.messageSource.getMessage(key, params, LocaleContextHolder.getLocale());
	}

}
