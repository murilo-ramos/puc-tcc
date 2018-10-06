package br.com.murilo.ecommercepucapp.application;

import br.com.murilo.ecommercepucapp.service.CustomerClient;
import br.com.murilo.ecommercepucapp.service.LoginClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Factory utilizada para criar os clientes para acesso aos serviços de cliente e login
 * Os clientes utilizam a API Retrofit para implementação do acesso
 * @author murilocosta
 */
public class ClientFactory {

    private static ClientFactory instance;

    private final Retrofit retrofit;

    private ClientFactory() {
        this.retrofit = this.buildRetrofit();
    }

    public static ClientFactory getInstance() {
        if (instance == null) {
            instance = new ClientFactory();
        }

        return instance;
    }

    public LoginClient createLoginClient() {
        return this.retrofit.create(LoginClient.class);
    }

    public CustomerClient createCustomerClient() {
        return this.retrofit.create(CustomerClient.class);
    }

    private Retrofit buildRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.106:8080/ecommerce-puc/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit;
    }
}
