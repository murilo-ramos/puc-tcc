package br.com.murilo.ecommerceprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.murilo.ecommerceprototype.adapter.ProductManagementAdapter;
import br.com.murilo.ecommerceprototype.adapter.ProductManagementItem;

public class ProductManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_management);
    }

    public void onProductManagementNewClick(View view) {
        Intent intent = new Intent(ProductManagementActivity.this, ProductEnrollment042.class);
        this.startActivity(intent);
    }

    public void onProductManagementSeachClick(View view) {
        ListView listView = this.findViewById(R.id.listViewProductManagement);

        List<ProductManagementItem> items = this.getItems();
        ProductManagementAdapter adapter = new ProductManagementAdapter(this, items);
        listView.setAdapter(adapter);
    }

    private List<ProductManagementItem> getItems() {
        List<ProductManagementItem> result = new ArrayList<>();

        result.add(new ProductManagementItem("01", "iPhone X"));
        result.add(new ProductManagementItem("02", "Smartphone Samsung"));
        result.add(new ProductManagementItem("03", "Notebook DELL"));
        result.add(new ProductManagementItem("04", "Câmera fotográfica Canon"));
        result.add(new ProductManagementItem("05", "Monitor LG"));
        result.add(new ProductManagementItem("06", "Mouse Logitech"));

        return result;
    }
}
