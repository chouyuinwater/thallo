package com.fish.design.product.impl;

import product.Sound;

public class BoseNormal implements Sound {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return "BoseNormal";
    }

    @Override
    public double getPrice() {
        return 899;
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
        return "Black";
    }
}
