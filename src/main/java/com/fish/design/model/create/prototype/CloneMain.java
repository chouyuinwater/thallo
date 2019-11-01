package com.fish.design.model.create.prototype;

import java.util.Date;

public class CloneMain {
    public static void main(String[] args) {
        Date date = new Date();
        Product product = new Product();
        CloneObject cloneObject = new CloneObject();
        product.setDate(date);
        product.setId(0L);
        product.setName("pro");
        cloneObject.setDate(date);
        cloneObject.setId(1L);
        cloneObject.setName("clo");
        cloneObject.setProduct(product);
        try {
            CloneObject cloneObject1 = (CloneObject)cloneObject.clone();
            System.out.println(cloneObject);
            System.out.println(cloneObject1);
            System.out.println("====================");
            Thread.sleep(3000);
            product.setId(2L);
            product.setName("734874");
            product.setDate(new Date());
            System.out.println(cloneObject);
            System.out.println(cloneObject1);
            System.out.println("====================");
            Thread.sleep(3000);
            cloneObject.setName("11111");
            product = new Product();
            product.setDate(new Date());
            product.setId(3L);
            product.setName("pro1111");
            cloneObject.setProduct(product);
            System.out.println(cloneObject);
            System.out.println(cloneObject1);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
