package com.fish.design.product.impl;

import product.Game;

public class FireEmblemRadiantDawn implements Game {
    @Override
    public int getId() {
        return 5;
    }

    @Override
    public String getName() {
        return "Megami";
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public String getCompany() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }
}
