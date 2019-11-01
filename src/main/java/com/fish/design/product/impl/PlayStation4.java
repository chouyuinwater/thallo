package com.fish.design.product.impl;

import product.Console;

import java.util.List;

public class PlayStation4 implements Console {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return "PS4";
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
        return "Sony";
    }

    @Override
    public List<String> getFamous() {
        return null;
    }
}
