package br.com.murilo.ecommerceprototype;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login01);
    }

    public void onLoginClick(View view) {
        EditText text = findViewById(R.id.edtLogin);

        Intent intent = null;

        if (text.getText().toString().contains("cliente")) {
            intent  = new Intent(LoginActivity01.this, MenuActivity031.class);
        } else if (text.getText().toString().contains("funcionario")) {
            intent  = new Intent(LoginActivity01.this, MenuActivity032.class);
        }

        startActivity(intent);
    }

    public void onCustomerRegisterClick(View view) {
        Intent intent  = new Intent(LoginActivity01.this, CustomerEnrollment02.class);
        startActivity(intent);
    }
}
