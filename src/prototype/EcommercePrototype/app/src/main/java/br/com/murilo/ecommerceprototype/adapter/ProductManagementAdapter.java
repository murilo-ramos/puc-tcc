package br.com.murilo.ecommerceprototype.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.murilo.ecommerceprototype.R;

public class ProductManagementAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<ProductManagementItem> dataSource;

    public ProductManagementAdapter(Context context, List<ProductManagementItem> dataSource) {
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
        View rowView = this.layoutInflater.inflate(R.layout.list_item_management, viewGroup, false);

        TextView textViewProductName = rowView.findViewById(R.id.textViewItemNameManagement);

        ProductManagementItem item = (ProductManagementItem) getItem(position);

        textViewProductName.setText(item.getName());

        return rowView;
    }
}
