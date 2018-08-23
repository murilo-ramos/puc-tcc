package br.com.murilo.ecommercepucapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.murilo.ecommercepucapp.application.AuthenticationData;
import br.com.murilo.ecommercepucapp.application.ClientFactory;
import br.com.murilo.ecommercepucapp.application.Logger;
import br.com.murilo.ecommercepucapp.application.MessageUtil;
import br.com.murilo.ecommercepucapp.entity.User;
import br.com.murilo.ecommercepucapp.service.LoginClient;
import br.com.murilo.ecommercepucapp.service.model.LoginResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final Logger LOGGER = Logger.create(LoginActivity.class);

    private EditText loginEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_login);
        this.initialize();
    }

    @Override
    protected void onResume() {
        super.onResume();

        AuthenticationData authenticationData = AuthenticationData.getInstance();

        if (authenticationData.isUserLogged()) {
            LOGGER.info("Logging off");
            authenticationData.logoffUser();
        }
    }

    private void initialize() {
        this.loginEditText = findViewById(R.id.loginEditText);
        this.passwordEditText = findViewById(R.id.loginPasswordEditText);
        this.loginButton = findViewById(R.id.loginButton);

        this.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginClick(view);
            }
        });
    }

    private void onLoginClick(View view) {
        String login = this.loginEditText.getText().toString();
        String password = this.passwordEditText.getText().toString();

        if (login == null || login.isEmpty()) {
            MessageUtil.showShortToast(this, "Login não pode ser vazio!");
            return;
        }

        if (password == null || password.isEmpty()) {
            MessageUtil.showShortToast(this, "Senha não pode ser vazia!");
            return;
        }

        ClientFactory clientFactory = ClientFactory.getInstance();
        LoginClient loginClient = clientFactory.createLoginClient();

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        Call<LoginResult> result = loginClient.login(user);

        result.enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                LoginResult result = response.body();

                if (!result.isLoginSuccessful()) {
                    MessageUtil.showLongToast(LoginActivity.this, "Credenciais inválidas!");
                } else {
                    performLogin(result.getUser());
                }
            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                MessageUtil.showLongToast(LoginActivity.this, "Ocorreu um erro na autenticação!");
                LOGGER.error(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void performLogin(User user) {
        AuthenticationData authenticationData = AuthenticationData.getInstance();

        authenticationData.setLoggedUser(user);

        LOGGER.info("Login successful.");

        switch (user.getType()) {
            case EMPLOYEE:
                showEmployeeMenu();
                break;
            case CUSTOMER:
                showCustomerMenu();
                break;
        }
    }

    private void showEmployeeMenu() {
        Intent intent = new Intent(LoginActivity.this, EmployeeMenuActivity.class);
        this.startActivity(intent);
    }

    private void showCustomerMenu() {
        Intent intent = new Intent(LoginActivity.this, CustomerMenuActivity.class);
        this.startActivity(intent);
    }
}
