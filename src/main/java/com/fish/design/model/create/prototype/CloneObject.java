package com.fish.design.model.create.prototype;

import java.util.Date;

public class CloneObject implements Cloneable {
    private String name;
    private Long id;
    private Date date;
    private Product product;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CloneObject{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", date=" + date +
                ", product=" + product +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        CloneObject result = (CloneObject)super.clone();
        result.setProduct((Product)product.clone());
        return result;
    }
}
