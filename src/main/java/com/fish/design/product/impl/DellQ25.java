package com.fish.design.product.impl;

import product.Display;

public class DellQ25 implements Display {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return "Q25";
    }

    @Override
    public double getPrice() {
        return 2999;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public String getCompany() {
        return "Dell";
    }

    @Override
    public String getSize() {
        return null;
    }
}
