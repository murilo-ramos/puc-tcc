package br.com.murilo.ecommerceprototype.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.murilo.ecommerceprototype.R;

public class CustomerManagementAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<CustomerManagementItem> dataSource;

    public CustomerManagementAdapter(Context context, List<CustomerManagementItem> dataSource) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.dataSource = dataSource;
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

        TextView textViewCustomerName = rowView.findViewById(R.id.textViewItemNameManagement);

        CustomerManagementItem item = (CustomerManagementItem) getItem(position);

        textViewCustomerName.setText(item.getName());

        return rowView;
    }
}
