package br.com.murilo.ecommercepucapp.application;

import br.com.murilo.ecommercepucapp.entity.User;

/**
 * Singleton utilizado para armazenar dados de autenticação e login
 * @author murilocosta
 */
public class AuthenticationData {

    private static AuthenticationData instance;

    private User loggedUser;


    private AuthenticationData() {
    }

    public static AuthenticationData getInstance() {
        if (instance == null) {
            instance = new AuthenticationData();
        }

        return instance;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public boolean isUserLogged() {
        return loggedUser != null;
    }

    public void logoffUser() {
        this.loggedUser = null;
    }
}
