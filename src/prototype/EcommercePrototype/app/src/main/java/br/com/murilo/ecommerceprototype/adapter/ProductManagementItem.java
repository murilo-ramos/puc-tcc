package br.com.murilo.ecommerceprototype.adapter;

public class ProductManagementItem {

    private String id;
    private String name;

    public ProductManagementItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductManagementItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
