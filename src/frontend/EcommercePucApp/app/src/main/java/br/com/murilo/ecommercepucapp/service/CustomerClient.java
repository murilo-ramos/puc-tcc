package br.com.murilo.ecommercepucapp.service;

import java.util.List;

import br.com.murilo.ecommercepucapp.entity.Customer;
import br.com.murilo.ecommercepucapp.service.model.RequestResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Interface representando o cliente de acesso aos serviços de cliente
 * A interface tem sua implementação criando em tempo de execução pela API Retrofit
 * @author murilocosta
 */
public interface CustomerClient {

    @GET("customer")
    Call<List<Customer>> getAll();

    @GET("customer/{name}")
    Call<List<Customer>> getListByName(@Path("name") String name);

    @POST("customer")
    Call<RequestResult<Customer>> add(@Body Customer customer);

    @PUT("customer")
    Call<RequestResult<Customer>> update(@Body Customer customer);

    //@DELETE("customer")
    @HTTP(method = "DELETE", path = "customer", hasBody = true)
    Call<RequestResult<Customer>> remove(@Body Customer customer);

}
