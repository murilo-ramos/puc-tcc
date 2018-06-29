package br.com.murilo.ecommerceprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.murilo.ecommerceprototype.adapter.OrderReportAdapter;
import br.com.murilo.ecommerceprototype.adapter.OrderReportItem;

public class OrdersReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_report);
    }

    public void onOrdersReportSearchClick(View view) {
        ListView listView = this.findViewById(R.id.listViewOrdersReport);

        List<OrderReportItem> items = this.getItems();
        OrderReportAdapter adapter = new OrderReportAdapter(this, items);
        listView.setAdapter(adapter);
    }

    private List<OrderReportItem> getItems() {
        List<OrderReportItem> result = new ArrayList<>();

        result.add(new OrderReportItem("Ricardo", "100", "20/09/2017"));
        result.add(new OrderReportItem("Karique", "25", "23/05/2017"));
        result.add(new OrderReportItem("Suellen", "10", "27/12/2017"));
        result.add(new OrderReportItem("Felipe", "255", "14/03/2017"));
        result.add(new OrderReportItem("Osvaldo", "700", "30/12/2017"));

        return result;
    }
}
