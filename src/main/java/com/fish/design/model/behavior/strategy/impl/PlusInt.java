package com.fish.design.model.behavior.strategy.impl;


import com.fish.design.model.behavior.strategy.Strategy;

public class PlusInt implements Strategy {
    @Override
    public int doMain(int a, int b) {
        return a * b;
    }
}
