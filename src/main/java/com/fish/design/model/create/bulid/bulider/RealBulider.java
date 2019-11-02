package com.fish.design.model.create.bulid.bulider;


import com.fish.design.model.create.bulid.product.RealSuit;
import com.fish.design.model.create.bulid.product.Suit;
import com.fish.design.product.Product;
import com.fish.design.product.impl.BoseHigh;
import com.fish.design.product.impl.DellQ27;
import com.fish.design.product.impl.MonsterHunterWorld;
import com.fish.design.product.impl.PlayStation4;

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