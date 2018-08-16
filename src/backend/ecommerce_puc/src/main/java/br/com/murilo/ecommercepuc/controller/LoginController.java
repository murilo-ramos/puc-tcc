package br.com.murilo.ecommercepuc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.murilo.ecommercepuc.configuration.I18nProvider;
import br.com.murilo.ecommercepuc.model.Login;
import br.com.murilo.ecommercepuc.model.LoginResult;
import br.com.murilo.ecommercepuc.service.LoginService;

@RestController
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private I18nProvider i18nProvider;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginResult login(@RequestBody Login login) {
		LoginResult result = new LoginResult();
		
		if (login.getLogin().trim().isEmpty()) {
			result.setMessage(i18nProvider.get("login.message.loginCannotBeEmpty"));
			return result;
		}
		
		if (login.getPassword().trim().isEmpty()) {
			result.setMessage(i18nProvider.get("login.message.passwordCannotBeEmpty"));			
			return result;
		}
		
		try {
			return this.loginService.login(login);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			result.setMessage(i18nProvider.get("login.message.errorWhenProcessingRequest"));
			return result;
		}
	}
	
}
