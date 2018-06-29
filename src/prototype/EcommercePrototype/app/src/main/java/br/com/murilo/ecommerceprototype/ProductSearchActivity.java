package br.com.murilo.ecommerceprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.murilo.ecommerceprototype.adapter.ProductSearchAdapter;
import br.com.murilo.ecommerceprototype.adapter.ProductSearchItem;

public class ProductSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_search);
    }

    public void onProductSearchSearchClick(View view) {
        ListView listView = this.findViewById(R.id.listViewProductSearch);

        List<ProductSearchItem> items = this.getItems();
        ProductSearchAdapter adapter = new ProductSearchAdapter(this, items);
        listView.setAdapter(adapter);
    }

    private List<ProductSearchItem> getItems() {
        List<ProductSearchItem> result = new ArrayList<>();

        result.add(new ProductSearchItem("01", "iPhone X", "100.00"));
        result.add(new ProductSearchItem("02", "Smartphone Samsung", "50.00"));
        result.add(new ProductSearchItem("03", "Notebook DELL", "250.10"));
        result.add(new ProductSearchItem("04", "Câmera fotográfica Canon", "20.00"));
        result.add(new ProductSearchItem("05", "Monitor LG", "1.00"));
        result.add(new ProductSearchItem("06", "Mouse Logitech", "15.00"));

        return result;
    }
}
