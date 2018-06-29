package br.com.murilo.ecommerceprototype.adapter;

public class ProductSearchItem {

    private String id;
    private String product;
    private String price;

    public ProductSearchItem(String id, String product, String price) {
        this.id = id;
        this.product = product;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
