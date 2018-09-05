package br.com.murilo.ecommercepuc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador reponsável por operações na home
 * Utilizado somente para fins de teste se aplicação está online
 * @author murilocosta
 */
@RestController
public class HomeController {
	
	@RequestMapping("/")
	public Home index() {
		return new Home();
	}
	
	private class Home {
		private final String message = "It Works";
		
		public String getMessage() {
			return message;
		}
	}
}
