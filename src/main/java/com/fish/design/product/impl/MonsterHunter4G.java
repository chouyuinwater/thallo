package com.fish.design.product.impl;

import com.fish.design.product.Game;

public class MonsterHunter4G  implements Game {
    @Override
    public int getId() {
        return 2;
    }

    @Override
    public String getName() {
        return "4G";
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
        return "A";
    }
}
