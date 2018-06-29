package br.com.murilo.ecommerceprototype.adapter;

public class OrderReportItem {

    private String customer;
    private String totalPrice;
    private String date;

    public OrderReportItem(String customer, String totalPrice, String date) {
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
