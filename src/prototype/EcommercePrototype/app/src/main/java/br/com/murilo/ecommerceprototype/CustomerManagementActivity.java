package br.com.murilo.ecommerceprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.murilo.ecommerceprototype.adapter.CustomerManagementAdapter;
import br.com.murilo.ecommerceprototype.adapter.CustomerManagementItem;

public class CustomerManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_management);
    }

    public void onCustomerManagementNewClick(View view) {
        Intent intent = new Intent(CustomerManagementActivity.this, CustomerEnrollment02.class);
        this.startActivity(intent);
    }

    public void onCustomerManagementSearchClick(View view) {
        ListView listView = this.findViewById(R.id.listViewCustomerManagement);

        List<CustomerManagementItem> items = this.getItems();
        CustomerManagementAdapter adapter = new CustomerManagementAdapter(this, items);
        listView.setAdapter(adapter);
    }

    private List<CustomerManagementItem> getItems() {
        List<CustomerManagementItem> result = new ArrayList<>();

        result.add(new CustomerManagementItem("Murilo", "12323434556", "murilo@eu.com.br"));
        result.add(new CustomerManagementItem("Felipe", "32142342144", "felipe@eu.com.br"));
        result.add(new CustomerManagementItem("Suellen", "43243243243", "suellen@eu.com.br"));
        result.add(new CustomerManagementItem("Karine", "654634564363", "karine@eu.com.br"));

        return result;
    }
}
