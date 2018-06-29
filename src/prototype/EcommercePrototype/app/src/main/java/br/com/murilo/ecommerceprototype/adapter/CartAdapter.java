package br.com.murilo.ecommerceprototype.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.murilo.ecommerceprototype.R;

public class CartAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<CartItem> dataSource;

    public CartAdapter(Context context, List<CartItem> dataSource) {
        this.context = context;
        this.dataSource = dataSource;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return this.dataSource.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowView = this.layoutInflater.inflate(R.layout.list_item_cart, viewGroup, false);

        TextView textViewProduct = rowView.findViewById(R.id.textViewProductCard);
        TextView textViewPrice = rowView.findViewById(R.id.textViewPriceCard);
        EditText editTextQuantity = rowView.findViewById(R.id.editTextQuantityCart);
        Button button = rowView.findViewById(R.id.buttonRemoveItemCard);

        final CartItem item = (CartItem) getItem(position);

        textViewProduct.setText(item.getProduct());
        textViewPrice.setText("Preço: " + item.getPrice());
        editTextQuantity.setText(item.getQuantity());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Removendo item: " + item.getProduct(), Toast.LENGTH_LONG).show();
            }
        });

        return rowView;
    }
}
