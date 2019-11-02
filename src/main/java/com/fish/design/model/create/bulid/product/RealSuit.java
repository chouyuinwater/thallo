package com.fish.design.model.create.bulid.product;



import com.fish.design.product.Product;

import java.util.List;

public class RealSuit extends AbstractSuit {

    private List<Product> products;

    @Override
    public String getInfo() {
        if (products != null && products.size() > 0) {
            StringBuffer buffer = new StringBuffer("Suit Info:");
            for (Product prodcut: products) {
                buffer.append(" ");
                buffer.append(prodcut.getName());
                buffer.append(" * ");
                buffer.append(prodcut.getNumber());
                buffer.append(";");
            }
            return buffer.toString();
        }
        return null;
    }

    @Override
    public double getPrice() {
        double price = 0;
        if (products != null && products.size() > 0) {
            for (Product prodcut: products) {
                price += prodcut.getPrice();
            }
        }
        return price;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
