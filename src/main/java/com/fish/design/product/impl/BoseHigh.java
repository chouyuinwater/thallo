package com.fish.design.product.impl;

import com.fish.design.product.Sound;

public class BoseHigh implements Sound {
    @Override
    public int getId() {
        return 1;
    }

    @Override
    public String getName() {
        return "BoseHigh";
    }

    @Override
    public double getPrice() {
        return 3000;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public String getCompany() {
        return "Bose";
    }

    @Override
    public String getColor() {
        return "white";
    }
}
