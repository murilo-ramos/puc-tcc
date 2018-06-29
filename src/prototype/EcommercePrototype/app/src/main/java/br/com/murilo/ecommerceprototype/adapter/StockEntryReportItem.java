package br.com.murilo.ecommerceprototype.adapter;

public class StockEntryReportItem {

    private String product;
    private String date;
    private int quantity;

    public StockEntryReportItem(String product, String date, int quantity) {
        this.product = product;
        this.date = date;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
