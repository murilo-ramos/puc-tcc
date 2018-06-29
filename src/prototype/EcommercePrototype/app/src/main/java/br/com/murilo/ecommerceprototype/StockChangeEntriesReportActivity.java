package br.com.murilo.ecommerceprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.murilo.ecommerceprototype.adapter.StockEntryReportAdapter;
import br.com.murilo.ecommerceprototype.adapter.StockEntryReportItem;

public class StockChangeEntriesReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_change_entries_report);
    }

    public void onStockChangeEntriesReportSearchClick(View view) {
        ListView listView = this.findViewById(R.id.listViewStockChangeEntryReport);

        List<StockEntryReportItem> items = this.getItems();
        StockEntryReportAdapter adapter = new StockEntryReportAdapter(this, items);
        listView.setAdapter(adapter);
    }

    private List<StockEntryReportItem> getItems() {
        List<StockEntryReportItem> result = new ArrayList<>();

        result.add(new StockEntryReportItem("iPhone X", "20/09/2017", 10));
        result.add(new StockEntryReportItem("Samsung Galaxy", "20/09/2017", -10));
        result.add(new StockEntryReportItem("Notebook DELL", "30/09/2017", -24));
        result.add(new StockEntryReportItem("TV Phillips", "24/03/2017", 56));
        result.add(new StockEntryReportItem("Filmadora Sony", "02/02/2017", 30));

        return result;
    }
}
