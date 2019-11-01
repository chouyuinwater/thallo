package com.fish.design.model.create.bulid.bulider;

import model.create.bulid.product.RealSuit;
import model.create.bulid.product.Suit;
import product.Product;
import product.impl.BoseHigh;
import product.impl.DellQ27;
import product.impl.MonsterHunterWorld;
import product.impl.PlayStation4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RealBulider implements Bulider {

    private List<Product> products;

    @Override
    public Suit getSuit() {
        RealSuit suit = new RealSuit();
        Random random = new Random(100);
        int count = random.nextInt();
        suit.setId(count);
        suit.setName("Suit_" + count);
        suit.setProducts(products);
        return suit;
    }

    public void initProducts() {
        products = new ArrayList<Product>();
    }

    public void bulidConsole() {
        products.add(new PlayStation4());
    }

    public void bulidDisplay() {
        products.add(new DellQ27());
    }

    public void bulidGame() {
        products.add(new MonsterHunterWorld());
    }

    public void bulidSound() {
        products.add(new BoseHigh());
    }
}