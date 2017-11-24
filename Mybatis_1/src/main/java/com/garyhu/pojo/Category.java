package com.garyhu.pojo;

import java.util.List;

/**
 * @author: garyhu
 * @Since: 2017/11/24 0024.
 * @Decription:
 */
public class Category {

    private int id;
    private String name;
    private List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + "]";
    }
}
