package br.com.murilo.ecommercepucapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.com.murilo.ecommercepucapp.entity.Customer;

/**
 * Classe utilizada como adaptador para exibir lista de clientes na tela de gerenciamento de cliente
 * @author murilocosta
 */
public class CustomerManagementListAdapter extends BaseAdapter {

    private final CustomerManagementActivity customerManagementActivity;
    private final LayoutInflater layoutInflater;
    private final List<Customer> dataSource;

    public CustomerManagementListAdapter(CustomerManagementActivity customerManagementActivity, List<Customer> dataSource) {
        this.customerManagementActivity = customerManagementActivity;
        this.layoutInflater = (LayoutInflater) customerManagementActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        final Customer customer = (Customer) getItem(position);

        View rowView = this.layoutInflater.inflate(R.layout.customer_management_item, viewGroup, false);
        TextView customerNameTextView = rowView.findViewById(R.id.itemManagementNameTextView);
        Button editButton = rowView.findViewById(R.id.itemManagementEditButton);
        Button deleteButton = rowView.findViewById(R.id.itemManagementDeleteButton);

        customerNameTextView.setText(customer.getName());

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customerManagementActivity.editCustomer(customer);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customerManagementActivity.deleteCustomer(customer);
            }
        });

        return rowView;
    }
}
