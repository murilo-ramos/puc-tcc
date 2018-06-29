package br.com.murilo.ecommerceprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity031 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu031);
    }

    public void onProductSearchClick(View view) {
        Intent intent = new Intent(MenuActivity031.this, ProductSearchActivity.class);
        startActivity(intent);
    }

    public void onCartClick(View view) {
        Intent intent = new Intent(MenuActivity031.this, CartActivity.class);
        startActivity(intent);
    }
}
