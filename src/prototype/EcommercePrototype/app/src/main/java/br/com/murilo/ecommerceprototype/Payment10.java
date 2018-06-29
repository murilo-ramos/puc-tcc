package br.com.murilo.ecommerceprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Payment10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment10);
    }

    public void onPerformPaymentClick(View view) {
        Intent intent = new Intent(Payment10.this, FinishShopping11.class);
        this.startActivity(intent);
    }

    public void onCancelPaymentClick(View view) {
        //reseta tudo
        Intent intent = new Intent(Payment10.this, MenuActivity031.class);
        this.startActivity(intent);
    }


}
