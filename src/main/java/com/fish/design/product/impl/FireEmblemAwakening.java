package com.fish.design.product.impl;

import com.fish.design.product.Game;

public class FireEmblemAwakening implements Game {
    @Override
    public int getId() {
        return 3;
    }

    @Override
    public String getName() {
        return "Awake";
    }

    @Override
    public double getPrice() {
        return 399;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public String getCompany() {
        return "Nintendo";
    }

    @Override
    public String getType() {
        return "S";
    }
}
