package com.fish.design.product.impl;

import com.fish.design.product.Console;

import java.util.List;

public class Switch implements Console {
    @Override
    public int getId() {
        return 1;
    }

    @Override
    public String getName() {
        return "Switch";
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
        return "Nintendo";
    }

    @Override
    public List<String> getFamous() {
        return null;
    }
}
