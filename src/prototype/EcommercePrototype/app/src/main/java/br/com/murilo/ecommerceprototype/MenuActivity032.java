package br.com.murilo.ecommerceprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity032 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu032);
    }

    public void onCustomerEnrollClick(View view) {
        Intent intent = new Intent(MenuActivity032.this, CustomerManagementActivity.class);
        this.startActivity(intent);
    }

    public void onProductEnrollClick(View view) {
        Intent intent = new Intent(MenuActivity032.this, ProductManagementActivity.class);
        this.startActivity(intent);
    }

    public void onProductCategoryEnrollClick(View view) {
        Intent intent = new Intent(MenuActivity032.this, ProductCategoryManagementActivity.class);
        this.startActivity(intent);
    }

    public void onStockReportClick(View view) {
        Intent intent = new Intent(MenuActivity032.this, StockChangeEntriesReportActivity.class);
        this.startActivity(intent);
    }

    public void onOrdersReportClick(View view) {
        Intent intent = new Intent(MenuActivity032.this, OrdersReportActivity.class);
        this.startActivity(intent);
    }


}
