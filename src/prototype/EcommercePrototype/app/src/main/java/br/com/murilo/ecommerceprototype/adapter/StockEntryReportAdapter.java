package br.com.murilo.ecommerceprototype.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.murilo.ecommerceprototype.R;

public class StockEntryReportAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<StockEntryReportItem> dataSource;

    public StockEntryReportAdapter(Context context, List<StockEntryReportItem> dataSource) {
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
        View rowView = this.layoutInflater.inflate(R.layout.list_item_report, viewGroup, false);

        TextView textViewCustomer = rowView.findViewById(R.id.textViewMainItemReport);
        TextView textViewTotalPrice = rowView.findViewById(R.id.textViewSecondItemReport);
        TextView textViewDate = rowView.findViewById(R.id.textViewThirdItemReport);

        StockEntryReportItem item = (StockEntryReportItem) getItem(position);

        textViewCustomer.setText("Produto: "  + item.getProduct());
        textViewTotalPrice.setText("Data: " + item.getDate());
        textViewDate.setText("Quantidade: " + String.valueOf(item.getQuantity()));

        return rowView;
    }
}
