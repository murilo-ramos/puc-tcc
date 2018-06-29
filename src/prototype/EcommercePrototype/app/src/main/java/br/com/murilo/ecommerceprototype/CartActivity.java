package br.com.murilo.ecommerceprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.murilo.ecommerceprototype.adapter.CartAdapter;
import br.com.murilo.ecommerceprototype.adapter.CartItem;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        this.initializeCartItems();
    }

    public void onFinishOrderClick(View view) {
        Intent intent = new Intent(CartActivity.this, Payment10.class);
        this.startActivity(intent);
    }

    private void initializeCartItems() {
        ListView listView = this.findViewById(R.id.listViewCart);

        List<CartItem> items = this.getItems();
        CartAdapter adapter = new CartAdapter(this, items);
        listView.setAdapter(adapter);
    }

    private List<CartItem> getItems() {
        List<CartItem> result = new ArrayList<>();

        result.add(new CartItem("iPhone X", "100.00", "1"));
        result.add(new CartItem("Smartphone Samsung", "50.00", "3"));
        result.add(new CartItem("Notebook DELL", "250.10", "10"));
        result.add(new CartItem("Câmera fotográfica Canon", "20.00", "6"));

        return result;
    }
}
