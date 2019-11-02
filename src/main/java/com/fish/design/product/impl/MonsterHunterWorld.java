package com.fish.design.product.impl;

import com.fish.design.product.Game;


public class MonsterHunterWorld implements Game {
    @Override
    public int getId() {
        return 1;
    }

    @Override
    public String getName() {
        return "World";
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
