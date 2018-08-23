package br.com.murilo.ecommercepucapp.service;

import br.com.murilo.ecommercepucapp.entity.User;
import br.com.murilo.ecommercepucapp.service.model.LoginResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginClient {

    @POST("login")
    Call<LoginResult> login(@Body User user);

}
