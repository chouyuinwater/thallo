package com.fish.design.product.impl;

import com.fish.design.product.Game;

public class FireEmblemIf implements Game {
    @Override
    public int getId() {
        return 4;
    }

    @Override
    public String getName() {
        return "If-W/B";
    }

    @Override
    public double getPrice() {
        return 599;
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
