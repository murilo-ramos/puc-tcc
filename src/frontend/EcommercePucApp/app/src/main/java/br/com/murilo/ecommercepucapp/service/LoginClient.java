package br.com.murilo.ecommercepucapp.service;

import br.com.murilo.ecommercepucapp.entity.User;
import br.com.murilo.ecommercepucapp.service.model.LoginResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Interface representando o cliente de acesso aos serviços de login
 * A interface tem sua implementação criando em tempo de execução pela API Retrofit
 * @author murilocosta
 */
public interface LoginClient {

    @POST("login")
    Call<LoginResult> login(@Body User user);

}
