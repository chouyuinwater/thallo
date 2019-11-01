package com.fish.design.product.impl;

import product.Game;

public class MonsterHunterXX implements Game {
    @Override
    public int getId() {
        return 1;
    }

    @Override
    public String getName() {
        return "MonsterHunterXX";
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
