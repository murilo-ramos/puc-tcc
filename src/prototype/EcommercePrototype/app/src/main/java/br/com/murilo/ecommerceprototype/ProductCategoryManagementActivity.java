package br.com.murilo.ecommerceprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.murilo.ecommerceprototype.adapter.ProductCategoryManagementAdapter;
import br.com.murilo.ecommerceprototype.adapter.ProductCategoryManagementItem;

public class ProductCategoryManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_category_management);
    }

    public void onProductCategoryManagementNewClick(View view) {
        Intent intent = new Intent(ProductCategoryManagementActivity.this, ProductCategoryEnrollment052.class);
        this.startActivity(intent);
    }

    public void onProductCategoryManagementSearchClick(View view) {
        ListView listView = this.findViewById(R.id.listViewProductCategoryManagement);

        List<ProductCategoryManagementItem> items = this.getItems();
        ProductCategoryManagementAdapter adapter = new ProductCategoryManagementAdapter(this, items);
        listView.setAdapter(adapter);
    }

    private List<ProductCategoryManagementItem> getItems() {
        List<ProductCategoryManagementItem> result = new ArrayList<>();

        result.add(new ProductCategoryManagementItem("01", "Eletronico"));
        result.add(new ProductCategoryManagementItem("02", "Eletrodomestico"));
        result.add(new ProductCategoryManagementItem("03", "Esporte"));
        result.add(new ProductCategoryManagementItem("04", "Cama banho"));
        result.add(new ProductCategoryManagementItem("05", "Decoração"));
        result.add(new ProductCategoryManagementItem("06", "Utilidades"));

        return result;
    }
}
