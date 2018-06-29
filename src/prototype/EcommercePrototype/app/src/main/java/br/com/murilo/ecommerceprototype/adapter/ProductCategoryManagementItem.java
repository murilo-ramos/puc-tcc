package br.com.murilo.ecommerceprototype.adapter;

public class ProductCategoryManagementItem {

    private String id;
    private String name;

    public ProductCategoryManagementItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductCategoryManagementItem() {
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
