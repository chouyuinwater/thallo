package com.fish.design.product.impl;

import product.Display;

public class DellQ27 implements Display {
    @Override
    public int getId() {
        return 1;
    }

    @Override
    public String getName() {
        return "Q27";
    }

    @Override
    public double getPrice() {
        return 4999;
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
        return "27";
    }
}
