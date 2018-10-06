package br.com.murilo.ecommercepucapp.service.model;

/**
 * Classe utilizada como modelo de resultado de requisições entre cliente e servidor
 * @author murilocosta
 */
public class RequestResult<T> {

    private boolean requestSuccessful;
    private T entity;
    private String message;

    public boolean isRequestSuccessful() {
        return requestSuccessful;
    }

    public void setRequestSuccessful(boolean requestSuccessful) {
        this.requestSuccessful = requestSuccessful;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
