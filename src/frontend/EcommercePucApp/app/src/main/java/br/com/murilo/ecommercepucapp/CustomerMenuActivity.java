package br.com.murilo.ecommercepucapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Activity responsável pelas operações da tela de menu de cliente
 * @author murilocosta
 */
public class CustomerMenuActivity extends AppCompatActivity {

    private Button productSearchButton;
    private Button cartButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_customer_menu);
        this.initialize();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, LoginActivity.class);
        this.startActivity(intent);
    }

    private void initialize() {
        this.productSearchButton = findViewById(R.id.customerMenuProductSearchButton);
        this.cartButton = findViewById(R.id.customerMenuCartButton);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(CustomerMenuActivity.this, "Recurso indisponível", Toast.LENGTH_LONG);
                toast.show();
            }
        };

        this.productSearchButton.setOnClickListener(onClickListener);
        this.cartButton.setOnClickListener(onClickListener);
    }
}
