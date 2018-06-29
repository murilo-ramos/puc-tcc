package br.com.murilo.ecommerceprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FinishShopping11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_shopping11);
    }

    public void onPrintTicketClick(View view) {
        Toast.makeText(this, "Imprimindo nota", Toast.LENGTH_SHORT);
    }

    public void onBackToBeginningClick(View view) {
        Intent intent = new Intent(FinishShopping11.this, LoginActivity01.class);
        this.startActivity(intent);
    }
}
